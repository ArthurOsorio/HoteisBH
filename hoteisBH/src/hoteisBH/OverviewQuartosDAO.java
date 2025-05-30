package hoteisBH;

import java.sql.*;

public class OverviewQuartosDAO {
	private long cpf;
	private long telefone;
	private String nome;
	private Date data;
	private int diasReservados;
	Connection con = ConexaoSQL.getConnection();
	public boolean quartoSelecionado(int id) {
		try {
		Statement stm = con.createStatement();
		ResultSet rs=stm.executeQuery("SELECT * from quartos"+" INNER JOIN cliente on cliente.cliente_id = quartos.id_cliente where quarto_id ="+id);
		if(rs.next()) {
			this.nome = rs.getString("nome");
			this.cpf = rs.getLong("cpf");
			this.telefone = rs.getLong("telefone");
			this.data = rs.getDate("data_reserva");
			this.diasReservados = rs.getInt("dias_reservados");
		}else {
			return false;
		}
		return true;
		}catch (SQLException sqle) {
			return false;
		}
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getDiasReservados() {
		return diasReservados;
	}
	public void setDiasReservados(int diasReservados) {
		this.diasReservados = diasReservados;
	}
	public boolean desocuparQuarto(int id) {
	try {
		Statement stm = con.createStatement();
		stm.executeUpdate(String.format("UPDATE quartos "+"set id_cliente = null , data_reserva = null , dias_reservados = null "
				+"WHERE quarto_id = %d",id));
		return true;
	} catch (SQLException sqle) {
		System.out.println(sqle);
		return false;
	}
	
	}
}
