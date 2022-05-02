package repository.account;

public class ContaNaoCadastradaException extends Exception {
    public ContaNaoCadastradaException() {
        super("Conta não cadastrada");
    }
}
