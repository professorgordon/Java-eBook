import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Arrays;

public class WBExample2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WBExample2 frame = new WBExample2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WBExample2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(WBExample2.class.getResource("/images/computersmall.png")));
		lblImage.setBounds(12, 16, 88, 74);
		contentPane.add(lblImage);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setBounds(150, 24, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(128, 54, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(202, 18, 147, 26);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(201, 47, 149, 26);
		contentPane.add(txtPassword);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(206, 1, 141, 16);
		contentPane.add(lblMessage);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(166, 89, 96, 29);
		contentPane.add(btnCancel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtLogin.getText().equals("admin") &&
						Arrays.equals(txtPassword.getPassword(), "admin".toCharArray()))
				{
					JOptionPane.showMessageDialog(null, "Login Successful");
				}
				else
				{
					lblMessage.setText("Error: Try Again");
					lblImage.setIcon(new ImageIcon(WBExample2.class.getResource("/images/computersmallno.png")));
				}
				txtLogin.setText("");
				txtPassword.setText("");
			}
		});
		btnLogin.setBounds(258, 89, 95, 29);
		contentPane.add(btnLogin);
		
	}
}
