import java.util.ArrayList;
import java.util.Collection;

public class RepositorioContasArray {
	private Conta[] contas;
	int indiceAtual;

	public RepositorioContasArray(int totalContas) {
		contas = new Conta[totalContas];
		indiceAtual = 0;
	}

	private int procurarIndice(String numero) {
		for (int i = 0; i < indiceAtual; i++) {
			Conta c = contas[i];

			if (c.getNumero().equals(numero)) {
				return i;
			}
		}

		return -1;
	}

	public void inserir(Conta novaConta) {
		contas[indiceAtual] = novaConta;
		indiceAtual++;
	}

	public Conta procurar(String numero) {
		int indice = procurarIndice(numero);

		if (indice > -1) {
			return contas[indice];
		}

		return null;
	}

	private boolean existe(String numero) {
		Conta c = procurar(numero);

		if (c == null) {
			return false;
		}

		return true;
	}

	public void atualizar(Conta conta) {
		if (existe(conta.getNumero())) {
			int indice = procurarIndice(conta.getNumero());
			contas[indice] = conta;
		}
	}

	public void remover(String numero) {
		if (existe(numero)) {
			int indice = procurarIndice(numero);
			contas[indice] = contas[indiceAtual];
			contas[indiceAtual] = null;
			indiceAtual--;
		}
	}

	public Collection procurarContas(String cpf){
		Collection<Conta> ccontas = new ArrayList<Conta>();
		
		for (int i = 0; i < indiceAtual; i++) {
			if(contas[i].getCliente().getCpf().equals(cpf)){
				ccontas.add(contas[i]);
			}
		}
		
		return ccontas;
	}

}
