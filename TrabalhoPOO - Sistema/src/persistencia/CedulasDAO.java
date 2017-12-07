package persistencia;

import modelo.AddDados;
import modelo.Cedulas;

public interface CedulasDAO {
	
	Cedulas atualizarNotas(Cedulas sq, AddDados adv);
	Cedulas recebeNotas();
	Cedulas tratarCedulasBD(Cedulas cd);
}
