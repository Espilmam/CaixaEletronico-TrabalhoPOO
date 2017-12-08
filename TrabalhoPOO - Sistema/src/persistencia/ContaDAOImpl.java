package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.AddDados;

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
	public AddDados recebeSaldo(AddDados saldo) {
		
		Connection con = BDConexaoDAOImpl.getInstance().getConnection();	
		String sql = "select saldo from Conta " + "where numCartao = '" + saldo.getNumCartao() + "'";
		
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
		
		Connection con = BDConexaoDAOImpl.getInstance().getConnection();	
		String sql1 = "select * from Conta " + "where banco = '" + usuario.getBanco() 
					+ "' and agencia = '" + usuario.getAgencia()
					+ "' and conta = '" + usuario.getConta() + "'";
		
		try {
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ResultSet rs = ps1.executeQuery();
			
			while(rs.next()) {
				
				usuario.setNumCartao(rs.getString("numCartao"));
				
			}
			if (usuario.getNumCartao() == null) {
				
				JOptionPane.showMessageDialog(null, "Dados procurados não existem");
				
				return false;
			}
			else {
				
				String sql2 = "update Conta set " + "saldo = saldo + " + usuario.getValor()
				+ " where numCartao = '"  + usuario.getNumCartao() + "' "; 
				System.out.println("passei3");
				try {
					PreparedStatement ps2 = con.prepareStatement(sql2);
				
					ps2.execute();
				} 
				catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "Dados não encontrados");
				}
				return true;
			}
		} 
		catch (SQLException e) {

		}
		return false;
	}
	@Override
	public void descontarSaldo(AddDados adv) {
		
		Connection con = BDConexaoDAOImpl.getInstance().getConnection();
		String sql = "update Conta set " + "saldo = " + adv.getSaldo()
                       + " where numCartao = '"  + adv.getNumCartao() + "' "; 
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.executeUpdate();
		} 
		catch (SQLException e) {
			
		}
	}
}






