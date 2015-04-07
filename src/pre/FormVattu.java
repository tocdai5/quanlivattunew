package pre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Vattu;

import bus.DanhsachVattu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormVattu extends JFrame {

	private JPanel contentPane;
	public final JTextField txtTim = new JTextField();
	public DefaultTableModel model = new DefaultTableModel();
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
					FormVattu frame = new FormVattu();
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
	public FormVattu() {
		setTitle("BangVattu");
		this.txtTim.setBounds(10, 11, 170, 20);
		this.txtTim.setColumns(10);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			contentPane.add(this.txtTim);
		}
		
		{
			model.addColumn("Mã vật tư");
			model.addColumn("Tên vật tư");
			model.addColumn("Đơn giá");
			model.addColumn("Đơn vị tính");
			for(Vattu vt : dsvt.getLstVattu()){
				Object[] ob = {vt.getMavattu(),vt.getTenvattu(),vt.getDongia(),vt.getDonvitinh()};
				model.addRow(ob);
			}
		}
		
		{
			
			this.scrollPane.setBounds(10, 42, 414, 209);
			contentPane.add(this.scrollPane);
		}
		{
			this.table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = table.getSelectedRow();
					if(index != -1)
					{
						String mavattu =  model.getValueAt(index, 0).toString();
						String tenvattu =  model.getValueAt(index, 1).toString();
						String dongia =  model.getValueAt(index, 2).toString();
						String donvitinh =  model.getValueAt(index, 3).toString();
						FormNhapKho.txtMavt.setText(mavattu);
						FormNhapKho.txttenvattu.setText(tenvattu);
						FormNhapKho.txtdongia.setText(dongia);
						FormNhapKho.txtdvt.setText(donvitinh);
						Vattu vt = dsvt.findByIndex(index);
						if(vt != null)
							FormNhapKho.vt = vt;
						dispose();
					}
				}
			});
			this.scrollPane.setRowHeaderView(this.table);
		}
	}
}
