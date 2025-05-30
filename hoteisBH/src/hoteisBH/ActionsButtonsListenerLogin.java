package hoteisBH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import org.mindrot.jbcrypt.BCrypt;

public class ActionsButtonsListenerLogin implements ActionListener {
	private Login login;
	private String storedPwd;
	private String senha;
	private ResultSet rs;
	public ActionsButtonsListenerLogin(Login login) {
		this.login=login;
	}
	public void login() {
		Connection con = ConexaoSQL.getConnection();
		try {
			PreparedStatement stm = con.prepareStatement("SELECT * from usuarios where usuarios.nome = ?");
			stm.setString(1, login.getTxtUsuario().getText());
			rs = stm.executeQuery();
			if (rs.next()) {
				storedPwd = rs.getString("senha");
			}else {
				System.out.println("Usuario não encontrado.");
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		senha = login.getTxtSenha().getText();
		if(checarSenha(senha)) {
			OverviewQuartos frame = new OverviewQuartos();
			frame.setVisible(true);
		}else {
			System.out.println("Senha Incorreta");
		}
	}
	public boolean checarSenha(String senha) {
		return BCrypt.checkpw(senha, storedPwd);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actCmd = e.getActionCommand();
		switch(actCmd) {
		case "ENTRAR":
			login();
			break;
		case "SAIR":
			System.exit(0);
			break;
		}
		
		
	}

}
