package repository.client;

import model.client.Client;
import java.util.List;

public interface RepositorioCliente {
    void inserirCliente(Client client) throws CPFJaCadastradoException;

    void alterarCliente(Client client) throws ClienteNaoCadastradoException;

    void deletarCliente(Client client) throws ClienteNaoCadastradoException;

    Client buscarCliente(String cpf) throws ClienteNaoCadastradoException;

    List<Client> getAll();
}