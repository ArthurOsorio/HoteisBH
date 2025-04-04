package hoteisBH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;

public class ActionButtonsListenerReservaTela implements ActionListener{
	private CriaReservaTela frame;
	public ActionButtonsListenerReservaTela(CriaReservaTela frame) {
		this.frame=frame;
	}
	private void concluir() {
		Connection con = ConexaoSQL.getConnection();
		try {
			LocalDate data = LocalDate.now();
			Date sqlData = Date.valueOf(LocalDate.now());
			PreparedStatement stm = con.prepareStatement("INSERT into cliente (nome,telefone,cpf) values (?,?,?)");
			stm.setString(1, frame.getTxtNome().getText());
			stm.setInt(2, Integer.parseInt(frame.getTxtTelefone().getText()));
			stm.setInt(3, Integer.parseInt(frame.getTxtCPF().getText()));
		}catch(SQLException sqle) {
			System.out.println(sqle);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actCmd = e.getActionCommand();
		switch(actCmd) {
		case "CONCLUIR":
			concluir();
			break;
		case "CANCELAR":
			System.exit(0);
		}
	}

}
