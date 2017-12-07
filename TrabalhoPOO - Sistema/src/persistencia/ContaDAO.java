package persistencia;

import modelo.AddValores;

public interface ContaDAO {
	
	void adiciona(AddValores dados);
	boolean verificaLogin(AddValores usuario);
}
