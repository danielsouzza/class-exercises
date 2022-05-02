package repository.client;

public class ClienteNaoCadastradoException extends Exception{
    
    public ClienteNaoCadastradoException() {
        super("Cliente não encontado");
    }
}
