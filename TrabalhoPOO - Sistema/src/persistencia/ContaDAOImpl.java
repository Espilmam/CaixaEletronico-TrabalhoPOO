package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.AddDados;
import visao.Telas;

public class ContaDAOImpl implements ContaDAO {
	
	@Override
	public void adiciona(AddDados dados){
		
		Connection con = BDConexaoDAOImpl.getInstance().getConnection();	
		String sql = "insert into Conta(nome, conta, numCartao, senha, saldo, banco, agencia) values (?,?,?,?,?,?,?)";
		
		try {			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, dados.getNome());
			ps.setString(2, dados.getConta());
			ps.setString(3, dados.getNumCartao());
			ps.setString(4, dados.getSenha());
			ps.setDouble(5, dados.getSaldo());
			ps.setString(6, dados.getBanco());
			ps.setString(7, dados.getAgencia());
			
			ps.executeUpdate();	
		} 
		catch (SQLException e) {
			
		}
	}
	@Override
	public boolean verificaLogin(AddDados usuario) {
		
		usuario.setAgencia(null);
		usuario.setConta(null);
		
		Connection con = BDConexaoDAOImpl.getInstance().getConnection();	
		String sql = "select * from Conta" 
		+ " where numCartao = '" + usuario.getNumCartao() + "' and senha = '" + usuario.getSenha() + "'";
		
		try {			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				usuario.setAgencia(rs.getString("agencia"));
				usuario.setBanco(rs.getString("banco"));
				usuario.setSaldo(rs.getDouble("saldo"));
				usuario.setConta(rs.getString("conta"));
				usuario.setNome(rs.getString("nome"));			
			}
			if (usuario.getAgencia() == null  || usuario.getConta() == null) {
				
				return false;
			}
			else {
				
				return true;
			}
		}
		catch (SQLException e) {
			
			return false;
		}
	}
	
	@Override
	public AddDados recebeSaldo() {

		AddDados saldo = new AddDados();
		
		Connection con = BDConexaoDAOImpl.getInstance().getConnection();	
		String sql = "select * from Conta" + "where numCartao = '" + saldo.getNumCartao() + "'";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				saldo.setSaldo(rs.getInt("saldo"));
			}		
		} 
		catch (SQLException e) {
			
		}	
		return saldo;
	}
	
	@Override
	public boolean verificaDeposito(AddDados usuario) {
		System.out.println("passei");
		Connection con = BDConexaoDAOImpl.getInstance().getConnection();	
		String sql1 = "select * from Conta" + "where banco = '" + usuario.getBanco() 
					+ "' and agencia = '" + usuario.getAgencia()
					+ "' and conta = '" + usuario.getConta() + "'";
		
		try {
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ResultSet rs = ps1.executeQuery();
			
			while(rs.next()) {
				
				usuario.setAgencia(rs.getString("agencia"));
				usuario.setBanco(rs.getString("banco"));
				usuario.setConta(rs.getString("conta"));					
			}
			if (usuario.getAgencia() == null || usuario.getBanco() == null || usuario.getConta() == null) {
				System.out.println("passei");
				return true;
			}
			else {
				
				String sql2 = "update Conta set " + "saldo = '" + (usuario.getValor()) + "'";
				
				try {
					PreparedStatement ps2 = con.prepareStatement(sql2);
					System.out.println("adicionei");
					ps2.execute();
				} 
				catch (Exception e) {
					
				}
				return true;
			}
		} 
		catch (SQLException e) {

		}
		return false;
	}
}






