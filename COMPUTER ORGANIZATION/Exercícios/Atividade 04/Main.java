import java.util.Scanner;
// teste

public class Main {
    static Scanner input = new Scanner(System.in);
    static int mar, mbr;
    public static void main(String[] args) {
        MemoryManagementUnit mmu = new MemoryManagementUnit();
        int option;

        do {
            // controller();
            limpaTela();
            controller();
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
                    write(mmu);
                    break;
                case 2 :
                    read(mmu);
                    break;
                case 3 :
                    readAll(mmu);
                    break;
            }
            
        } while (option != 0);        
    }

    public static void write(MemoryManagementUnit mmu){
        limpaTela();
        System.out.println("===== Barramento de entrada =====");
        System.out.printf("Mbr -> ");
        mbr = input.nextInt();
        try {
            mmu.write(mbr);
        } catch (MemoryManagementUnitException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\nPress <ENTER> to go back");
        input.nextLine(); //Clear buffer
        input.nextLine(); //
    }

    public static void read(MemoryManagementUnit mmu){
        limpaTela();
        System.out.println("===== Barramento de saida =====");
        System.out.printf("mar (0 - 15) -> ");
        mar = input.nextInt();
        try {
            System.out.printf("Mar -> %d | Mbr -> %d\n", mar, mmu.read(mar));
        } catch (MemoryManagementUnitException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\nPress <ENTER> to go back");
        input.nextLine(); //Clear buffer
        input.nextLine();
    }

    public static void readAll(MemoryManagementUnit mmu){
        limpaTela();
        Integer[] memoria =  mmu.read();
        System.out.println("===== Barramento de saida =====");
        for(int mar = 0 ; mar < mmu.getSize(); mar++){
            System.out.printf("Mar -> %d\t| Mbr -> %d\n", mar, memoria[mar]);
        }
        
        System.out.println("\nPress <ENTER> to go back");
        input.nextLine(); //Clear buffer
    }

    public static void controller(){
        limpaTela();
        System.out.println("===== Memory RAM =====");
        String instructions = 
            String.format("[1] - Escrever na memória\n[2] - Ler um dado da memória\n");
        System.out.println(instructions + "[3] - Ler toda a memória");
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