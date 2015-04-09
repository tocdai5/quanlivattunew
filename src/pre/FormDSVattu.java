package pre;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Vattu;
import bus.DanhsachVattu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormDSVattu extends JFrame {

	private JPanel contentPane;
	public final JPanel panel = new JPanel();
	public final JLabel lblMVat = new JLabel("M\u00E3 v\u1EADt t\u01B0");
	public final JLabel lblTnVtT = new JLabel("T\u00EAn v\u1EADt t\u01B0");
	public final JLabel lblGiTin = new JLabel("Gi\u00E1 ti\u1EC1n");
	public final JTextField txtTenVT = new JTextField();
	public final JTextField txtDongia = new JTextField();
	public final JTextField txtMaVT = new JTextField();
	public final JButton btnThem = new JButton("Thêm");
	public final JButton btnXoa = new JButton("Xóa");
	public final JButton btnSua = new JButton("Sửa");
	public final JButton btnThoat = new JButton("Thoát");
	
	public final JLabel lblNewLabel = new JLabel("\u0110\u01A1n v\u1ECB t\u00EDnh");
	public final JTextField txtDVT = new JTextField();
	
	DefaultTableModel model= new DefaultTableModel();	
	public final JScrollPane scrollPane = new JScrollPane();
	public final JTable table = new JTable(model);
	
	DanhsachVattu dsvt = new DanhsachVattu();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDSVattu frame = new FormDSVattu();
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
	public FormDSVattu() {
		this.txtDVT.setBounds(172, 91, 134, 20);
		this.txtDVT.setColumns(10);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 487, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			this.panel.setLayout(null);
			this.panel.setBounds(10, 11, 451, 150);
			contentPane.add(this.panel);
		}
		{
			this.lblMVat.setBounds(50, 11, 90, 14);
			this.panel.add(this.lblMVat);
		}
		{
			this.lblTnVtT.setBounds(50, 36, 90, 14);
			this.panel.add(this.lblTnVtT);
		}
		{
			this.lblGiTin.setBounds(50, 63, 90, 14);
			this.panel.add(this.lblGiTin);
		}
		{
			this.txtTenVT.setColumns(10);
			this.txtTenVT.setBounds(172, 33, 134, 20);
			this.panel.add(this.txtTenVT);
		}
		{
			this.txtDongia.setColumns(10);
			this.txtDongia.setBounds(172, 60, 134, 20);
			this.panel.add(this.txtDongia);
		}
		{
			this.txtMaVT.setColumns(10);
			this.txtMaVT.setBounds(172, 8, 134, 20);
			this.panel.add(this.txtMaVT);
		}
		{
			this.btnThem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(thongtinnhaprong() == true)
					{
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!!!");
					}
					else
					{
						Vattu vt = getThongtinVattu();
						if(dsvt.themVattu(vt))
						{
							JOptionPane.showMessageDialog(null, "Thêm Vật tư thành công");
							themXuongTable(vt);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Vật tư đã tồn tại");
						}
					}
				}
			});
			this.btnThem.setBounds(352, 7, 89, 23);
			this.panel.add(this.btnThem);
		}
		{
			this.btnXoa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = table.getSelectedRow();
					if(index != -1)
					{
						dsvt.xoaVattu(index);
						model.removeRow(index);
					}
				}
			});
			this.btnXoa.setBounds(352, 35, 89, 23);
			this.panel.add(this.btnXoa);
		}
		{
			this.btnSua.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = table.getSelectedRow();
					if(index != -1)
					{
						Vattu vt = getThongtinVattu();
						dsvt.capnhatpVattu(index, vt);
						suaDuoiTable(index, vt);
					}
				}
			});
			this.btnSua.setBounds(352, 63, 89, 23);
			this.panel.add(this.btnSua);
		}
		{
			this.btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			this.btnThoat.setBounds(352, 93, 89, 23);
			this.panel.add(this.btnThoat);
		}
		{
			this.lblNewLabel.setBounds(50, 97, 90, 14);
			this.panel.add(this.lblNewLabel);
		}
		{
			this.panel.add(this.txtDVT);
		}
		{
			this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			this.scrollPane.setBounds(10, 164, 451, 141);
			contentPane.add(this.scrollPane);
		}
		{
			this.table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int index = table.getSelectedRow();
					if(index != -1)
					{
						Vattu vt = dsvt.getByIndex(index);
						clearTextBox();
						setOnTextBox(vt);
					}
				}
			});
			model.addColumn("Mã vật tư");
			model.addColumn("Tên vật tư");
			model.addColumn("Giá tiền");
			model.addColumn("Đơn vị tính");
			napDanhSachVattu();
			this.scrollPane.setViewportView(this.table);
		}
	}

	protected void clearTextBox() {
		txtMaVT.setText("");
		txtTenVT.setText("");
		txtDongia.setText("");
		txtDVT.setText("");
	}

	protected void setOnTextBox(Vattu vt) {
		txtMaVT.setText(vt.getMavattu());
		txtTenVT.setText(vt.getTenvattu());
		txtDongia.setText(String.valueOf(vt.getDongia()));
		txtDVT.setText(vt.getDonvitinh());
	}

	private void napDanhSachVattu() {
		model.setRowCount(0);
		for(Vattu vt : dsvt.getLstVattu())
		{
			Object ob[] = {vt.getMavattu() , vt.getTenvattu() , vt.getDongia() , vt.getDonvitinh()};
			model.addRow(ob);
		}
		
	}

	protected void suaDuoiTable(int index, Vattu vt) {
		model.setValueAt(vt.getMavattu(), index, 0);
		model.setValueAt(vt.getTenvattu(), index, 1);
		model.setValueAt(vt.getDongia(), index, 2);
		model.setValueAt(vt.getDonvitinh(), index, 3);
	}

	protected void themXuongTable(Vattu vt) {
		Object ob[] = {vt.getTenvattu() , vt.getMavattu()  ,vt.getDongia() ,vt.getDonvitinh()};
		model.addRow(ob);
	}

	protected Vattu getThongtinVattu() {
		Vattu vt = new Vattu();
		vt.setMavattu(txtMaVT.getText());
		vt.setTenvattu(txtTenVT.getText());
		vt.setDongia(Double.parseDouble(txtDongia.getText()));
		vt.setDonvitinh(txtDVT.getText());
		return vt;
	}

	protected boolean thongtinnhaprong() {
		if(txtMaVT.getText().equals("") || txtTenVT.getText().equals("") || txtDongia.getText().equals("") || txtDVT.getText().equals(""))
			return true;
		return false;
	}
}
