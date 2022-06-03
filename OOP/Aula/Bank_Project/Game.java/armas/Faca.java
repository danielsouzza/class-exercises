package armas;

public class Faca extends Armas{

    public Faca() {
        super("Faca", 1, 3);
    }

    @Override
    public void action() {
        System.out.println("ESTOCADA");        
    }

    
    
}
