package controle;

import modelo.AddValores;
import persistencia.ContaDAOImpl;

public class CtrAddValor {

	ContaDAOImpl cdao = new ContaDAOImpl();
	
	public void criaConta(AddValores adv) {
		
		cdao.adiciona(adv);
	}
	public boolean verificaLogin(AddValores usuario) {
		return cdao.verificaLogin(usuario);
	}
}
