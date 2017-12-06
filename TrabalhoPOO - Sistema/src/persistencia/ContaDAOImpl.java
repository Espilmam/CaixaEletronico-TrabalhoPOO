package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.AddValores;

public class ContaDAOImpl implements ContaDAO {
	
	@Override
	public void adiciona(AddValores dados){
	
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
}
