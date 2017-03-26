
public class Cliente {
	private String cpf;
	private String nome;
	
	public Cliente() {
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString(){
		return "CPF:" + getCpf() + " Nome:" + this.nome;
	}
}
