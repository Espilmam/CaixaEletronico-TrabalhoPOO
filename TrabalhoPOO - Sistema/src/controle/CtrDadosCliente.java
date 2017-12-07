package controle;

import modelo.AddDados;
import persistencia.ContaDAOImpl;

public class CtrDadosCliente {

	ContaDAOImpl cdao = new ContaDAOImpl();
	
	public void criaConta(AddDados adv) {
		
		cdao.adiciona(adv);
	}
	public AddDados recebeSaldo() {
		
		return cdao.recebeSaldo();
	}
	public boolean verificaLogin(AddDados usuario) {
		
		return cdao.verificaLogin(usuario);
	}
	public boolean verificaDeposito(AddDados usuario) {
		
		return cdao.verificaDeposito(usuario);
	}
}
