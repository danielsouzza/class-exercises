package repository.account;

import model.account.Conta;
import java.util.ArrayList;
import java.util.List;

public class RepositorioContaLista implements RepositorioConta {

    List<Conta> contas;

    public RepositorioContaLista() {
        this.contas = new ArrayList<>();
    }

    @Override
    public Conta inserirConta(Conta conta) throws ContaJaCadastradaException {
        try {
            buscarConta(conta.getNumero());
            throw new ContaJaCadastradaException();
        } catch (ContaNaoCadastradaException ex) {
            this.contas.add(conta);
        }
         return conta;
    }

    @Override
    public void alterarConta(Conta conta) {
        // Em memória, não há necessidade de atualizar objeto
    }

    @Override
    public void deletarConta(Conta conta) throws ContaNaoCadastradaException {
        if (! contas.remove(conta)) {
            throw new ContaNaoCadastradaException();
        }
    }

    @Override
    public Conta buscarConta(String numero) throws ContaNaoCadastradaException {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)){
                return conta;
            }
        }
        throw new ContaNaoCadastradaException();
    }

    @Override
    public List<Conta> getAll() {
        return new ArrayList<>(contas);
    }

    @Override
    public List<Conta> getAll(String cpf) {
        List<Conta> lista = new ArrayList<>();
        for (Conta conta : contas) {
            if (conta.getTitular().getCpf().equals(cpf)){
                lista.add(conta);
            }
        }
        return lista;
    }

}
