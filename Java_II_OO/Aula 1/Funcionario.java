class Funcionario{
	private String nome;
	private String cpf;
	protected double salario;
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public double getBonificacao(){
		return this.salario * 0.10;
	}
	
	public void setSalario(double salario){
		this.salario = salario;
	}
}