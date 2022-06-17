package armas;

public class Machado extends Armas{

    public Machado() {
        super("Machado", 6, 7);
    }

    @Override
    public void action() {
        System.out.println("MACHADADA");
        
    }
    
    
}
