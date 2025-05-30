package hoteisBH;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.*;

import javax.swing.SwingConstants;
import java.awt.Component;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JTextField getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(JTextField txtSenha) {
		this.txtSenha = txtSenha;
	}

	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String url = "SELECT * from usuarios";
		Connection con = ConexaoSQL.getConnection();
		ResultSet rs = null;
		try {
			Statement stm = con.createStatement();
			rs = stm.executeQuery(url);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		try {
			if(rs.next()) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login frame = new Login();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			}else {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FirstLogin frame = new FirstLogin();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBounds(100, 100, 681, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSenha.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtUsuario, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
						.addComponent(txtSenha, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
						.addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(lblUser)
					.addGap(40)
					.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(lblSenha)
					.addGap(32)
					.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.setActionCommand("ENTRAR");
		btnLogin.addActionListener(new ActionsButtonsListenerLogin(this));
		panel_1.add(btnLogin);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setMaximumSize(new Dimension(63, 23));
		btnSair.setMinimumSize(new Dimension(63, 23));
		btnSair.setPreferredSize(new Dimension(63, 23));
		btnSair.setActionCommand("SAIR");
		btnSair.addActionListener(new ActionsButtonsListenerLogin(this));
		panel_1.add(btnSair);
		contentPane.setLayout(gl_contentPane);
	}
}
