import java.util.*;

public class Temperatura {
    public static void main(String[] args) {
        Double C, Temp;

        String comando = "\n[K] Kelvin\n[F] Fahrenheit\n";
        System.out.printf("Enter a temperature:%s", comando);
        try (Scanner input = new Scanner(System.in)) {
            System.out.printf("To: ");
            String To = input.nextLine();
            

            switch (To) {
                case "F":
                    System.out.printf("Enter the temperature in Celsius: ");
                    C = input.nextDouble();
                    Temp = (C * 1.8) + 32;
                    System.out.printf("Temperature in Fahrenheit: [%4.2f F]\n", Temp);
                    break;
                case "K":
                    System.out.printf("Enter the temperature in Celsius: ");
                    C = input.nextDouble();
                    Temp = (C +  273.15);
                    System.out.printf("Temperature in Kelvin: [%4.2f k]\n", Temp);
                    break;
                default:
                System.out.printf("Invalid input !!\n");
            }
        }
    }
}
