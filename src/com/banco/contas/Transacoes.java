package com.banco.contas;

import com.banco.cliente.Cliente;

public interface Transacoes {


	void deposito(double valor);
	

	void saque(double valor);
	

	void tranferencia(Conta contaDestino, double valor);
	
	
	void extrato();
	
	
}
