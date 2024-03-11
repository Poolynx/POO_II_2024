package exercicio_conta_bancaria.contas;

import java.time.LocalDate;

public class ContaPoupanca extends ContaBancaria{
	private int qntMaxDeSaques = 5;
	private int mesAnterior;
	
	public void setMes(int mes) {
		mesAnterior = mes;
	}
	
	public ContaPoupanca() {
		super();
		mesAnterior = LocalDate.now().getMonthValue();
	}

	public ContaPoupanca(String identificador, Double saldo) {
		super(identificador, saldo);
		mesAnterior = LocalDate.now().getMonthValue();
	}	
	
	@Override
	public void sacar(Double valorSaque) {
		checkMes();
		if(limiteDisponivel(valorSaque) && qntMaxDisponivel()) {
			this.setSaldoConta(this.getSaldoConta() - valorSaque);
			qntMaxDeSaques -= 1;
		}
	}
	
	private void checkMes() {
		int mesAtual = LocalDate.now().getMonthValue();
		if(mesAtual != mesAnterior) {
			qntMaxDeSaques = 5;
			mesAnterior = mesAtual;
		}
	}
	
	public boolean limiteDisponivel(Double valorSaque) {
		if(this.getSaldoConta() - valorSaque >= 0) {
			return true;
		}
		return false;
	}
	
	public boolean qntMaxDisponivel() {
		if(this.qntMaxDeSaques > 0) {
			return true;
		}
		return false;
	}
	
}
