package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.AddValores;
import modelo.Saque;

public class SaqueDAOImpl implements SaqueDAO{

	@Override
	public Saque retirarNotas(Saque sq, AddValores adv) {
		
		Connection con = BDConexaoDAOImpl.getInstance().getConnection();
		String sql = "update Cedulas set " 
				+ "n2 = "+ sq.getN2() +", "
				+ "n5 = "+ sq.getN5() +", "
				+ "n10 = "+ sq.getN10() +", "
				+ "n20 = "+ sq.getN20() +", "
				+ "n50 = "+ sq.getN50() +", "
				+ "n100 = "+ sq.getN100(); 
		
		try {		
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.executeUpdate();	
			System.out.println("passei2");
		} 
		catch (SQLException e) {
			
		}	
		return sq;
	}
}
