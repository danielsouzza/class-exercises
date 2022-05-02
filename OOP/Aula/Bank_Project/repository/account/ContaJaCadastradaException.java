package repository.account;

public class ContaJaCadastradaException extends Exception {
    public ContaJaCadastradaException() {
        super("Conta já cadastrada");
    }
}
