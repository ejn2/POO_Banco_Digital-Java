package com.banco.contas;

import com.banco.cliente.Cliente;

public class ContaCorrente extends Conta {
	
	private final static String TIPO_DE_CONTA = "001";
	
	public ContaCorrente(Cliente cliente) {
		super(cliente, TIPO_DE_CONTA);
	}

	public void extrato() {
		System.out.println("+=============================================+");
		System.out.println("|               [ Conta Corrente ]            |");
		super.sobreAConta();
	}
	
}
