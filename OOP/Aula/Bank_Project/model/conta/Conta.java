package model.conta;

import model.cliente.Cliente;
import java.io.Serializable;
import strategy.GetDate;


public abstract class Conta implements Serializable {
    private GetDate date;
    
    private String numero;
    private Cliente titular;
    private double saldo;
    private ExtratoConta extrato;
  
    public Conta(Cliente titular) {
        this.date = new GetDate();
        this.titular =  titular;
        this.saldo = 0;
        this.extrato = new ExtratoConta("Saldo anterior",0,"",0,0);
    }
    
    public void depositar(double valor) {
        this.saldo = this.saldo + valor;
        this.lancamento("Deposito",valor,"C",(this.getSaldo()-valor), this.getSaldo());
    }
    
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= this.getDisponivelParaSaque()) {
            this.saldo -= valor;
            this.lancamento("Saque",valor,"D",(this.getSaldo()-valor), this.getSaldo());
        } else {
            throw new SaldoInsuficienteException(this);
        }
        
    }
    
    public void transferir(Conta destino, double valor) throws SaldoInsuficienteException {
        this.sacar(valor);
        destino.depositar(valor);
        this.lancamento(("Transferiu para conta #" + destino.getNumero()),valor,"C",(this.getSaldo()-valor), this.getSaldo());
        destino.lancamento(("Recebeu da conta #" + this.numero),valor,"C",(destino.getSaldo()-valor), this.getSaldo());
    }

    public void lancamento(String historico, double valor, String tipo, double saldoA, double saldoP){
        ExtratoItem lancamento = new ExtratoItem(this.date.getDate(),historico,valor,tipo,saldoA, saldoP);
        this.extrato.addLancamento(lancamento);
      }

    public ExtratoConta getExtratoConta(){
        return this.extrato;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public void setNumero(String numero) {
	    this.numero = numero;
    }
    
    public String getNumero() {
        return this.numero;
    }
    
    public double getSaldo() {
        return this.saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getDisponivelParaSaque() {
        return this.saldo;
    }
  
    public abstract String getTipo();
    
    public String toString() {
        return "Número...: " + this.getNumero() +
               "\nTitular..: " + this.getTitular() +
               "\nSaldo....: " + this.getSaldo();
    }
}