package pre;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.KhoHome;
import dao.NhacungcapHome;
import model.Kho;
import model.Nhacungcap;
import bus.DanhsachKho;
import bus.DanhsachNhacungcap;


public class FormDSKho extends JFrame {

	private JPanel contentPane;
	private static JTextField txtTenkho;
	private JTable tbkho;
	DefaultTableModel modelkho= new DefaultTableModel();	
	private static JTextField txtMakho;
	private DanhsachKho dskho=new DanhsachKho();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FormDSKho frame = new FormDSKho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	/**
	 * 
	 */
	public FormDSKho() {
		setTitle("Danh sách Kho");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(100, 100, 720, 487);
		setSize(480,334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_dt = new JPanel();
		panel_dt.setBounds(10, 11, 448, 124);
		contentPane.add(panel_dt);
		panel_dt.setLayout(null);
		
		JLabel lblMakho = new JLabel("Mã kho");
		lblMakho.setBounds(50, 11, 112, 14);
		panel_dt.add(lblMakho);
		
		JLabel lblTenkho = new JLabel("Tên kho");
		lblTenkho.setBounds(50, 54, 112, 14);
		panel_dt.add(lblTenkho);
		
		txtTenkho = new JTextField();
		txtTenkho.setBounds(172, 51, 134, 20);
		panel_dt.add(txtTenkho);
		txtTenkho.setColumns(10);
		
		txtMakho = new JTextField();
		txtMakho.setColumns(10);
		txtMakho.setBounds(172, 8, 134, 20);
		panel_dt.add(txtMakho);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(kiemtrarong()==false){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!!!");
				}
				else{
					Kho newkho=new Kho(txtMakho.getText().toString(), txtTenkho.getText().toString());;
					if(dskho.getLstKho().contains(newkho)){
						JOptionPane.showMessageDialog(null, "Đối tượng này tồn tại!!!");
					}else{						
						KhoHome khohome=new KhoHome();
						khohome.attachDirty(newkho);
						dskho.getLstKho().add(newkho);
							Object[] ob = {newkho.getMakho() , newkho.getTenkho()};
							modelkho.addRow(ob);						
					}
				}
			}
		});
		btnThem.setBounds(352, 7, 89, 23);
		panel_dt.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tbkho.getSelectedRow();
				if(index != -1)
				{					
					Kho kho = dskho.getByIndex(index);
					setForTextBox(kho);
					lammoitthongtin();
					try {
						KhoHome khohome=new KhoHome();
						khohome.delete(kho);
						dskho.getLstKho().remove(index);
						modelkho.removeRow(index);
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Không thể xóa vì tồn tại khóa ngoại!!!");
					}
				}
			}
		});
		btnXoa.setBounds(352, 35, 89, 23);
		panel_dt.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tbkho.getSelectedRow();
				if(index != -1)
				{			
					KhoHome khohome=new KhoHome();
					Kho kho = dskho.getByIndex(index);										
					kho.setTenkho(txtTenkho.getText().toString());
					khohome.merge(kho);
					dskho.getLstKho().set(index, kho);
					modelkho.setValueAt(kho.getTenkho(), index, 1);					
						
					
				}
			}
		});
		btnSua.setBounds(352, 63, 89, 23);
		panel_dt.add(btnSua);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBounds(352, 93, 89, 23);
		panel_dt.add(btnThoat);
		
		JScrollPane scrollPane_dt = new JScrollPane();
		scrollPane_dt.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_dt.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_dt.setBounds(9, 151, 449, 141);
		contentPane.add(scrollPane_dt);
		
		tbkho = new JTable(modelkho);
		tbkho.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbkho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = tbkho.getSelectedRow();
				if(index != -1)
				{					
					String sct = modelkho.getValueAt(index, 1).toString();
					Kho kho = dskho.getByIndex(index);
					setForTextBox(kho);
				}
			}
		});
		modelkho.addColumn("Mã đối tượng");
		modelkho.addColumn("Tên đối tượng");
		for(Kho kho : dskho.getLstKho()){
			Object[] ob = {kho.getMakho(),kho.getTenkho()};
			modelkho.addRow(ob);
		}		
		scrollPane_dt.setViewportView(tbkho);
	}
	
	private void setForTextBox(Kho kho) {
		try {
			lammoitthongtin();			
			txtMakho.setText(kho.getMakho());
			txtTenkho.setText(kho.getTenkho());			
		} catch (NullPointerException e) {
			
		}
	}
	
	private void lammoitthongtin() {
		txtMakho.setText("");
		txtTenkho.setText("");				
	}
	private boolean kiemtrarong(){
		if(txtMakho.getText().equals("")||txtTenkho.getText().equals(""))
			return false;
		return true;
			
	}
	
}
