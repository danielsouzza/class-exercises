package hero;

public class Gorila extends Hero{
    public Gorila (){
        super("Brutus", 10, 3);
    }

    @Override
    public String HandAttack(){
        return " POTENTE SOCO ";
    }
}
