package projeto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/bd2msin?user=root&password=a1b2c3d4");
		} catch (SQLException excecao) {
			throw new RuntimeException(excecao);
		}
	}

}// fim da classe