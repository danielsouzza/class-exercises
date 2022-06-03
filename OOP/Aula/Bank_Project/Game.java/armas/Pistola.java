package armas;

public class Pistola extends Armas{
    public Pistola() {
        super("Pistola", 5, 8);
    }

    @Override
    public void action() {
        System.out.println("TIRO");
        
    }
    
}
