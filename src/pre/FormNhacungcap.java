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

import bus.DanhsachNhacungcap;

import model.Nhacungcap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormNhacungcap extends JFrame {

	private JPanel contentPane;
	public final JTextField txtTim = new JTextField();
	public DefaultTableModel model = new DefaultTableModel();
	public final JScrollPane scrollPane = new JScrollPane();
	public final JTable table = new JTable(model);

	DanhsachNhacungcap dsncc = new DanhsachNhacungcap();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormNhacungcap frame = new FormNhacungcap();
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
	public FormNhacungcap() {
		setTitle("BangNhacungcap");
		this.txtTim.setBounds(10, 11, 166, 20);
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
			this.scrollPane.setBounds(10, 42, 414, 209);
			contentPane.add(this.scrollPane);
		}
		
		{
			model.addColumn("Mã nhà cung cấp");
			model.addColumn("Tên nhà cung cấp");
			model.addColumn("Địa chỉ");
			for(Nhacungcap ncc : dsncc.getLstNhacungcap()){
				Object[] ob = {ncc.getManhacungcap() ,ncc.getTennhacungcap() , ncc.getDiachi()};
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
						String tenncc =  model.getValueAt(index, 1).toString();
						String diachi =  model.getValueAt(index, 2).toString();
						FormNhapKho.txtnhacungcap.setText(tenncc);
						FormNhapKho.txtdiachi.setText(diachi);
						Nhacungcap ncc = dsncc.findByIndex(index);
						if(ncc != null)
							FormNhapKho.nhacungcap = ncc;
						dispose();
					}
				}
			});
			this.scrollPane.setViewportView(this.table);
		}
	}

}
