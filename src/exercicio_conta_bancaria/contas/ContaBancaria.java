package exercicio_conta_bancaria.contas;

public class ContaBancaria {
	private String identificadorConta;
	private Double saldoConta;
	
	public ContaBancaria() {
		this.identificadorConta = "";
		this.saldoConta = 0.0;
	}

	public ContaBancaria(String identificadorConta, Double saldoConta) {
		super();
		this.identificadorConta = identificadorConta;
		this.saldoConta = saldoConta;
	}

	public String getIdentificadorConta() {
		return identificadorConta;
	}

	public void setIdentificadorConta(String identificadorConta) {
		this.identificadorConta = identificadorConta;
	}

	public Double getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(Double saldoConta) {
		this.saldoConta = saldoConta;
	}
	
	public void depositar(Double valorDeposito) {
		this.saldoConta += valorDeposito;
	}
	
	public void sacar(Double valorSaque) {
		this.saldoConta -= valorSaque;
	}
	
	public void transferencia(ContaBancaria contaDestino, Double valorTransf) {
		this.saldoConta -= valorTransf;
		contaDestino.setSaldoConta(contaDestino.getSaldoConta() + valorTransf);
	}
	
}
