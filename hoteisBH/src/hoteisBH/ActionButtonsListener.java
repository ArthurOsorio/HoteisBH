package hoteisBH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JOptionPane;

public class ActionButtonsListener implements ActionListener {
	private OverviewQuartos quartos;
	public ActionButtonsListener(OverviewQuartos q) {
		this.quartos=q;
	}
	private void reservar() {
		CriaReservaTela frame = new CriaReservaTela();
		frame.id = quartos.id;
		frame.setVisible(true);
	}
	private void desocupar() {
		Connection con = ConexaoSQL.getConnection();
		try {
			int result=JOptionPane.showConfirmDialog(quartos, "Deseja desocupar o quarto?");
			if (result == JOptionPane.YES_OPTION) {
			Statement stm = con.createStatement();
			stm.executeUpdate(String.format("UPDATE quartos "+"set id_cliente = null "+"WHERE quarto_id = %d",quartos.id));
			quartos.lblNome.setText("");
			quartos.lblTelefone.setText("");
			JOptionPane.showMessageDialog(quartos, "Quarto desocupado.");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actCmd = e.getActionCommand();
		switch(actCmd) {
		case "RESERVAR":
			reservar();
			break;
		case "DESOCUPAR":
			desocupar();
			break;
		case "SAIR":
			System.exit(0);
		}
	}

}
