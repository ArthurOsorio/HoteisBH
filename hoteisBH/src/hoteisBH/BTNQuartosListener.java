package hoteisBH;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;

public class BTNQuartosListener implements ActionListener {
	private OverviewQuartos overview;
	private int id;
	public BTNQuartosListener(OverviewQuartos over,int id) {
		this.overview=over;
		this.id=id;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
			OverviewQuartosDAO dao = new OverviewQuartosDAO();
			if(dao.quartoSelecionado(this.id)) {
				overview.getLblNome().setText(dao.getNome());
				overview.getLblTelefone().setText(Long.toString(dao.getTelefone()));
				overview.getLblCPF().setText(Long.toString(dao.getCpf()));
				overview.getLblDataRes().setText(dao.getData().toString());
				Date data = dao.getData();
				LocalDate lcdata = data.toLocalDate();
				lcdata = lcdata.plusDays(dao.getDiasReservados());;
				overview.getLblDataSaida().setText(lcdata.toString());
				overview.getLblReservado().setText("Ocupado");
				overview.getLblReservado().setFont(new Font("Tahoma",Font.BOLD,13));
				overview.getLblReservado().setForeground(Color.RED);
				overview.setId(this.id);
			}else {
				overview.setId(this.id);
				overview.getLblNome().setText("");
				overview.getLblTelefone().setText("");
				overview.getLblCPF().setText("");
				overview.getLblDataRes().setText("");
				overview.getLblDataSaida().setText("");
				overview.getLblReservado().setText("Desocupado");
				overview.getLblReservado().setFont(new Font("Tahoma",Font.BOLD,13));
				overview.getLblReservado().setForeground(Color.GREEN);;
			}
		
	}

}
