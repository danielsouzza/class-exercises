import controler.ControladorBanco;
import controler.ControladorException;
import model.account.Conta;
import model.account.limitReachedException;
import model.client.Client;
import repository.account.ContaJaCadastradaException;
import repository.account.ContaNaoCadastradaException;
import repository.client.CPFJaCadastradoException;
import repository.client.ClienteNaoCadastradoException;

import java.util.List;
import java.util.Scanner;

public class Main {
    static ControladorBanco controlador;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        controlador = new ControladorBanco();

        insereDadosTeste();

        int opcao;
        do {
            limpaTela();
            System.out.println("MENU PRINCIPAL");
            System.out.println("==== =========");
            System.out.println();
            System.out.println("<1> Cadastro Clientes");
            System.out.println("<2> Cadastro Contas");
            System.out.println("<3> CAIXA ELETRONICO");
            System.out.println("<0> Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");    
            try {
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    cadastroClientes();
                    break;
                case 2:
                    cadastroContas();
                     break;
                case 3:
                    caixaEletronico();
                    break;
            }
        } while (opcao != 0);

        controlador.exit();
        System.out.println("Programa terminado");
    }

    private static void insereDadosTeste() {

        try {
    
            Client client1 = new Client("Daniel", "111.111.111-11",'M', "(93) 991111111");
            Client client2 = new Client("Lucas", "222.222.222-22", 'M', "(93) 992222222");
            controlador.inserirCliente(client1);
            controlador.inserirCliente(client2);

            Conta conta1 = new Conta(client1, 500);
            Conta conta2 = new Conta(client2, 300);
            controlador.inserirConta(conta1);
            controlador.inserirConta(conta2);

        } catch (CPFJaCadastradoException | ContaJaCadastradaException ex) {
        }
    }

    private static void cadastroClientes() {
        int opcao;
        do {
            limpaTela();
            System.out.println("CADASTRO CLIENTES");
            System.out.println("======== ========");
            System.out.println();
            System.out.println("<1> Incluir Cliente");
            System.out.println("<2> Alterar Cliente");
            System.out.println("<3> Excluir Cliente");
            System.out.println("<4> Listar Clientes");
            System.out.println("<0> Menu Principal");
            System.out.println();
            System.out.print("Escolha uma opção: ");
    
            try {
               opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
               opcao = 0;
            }

            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    incluirCliente();
                    break;
                case 2:
                    alterarCliente();
                    break;
                case 3:
                    excluirCliente();
                    break;
                case 4:
                    listarCliente();
                    break;
            }

        } while (opcao != 0);
    }
    
    private static void incluirCliente() {
        limpaTela();
        System.out.println("Cadastro de Cliente");
        System.out.println("===================");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sexo: ");
        char sexo = scanner.nextLine().charAt(0);
        System.out.print("Telefone: ");
        String fone = scanner.nextLine();
    
        Client cliente = new Client(cpf, nome, sexo, fone);
    
        try {
            controlador.inserirCliente(cliente);
            System.out.println("Cliente cadastrado!");
        } catch (CPFJaCadastradoException ex) {
            System.err.println(ex.getMessage());
        }
    
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void listarCliente() {
        limpaTela();
        List<Client> clientes = controlador.getAllClientes();
        System.out.printf("CPF            Nome                 Sexo Telefone\n");
        System.out.printf("============== ==================== ==== ===============\n");
        for (Client cliente : clientes) {
            System.out.printf("%12s ", cliente.getCpf());
            System.out.printf("%-20s ", cliente.getName());
            System.out.printf("%-4s ", String.valueOf(cliente.getSexo()));
            System.out.printf("%15s\n", cliente.getPhone());
        }
    
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }
    
    private static void excluirCliente() {
        limpaTela();
        System.out.println("Excluir de Cliente");
        System.out.println("==================");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        try {
            Client client = controlador.buscarCliente(cpf);
            System.out.println();
            System.out.println("Nome: " + client.getName());
            System.out.println("Sexo: " + client.getSexo());
            System.out.println("Telefone: " + client.getPhone());
            System.out.println();   
            System.out.print("Exclui esse cliente? (s/n)?");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
            controlador.excluirCliente(client);
            System.out.println("Cliente excluído!");
            }

        } catch (ClienteNaoCadastradoException | ControladorException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void alterarCliente() {
        limpaTela();
        System.out.println("Alterar de Cliente");
        System.out.println("==================");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
    
        try {
            Client cliente = controlador.buscarCliente(cpf);

            System.out.println();
            System.out.println("Nome: " + cliente.getName());
            System.out.print("Nome (<enter> = Não alterar): ");
            String nome = scanner.nextLine();
            if (!nome.equals("")) {
                cliente.setName(nome);
            }

            System.out.println("Sexo: " + cliente.getSexo());
            System.out.print("Sexo (<enter> = Não alterar): ");
            String sexo = scanner.nextLine();
            if (!sexo.equals("")) {
                cliente.setSexo(sexo.charAt(0));
            }

            System.out.println("Telefone: " + cliente.getPhone());
            System.out.print("Telefone (<enter> = Não alterar): ");
            String fone = scanner.nextLine();
            if (!fone.equals("")) {
                cliente.setPhone(fone);
            }

            System.out.println();

            controlador.alterarCliente(cliente);
            System.out.println("Cliente Alterado!");
            System.out.println();

        } catch (ClienteNaoCadastradoException ex) {
            System.err.println(ex.getMessage());
        }
    
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void cadastroContas() {
        int opcao;

        do {
            limpaTela();
            System.out.println("CADASTRO CONTAS");
            System.out.println("======== ======");
            System.out.println();
            System.out.println("<1> Incluir Conta");
            System.out.println("<2> Excluir Conta");
            System.out.println("<3> Consultar Conta");
            System.out.println("<4> Listar Contas");
            System.out.println("<5> Render Juros");
            System.out.println("<0> Menu Principal");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    incluirConta();
                    break;
                case 2:
                    excluirConta();
                    break;
                case 3:
                    consultarConta();
                    break;
                case 4:
                    listarContas();
                    break;
                case 5:
                    // TODO Implementar Render Juros
                    break;
            }
        } while (opcao != 0);
    }

    private static void incluirConta() {
        limpaTela();
        System.out.println("Cadastro de Conta");
        System.out.println("=================");
    
        try {
            System.out.print("CPF do titular: ");
            String cpf = scanner.nextLine();
            Client titular = controlador.buscarCliente(cpf);

            Conta conta = new Conta(titular, 100);
            conta = controlador.inserirConta(conta);
            System.out.println("Conta Corrente #" + conta.getNumero() + " criada!");

        } catch (ClienteNaoCadastradoException | ContaJaCadastradaException ex) {
            System.err.println(ex.getMessage());
        }
    
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void excluirConta() {
        limpaTela();
        System.out.println("Excluir de Conta");
        System.out.println("================");
        System.out.println();
        System.out.print("Numero da Conta: ");
        String numero = scanner.nextLine();
    
        try {
            Conta conta = controlador.buscarConta(numero);
            System.out.println();
            System.out.println("Numero: " + conta.getNumero());
            System.out.println("Titular: " + conta.getTitular().getName());
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println();
            
            System.out.print("Exclui essa conta? (s/n)?");
            String resposta = scanner.nextLine();
    
            if (resposta.equalsIgnoreCase("s")) {
                controlador.excluirConta(conta);
                System.out.println("Conta excluída!");
            }
    
        } catch (ContaNaoCadastradaException | ControladorException ex) {
            System.err.println(ex.getMessage());
        }
    
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void consultarConta() {
        limpaTela();
        System.out.println("Consultar Saldo");
        System.out.println("===============");
        System.out.println();
        System.out.print("Numero da Conta: ");
        String numero = scanner.nextLine();
    
        try {
            Conta conta = controlador.buscarConta(numero);
            System.out.println();
            System.out.println("Numero: " + conta.getNumero());
            System.out.println("Titular: " + conta.getTitular().getName());
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println();
    
        } catch (ContaNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }
    
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void caixaEletronico() {

        try {
            limpaTela();
            System.out.println("CAIXA ELETRONICO");
            System.out.println("================");
            System.out.println();
            System.out.print("Numero da Conta: ");
            String numeroConta = scanner.nextLine();
            controlador.buscarConta(numeroConta);
            
            int opcao;
            do {
                limpaTela();
                System.out.println("CAIXA ELETRONICO");
                System.out.println("===== ==========");
                System.out.println();
                System.out.println("<1> Deposito");
                System.out.println("<2> Saque");
                System.out.println("<3> Transferência");
                System.out.println("<4> Consulta Saldo");
                System.out.println("<5> Extrato");
                System.out.println("<0> Menu Principal");
                System.out.println();
                System.out.print("Escolha uma opção: ");
                
                try {
                    opcao = Integer.valueOf(scanner.nextLine());
                } catch (Exception e) {
                    opcao = 0;
                }
              
                switch (opcao) {
                    case 0:
                        limpaTela();
                        break;
                    case 1:
                        deposito(numeroConta);
                        break;
                    case 2:
                        saque(numeroConta);
                        break;
                    case 3:
                        tranferencia(numeroConta);
                        break;
                    case 4:
                        consultarSaldo(numeroConta);
                        break;
                    case 5:
                        extrato(numeroConta);
                        break;
                }
            } while (opcao != 0);

        } catch (ContaNaoCadastradaException e) {
            System.err.println(e.getMessage());
        }
    
    }

    private static void deposito(String numero) {
        limpaTela();
        System.out.println("Deposito em Conta");
        System.out.println("=================");
        System.out.println();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
    
        try {
            controlador.deposito(numero, valor);
            System.out.println("Depósito Realizado!");
        } catch (ContaNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }
    
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void saque(String numero) {
        limpaTela();
        System.out.println("Saque de Conta");
        System.out.println("==============");
        System.out.println();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
    
        try {
            controlador.saque(numero, valor);
            System.out.println("Saque Realizado!");
        } catch (ContaNaoCadastradaException | limitReachedException ex) {
            System.err.println(ex.getMessage());
        }
    
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void tranferencia(String numero) {
        limpaTela();
        System.out.println("Transferencia entre Contas");
        System.out.println("==========================");
        System.out.println();
        System.out.print("Conta destino: ");
        String destino = scanner.nextLine();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
    
        try {
            controlador.tranferir(numero, destino, valor);
            System.out.println("Transferência Realizada!");
        } catch (ContaNaoCadastradaException | limitReachedException ex) {
            System.err.println(ex.getMessage());
        }
    
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void consultarSaldo(String numero) {
        limpaTela();
        System.out.println("Consultar Saldo");
        System.out.println("===============");
        System.out.println();
        try {
            Conta conta = controlador.buscarConta(numero);
            System.out.println();
            System.out.println("Numero: " + conta.getNumero());
            System.out.println("Titular: " + conta.getTitular().getName());
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println();

        } catch (ContaNaoCadastradaException ex) {
            System.err.println(ex.getMessage());
        }
    
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void extrato(String numeroConta) {

        // TODO Implementar extrato da conta
        /*
         * Exemplo:
         * Data Historico Valor T
         * ======== ========================= =============== =
         * Saldo anterior R$ 0,00
         * 14/01/19 Depósito R$ 500,00 C
         * 14/01/19 Saque R$ 30,00 D
         * 14/01/19 Tranferido para conta #2 R$ 25,00 D
         * Saldo atual R$ 445,00
         */
    }
    
    private static void listarContas() {
        limpaTela();
        List<Conta> contas = controlador.getAllContas();
        System.out.printf("Conta  Titular              Saldo\n");
        System.out.printf("=====  ==================== ===============\n");

        for(Conta conta : contas) {
            System.out.printf("%-6s ",conta.getNumero());
            System.out.printf("%-20s ", conta.getTitular().getName());
            System.out.printf("%.2f\n", conta.getSaldo());
        }

        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void limpaTela() {
        try{
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        } catch (Exception e){

        }
    }
}