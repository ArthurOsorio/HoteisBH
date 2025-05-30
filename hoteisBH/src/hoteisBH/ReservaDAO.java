package hoteisBH;

import java.sql.*;
import java.time.LocalDate;

public class ReservaDAO {
	Connection con = ConexaoSQL.getConnection();
	public boolean criarReserva(String nome, long cpf, long telefone, int diasReservados, int id) {
		try {
		Date sqlData = Date.valueOf(LocalDate.now());
		PreparedStatement stm = con.prepareStatement("INSERT into cliente (nome,telefone,cpf) values (?,?,?)");
		stm.setString(1, nome);
		stm.setLong(2, telefone);
		stm.setLong(3, cpf);
		stm.executeUpdate();
		stm = con.prepareStatement("UPDATE quartos set id_cliente = (SELECT cliente_id FROM cliente WHERE cliente.cpf = ?) WHERE quarto_id = ?");
		stm.setLong(1, cpf);
		stm.setInt(2, id);
		stm.executeUpdate();
		stm = con.prepareStatement("UPDATE quartos SET data_reserva = ? , dias_reservados = ? WHERE quarto_id = ?");
		stm.setDate(1, sqlData);
		stm.setInt(2, diasReservados);
		stm.setInt(3, id);
		stm.executeUpdate();
		return true;
		}catch (SQLException sqle) {
			System.out.println(sqle);
			return false;
		}
	}

}
