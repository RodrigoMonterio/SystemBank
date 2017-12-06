//Projeto do Professor Endrigo - Faculdade dos Guararapes.


public class BancoFGMain {	

	public static void main(String[] args) {
		RepositorioContasArray contas = new RepositorioContasArray(3);
		
		Cliente c1 = new Cliente();
		Conta conta1 = new Conta("1", 100, c1);
		
		Cliente c2 = new Cliente();
		
		Conta conta2 = new Conta("2", 200, c2);
	}

}
