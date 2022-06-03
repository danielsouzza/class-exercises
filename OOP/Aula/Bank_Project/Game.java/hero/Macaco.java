package hero;

public class Macaco extends Hero{
    public Macaco() {
        super("Fredy", 6, 6);
    }

    @Override
    public String HandAttack(){
        return " TAPA ";
    }
}
