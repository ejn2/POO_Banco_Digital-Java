package com.banco.contas;

import com.banco.cliente.Cliente;

public class ContaPoupanca extends Conta{
	
	private final static String TIPO_DE_CONTA = "013";

	public ContaPoupanca(Cliente cliente) {
		super(cliente, TIPO_DE_CONTA);
	}

	@Override
	public void extrato() {
		System.out.println("+=============================================+");
		System.out.println("|               [ Conta Poupanca ]            |");
		super.sobreAConta();
		
	}

}
