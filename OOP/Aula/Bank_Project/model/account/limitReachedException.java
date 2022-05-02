package model.account;
public class limitReachedException extends Exception{
    private Conta conta;
    private double valor;
    public limitReachedException(Conta conta, double valor){
        super("Limite atingido para cheque especial na conta " + conta.getNumero());
        this.conta = conta;
        this.valor = valor;
    }

    public Conta getConta() {
        return this.conta;  
    }

    public double getValor(){
        return this.valor;
    }
}