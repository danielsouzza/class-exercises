

public class Director {
    private HamburguerBuilder builder; 

    public Director(HamburguerBuilder builder){
        this.builder = builder;
    }

    public Hamburguer builderHamburguer(){
        return this.builder.getResult();
    }

    public Hamburguer builderXBacon(){
        this.builder.setBacon(true);
        this.builder.setQueijo(true);
        return builder.getResult();
    }


    public Hamburguer builderXEggs(){
        this.builder.setOvo(true);
        this.builder.setQueijo(true);
        return this.builder.getResult();
    }

    public Hamburguer builderXTudo(){
        this.builder.setOvo(true);
        this.builder.setQueijo(true);
        this.builder.setBacon(true);
        this.builder.setPresunto(true);
        return this.builder.getResult();
    }
}
