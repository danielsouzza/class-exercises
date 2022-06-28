

class Main{
    public static void main(String[] args) 
    {
        // Sem director
        Hamburguer hamburguer = new HamburguerBuilder()
        .setBacon(true)
        .setPresunto(true)
        .setOvo(true)
        .getResult();
        System.out.println(hamburguer);

        // Com director
        HamburguerBuilder hBuilder = new HamburguerBuilder();
        Director director = new Director(hBuilder);
        Hamburguer hamburguer2 = director.builderXBacon();
        System.out.println(hamburguer2);
        hBuilder.reset();
        hamburguer2 = director.builderXTudo();
        System.out.println(hamburguer2);
    }
  }