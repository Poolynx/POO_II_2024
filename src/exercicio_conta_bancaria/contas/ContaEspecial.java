package exercicio_conta_bancaria.contas;

public class ContaEspecial extends ContaBancaria{
	private Double limiteEspecial;
	
	public ContaEspecial() {
		super();
		this.limiteEspecial = 0.0;
	}

	public ContaEspecial(String identificador, Double saldo, Double limiteEspecial) {
		super(identificador, saldo);
		this.limiteEspecial = limiteEspecial;
	}

	public Double getLimiteEspecial() {
		return limiteEspecial;
	}

	public void setLimiteEspecial(Double limiteEspecial) {
		this.limiteEspecial = limiteEspecial;
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
		
		if(this.limiteEspecial >= valorSaque - this.getSaldoConta()) {
			return true;
		}
		
		return false;
	}
	
	
}
