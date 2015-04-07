package pre;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import quanly.QuanlyKho;

import model.Kho;

import bus.DanhsachKho;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormDMKho extends JFrame {

	private JPanel contentPane;
	public final JTextField txtTimKho = new JTextField();
	public DefaultTableModel model = new DefaultTableModel();
	public final JScrollPane scrollPane = new JScrollPane();
	public final JTable table = new JTable(model);
	
	
	DanhsachKho dskho = new DanhsachKho();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDMKho frame = new FormDMKho();
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
	public FormDMKho() {
		this.txtTimKho.setBounds(10, 11, 167, 20);
		this.txtTimKho.setColumns(10);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			contentPane.add(this.txtTimKho);
		}
		
		{
			this.scrollPane.setBounds(10, 42, 414, 209);
			contentPane.add(this.scrollPane);
		}
		
		{
			model.addColumn("Mã kho");
			model.addColumn("Tên kho");
			for(Kho k : dskho.getLstKho()){
				Object[] ob = { k.getMakho() , k.getTenkho()};
				model.addRow(ob);
			}
		}
		
		{
			this.table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int index = table.getSelectedRow();
					if(index != -1)
					{
						String value =  model.getValueAt(index, 1).toString();
							FormNhapKho.txtkhonhap.setText(value);
						Kho k = dskho.findIndex(index);
						if(k != null)
							FormNhapKho.kho = k;
						dispose();
					}
				}
			});
			this.scrollPane.setViewportView(this.table);
		}
		
	}
}
