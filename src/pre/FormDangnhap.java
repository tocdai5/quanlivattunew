package pre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;









import java.awt.Font;

public class FormDangNhap extends JFrame {

	private JPanel contentPane;
	private JLabel lblname;
	private JTextField tfName;
	private JPasswordField tfPass;
	private static FormDangNhap frame;
	private static FormNhapKho frnhapkho;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					frame= new FormDangNhap();
					frame.setVisible(true);
					frame.setTitle("Ä�Äƒng nháº­p");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormDangNhap() {
		setTitle("\u0110\u0103ng nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfName = new JTextField();
		tfName.setBounds(127, 75, 153, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(10, 78, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PassWord");
		lblNewLabel_1.setBounds(10, 129, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btndangnhap = new JButton("\u0110\u0103ng Nh\u1EADp");
		btndangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfName.getText().toString().equals("") || tfPass.getText().toString().equals(""))
				{
					 JOptionPane.showMessageDialog(null, "Báº¡n chÆ°a nháº­p UserName hoáº·c Password!");
				} else 
					{
						try {
							createConnection();							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							System.out.println("Eror:"+e1.getMessage());
						}
						
					}
		          }
			
			private void createConnection() throws SQLException {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//load driver
				String url = "jdbc:mysql://localhost:3306/quanlivattu";
			    String user="root", passwd="root";
			    Connection conn=DriverManager.getConnection(url, user, passwd);
			    Statement stm=conn.createStatement();  
			    String qrselect ="select * from user where User='"+tfName.getText().toString().trim()+"'and Password='"+new String(tfPass.getPassword()).trim()+"'";
			    ResultSet rs = stm.executeQuery(qrselect);//thuc hien cau lenh query tra ve gia tri ResultSet
			    if(rs.next())
			    {
			    	 lblname.setText("Ban nháº­p Ä�Ãºng");
			         lblname.setForeground(Color.GREEN);  
			         frame.setVisible(false);
					 frnhapkho=new FormNhapKho();
					 frnhapkho.setVisible(true);
			    }
			    else
			    {
			         lblname.setText("Fail! Vui long nhập lại");
			         lblname.setForeground(Color.red);
			    }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block				
				System.err.println("Driver not found");
			}
		      
		    }		
	    });
		
		btndangnhap.setBounds(65, 183, 125, 23);
		contentPane.add(btndangnhap);
		
		JButton btnquaylai = new JButton("Quay l\u1EA1i");
		btnquaylai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 GotoFormQuanLi();
			}

			private void GotoFormQuanLi() {
				// TODO Auto-generated method stub
				//FormQuanLi fr= new FormQuanLi();
				FormDangNhap fr=new FormDangNhap();
				fr.setVisible(true);
				dispose();
				
			}
		});
		btnquaylai.setBounds(210, 183, 103, 23);
		contentPane.add(btnquaylai);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(127, 126, 153, 20);
		contentPane.add(tfPass);
		
		JCheckBox chckbxGhiNhMt = new JCheckBox("Ghi nh\u1EADn m\u1EADt kh\u1EA9u");
		chckbxGhiNhMt.setBounds(127, 153, 153, 23);
		contentPane.add(chckbxGhiNhMt);
		
		JLabel lblPhnMmQun = new JLabel("Ph\u1EA7n m\u1EC1m Qu\u1EA3n l\u00FD V\u1EADt t\u01B0");
		lblPhnMmQun.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPhnMmQun.setBounds(106, 11, 279, 53);
		contentPane.add(lblPhnMmQun);
		
		lblname = new JLabel("");
		lblname.setBounds(291, 75, 150, 14);
		contentPane.add(lblname);
	
	addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });;
	}
}
