package hoteisBH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
			overview.id = this.id;
			con.close();
			}
		} catch (SQLException e1) {
			System.out.println(e1);
		}
		
		
	}

}
