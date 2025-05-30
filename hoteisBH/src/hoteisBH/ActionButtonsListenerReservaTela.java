package hoteisBH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ActionButtonsListenerReservaTela implements ActionListener{
	private CriaReservaTela frame;
	private ReservaDAO dao = new ReservaDAO();
	private String nome;
	private long cpf;
	private long telefone;
	private int id;
	private int diasReservados;
	public ActionButtonsListenerReservaTela(CriaReservaTela frame) {
		this.frame=frame;
	}
	private void concluir() {
		this.nome=frame.getTxtNome().getText();
		this.cpf = Long.parseLong(frame.getTxtCPF().getText());
		this.telefone = Long.parseLong(frame.getTxtTelefone().getText());
		this.id = frame.getId();
		this.diasReservados = frame.slider.getValue();
		if(dao.criarReserva(nome, cpf, telefone, diasReservados, id)) {
		JOptionPane.showMessageDialog(frame, "Quarto reservado");
		frame.dispose();
		}else {
			JOptionPane.showMessageDialog(frame, "Erro na reserva.");
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
