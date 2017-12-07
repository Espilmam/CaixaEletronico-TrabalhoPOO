package controle;

import modelo.AddDados;
import persistencia.ContaDAOImpl;

public class CtrDadosCliente {

	ContaDAOImpl cdao = new ContaDAOImpl();
	
	public void criaConta(AddDados adv) {
		
		cdao.adiciona(adv);
	}
	public boolean verificaLogin(AddDados usuario) {
		
		return cdao.verificaLogin(usuario);
	}
}
