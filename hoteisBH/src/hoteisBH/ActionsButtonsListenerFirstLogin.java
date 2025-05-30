package hoteisBH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ActionsButtonsListenerFirstLogin implements ActionListener{
	private FirstLogin firstLogin;
	private LoginDAO dao = new LoginDAO();
	public ActionsButtonsListenerFirstLogin(FirstLogin frame) {
		this.firstLogin = frame;
	}
	public void criarUsuario() {
		if(dao.criarUsuario(firstLogin.getTxtUser().getText(), firstLogin.getTxtSenha().getText())) {
			Login frame = new Login();
			frame.setVisible(true);
			this.firstLogin.dispose();
		}else {
			JOptionPane.showMessageDialog(firstLogin, "Erro ao criar o usuario.");
		}
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String actCmd = e.getActionCommand();
		switch(actCmd) {
		case "CRIAR":
			criarUsuario();
			break;
		case "CANCELAR":
			System.exit(0);
			break;
		}
	}

}
