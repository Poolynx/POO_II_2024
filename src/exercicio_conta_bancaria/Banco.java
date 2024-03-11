package exercicio_conta_bancaria;

import java.util.ArrayList;
import java.util.List;

import exercicio_conta_bancaria.contas.ContaBancaria;

public class Banco  {
	private List<ContaBancaria> contas;

	public Banco() {
		this.contas = new ArrayList<>();
	}
	
	public Banco(ContaBancaria conta) {
		this.contas = new ArrayList<>();
		contas.add(conta);
	}

	public List<ContaBancaria> getContas() {
		return contas;
	}

	public void addConta(ContaBancaria conta) {
		if(revisarNome(conta)) {
			contas.add(conta);
		}
	}
	
	private boolean revisarNome(ContaBancaria conta) {
		for(ContaBancaria rev : contas) {
			if(rev.getIdentificadorConta().equals(conta.getIdentificadorConta())) {
				return false;
			}
		}
		return true;
	}
}
