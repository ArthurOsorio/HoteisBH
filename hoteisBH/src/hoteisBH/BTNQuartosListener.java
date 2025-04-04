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
			overview.lblNome.setText(rs.getString("nome"));
			overview.lblTelefone.setText(Integer.toString(rs.getInt("telefone")));
			overview.lblCPF.setText(Integer.toString(rs.getInt("cpf")));
			overview.lblDataRes.setText(rs.getDate("data_reserva").toString());
			Date data = rs.getDate("data_reserva");
			LocalDate lcdata = data.toLocalDate();
			System.out.println(lcdata);
			lcdata.plusDays(rs.getInt("dias_reservados"));
			System.out.println(rs.getInt("dias_reservados"));
			System.out.println(lcdata);
			overview.lblDataSaida.setText(lcdata.toString());
			overview.lblReservado.setText("Ocupado");
			overview.lblReservado.setFont(new Font("Tahoma",Font.BOLD,13));
			overview.lblReservado.setForeground(Color.RED);
			overview.id = this.id;
			con.close();
			}else {
				overview.id=this.id;
				overview.lblReservado.setText("Desocupado");
				overview.lblReservado.setFont(new Font("Tahoma",Font.BOLD,13));
				overview.lblReservado.setForeground(Color.GREEN);;
			}
		} catch (SQLException sqle1) {
			System.out.println(sqle1);
		}
		
		
	}

}
