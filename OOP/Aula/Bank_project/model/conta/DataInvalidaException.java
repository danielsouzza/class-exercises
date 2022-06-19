package model.conta;

public class DataInvalidaException extends Exception{
    public DataInvalidaException(String date){
        super("Nenhuma transação na data "+ date);
    }   
}
