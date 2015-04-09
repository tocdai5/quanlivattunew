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

import dao.NhacungcapHome;
import model.Nhacungcap;
import bus.DanhsachNhacungcap;


public class FormDSNCC extends JFrame {

	private JPanel contentPane;
	private static JTextField txtTenNCC;
	public 	static JTextField txtDiachi;
	private JTable tbncc;
	DefaultTableModel modelncc= new DefaultTableModel();	
	private static JTextField txtMaNCC;
	private DanhsachNhacungcap dsNCC=new DanhsachNhacungcap();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FormDSNCC frame = new FormDSNCC();
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
	public FormDSNCC() {
		setTitle("Danh sách Nhà cung  cấp");
		
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
		
		JLabel lblMaNCC = new JLabel("Mã nhà cung cấp");
		lblMaNCC.setBounds(50, 11, 112, 14);
		panel_dt.add(lblMaNCC);
		
		JLabel lblTenNCC = new JLabel("Tên nhà cung cấp");
		lblTenNCC.setBounds(50, 36, 112, 14);
		panel_dt.add(lblTenNCC);
		
		JLabel lblDiachi = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblDiachi.setBounds(50, 63, 112, 14);
		panel_dt.add(lblDiachi);
		
		txtTenNCC = new JTextField();
		txtTenNCC.setBounds(172, 33, 134, 20);
		panel_dt.add(txtTenNCC);
		txtTenNCC.setColumns(10);
		
		txtDiachi = new JTextField();		
		txtDiachi.setColumns(10);
		txtDiachi.setBounds(172, 60, 134, 20);
		panel_dt.add(txtDiachi);
		
		txtMaNCC = new JTextField();
		txtMaNCC.setColumns(10);
		txtMaNCC.setBounds(172, 8, 134, 20);
		panel_dt.add(txtMaNCC);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(kiemtrarong()==false){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!!!");
				}
				else{
					Nhacungcap newncc=new Nhacungcap(txtMaNCC.getText().toString(), txtTenNCC.getText().toString(), txtDiachi.getText().toString());
					if(dsNCC.getLstNhacungcap().contains(newncc)){
						JOptionPane.showMessageDialog(null, "Đối tượng này tồn tại!!!");
					}else{						
						NhacungcapHome ncchome=new NhacungcapHome();
						ncchome.attachDirty(newncc);
						dsNCC.getLstNhacungcap().add(newncc);
							Object[] ob = {newncc.getManhacungcap() , newncc.getTennhacungcap()};
							modelncc.addRow(ob);						
					}
				}
			}
		});
		btnThem.setBounds(352, 7, 89, 23);
		panel_dt.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tbncc.getSelectedRow();
				if(index != -1)
				{					
					Nhacungcap ncc = dsNCC.getByIndex(index);
					setForTextBox(ncc);
					lammoitthongtin();
					try {
						NhacungcapHome ncchome=new NhacungcapHome();
						ncchome.delete(ncc);
						dsNCC.getLstNhacungcap().remove(index);
						modelncc.removeRow(index);
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "KhÃ´ng thá»ƒ xÃ³a vÃ¬ tá»“n táº¡i khÃ³a ngoáº¡i!!!");
					}
				}
			}
		});
		btnXoa.setBounds(352, 35, 89, 23);
		panel_dt.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tbncc.getSelectedRow();
				if(index != -1)
				{			
					NhacungcapHome ncchome=new NhacungcapHome();
					Nhacungcap ncc = dsNCC.getByIndex(index);										
					ncc.setTennhacungcap(txtTenNCC.getText().toString());
					ncc.setDiachi(txtDiachi.getText().toString());
					ncchome.merge(ncc);
					dsNCC.getLstNhacungcap().set(index, ncc);
					modelncc.setValueAt(ncc.getTennhacungcap(), index, 1);
					modelncc.setValueAt(ncc.getDiachi(), index, 2);
						
					
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
		
		tbncc = new JTable(modelncc);
		tbncc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbncc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = tbncc.getSelectedRow();
				if(index != -1)
				{					
					String sct = modelncc.getValueAt(index, 1).toString();
					Nhacungcap ncc = dsNCC.getByIndex(index);
					setForTextBox(ncc);
				}
			}
		});
		modelncc.addColumn("Mã đối tượng");
		modelncc.addColumn("Tên đối tượng");
		modelncc.addColumn("Địa chỉ");	
		for(Nhacungcap ncc : dsNCC.getLstNhacungcap()){
			Object[] ob = {ncc.getManhacungcap(),ncc.getTennhacungcap(),ncc.getDiachi()};
			modelncc.addRow(ob);
		}		
		scrollPane_dt.setViewportView(tbncc);
	}
	
	private void setForTextBox(Nhacungcap ncc) {
		try {
			lammoitthongtin();			
			txtMaNCC.setText(ncc.getManhacungcap());
			txtTenNCC.setText(ncc.getTennhacungcap());
			txtDiachi.setText(ncc.getDiachi());
		} catch (NullPointerException e) {
			
		}
	}
	
	private void lammoitthongtin() {
		txtMaNCC.setText("");
		txtTenNCC.setText("");		
		txtDiachi.setText("");		
	}
	private boolean kiemtrarong(){
		if(txtDiachi.getText().equals("")||txtMaNCC.getText().equals("")||txtTenNCC.getText().equals(""))
			return false;
		return true;
			
	}
	
}
