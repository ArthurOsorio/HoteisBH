package hoteisBH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import org.mindrot.jbcrypt.BCrypt;

public class ActionsButtonsListenerFirstLogin implements ActionListener{
	private FirstLogin firstLogin;
	public ActionsButtonsListenerFirstLogin(FirstLogin frame) {
		this.firstLogin = frame;
	}
	public void criarUsuario() {
		Connection con = ConexaoSQL.getConnection();
		try {
			PreparedStatement stm = con.prepareStatement("INSERT into usuarios(nome,senha) values (?,?)");
			stm.setString(1, firstLogin.getTxtUser().getText());
			String hashedPwd = BCrypt.hashpw(firstLogin.getTxtSenha().getText(), BCrypt.gensalt(12));
			stm.setString(2, hashedPwd);
			stm.executeUpdate();
			Login frame = new Login();
			frame.setVisible(true);
			this.firstLogin.dispose();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String actCmd = e.getActionCommand();
		switch(actCmd) {
		case "CRIAR":
			criarUsuario();
		case "CANCELAR":
			System.exit(0);
		}
	}

}
