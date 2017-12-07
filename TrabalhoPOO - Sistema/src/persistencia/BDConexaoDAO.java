package persistencia;

import java.sql.Connection;

import modelo.AddDados;

public interface BDConexaoDAO {
	
	public Connection getConnection();
	
}
