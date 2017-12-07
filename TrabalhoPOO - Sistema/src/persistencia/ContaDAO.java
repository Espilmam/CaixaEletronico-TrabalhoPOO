package persistencia;

import modelo.AddDados;

public interface ContaDAO {
	
	void adiciona(AddDados dados);
	boolean verificaLogin(AddDados usuario);
	boolean verificaDeposito(AddDados usuario);
	AddDados recebeSaldo();
}
