package hoteisBH;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ActionButtonsListenerOverviewQuartos implements ActionListener {
	private OverviewQuartos quartos;
	public ActionButtonsListenerOverviewQuartos(OverviewQuartos q) {
		this.quartos=q;
	}
	private void reservar() {
		CriaReservaTela frame = new CriaReservaTela();
		frame.setId(quartos.getId());
		frame.setVisible(true);
	}
	private void desocupar() {
			int result=JOptionPane.showConfirmDialog(quartos, "Deseja desocupar o quarto?");
			if (result == JOptionPane.YES_OPTION) {
			OverviewQuartosDAO dao = new OverviewQuartosDAO();
			if(dao.desocuparQuarto(quartos.getId())) {
				quartos.getLblNome().setText("");
				quartos.getLblTelefone().setText("");
				quartos.getLblCPF().setText("");
				quartos.getLblDataRes().setText("");
				quartos.getLblDataSaida().setText("");
				quartos.getLblReservado().setText("Desocupado");
				quartos.getLblReservado().setFont(new Font("Tahoma",Font.BOLD,13));
				quartos.getLblReservado().setForeground(Color.GREEN);;
			JOptionPane.showMessageDialog(quartos, "Quarto desocupado.");
			}else {
				JOptionPane.showMessageDialog(quartos, "Erro ao desocupar o quarto.");
			}
			}
	
	}
	private void sair() {
		Login frame = new Login();
		quartos.dispose();
		frame.setVisible(true);
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
			sair();
		}
	}

}
