package model.account;
import model.client.Client;

public class Conta{
    private static int prox_num = 1;
    private Client titular;
    private String numero;
    private double saldo;
    private double limite;
    private double saldoDevedor;

    public Conta(Client titular, double limite){
        this.titular = titular;
        this.numero = String.valueOf(prox_num++);
        this.limite = limite;
        this.saldoDevedor = 0;
        this.saldo = 0;
    }

    public void setTitular(Client titular){
        this.titular = titular;
    }

    public void depositar(double valor){
        if (this.saldoDevedor > 0){
            if(valor <= saldoDevedor){
                this.saldoDevedor -= valor;
            } else {
                this.saldo += valor - saldoDevedor;
                this.saldoDevedor -= valor - this.saldo;
            }
        } else this.saldo += valor;
    }

    public void transfer(Conta destino, double valor) throws limitReachedException{
        sacar(valor);
        destino.depositar(valor);
    }

    public void sacar(double valor) throws limitReachedException{
        if (this.saldo >= valor){
            this.saldo -= valor;
        } else if ((limite - this.saldoDevedor) + this.saldo  >= valor){
            this.saldoDevedor  += valor - this.saldo;
            this.saldo -= this.saldo;
        }else{
            throw new limitReachedException(this, valor);
        }
    }

    public String getNumero(){
        return this.numero;
    }

    public Client getTitular(){
        return this.titular;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public double getLimite(){
        return this.limite;
    }
    public double getSaldoDevedor(){
        return this.saldoDevedor;
    }

    public String toString() {
        return "Numero.: " + this.numero +
                " | Titular: " + this.titular.getCpf() +
                " | Saldo..: " + this.saldo;
    }
}