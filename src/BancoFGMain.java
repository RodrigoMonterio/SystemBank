
public class BancoFGMain {	

	public static void main(String[] args) {
		RepositorioContasArray contas = new RepositorioContasArray(3);
		
		Cliente c1 = new Cliente();
		Conta conta2 = new Conta("1", 100, c1);
	}

}
