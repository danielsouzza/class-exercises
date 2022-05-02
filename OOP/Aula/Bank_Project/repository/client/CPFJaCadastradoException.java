package repository.client;

public class CPFJaCadastradoException extends Exception{
    
    public CPFJaCadastradoException() {
        super("CPF já cadastrado");
    }
}
