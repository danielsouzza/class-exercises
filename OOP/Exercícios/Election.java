import java.util.Scanner;

class Candidato{
    private String nome;
    private int numero;
    private int votos;

    public Candidato(String nome, int numero){
        this.nome = nome;
        this.numero = numero;
        this.votos = 0;
    }

    public String toString(){
        return ("Nome..: " + this.nome + "\nVotos.: " + this.votos);
    }

    public void votar() {
        this.votos += 1;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getName() {
        return this.nome;
    }

    public int getNumero() {
        return this.numero;
    }
}

public class Election {
    public static void main(String[] args) {
        Candidato candidato1 = new Candidato("Barack Obama",10);
        Candidato candidato2 = new Candidato("Donald Trump", 45);
        Candidato candidato3 = new Candidato("Joe Biden", 35);
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("<><><><><><> CANDIDATOS <><><><><><>");
            System.out.printf("Candidato #1: %s\t[%d]\n",candidato1.getName(), candidato1.getNumero());
            System.out.printf("Candidato #2: %s\t[%d]\n",candidato2.getName(), candidato2.getNumero());
            System.out.printf("Candidato #3: %s \t[%d]\n",candidato3.getName(), candidato3.getNumero());
            System.out.println("<><><><><><><><><><><><><><><><><><>");
            System.out.println("Digite [0] para parar de votar");
            System.out.println("<><><><><><><><><><><><><><><><><><>");


            while(true){
                System.out.printf("Vote com o número do candidato: ");
                int choice = input.nextInt();
                if(choice == candidato1.getNumero()){
                    candidato1.votar();
                }
                else if(choice == candidato2.getNumero()){
                    candidato2.votar();
                }
                else if(choice == candidato3.getNumero()){
                    candidato3.votar();
                }
                else if(choice == 0){
                    break;
                }
                else System.out.println("Digite uma opção válida");
            }
        }

        System.out.println("\n<><><><><><> RESULTADO <><><><><><>");
        System.out.printf("Candidato #1: \n%s\n",candidato1.toString());
        System.out.printf("Candidato #2: \n%s\n",candidato2.toString());
        System.out.printf("Candidato #3: \n%s\n",candidato3.toString());
    }
}
