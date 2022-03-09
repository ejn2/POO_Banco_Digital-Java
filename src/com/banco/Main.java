package com.banco;

import com.banco.cliente.Cliente;
import com.banco.contas.Conta;
import com.banco.contas.ContaCorrente;
import com.banco.contas.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		
		//Criando Clientes
		Cliente eduardoCliente = new Cliente("Eduardo", "123.456.789-10");
		Cliente pedrinhoCliente = new Cliente("Pedrinho", "664.774.888-94");
		Cliente joaoCliente = new Cliente("Joao","993.883.883-99");
		
		//Criando Contas.
		Conta eduardoConta = new ContaCorrente(eduardoCliente);
		Conta pedrinhoConta = new ContaCorrente(pedrinhoCliente);
		Conta joaoConta = new ContaPoupanca(joaoCliente);
		
		//Depositando valores nas contas.
		eduardoConta.deposito(1000);
		pedrinhoConta.deposito(1000);
		joaoConta.deposito(2450.15);
		
		
		//Transferindo
		pedrinhoConta.tranferencia(eduardoConta, 750.30);
		
		//Emitindo informações sobre as contas.
		pedrinhoConta.extrato();
		eduardoConta.extrato();
		
		//Efetuando saque.
		eduardoConta.saque(220.00);
		
		//Emitindo informações atualizadas sobre as contas.
		eduardoConta.extrato();
		joaoConta.extrato();
		
		//Emitindo erro ao tentar sacar um valor superior ao do saldo atual.
		eduardoConta.saque(750000.00);
		
	}

}
