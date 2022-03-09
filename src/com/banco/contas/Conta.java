package com.banco.contas;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.banco.cliente.Cliente;

public abstract class Conta implements Transacoes{

	private int SERIAL = 1;
	private boolean E_SAUQUE = true;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected String tipoConta;
	
	protected String dataEmissao;
	
	public Conta(Cliente cliente, String tipoConta) {
		this.cliente = cliente;
		this.agencia = 1;
		this.numero = SERIAL++;
		this.saldo = 0.0d;
		this.tipoConta = tipoConta;
		this.dataEmissao = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		
	}
	

	@Override
	public void deposito(double valor) {
		this.saldo += valor;
		
	}
	
	@Override
	public void saque(double valor) {
		if(this.saldo < valor) {
			System.out.println("\n========= [ Error ] =========\n");
			System.out.println(" * Erro na transacao. Seu saldo é inferiror ao saque que esta tentando realizar. * \n\n");
			
		}else {
			
			if(E_SAUQUE) {
				this.saldo -= valor;
				System.out.println("O saque foi realizado com sucesso.");
			}
		}

	}
	
	
	@Override
	public void tranferencia(Conta contaDestino, double valor) {
		
		if(this.saldo < valor) {
			System.out.println("\n========= [ Error ] =========\n");
			System.out.println(" * Erro na transacao. Voce não tem saldo o suficiente. * \n\n");
					
		}else {
			
			E_SAUQUE = false;
			
			this.saque(valor);
			contaDestino.deposito(valor);
			System.out.println("Transferido com sucesso.");
		}

	}

	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	protected void sobreAConta() {
		System.out.println("+=============================================+");
		System.out.println("|-Nome: "+this.cliente.getNome());
		System.out.println("|-Tipo da Conta: "+this.tipoConta);
		System.out.println(String.format("|-CPF: %s***", this.cliente.getCpf().substring(0, 4)));
		System.out.println(String.format("|-Saldo: R$ %.2f", this.saldo));
		System.out.println("|-Agencia: 000"+this.agencia);
		System.out.println("|-Numero: 000"+this.numero);
		System.out.println("|-Data/hora de emissao : "+this.dataEmissao);
		System.out.println("+=============================================+");

	}

}