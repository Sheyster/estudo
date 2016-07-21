class AtualizadorDeContas{
	private double saldoTotal = 0;
	private double selic;
	
	public AtualizadorDeContas(double selic){
		this.selic = selic;
	}
	
	public void roda(Conta c) {
        System.out.println("===============================");
        System.out.println("Saldo anterior: " + c.getSaldo());
        c.atualiza(this.selic);
        System.out.println("Saldo atualizado: " + c.getSaldo());
        this.saldoTotal += c.getSaldo();
    }
	
	//public void roda(Conta c){
	//	System.out.println(c.getSaldo());
	//	double valor = c.getSaldo() * this.selic;
	//	c.atualizandoConta(valor);
	//	System.out.println(c.getSaldo());
	//	saldoTotal += valor;
	//}
	
	public double getSaldoTotal(){
		return this.saldoTotal;
	}
}