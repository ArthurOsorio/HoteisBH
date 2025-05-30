package hoteisBH;

import java.sql.*;

import org.mindrot.jbcrypt.BCrypt;

public class LoginDAO {
	Connection con = ConexaoSQL.getConnection();
	private ResultSet rs = null;
	private String usuario;
	private String storedPwd;
	public boolean criarUsuario(String nome , String senha) {
		try {
			PreparedStatement stm = con.prepareStatement("INSERT into usuarios(nome,senha) values (?,?)");
			stm.setString(1, nome);
			String hashedPwd = BCrypt.hashpw(senha, BCrypt.gensalt(12));
			stm.setString(2, hashedPwd);
			stm.executeUpdate();
			return true;
		}catch (SQLException sqle){
			return false;
		}
	}
	public boolean verificarUsuario(String nome) {
	try {
		PreparedStatement stm = con.prepareStatement("SELECT * from usuarios where usuarios.nome = ?");
		stm.setString(1, nome);
		rs = stm.executeQuery();
		if(rs.next()) {
			this.usuario = rs.getString("nome");
			this.storedPwd = rs.getString("senha");
		}else {
			return false;
		}
		return true;
	} catch (SQLException sqle) {
		System.out.println(sqle);
		return false;
	}
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getStoredPwd() {
		return storedPwd;
	}
	public void setStoredPwd(String storedPwd) {
		this.storedPwd = storedPwd;
	}

}
