package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.AddDados;
import modelo.Cedulas;

public class CedulasDAOImpl implements CedulasDAO{

	@Override
	public Cedulas atualizarNotas(Cedulas sq, AddDados adv) {
		
		Connection con = BDConexaoDAOImpl.getInstance().getConnection();
		String sql1 = "update Cedulas set " 
				+ "n2 = "+ sq.getN2() +", "
				+ "n5 = "+ sq.getN5() +", "
				+ "n10 = "+ sq.getN10() +", "
				+ "n20 = "+ sq.getN20() +", "
				+ "n50 = "+ sq.getN50() +", "
				+ "n100 = "+ sq.getN100();
		
		try {		
			PreparedStatement ps1 = con.prepareStatement(sql1);
			
			ps1.executeUpdate();	
		} 
		catch (SQLException e) {
			
		}			
		String sql2 = "update Conta set " + "saldo = " + adv.getSaldo()
		             + " where numCartao = '"  + adv.getNumCartao() + "' "; 
		
		try {
			PreparedStatement ps2 = con.prepareStatement(sql2);
			
			ps2.executeUpdate();
		} catch (Exception e) {
			
		}
		return sq;
	}

	@Override
	public Cedulas recebeNotas() {
		
		Cedulas caixa = new Cedulas();
		
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
	public Cedulas tratarCedulasBD(Cedulas cd) {
		
		Connection con = BDConexaoDAOImpl.getInstance().getConnection();
		String sql = "update Cedulas set " 
				+ "n2 = "+ cd.getN2() +", "
				+ "n5 = "+ cd.getN5() +", "
				+ "n10 = "+ cd.getN10() +", "
				+ "n20 = "+ cd.getN20() +", "
				+ "n50 = "+ cd.getN50() +", "
				+ "n100 = "+ cd.getN100(); 
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.execute();
		} 
		catch (SQLException e) {
			
		}
		return cd;
	}
}
