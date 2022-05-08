import java.util.Scanner;

public class Cpu {
    static Scanner input = new Scanner(System.in);
    static int mar, mbr;
    public static void main(String[] args) {
        Memory ram = new Memory();
        int option;

        do {
            // controller();
            limpaTela();
            System.out.println("===== Memory RAM =====");
            String instructions = 
            String.format("[1] - Escrever na memoria\n[2] - Ler um dado da memoria");
            System.out.println(instructions);
            System.out.printf("> ");
            try {
                option = Integer.valueOf(input.nextLine());
            } catch (Exception e) {
                option = 5;
                continue;
            }
            switch (option) {
                case 0:
                    limpaTela();
                    break;
                case 1 :
                    write(ram);
                    break;
                case 2 :
                    read(ram);
                    break;
            }
            
        } while (option != 0);        
    }

    public static void write(Memory ram){
        limpaTela();
        System.out.println("===== Barramento de entrada =====");
        System.out.printf("Mar (0 - 1023) -> ");
        mar = input.nextInt();
        System.out.printf("Mbr -> ");
        mbr = input.nextInt();
        ram.write(mar, mbr);
        
        System.out.println();
        System.out.println("Press <enter> to go back");
        input.nextLine(); //Clear buffer
        input.nextLine(); //
    }

    public static void read(Memory ram){
        limpaTela();
        System.out.println("===== Barramento de saida =====");
        System.out.printf("mar (0 - 1023) -> ");
        mar = input.nextInt();
        System.out.printf("Mar -> %d | Mbr -> %d\n", mar, ram.read(mar));
        
        System.out.println();
        System.out.println("Press <enter> to go back");
        input.nextLine(); //Clear buffer
        input.nextLine();
    }

    public static void controller(){
        limpaTela();
        System.out.println("===== Memory RAM =====");
        String instructions = 
            String.format("[1] - Escrever na memoria\n[2] - Ler um dado da memoria");
        System.out.println(instructions);
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
        } catch (Exception e){}

    }
}