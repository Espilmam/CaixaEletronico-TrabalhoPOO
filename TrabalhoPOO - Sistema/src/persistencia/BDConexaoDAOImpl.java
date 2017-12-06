package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConexaoDAOImpl implements BDConexaoDAO{
	
  /*USERNAME = UserADM
	PASSWORD = Trabalhopoo123
	URLDB = trabalhopoo-conta.database.windows.net */
	
	private static BDConexaoDAOImpl instancia;
	private Connection con;
	
	public BDConexaoDAOImpl() {
		
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:jtds:sqlserver://trabalhopoo-conta.database.windows.net:1433;DatabaseName=BDConta;namedPipes=true;user=UserADM;password=Trabalhopoo123");
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	public static BDConexaoDAOImpl getInstance() {
		
		if (instancia == null) {
			
			instancia = new BDConexaoDAOImpl();
		}
		return instancia;
	}
	public Connection getConnection() {
				
		return con;
	}
}
