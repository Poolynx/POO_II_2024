package exercicio_conta_bancaria.contas;

public class ContaCorrente extends ContaBancaria{
	
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(String identificador, Double saldo) {
		super(identificador, saldo);
	}
	
	@Override
	public void transferencia(ContaBancaria contaDestino, Double valorTransf) {
		if(limiteDisponivel(valorTransf)) {
			this.setSaldoConta(this.getSaldoConta() - valorTransf);
			contaDestino.setSaldoConta(valorTransf);
		}
	}
	
	@Override
	public void sacar(Double valorSaque) {
		if(limiteDisponivel(valorSaque)) {
			this.setSaldoConta(this.getSaldoConta() - valorSaque);
		}
	}
	
	public boolean limiteDisponivel(Double valorSaque) {
		if(this.getSaldoConta() - valorSaque >= 0) {
			return true;
		}
		return false;
	}
}
