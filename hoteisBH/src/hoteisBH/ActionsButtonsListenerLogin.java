package hoteisBH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.mindrot.jbcrypt.BCrypt;

public class ActionsButtonsListenerLogin implements ActionListener {
	private Login login;
	private String senha;
	private LoginDAO dao = new LoginDAO();
	public ActionsButtonsListenerLogin(Login login) {
		this.login=login;
	}
	public void login() {
			if (dao.verificarUsuario(login.getTxtUsuario().getText())) {
				senha = login.getTxtSenha().getText();
				if(checarSenha(senha)) {
					OverviewQuartos frame = new OverviewQuartos();
					frame.setVisible(true);
					login.dispose();
				}else {
					System.out.println("Senha Incorreta");
				}
			}else {
				System.out.println("Usuario não encontrado.");
			}
	}
	public boolean checarSenha(String senha) {
		return BCrypt.checkpw(senha, dao.getStoredPwd());
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
