package hero;

public class Mico extends Hero{
    public Mico() {
        super("Simão", 3, 10);
    }

    @Override
    public String HandAttack(){
        return " DESFEIR CASCUDOS ";
    }
}
