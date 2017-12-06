package persistencia;

import modelo.AddValores;
import modelo.Saque;

public interface SaqueDAO {
	
	Saque retirarNotas(Saque sq, AddValores adv);
	
}
