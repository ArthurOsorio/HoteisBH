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
	private ResultSet rs;
	public BTNQuartosListener(OverviewQuartos over,int id) {
		this.overview=over;
		this.id=id;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Connection con = ConexaoSQL.getConnection();
		try {
			Statement stm = con.createStatement();
			rs=stm.executeQuery("SELECT * from quartos"+" INNER JOIN cliente on cliente.cliente_id = quartos.id_cliente where quarto_id ="+id);
			if(rs.next()) {
			overview.getLblNome().setText(rs.getString("nome"));
			overview.getLblTelefone().setText(Long.toString(rs.getLong("telefone")));
			overview.getLblCPF().setText(Long.toString(rs.getLong("cpf")));
			overview.getLblDataRes().setText(rs.getDate("data_reserva").toString());
			Date data = rs.getDate("data_reserva");
			LocalDate lcdata = data.toLocalDate();
			lcdata = lcdata.plusDays(rs.getInt("dias_reservados"));;
			overview.getLblDataSaida().setText(lcdata.toString());
			overview.getLblReservado().setText("Ocupado");
			overview.getLblReservado().setFont(new Font("Tahoma",Font.BOLD,13));
			overview.getLblReservado().setForeground(Color.RED);
			overview.setId(this.id);
			con.close();
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
		} catch (SQLException sqle1) {
			System.out.println(sqle1);
		}
		
		
	}

}
