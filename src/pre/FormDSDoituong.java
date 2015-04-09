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

import dao.DoituongHome;
import model.Doituong;
import bus.DanhsachDoituong;


public class FormDSDoituong extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDT;
	public 	static JTextField txtDiachi;
	private JTable tbdoituong;
	DefaultTableModel modeldoituong= new DefaultTableModel();	
	private JTextField txtMaDT;
	private DanhsachDoituong dsDT=new DanhsachDoituong();
	private Doituong newdt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FormDSDoituong frame = new FormDSDoituong();
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
	public FormDSDoituong() {
		setTitle("Danh s\u00E1ch \u0111\u1ED1i t\u01B0\u1EE3ng");
		
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
		
		JLabel lblngaynhap = new JLabel("M\u00E3 \u0111\u1ED1i t\u01B0\u1EE3ng");
		lblngaynhap.setBounds(50, 11, 90, 14);
		panel_dt.add(lblngaynhap);
		
		JLabel lblsodt = new JLabel("T\u00EAn \u0111\u1ED1i t\u01B0\u1EE3ng");
		lblsodt.setBounds(50, 36, 90, 14);
		panel_dt.add(lblsodt);
		
		JLabel lblnhacc = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblnhacc.setBounds(50, 63, 90, 14);
		panel_dt.add(lblnhacc);
		
		txtTenDT = new JTextField();
		txtTenDT.setBounds(172, 33, 134, 20);
		panel_dt.add(txtTenDT);
		txtTenDT.setColumns(10);
		
		txtDiachi = new JTextField();		
		txtDiachi.setColumns(10);
		txtDiachi.setBounds(172, 60, 134, 20);
		panel_dt.add(txtDiachi);
		
		txtMaDT = new JTextField();
		txtMaDT.setColumns(10);
		txtMaDT.setBounds(172, 8, 134, 20);
		panel_dt.add(txtMaDT);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kiemtrarong()==false){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!!!");
				}
				else{
					newdt=new Doituong(txtMaDT.getText().toString(), txtTenDT.getText().toString(), txtDiachi.getText().toString());
					if(dsDT.getLstDoituong().contains(newdt)){
						JOptionPane.showMessageDialog(null, "Đối tượng này tồn tại!!!");
					}else{
						DoituongHome dthome=new DoituongHome();
						dthome.attachDirty(newdt);
						dsDT.getLstDoituong().add(newdt);
							Object[] ob = {newdt.getMadoituong(),newdt.getTendoituong(),newdt.getDiachi()};
							modeldoituong.addRow(ob);						
					}
				}
			}
		});
		btnThem.setBounds(352, 7, 89, 23);
		panel_dt.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tbdoituong.getSelectedRow();
				if(index != -1)
				{					
					Doituong dt = dsDT.getByIndex(index);
					setForTextBox(dt);
					lammoitthongtin();
					try {
						DoituongHome dthome=new DoituongHome();
						dthome.delete(dt);
						dsDT.getLstDoituong().remove(index);
						modeldoituong.removeRow(index);
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
				int index = tbdoituong.getSelectedRow();
				if(index != -1)
				{			
					DoituongHome dthome=new DoituongHome();
					Doituong dt = dsDT.getByIndex(index);										
					dt.setTendoituong(txtTenDT.getText().toString());
					dt.setDiachi(txtDiachi.getText().toString());
					dthome.merge(dt);
					dsDT.getLstDoituong().set(index, dt);
					modeldoituong.setValueAt(dt.getTendoituong(), index, 1);
					modeldoituong.setValueAt(dt.getDiachi(), index, 2);
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
		
		tbdoituong = new JTable(modeldoituong);
		tbdoituong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbdoituong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = tbdoituong.getSelectedRow();
				if(index != -1)
				{					
					String sct = modeldoituong.getValueAt(index, 1).toString();
					Doituong dt = dsDT.getByIndex(index);
					setForTextBox(dt);
				}
			}
		});
		modeldoituong.addColumn("Mã đối tượng");
		modeldoituong.addColumn("Tên đối tượng");
		modeldoituong.addColumn("Địa chỉ");	
		for(Doituong dt : dsDT.getLstDoituong()){
			Object[] ob = {dt.getMadoituong(),dt.getTendoituong(),dt.getDiachi()};
			modeldoituong.addRow(ob);
		}		
		scrollPane_dt.setViewportView(tbdoituong);
	}
	
	private void setForTextBox(Doituong dt) {
		try {
			lammoitthongtin();			
			txtMaDT.setText(dt.getMadoituong());
			txtTenDT.setText(dt.getTendoituong());
			txtDiachi.setText(dt.getDiachi());
		} catch (NullPointerException e) {
			
		}
	}
	
	private void lammoitthongtin() {
		txtMaDT.setText("");
		txtTenDT.setText("");		
		txtDiachi.setText("");		
	}
	private boolean kiemtrarong(){
		if(txtDiachi.getText().equals("")||txtMaDT.getText().equals("")||txtTenDT.getText().equals(""))
			return false;
		return true;
			
	}
	
}
