package pre;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Chitiethoadon;
import model.Doituong;
import model.Hoadon;
import model.Kho;
import model.Nhacungcap;
import model.User;
import model.Vattu;
import bus.DanhSachChitiethoadon;
import bus.DanhsachHoadon;

import com.toedter.calendar.JDateChooser;

import dao.HoadonHome;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class FormXuatKho extends JFrame {

	private JPanel contentPane;
	private JDateChooser dateNgaynhap;
	private JTextField txtnguoinhan;
	private JTextField txtMakho;
	public static JTextField txtMavt;
	public static JTextField txtdvt;
	private JTextField txthangton;
	private JTextField txtghichu;
	public static JTextField txttenvattu;
	private JTextField txtsoluong;
	public static JTextField txtdongia;
	private JTable tbvattu;
	private JTextField txtsochungtu;
	public 	static JTextField txtTendoituong;
	public static JTextField txtTenkho;
	public static JTextField txtdiachi;
	private JTextField txthdgc;
	private JTable tbhoadon;
	DefaultTableModel modelhoadon= new DefaultTableModel();
	DefaultTableModel modelvattu= new DefaultTableModel();
	private HoadonHome homehd=new HoadonHome();
	
	private JTextField txtThanhtien;
	private JComboBox cbnguoikt ;
	
	private boolean enableBtn = false;
	
	private DanhsachHoadon dsHD = new DanhsachHoadon();
	private DanhSachChitiethoadon dscthd = new DanhSachChitiethoadon();
	public static Kho kho;
	public static Nhacungcap nhacungcap;
	public static User user;
	public static Vattu vt;
	public static Doituong dt;
	public final JMenuItem mntmDanhMcKho = new JMenuItem("Danh mục Kho");
	public final JMenuItem mntmDanhMcNh = new JMenuItem("Danh mục Nhà cung cấp");
	public final JMenuItem mntmDanhMci = new JMenuItem("Danh mục Đối tượng");
	public final JMenuItem mntmDanhMcVt = new JMenuItem("Danh mục Vật tư");
	public final JMenuItem mntmDanhSch = new JMenuItem("Danh sách Đối tượng");
	public final JMenuItem mntmDanhSchNh = new JMenuItem("Danh sách Nhà cung cấp");
	public final JMenuItem mntmDanhSchKho = new JMenuItem("Danh sách Kho");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FormXuatKho frame = new FormXuatKho();
					frame.setVisible(true);
					frame.setResizable(false);
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
	public FormXuatKho() {
		setTitle("Xuất kho");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 720, 487);
		setSize(905,680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_hd = new JPanel();
		panel_hd.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "H\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_hd.setBounds(10, 32, 589, 183);
		contentPane.add(panel_hd);
		panel_hd.setLayout(null);
		
		JLabel lblngaynhap = new JLabel("Ngày Xuất");
		lblngaynhap.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblngaynhap.setBounds(10, 26, 90, 14);
		panel_hd.add(lblngaynhap);
		
		JLabel lblsohd = new JLabel("Mã kho");
		lblsohd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblsohd.setBounds(10, 51, 90, 14);
		panel_hd.add(lblsohd);
		
		JLabel lblnhacc = new JLabel("Đối tượng");
		lblnhacc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblnhacc.setBounds(10, 85, 90, 14);
		panel_hd.add(lblnhacc);
		
		JLabel lblnguoikt = new JLabel("Ng\u01B0\u1EDDi Ki\u1EC3m Tra");
		lblnguoikt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblnguoikt.setBounds(10, 123, 90, 14);
		panel_hd.add(lblnguoikt);
		
		JLabel lblGhiChu = new JLabel("Ghi Ch\u00FA");
		lblGhiChu.setBounds(10, 151, 90, 14);
		panel_hd.add(lblGhiChu);
		
		JLabel lblsoct = new JLabel("S\u1ED1 Ch\u1EE9ng T\u1EEB");
		lblsoct.setBounds(307, 26, 84, 14);
		panel_hd.add(lblsoct);
		
		JLabel lblkhonhap = new JLabel("Tên kho");
		lblkhonhap.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblkhonhap.setBounds(307, 54, 68, 14);
		panel_hd.add(lblkhonhap);
		
		JLabel lbldiachi = new JLabel("\u0110\u1ECBa Ch\u1EC9");
		lbldiachi.setBounds(305, 85, 68, 14);
		panel_hd.add(lbldiachi);
		
		JLabel lblNguoinhan = new JLabel("Ng\u01B0\u1EDDi Nh\u1EADn");
		lblNguoinhan.setBounds(307, 123, 68, 14);
		panel_hd.add(lblNguoinhan);
		
		txtnguoinhan = new JTextField();
		txtnguoinhan.setBounds(385, 120, 103, 20);
		panel_hd.add(txtnguoinhan);
		txtnguoinhan.setColumns(10);
		
		txtMakho = new JTextField();
		txtMakho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 )
				{
					FormDMKho fKho = new FormDMKho();
					fKho.setVisible(true);
					fKho.setAlwaysOnTop(true);
				}
			}
		});
		txtMakho.setEditable(false);
		txtMakho.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtMakho.setBounds(110, 51, 154, 20);
		panel_hd.add(txtMakho);
		txtMakho.setColumns(10);
		
		String items[] = {"Tài chính" , "Bán lẻ"};
		
		cbnguoikt = new JComboBox();
		cbnguoikt.setEditable(true);
		cbnguoikt.setBounds(110, 120, 154, 20);
		panel_hd.add(cbnguoikt);
		
		String itms[] = {"Tiền mặt" , "Chuyển khoản"};
		
		txtsochungtu = new JTextField();
		txtsochungtu.setEditable(false);
		txtsochungtu.setColumns(10);
		txtsochungtu.setBounds(383, 23, 179, 20);
		panel_hd.add(txtsochungtu);
		
		txtTendoituong = new JTextField();
		txtTendoituong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 )
				{
					FormNhacungcap fncc = new FormNhacungcap();
					fncc.setVisible(true);
					fncc.setAlwaysOnTop(true);
				}
			}
		});
		txtTendoituong.setEditable(false);
		txtTendoituong.setColumns(10);
		txtTendoituong.setBounds(110, 82, 154, 20);
		panel_hd.add(txtTendoituong);
		
		txtTenkho = new JTextField();
		txtTenkho.setEditable(false);
		txtTenkho.setColumns(10);
		txtTenkho.setBounds(383, 51, 179, 20);
		panel_hd.add(txtTenkho);
		
		txtdiachi = new JTextField();
		txtdiachi.setEditable(false);
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(383, 82, 179, 20);
		panel_hd.add(txtdiachi);
		
		txthdgc = new JTextField();
		txthdgc.setColumns(10);
		txthdgc.setBounds(110, 148, 452, 20);
		panel_hd.add(txthdgc);
		
		dateNgaynhap = new JDateChooser();
		dateNgaynhap.getCalendarButton().setEnabled(false);
		dateNgaynhap.setDateFormatString(" dd/MM/yyyy");
		dateNgaynhap.setBounds(110, 23, 154, 20);
		panel_hd.add(dateNgaynhap);
		
		JButton btthemhd = new JButton("Th\u00EAm H\u00F3a \u0110\u01A1n");
		btthemhd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btthemhd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hoadon hd = getThongtinHoadon();
				if(dscthd.getCthds().size() != 0)
				{
					hd.setChitiethoadons(dscthd.getCthds());
				}
				if(dsHD.themHoadon(hd))
				{
					JOptionPane.showMessageDialog(null, "Them hoa don thanh cong");
					themxuongModelHoadon();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Them hoa don khong thanh cong");
				}
			}
		});
		btthemhd.setBounds(620, 62, 116, 56);
		
		contentPane.add(btthemhd);
		
		JButton btinhoadon = new JButton("In H\u00F3a \u0110\u01A1n");
		btinhoadon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btinhoadon.setBounds(768, 62, 111, 56);
		contentPane.add(btinhoadon);
		
		JButton btsuahd = new JButton("S\u1EEDa H\u00F3a \u0110\u01A1n");
		btsuahd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btsuahd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tbhoadon.getSelectedRow();
				if(index != -1)
				{
					Hoadon hd = dsHD.getByIndex(index);
					suathongtinHoadon(hd);
					suaduoimodel(index,hd);
				}

			}
		});
		btsuahd.setBounds(620, 151, 116, 56);
		contentPane.add(btsuahd);
		
		JButton btlammoi = new JButton("L\u00E0m M\u1EDBi");
		btlammoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btlammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lammoitthongtin();
				modelvattu.setRowCount(0);
				setSochungtu();
				xoatrangCthd();
			}
		});
		btlammoi.setBounds(768, 151, 111, 56);
		contentPane.add(btlammoi);
		
		JScrollPane scrollPane_hd = new JScrollPane();
		scrollPane_hd.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_hd.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_hd.setBounds(10, 226, 869, 110);
		contentPane.add(scrollPane_hd);
		
		tbhoadon = new JTable(modelhoadon);
		tbhoadon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbhoadon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = tbhoadon.getSelectedRow();
				if(index != -1)
				{
					String sct = modelhoadon.getValueAt(index, 1).toString();
					Hoadon hd = dsHD.getByIndex(index);
					setForTextBox(hd);
					setChitiethoadon(hd);
					tinhTongThanhtien();
					xoatrangCthd();
				}
			}
		});
		modelhoadon.addColumn("Ngày xuất");
		modelhoadon.addColumn("Số chứng từ");
		modelhoadon.addColumn("Tên kho");
		modelhoadon.addColumn("Đối tượng");
		modelhoadon.addColumn("Địa chỉ");
		modelhoadon.addColumn("Người kiểm tra");
		modelhoadon.addColumn("Người nhận");
		modelhoadon.addColumn("Ghi chú");
		themxuongModelHoadon();
		
		scrollPane_hd.setViewportView(tbhoadon);
		
		JButton btthem = new JButton("Th\u00EAm");
		btthem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btthem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!kiemtrathongtinkhongrong())
					return;
				Chitiethoadon cthd = getChitiethoadon();
				boolean kt = dscthd.themChitiethoadon(cthd);
				if(kt)
				{
					themlentable(cthd);
					tinhTongThanhtien();
				}
				else
					JOptionPane.showMessageDialog(null, "Chi tiet hoa don da ton tai");
				
			}
		});
		btthem.setBounds(549, 396, 89, 46);
		contentPane.add(btthem);
		
		JButton btxoa = new JButton("X\u00F3a");
		btxoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tbvattu.getSelectedRow();
				if(index != -1)
				{
					Chitiethoadon cthd = getChitiethoadon();
					dscthd.xoaCthd(cthd);
					xoatrangCthd();
					lammoiTableVattu();
					tinhTongThanhtien();
				}
				
			}
		});
		btxoa.setBounds(667, 396, 89, 46);
		contentPane.add(btxoa);
		
		JButton btsua = new JButton("S\u1EEDa");
		btsua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tbvattu.getSelectedRow();
				if(index != -1)
				{
					Chitiethoadon cthd = getChitiethoadon();
					if(dscthd.suaCthd(cthd) == null){
						JOptionPane.showMessageDialog(null, "Sua khong thanh cong");
					}
					else
					{
						suaVattutrenTextBox(cthd);
						suaVattuDuoiModel(index , cthd);
						tinhTongThanhtien();
					}
				}
			}
		});
		btsua.setBounds(790, 396, 89, 46);
		contentPane.add(btsua);
		
		JPanel panel_cthd = new JPanel();
		panel_cthd.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Chi ti\u1EBFt h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		panel_cthd.setBounds(10, 347, 507, 144);
		contentPane.add(panel_cthd);
		panel_cthd.setLayout(null);
		
		JLabel lblmavt = new JLabel("M\u00E3 V\u1EADt T\u01B0");
		lblmavt.setBounds(10, 24, 83, 14);
		panel_cthd.add(lblmavt);
		
		JLabel lbldvt = new JLabel("\u0110\u01A1n V\u1ECB T\u00EDnh");
		lbldvt.setBounds(10, 49, 70, 14);
		panel_cthd.add(lbldvt);
		
		JLabel lblthue = new JLabel("Trong kho còn");
		lblthue.setBounds(10, 74, 83, 14);
		panel_cthd.add(lblthue);
		
		JLabel lblGhiCh_1 = new JLabel("Ghi Ch\u00FA");
		lblGhiCh_1.setBounds(10, 107, 46, 14);
		panel_cthd.add(lblGhiCh_1);
		
		JLabel lbltenvt = new JLabel("T\u00EAn v\u1EADt t\u01B0");
		lbltenvt.setBounds(250, 24, 83, 14);
		panel_cthd.add(lbltenvt);
		
		JLabel lblSLng = new JLabel("Số Lượng");
		lblSLng.setBounds(250, 49, 70, 14);
		panel_cthd.add(lblSLng);
		
		JLabel lbldg = new JLabel("\u0110\u01A1n Gi\u00E1");
		lbldg.setBounds(250, 74, 46, 14);
		panel_cthd.add(lbldg);
		
		txtMavt = new JTextField();
		txtMavt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 )
				{
					FormVattu fvt = new FormVattu();
					fvt.setVisible(true);
					fvt.setAlwaysOnTop(true);
				}
			}
		});
		txtMavt.setEditable(false);
		txtMavt.setBounds(95, 21, 122, 20);
		panel_cthd.add(txtMavt);
		txtMavt.setColumns(10);
		
		txtdvt = new JTextField();
		txtdvt.setEditable(false);
		txtdvt.setBounds(95, 46, 122, 20);
		panel_cthd.add(txtdvt);
		txtdvt.setColumns(10);
		
		txthangton = new JTextField();
		txthangton.setBounds(95, 71, 122, 20);
		panel_cthd.add(txthangton);
		txthangton.setColumns(10);
		
		txtghichu = new JTextField();
		txtghichu.setBounds(95, 104, 389, 20);
		panel_cthd.add(txtghichu);
		txtghichu.setColumns(10);
		
		txttenvattu = new JTextField();
		txttenvattu.setEditable(false);
		txttenvattu.setBounds(350, 21, 134, 20);
		panel_cthd.add(txttenvattu);
		txttenvattu.setColumns(10);
		
		txtsoluong = new JTextField();
		txtsoluong.setColumns(10);
		txtsoluong.setBounds(350, 46, 134, 20);
		panel_cthd.add(txtsoluong);
		
		txtdongia = new JTextField();
		txtdongia.setEditable(false);
		txtdongia.setColumns(10);
		txtdongia.setBounds(350, 71, 134, 20);
		panel_cthd.add(txtdongia);
		
		JScrollPane scrollPane_cthd = new JScrollPane();
		scrollPane_cthd.setBounds(10, 502, 869, 100);
		contentPane.add(scrollPane_cthd);
		
		tbvattu = new JTable(modelvattu);
		tbvattu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tbvattu.getSelectedRow();
				if(index != -1)
				{
					themDulieuLenTextBoxChitiethoadon(index);
				}
			}
		});
		modelvattu.addColumn("Số chứng từ");
		modelvattu.addColumn("Mã vật tư");
		modelvattu.addColumn("Tên vật tư");
		modelvattu.addColumn("ĐVT");
		modelvattu.addColumn("Số lượng");
		modelvattu.addColumn("Đơn giá");
		modelvattu.addColumn("Thuế");
		modelvattu.addColumn("Thành tiền");
		modelvattu.addColumn("Ghi chú");
		
		scrollPane_cthd.setViewportView(tbvattu);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1184, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Nhập");
		mnNewMenu.setFont(new Font("Arial", mnNewMenu.getFont().getStyle() | Font.BOLD, 12));
		mnNewMenu.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(mnNewMenu);
		{
			mnNewMenu.add(this.mntmDanhSch);
		}
		{
			mnNewMenu.add(this.mntmDanhSchNh);
		}
		{
			mnNewMenu.add(this.mntmDanhSchKho);
		}
		
		JMenuItem mntmDanhSchVt = new JMenuItem("Danh sách Vật tư");
		mnNewMenu.add(mntmDanhSchVt);
		
		JMenu mnNewMenu_1 = new JMenu("Danh mục");
		mnNewMenu_1.setFont(new Font("Arial", mnNewMenu_1.getFont().getStyle() | Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		{
			this.mntmDanhMcKho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					FormDMKho fdmkho = new FormDMKho();
					fdmkho.setVisible(true);
					fdmkho.setAlwaysOnTop(true);
				}
			});
			mnNewMenu_1.add(this.mntmDanhMcKho);
		}
		{
			this.mntmDanhMcNh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FormNhacungcap fncc = new FormNhacungcap();
					fncc.setVisible(true);
					fncc.setAlwaysOnTop(true);
				}
			});
			mnNewMenu_1.add(this.mntmDanhMcNh);
		}
		{
			this.mntmDanhMci.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnNewMenu_1.add(this.mntmDanhMci);
		}
		{
			this.mntmDanhMcVt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FormVattu fvt = new FormVattu();
					fvt.setVisible(true);
					fvt.setAlwaysOnTop(true);
				}
			});
			mnNewMenu_1.add(this.mntmDanhMcVt);
		}
		
		JMenu mnNewMenu_2 = new JMenu("Giúp đỡ");
		mnNewMenu_2.setFont(new Font("Arial", mnNewMenu_2.getFont().getStyle() | Font.BOLD, mnNewMenu_2.getFont().getSize()));
		menuBar.add(mnNewMenu_2);
		
		JLabel lblThanhtien = new JLabel("Tổng thành tiền :");
		lblThanhtien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThanhtien.setBounds(560, 613, 126, 20);
		contentPane.add(lblThanhtien);
		
		txtThanhtien = new JTextField();
		txtThanhtien.setBounds(714, 611, 151, 20);
		contentPane.add(txtThanhtien);
		txtThanhtien.setColumns(10);
		
		setSochungtu();
		setNgaynhap();
		setNguoikiemtra();
	}
	

	protected boolean kiemtrathongtinkhongrong() {
		if(txtMavt.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Ma vat tu khong the rong");
			return false;
		}
		else if(txtsoluong.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "So luong vat tu khong the rong");
			return false;
		}
		else if(txthangton.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Thue khong the rong");
			return false;
		}
		return true;
	}

	protected void tinhTongThanhtien() {
		double tongthanhtien = dscthd.tinhTongthanhtien() ;
		if(tongthanhtien > 0)
			txtThanhtien.setText(String.valueOf(tongthanhtien));
		else
			txtThanhtien.setText("");
	}

	// con bo sung them
	protected void suaduoimodel(int index, Hoadon hd) {
		String loaihd = hd.getLoaihoadon();
		String thanhtoan = hd.getThanhtoan();
		String nguoinhan = hd.getNguoinhan();
		modelhoadon.setValueAt(loaihd, index, 6);
		modelhoadon.setValueAt(thanhtoan, index, 7);
		modelhoadon.setValueAt(nguoinhan, index, 9);
	}

	// bo sung them
	protected void suathongtinHoadon(Hoadon hd) {
		//hd.setUser(user) test truoc da
		String nguoinhan = txtnguoinhan.getText();
		if(!nguoinhan.isEmpty()){
			hd.setNguoinhan(nguoinhan);
		}
	}

	private void themxuongModelHoadon() {
		modelhoadon.setRowCount(0);
		for(Hoadon hd: dsHD.getListHD()){
			Object[] ob={getFormatDate(hd.getNgay()),hd.getSochungtu(),hd.getSohoadon(),hd.getKho(),
					hd.getNhacungcap(),hd.getDoituong(),hd.getLoaihoadon(),	hd.getThanhtoan(),
					hd.getUser(),hd.getNguoinhan(),hd.getGhichu()};
			modelhoadon.addRow(ob);
		}
	}

	protected void suaVattuDuoiModel(int index, Chitiethoadon cthd) {
		int sl = cthd.getSoluong();
		float thue = cthd.getThue();
		double thanhtien = cthd.getThanhtien();
		modelvattu.setValueAt(String.valueOf(sl), index, 4);
		modelvattu.setValueAt(String.valueOf(thue), index, 6);
		modelvattu.setValueAt(String.valueOf(thanhtien), index, 7);
		modelvattu.setValueAt(cthd.getGhichu(), index, 8);
	}

	protected void suaVattutrenTextBox(Chitiethoadon cthd) {
		
	}

	protected void themDulieuLenTextBoxChitiethoadon(int index) {
		String mavattu = modelvattu.getValueAt(index, 1).toString();
		Chitiethoadon cthd = dscthd.timCthd(mavattu);
		vt = cthd.getVattu();
		txtMavt.setText(vt.getMavattu());
		txttenvattu.setText(vt.getTenvattu());
		txtdvt.setText(vt.getDonvitinh());
		txtdongia.setText(String.valueOf(vt.getDongia()));
		txtsoluong.setText(String.valueOf(cthd.getSoluong()));
		txthangton.setText(String.valueOf(cthd.getThue()));
		txtghichu.setText(cthd.getGhichu());
	}

	protected void lammoiTableVattu() {
		modelvattu.setRowCount(0);
		for(Iterator<Chitiethoadon> it = dscthd.getCthds().iterator() ; it.hasNext() ; )
		{
			Chitiethoadon cthd = it.next();
			themlentable(cthd);
		}
	}

	protected void xoatrangCthd() {
		txtMavt.setText("");
		txttenvattu.setText("");
		txtdongia.setText("");
		txtdvt.setText("");
		txtsoluong.setText("");
		txthangton.setText("");
		txtghichu.setText("");
	}

	protected void themlentable(Chitiethoadon cthd) {
		Object[] ob = {cthd.getId(), cthd.getVattu().getMavattu() , cthd.getVattu().getTenvattu() , cthd.getVattu().getDonvitinh() ,cthd.getSoluong() , cthd.getVattu().getDongia() , 
				 getThanhtien(cthd.getSoluong(), cthd.getVattu().getDongia()) ,cthd.getGhichu()};
		modelvattu.addRow(ob);
	}

	protected Chitiethoadon getChitiethoadon() {
		Chitiethoadon cthd = new Chitiethoadon();
		
		cthd.setVattu(vt);
		int sl = Integer.parseInt(txtsoluong.getText());
		cthd.setSoluong(sl);
		double thanhtien = Double.parseDouble(getThanhtien(sl, vt.getDongia()));
		cthd.setThanhtien(thanhtien);
		cthd.setGhichu(txtghichu.getText());
		return cthd;
	}

	private void setNguoikiemtra() {
		user = new User("user01", "tocdai", "12345");
		cbnguoikt.setSelectedItem(user.getUser());
	}

	protected Hoadon getThongtinHoadon() {
		Hoadon hd = new Hoadon();
		
		hd.setNgay(dateNgaynhap.getDate());
		hd.setSochungtu(txtsochungtu.getText());
		String sohd = txtMakho.getText();
		if(!sohd.isEmpty())
			hd.setSohoadon(Integer.parseInt(sohd));
		String tenkho = txtTenkho.getText();
		if(!tenkho.isEmpty())
			hd.setKho(kho);
		String dt = txtTendoituong.getText();
		if(!dt.isEmpty())
			hd.setNhacungcap(nhacungcap);
		//hd.setUser(user); test truoc da
		String nguoinhan = txtnguoinhan.getText();
		if(!nguoinhan.isEmpty()){
			hd.setNguoinhan(nguoinhan);
		}
		// con ghi chu 
		return hd;
	}

	private void setNgaynhap() {
		dateNgaynhap.setDate(new Date());
	}

	private void setSochungtu() {
		if(dsHD.getListHD().isEmpty())
		{
			txtsochungtu.setText("1/XK");
		}
		else
		{
			int size = dsHD.getListHD().size();
			String sct = String.valueOf(size + 1 ) + "/XK";
			txtsochungtu.setText(sct.toString());
		}
	}

	protected void setChitiethoadon(Hoadon hd) {
		modelvattu.setRowCount(0);
		Set<Chitiethoadon> chitiethds =  hd.getChitiethoadons();
		
		for(Iterator<Chitiethoadon> it = chitiethds.iterator(); it.hasNext() ;)
		{
			Chitiethoadon cthd = it.next();
			Object[] ob = {hd.getId(),
					cthd.getVattu().getMavattu() ,
					cthd.getVattu().getTenvattu() , 
					cthd.getVattu().getDonvitinh() ,cthd.getSoluong() ,cthd.getVattu().getDongia(),
				getThanhtien(cthd.getSoluong(),cthd.getVattu().getDongia()),cthd.getGhichu()};
			modelvattu.addRow(ob);
		}
		// set danh sach chi tiet hoa don lay trong 1 hoa don
		dscthd.setCthds(chitiethds);
	}
		
	private String getThanhtien(int soluong, double dongia) {
		
		double thanhtien = soluong * dongia;
		return String.valueOf(thanhtien);
	}

	

	protected void setForTextBox(Hoadon hd) {
		try {
			lammoitthongtin();
			dateNgaynhap.setDate(hd.getNgay());
			txtsochungtu.setText(hd.getSochungtu());
			if(hd.getSohoadon() != null )
				txtMakho.setText(hd.getKho().getMakho());
			txtTenkho.setText(hd.getKho().toString());
			txtTendoituong.setText(hd.getDoituong().toString());
			txtdiachi.setText(hd.getDoituong().toString());
			cbnguoikt.setSelectedItem(hd.getUser().toString());
			if(hd.getNguoinhan() != null)
				txtnguoinhan.setText(hd.getNguoinhan());
			if(hd.getGhichu() !=null)
				txthdgc.setText(hd.getGhichu());
		} catch (NullPointerException e) {
			
		}
	}
	
	private void lammoitthongtin() {
		dateNgaynhap.setDate(new Date());
		txtMakho.setText("");
		txtTenkho.setText("");
		txtTendoituong.setText("");
		txtdiachi.setText("");
		cbnguoikt.setSelectedItem("tocdai");
		txtnguoinhan.setText("");
		txthdgc.setText("");
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
