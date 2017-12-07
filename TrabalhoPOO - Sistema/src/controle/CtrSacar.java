package controle;

import modelo.AddValores;
import modelo.Saque;
import persistencia.SaqueDAOImpl;

public class CtrSacar {
	
	private SaqueDAOImpl saqueBd = new SaqueDAOImpl();
	
	public Saque sacarValor(Saque sq, AddValores conta) {
		
		System.out.println("passei1");
		
		return saqueBd.atualizarNotas(sq, conta);	
	}
	
	public Saque recebeNotas(){
		return saqueBd.recebeNotas();
	}
}
