package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.AddValores;
import modelo.Saque;

public class SaqueDAOImpl implements SaqueDAO{

	@Override
	public Saque atualizarNotas(Saque sq, AddValores adv) {
		
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

	@Override
	public Saque recebeNotas() {
		Saque caixa = new Saque();
		
		Connection con = BDConexaoDAOImpl.getInstance().getConnection();
		String sql = "select * from cedulas";
		
		try {		
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				caixa.setN2(rs.getInt("n2"));
				caixa.setN5(rs.getInt("n5"));
				caixa.setN10(rs.getInt("n10"));
				caixa.setN20(rs.getInt("n20"));
				caixa.setN50(rs.getInt("n50"));
				caixa.setN100(rs.getInt("n100"));
			}
		} 
		catch (SQLException e) {
			
		}	
		return caixa;
	}
	
	
}
