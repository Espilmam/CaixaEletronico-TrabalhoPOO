package persistencia;

import java.sql.Connection;

import modelo.AddValores;

public interface BDConexaoDAO {
	
	public Connection getConnection();
	
}
