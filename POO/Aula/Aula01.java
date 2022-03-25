import java.util.*;

public class Aula01 {
    public static void main(String[ ] args) {
        Scanner input = new Scanner(System.in);
        double ax = input.nextDouble();
        double bx = input.nextDouble();
        double cx = input.nextDouble();
        double px = (ax+bx+cx)/2;
        double areax = Math.sqrt(px*(px-ax)*(px-bx)*(px-cx));

        double ay = input.nextDouble();
        double by = input.nextDouble();
        double cy = input.nextDouble();
        double py = (ay+by+cy)/2;
        double areay = Math.sqrt(py*(py-ay)*(py-by)*(py-cy));

        System.out.printf("A area do triangulo x = %.0f\n",areax);
        System.out.printf("A area do triangulo x = %.0f\n",areay);

        if (areax > areay){
            System.out.printf("A area do triangulo x é maior = [%.0f]\n",areax);
        }else if(areay > areax){
            System.out.printf("A area do triangulo x é maior = [%.0f]\n",areay);
        }else{
        System.out.printf("As áreas dos triângulos são iguais X = [%4.2f] e y = [%4.2f]\n", areax,areay);
        }
    }
}