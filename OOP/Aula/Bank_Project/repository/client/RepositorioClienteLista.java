package repository.client;

import model.client.Client;

import java.util.ArrayList;
import java.util.List;

public class RepositorioClienteLista implements RepositorioCliente{
    List<Client> clients;
    
    public RepositorioClienteLista(){
        this.clients = new ArrayList<Client>();
    }

    @Override
    public void inserirCliente(Client client) throws CPFJaCadastradoException {
        try {
            buscarCliente(client.getCpf());
            throw new CPFJaCadastradoException();
        } catch (ClienteNaoCadastradoException ex) {
            clients.add(client);
        }
    }

    @Override
    public void alterarCliente(Client client) throws ClienteNaoCadastradoException {
        // Em memória, não há necessidade de atualizar objeto
        buscarCliente(client.getCpf());
    }

    @Override
    public void deletarCliente(Client client) throws ClienteNaoCadastradoException {
        if (! clients.remove(client)) {
            throw new ClienteNaoCadastradoException();
        }
    }

    @Override
    public Client buscarCliente(String cpf) throws ClienteNaoCadastradoException {
        for (Client client : clients) {
            if (client.getCpf().equals(cpf)){
                return client;
            }
        }
        throw new ClienteNaoCadastradoException();
    }

    @Override
    public List<Client> getAll() {
        return new ArrayList<>(clients);
    }
}
