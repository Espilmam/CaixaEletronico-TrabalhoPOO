package controle;

import modelo.AddDados;
import modelo.Cedulas;
import persistencia.CedulasDAOImpl;

public class CtrCedulas {
	
	private CedulasDAOImpl saqueBd = new CedulasDAOImpl();
	private CedulasDAOImpl tratarBD = new CedulasDAOImpl();
	
	public Cedulas sacarValor(Cedulas sq, AddDados conta) {
		
		return saqueBd.atualizarNotas(sq, conta);	
	}
	public Cedulas recebeNotas(){
		
		return saqueBd.recebeNotas();
	}
	public Cedulas tratarCedulas(Cedulas cd) {
		
		return tratarBD.tratarCedulasBD(cd);
	}	
}
