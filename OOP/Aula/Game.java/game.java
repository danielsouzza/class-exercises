import java.util.Random;
import armas.Armas;
import armas.Faca;
import armas.Machado;
import armas.Pistola;
import hero.Hero;
import hero.Gorila;
import hero.Macaco;
import hero.Mico;

public class game {
    public static void main(String[] args) {
        Armas[] arma = new Armas[3];
    
    arma[0] = new Faca();
    arma[1] = new Machado();
    arma[2] = new Pistola();
    
    Hero[] heroi = new Hero[3];
    
    heroi[0] = new Gorila();
    heroi[1] = new Macaco();
    heroi[2] = new Mico();

    Random random = new Random(System.currentTimeMillis());
    int h = random.nextInt(3);
    
    heroi[h].run();
    heroi[h].jump();
    heroi[h].attack();
    int a = random.nextInt(3);
    
    System.out.println(heroi[h].getName() + " encontrou uma arma.");
    heroi[h].setArma(arma[a]);
    
    heroi[h].attack();
    heroi[h].attack();
    heroi[h].attack();
    
    System.out.println(heroi[h].getName() + " está com saúde de " + heroi[h].getSaude() + "%");
  }
}
