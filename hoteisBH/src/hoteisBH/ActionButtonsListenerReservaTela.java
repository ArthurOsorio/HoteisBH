package hoteisBH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class ActionButtonsListenerReservaTela implements ActionListener{
	private CriaReservaTela frame;
	public ActionButtonsListenerReservaTela(CriaReservaTela frame) {
		this.frame=frame;
	}
	private void concluir() {
		Connection con = ConexaoSQL.getConnection();
		try {
			Date sqlData = Date.valueOf(LocalDate.now());
			PreparedStatement stm = con.prepareStatement("INSERT into cliente (nome,telefone,cpf) values (?,?,?)");
			stm.setString(1, frame.getTxtNome().getText());
			stm.setInt(2, Integer.parseInt(frame.getTxtTelefone().getText()));
			stm.setInt(3, Integer.parseInt(frame.getTxtCPF().getText()));
			stm.executeUpdate();
			stm = con.prepareStatement("UPDATE quartos set id_cliente = (SELECT cliente_id FROM cliente WHERE cliente.nome = ?) WHERE quarto_id = ?");
			stm.setString(1, frame.getTxtNome().getText());
			stm.setInt(2, frame.getId());
			stm.executeUpdate();
			stm = con.prepareStatement("UPDATE quartos SET data_reserva = ? , dias_reservados = ? WHERE quarto_id = ?");
			stm.setDate(1, sqlData);
			stm.setInt(2, frame.slider.getValue());
			stm.setInt(3, frame.getId());
			stm.executeUpdate();
			JOptionPane.showMessageDialog(frame, "Quarto reservado");
			frame.dispose();
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
		case "CANCELAR":
			frame.dispose();
		}
	}

}
