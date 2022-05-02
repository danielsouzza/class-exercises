package controler;

import java.util.List;

import model.account.limitReachedException;
import model.account.Conta;
import model.client.Client;
import repository.account.ContaJaCadastradaException;
import repository.account.ContaNaoCadastradaException;
import repository.account.RepositorioConta;
import repository.account.RepositorioContaLista;
import repository.client.CPFJaCadastradoException;
import repository.client.ClienteNaoCadastradoException;
import repository.client.RepositorioCliente;
import repository.client.RepositorioClienteLista;



public class ControladorBanco {

    private RepositorioCliente repositorioCliente;
    private RepositorioConta repositorioConta;

    public ControladorBanco() {
        repositorioCliente = new RepositorioClienteLista();
        repositorioConta = new RepositorioContaLista();
    }

    public void inserirCliente(Client client) throws CPFJaCadastradoException {
        repositorioCliente.inserirCliente(client);
    }

    public void alterarCliente(Client cliente) throws ClienteNaoCadastradoException {
        repositorioCliente.alterarCliente(cliente);
    }

    public Client buscarCliente(String cpf) throws ClienteNaoCadastradoException {
        return repositorioCliente.buscarCliente(cpf);
    }

    public void excluirCliente(Client cliente) throws ControladorException, ClienteNaoCadastradoException {
    	// Busca listas de contas do Cliente
    	List<Conta> contasCliente = this.getAllContas(cliente.getCpf());
    	
        if (contasCliente.isEmpty()) {
            repositorioCliente.deletarCliente(cliente);
        } else {
            throw new ControladorException("Cliente com contas ativas não pode ser excluído");
        }
    }

    public Conta inserirConta(Conta conta) throws ContaJaCadastradaException {
        return repositorioConta.inserirConta(conta);
    }

    public Conta buscarConta(String numero) throws ContaNaoCadastradaException  {
        return repositorioConta.buscarConta(numero);
    }

    // TODO Regra de Negocio: não excluir conta com saldo
    public void excluirConta(Conta conta) throws ControladorException, ContaNaoCadastradaException {
        if(!(conta.getSaldo() > 0)){
            repositorioConta.deletarConta(conta);
        } else {
            throw new ControladorException("Conta com saldo positivo não pode ser excluída");
        }
    }

    public void deposito(String numero, double valor) throws ContaNaoCadastradaException {
        Conta conta = repositorioConta.buscarConta(numero);
        conta.depositar(valor);
        repositorioConta.alterarConta(conta);
    }

    public void saque(String numero, double valor) throws ContaNaoCadastradaException, limitReachedException {
        Conta conta = repositorioConta.buscarConta(numero);
        conta.sacar(valor);
        repositorioConta.alterarConta(conta);
    }

    public void tranferir(String origem, String destino, double valor) throws ContaNaoCadastradaException, limitReachedException {
        Conta conta1 = repositorioConta.buscarConta(origem);
        Conta conta2 = repositorioConta.buscarConta(destino);
        conta1.sacar(valor);
        conta2.depositar(valor);
        repositorioConta.alterarConta(conta1);
        repositorioConta.alterarConta(conta2);
    }

    public List<Conta> getAllContas() {
        return repositorioConta.getAll();
    }

    public List<Conta> getAllContas(String cpf) {
        return repositorioConta.getAll(cpf);
    }

    public List<Client> getAllClientes() {
        return repositorioCliente.getAll();
    }

    public void exit() {
        // Nada para fazer
    }
}

