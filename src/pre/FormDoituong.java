package pre;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Doituong;
import bus.DanhsachDoituong;

public class FormDoituong extends JFrame {

	private JPanel contentPane;
	public final JTextField txtTim = new JTextField();
	public DefaultTableModel model = new DefaultTableModel();
	public final JScrollPane scrollPane = new JScrollPane();
	public final JTable table = new JTable(model);
	
	DanhsachDoituong dsdt = new DanhsachDoituong();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDoituong frame = new FormDoituong();
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
	public FormDoituong() {
		this.txtTim.setBounds(10, 11, 173, 27);
		this.txtTim.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			contentPane.add(this.txtTim);
		}
		{
			this.scrollPane.setBounds(10, 44, 414, 207);
			contentPane.add(this.scrollPane);
		}
		{
			model.addColumn("Mã đối tượng");
			model.addColumn("Tên đối tượng");
			model.addColumn("Địa chỉ");
			for(Doituong dt : dsdt.getLstDoituong()){
				Object[] ob = {dt.getMadoituong(),dt.getTendoituong(),dt.getDiachi()};
				model.addRow(ob);
			}
		}
		{
			this.table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = table.getSelectedRow();
					if(index != -1)
					{
						String tendt =  model.getValueAt(index, 1).toString();
						String diachi =  model.getValueAt(index, 2).toString();
						FormXuatKho.txtTendoituong.setText(tendt);
						FormXuatKho.txtdiachi.setText(diachi);
						Doituong dt = dsdt.findByIndex(index);
						if(dt != null)
							FormXuatKho.dt = dt;
						dispose();
					}
				}
			});
			this.scrollPane.setViewportView(this.table);
		}
	}
}
