package persistencia;

import modelo.AddValores;
import modelo.Saque;

public interface SaqueDAO {
	
	Saque atualizarNotas(Saque sq, AddValores adv);
	
	Saque recebeNotas ();
}
