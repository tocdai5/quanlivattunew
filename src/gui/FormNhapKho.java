package gui;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;

import model.Hoadon;
import dao.HoadonHome;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

import bus.DanhsachHoadon;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormNhapKho extends JFrame {

	private JPanel contentPane;
	private JDateChooser dateNgaynhap;
	private JTextField txtnguoinhan;
	private JTextField txtsohoadon;
	private JTextField txtMavt;
	private JTextField txtdvt;
	private JTextField txtthue;
	private JTextField txtghichu;
	private JTextField txttenvattu;
	private JTextField txtsoluong;
	private JTextField txtdongia;
	private JTable tbvattu;
	private JTextField txtsochungtu;
	private JTextField txtnhacungcap;
	private JTextField txtkhonhap;
	private JTextField txtdiachi;
	private JTextField txtgc;
	private JTable tbhoadon;
	DefaultTableModel modelhoadon= new DefaultTableModel();
	DefaultTableModel modelvattu= new DefaultTableModel();
	private HoadonHome homehd=new HoadonHome();
	private DanhsachHoadon dsHD;
	private JTextField txtThanhtien;
	
	private JComboBox cbloaihd ;
	private JComboBox cbnguoikt ;
	private JComboBox cbthanhtoan;
	
	private boolean enableBtn = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FormNhapKho frame = new FormNhapKho();
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
	public FormNhapKho() {
		load();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 720, 487);
		setSize(813,662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_hd = new JPanel();
		panel_hd.setBounds(10, 33, 485, 165);
		contentPane.add(panel_hd);
		panel_hd.setLayout(null);
		
		JLabel lblngaynhap = new JLabel("Ng\u00E0y Nh\u1EADp");
		lblngaynhap.setBounds(10, 11, 90, 14);
		panel_hd.add(lblngaynhap);
		
		JLabel lblsohd = new JLabel("S\u1ED1 H\u00F3a \u0110\u01A1n");
		lblsohd.setBounds(10, 36, 90, 14);
		panel_hd.add(lblsohd);
		
		JLabel lblnhacc = new JLabel("Nh\u00E0 Cung C\u1EA5p");
		lblnhacc.setBounds(10, 63, 90, 14);
		panel_hd.add(lblnhacc);
		
		JLabel lblloaihd = new JLabel("Lo\u1EA1i H\u00F3a \u0110\u01A1n");
		lblloaihd.setBounds(10, 88, 90, 14);
		panel_hd.add(lblloaihd);
		
		JLabel lblnguoikt = new JLabel("Ng\u01B0\u1EDDi Ki\u1EC3m Tra");
		lblnguoikt.setBounds(10, 113, 90, 14);
		panel_hd.add(lblnguoikt);
		
		JLabel lblGhiChu = new JLabel("Ghi Ch\u00FA");
		lblGhiChu.setBounds(10, 138, 90, 14);
		panel_hd.add(lblGhiChu);
		
		JLabel lblsoct = new JLabel("S\u1ED1 Ch\u1EE9ng T\u1EEB");
		lblsoct.setBounds(251, 11, 84, 14);
		panel_hd.add(lblsoct);
		
		JLabel lblkhonhap = new JLabel("Kho Nh\u1EADp");
		lblkhonhap.setBounds(251, 36, 68, 14);
		panel_hd.add(lblkhonhap);
		
		JLabel lbldiachi = new JLabel("\u0110\u1ECBa Ch\u1EC9");
		lbldiachi.setBounds(251, 63, 68, 14);
		panel_hd.add(lbldiachi);
		
		JLabel lblThanhtoan = new JLabel("Thanh To\u00E1n");
		lblThanhtoan.setBounds(251, 88, 68, 14);
		panel_hd.add(lblThanhtoan);
		
		JLabel lblNguoinhan = new JLabel("Ng\u01B0\u1EDDi Nh\u1EADn");
		lblNguoinhan.setBounds(251, 113, 68, 14);
		panel_hd.add(lblNguoinhan);
		
		txtnguoinhan = new JTextField();
		txtnguoinhan.setBounds(376, 110, 86, 20);
		panel_hd.add(txtnguoinhan);
		txtnguoinhan.setColumns(10);
		
		txtsohoadon = new JTextField();
		txtsohoadon.setBounds(110, 33, 116, 20);
		panel_hd.add(txtsohoadon);
		txtsohoadon.setColumns(10);
		
		cbloaihd = new JComboBox();
		cbloaihd.setEditable(true);
		cbloaihd.setBounds(110, 85, 116, 20);
		panel_hd.add(cbloaihd);
		
		cbnguoikt = new JComboBox();
		cbnguoikt.setEditable(true);
		cbnguoikt.setBounds(110, 110, 116, 20);
		panel_hd.add(cbnguoikt);
		
		cbthanhtoan = new JComboBox();
		cbthanhtoan.setEditable(true);
		cbthanhtoan.setBounds(376, 85, 86, 20);
		panel_hd.add(cbthanhtoan);
		
		txtsochungtu = new JTextField();
		txtsochungtu.setColumns(10);
		txtsochungtu.setBounds(376, 8, 86, 20);
		panel_hd.add(txtsochungtu);
		
		txtnhacungcap = new JTextField();
		txtnhacungcap.setEditable(false);
		txtnhacungcap.setColumns(10);
		txtnhacungcap.setBounds(110, 60, 116, 20);
		panel_hd.add(txtnhacungcap);
		
		txtkhonhap = new JTextField();
		txtkhonhap.setEditable(false);
		txtkhonhap.setColumns(10);
		txtkhonhap.setBounds(376, 33, 86, 20);
		panel_hd.add(txtkhonhap);
		
		txtdiachi = new JTextField();
		txtdiachi.setEditable(false);
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(376, 60, 86, 20);
		panel_hd.add(txtdiachi);
		
		txtgc = new JTextField();
		txtgc.setColumns(10);
		txtgc.setBounds(110, 135, 352, 20);
		panel_hd.add(txtgc);
		
		dateNgaynhap = new JDateChooser();
		dateNgaynhap.getCalendarButton().setEnabled(false);
		dateNgaynhap.setDateFormatString(" dd /MM/yyyy");
		dateNgaynhap.setBounds(110, 8, 116, 20);
		panel_hd.add(dateNgaynhap);
		
		JButton btthemhd = new JButton("Th\u00EAm H\u00F3a \u0110\u01A1n");
		btthemhd.setEnabled(false);
		btthemhd.setBounds(518, 35, 107, 56);
		contentPane.add(btthemhd);
		
		JButton btinhoadon = new JButton("In H\u00F3a \u0110\u01A1n");
		btinhoadon.setBounds(661, 35, 99, 56);
		contentPane.add(btinhoadon);
		
		JButton btsuahd = new JButton("S\u1EEDa H\u00F3a \u0110\u01A1n");
		btsuahd.setBounds(518, 125, 107, 56);
		contentPane.add(btsuahd);
		
		JButton btlammoi = new JButton("L\u00E0m M\u1EDBi");
		btlammoi.setBounds(661, 125, 99, 56);
		contentPane.add(btlammoi);
		
		JScrollPane scrollPane_hd = new JScrollPane();
		scrollPane_hd.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_hd.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_hd.setBounds(10, 209, 777, 76);
		contentPane.add(scrollPane_hd);
		
		tbhoadon = new JTable(modelhoadon);
		tbhoadon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = tbhoadon.getSelectedRow();
				String sct = modelhoadon.getValueAt(index, 1).toString();
				Hoadon hd = dsHD.getByIndex(index);
				setForTextBox(hd);
			}
		});
		modelhoadon.addColumn("Ngày nhập");
		modelhoadon.addColumn("Số chứng từ");
		modelhoadon.addColumn("Số hóa đơn");
		modelhoadon.addColumn("Kho nhập");
		modelhoadon.addColumn("Nhà cung cấp");	
		modelhoadon.addColumn("Địa chỉ");
		modelhoadon.addColumn("Loại hóa đơn");
		modelhoadon.addColumn("Thanh toán");	
		modelhoadon.addColumn("Người kiểm tra");
		modelhoadon.addColumn("Người nhận");
		modelhoadon.addColumn("Ghi chú");
		for(Hoadon hd: dsHD.getListHD()){
			Object[] ob={getFormatDate(hd.getNgay()),hd.getSochungtu(),hd.getSohoadon(),hd.getKho(),
					hd.getNhacungcap(),hd.getDoituong(),hd.getLoaihoadon(),	hd.getThanhtoan(),
					hd.getUser(),hd.getNguoinhan(),hd.getGhichu()};
			modelhoadon.addRow(ob);
		}
		scrollPane_hd.setViewportView(tbhoadon);
		
		JButton btthem = new JButton("Th\u00EAm");
		btthem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selected = tbhoadon.getSelectedRow();
				if(selected != -1)
				{
					
				}
			}
		});
		btthem.setBounds(500, 333, 89, 46);
		contentPane.add(btthem);
		
		JButton btxoa = new JButton("X\u00F3a");
		btxoa.setBounds(599, 333, 89, 46);
		contentPane.add(btxoa);
		
		JButton btsua = new JButton("S\u1EEDa");
		btsua.setBounds(698, 333, 89, 46);
		contentPane.add(btsua);
		
		JPanel panel_cthd = new JPanel();
		panel_cthd.setBounds(10, 294, 485, 144);
		contentPane.add(panel_cthd);
		panel_cthd.setLayout(null);
		
		JLabel lblmavt = new JLabel("M\u00E3 V\u1EADt T\u01B0");
		lblmavt.setBounds(10, 24, 83, 14);
		panel_cthd.add(lblmavt);
		
		JLabel lbldvt = new JLabel("\u0110\u01A1n V\u1ECB T\u00EDnh");
		lbldvt.setBounds(10, 49, 70, 14);
		panel_cthd.add(lbldvt);
		
		JLabel lblthue = new JLabel("Thu\u1EBF");
		lblthue.setBounds(10, 74, 46, 14);
		panel_cthd.add(lblthue);
		
		JLabel lblGhiCh_1 = new JLabel("Ghi Ch\u00FA");
		lblGhiCh_1.setBounds(10, 107, 46, 14);
		panel_cthd.add(lblGhiCh_1);
		
		JLabel lbltenvt = new JLabel("T\u00EAn v\u1EADt t\u01B0");
		lbltenvt.setBounds(250, 24, 83, 14);
		panel_cthd.add(lbltenvt);
		
		JLabel lblSLng = new JLabel("s\u1ED1 L\u01B0\u1EE3ng");
		lblSLng.setBounds(250, 49, 46, 14);
		panel_cthd.add(lblSLng);
		
		JLabel lbldg = new JLabel("\u0110\u01A1n Gi\u00E1");
		lbldg.setBounds(250, 74, 46, 14);
		panel_cthd.add(lbldg);
		
		txtMavt = new JTextField();
		txtMavt.setEditable(false);
		txtMavt.setBounds(85, 21, 122, 20);
		panel_cthd.add(txtMavt);
		txtMavt.setColumns(10);
		
		txtdvt = new JTextField();
		txtdvt.setEditable(false);
		txtdvt.setBounds(85, 46, 122, 20);
		panel_cthd.add(txtdvt);
		txtdvt.setColumns(10);
		
		txtthue = new JTextField();
		txtthue.setBounds(85, 71, 122, 20);
		panel_cthd.add(txtthue);
		txtthue.setColumns(10);
		
		txtghichu = new JTextField();
		txtghichu.setBounds(85, 104, 372, 20);
		panel_cthd.add(txtghichu);
		txtghichu.setColumns(10);
		
		txttenvattu = new JTextField();
		txttenvattu.setEditable(false);
		txttenvattu.setBounds(350, 21, 107, 20);
		panel_cthd.add(txttenvattu);
		txttenvattu.setColumns(10);
		
		txtsoluong = new JTextField();
		txtsoluong.setColumns(10);
		txtsoluong.setBounds(350, 46, 107, 20);
		panel_cthd.add(txtsoluong);
		
		txtdongia = new JTextField();
		txtdongia.setEditable(false);
		txtdongia.setColumns(10);
		txtdongia.setBounds(350, 71, 107, 20);
		panel_cthd.add(txtdongia);
		
		JScrollPane scrollPane_cthd = new JScrollPane();
		scrollPane_cthd.setBounds(10, 449, 777, 127);
		contentPane.add(scrollPane_cthd);
		
		tbvattu = new JTable(modelvattu);
		modelvattu.addColumn("Sá»‘ chá»©ng tá»«");
		modelvattu.addColumn("MÃ£ váº­t tÆ°");
		modelvattu.addColumn("TÃªn váº­t tÆ°");
		modelvattu.addColumn("Ä�VT");
		modelvattu.addColumn("Sá»‘ lÆ°á»£ng");
		modelvattu.addColumn("Ä�Æ¡n giÃ¡");
		modelvattu.addColumn("Thuáº¿");
		modelvattu.addColumn("ThÃ nh tiá»�n");
		
		scrollPane_cthd.setViewportView(tbvattu);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1184, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Nháº­p");
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mnNewMenu.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Danh má»¥c");
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("GiÃºp Ä‘á»¡");
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
		
		JLabel lblThanhtien = new JLabel("Tá»•ng thÃ nh tiá»�n :");
		lblThanhtien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThanhtien.setBounds(432, 599, 126, 14);
		contentPane.add(lblThanhtien);
		
		txtThanhtien = new JTextField();
		txtThanhtien.setBounds(583, 596, 151, 20);
		contentPane.add(txtThanhtien);
		txtThanhtien.setColumns(10);
		
		
	}
	protected void setForTextBox(Hoadon hd) {
		try {
			dateNgaynhap.setDate(hd.getNgay());
			txtsochungtu.setText(hd.getSochungtu());
			if(hd.getSohoadon() == null )
			{
				txtsohoadon.setText("");
			}
			else
			{
				txtsohoadon.setText(Integer.toString(hd.getSohoadon()));
			}
			txtkhonhap.setText(hd.getKho().toString());
			txtnhacungcap.setText(hd.getNhacungcap().toString());
			txtdiachi.setText(hd.getNhacungcap().toString());
			txtnguoinhan.setText(hd.getNguoinhan().toString());
			txtgc.setText(hd.getGhichu().toString());
			cbloaihd.setSelectedItem(hd.getLoaihoadon());
			cbthanhtoan.setSelectedItem(hd.getThanhtoan());
			cbnguoikt.setSelectedItem(hd.getUser().toString());
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			
		}
		
	}

	private void load(){
		dsHD= new DanhsachHoadon( );
	}
	
	public String getFormatDate(Date d)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String formatString = sdf.format(d);
		return formatString;
	}
	
	public void setEnableBtnThem(JButton bt)
	{
		if(enableBtn == false)
		{
			enableBtn = true;
			bt.setEnabled(true);
		}
	}
}
