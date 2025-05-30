package hoteisBH;

import java.sql.*;

public class ConexaoSQL {
	private static final String url="jdbc:mysql://localhost:3306/?";
	private static final String[] user={"root","root"};
	private static final String[] pwd={"Gkt1649000","root"};
	public static Connection getConnection() {
		int i = 0;
		Connection c = null;
		do {
			c = tryConnection(url,user[i],pwd[i]);
			i++;
		}while(i<user.length && c == null);
		enterDB(c);
		return c;
	}
	public static Connection tryConnection(String url,String user,String pwd)  {
		try {
			return DriverManager.getConnection(url,user,pwd);
		}catch(SQLException sqle) {
			System.out.println(sqle);
			return null;
		}
	}
	public static void enterDB(Connection c) {
		try {
			c.setCatalog("hoteisbh");
		} catch (SQLException sqle) {
			if (sqle.getErrorCode()==1049) {
				createDB(c);
			try {
			c.setCatalog("hoteisbh");
			createTable(c);
			populateTable(c);
			}catch(SQLException sqle1){
				System.out.println(sqle1);
			}
			}else {
				System.out.println(sqle);
			}
		
		}
	}
	public static void createDB(Connection c) {
		try {
			Statement stm = c.createStatement();
			stm.executeUpdate("CREATE DATABASE hoteisbh");
		}catch(SQLException sqle) {
			System.out.println(sqle);
		}
	}
	public static void createTable(Connection c) {
		try {
			String url = "CREATE TABLE cliente"+ "(cliente_id int AUTO_INCREMENT PRIMARY KEY NOT NULL,nome VARCHAR(255) NOT NULL,"+
					"telefone int NOT NULL, cpf int UNIQUE NOT NULL)";
			Statement stm = c.createStatement();
			stm.addBatch(url);
			url = "CREATE TABLE quartos" + "(quarto_id int AUTO_INCREMENT PRIMARY KEY NOT NULL,"+
				    "id_cliente int UNIQUE,data_reserva DATE,dias_reservados int,"
				    		+ "CONSTRAINT fk_id_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(cliente_id))";
			stm.addBatch(url);
			url = "CREATE TABLE usuarios" + "(usuario_id int AUTO_INCREMENT PRIMARY KEY NOT NULL, nome VARCHAR(255) NOT NULL, senha VARCHAR(60) NOT NULL)";
			stm.addBatch(url);
			stm.executeBatch();
		}catch(SQLException sqle) {
			System.out.println(sqle);
		}
	}
	public static void populateTable(Connection c) {
		String url = "INSERT into quartos () values ()";
		try {
			for (int i = 0; i<=10 ; i++) {
			Statement stm = c.createStatement();
			stm.executeUpdate(url);
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}

}
