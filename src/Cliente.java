
public class Cliente {
	private String cpf;
	private String nome;
	private String estadoCivil;
	
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
	public void public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	@Override
	public String toString(){
		return "CPF:" + getCpf() + " Nome:" + this.nome;
	}
}
