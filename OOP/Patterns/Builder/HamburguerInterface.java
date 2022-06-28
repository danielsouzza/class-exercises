public interface HamburguerInterface {
    public HamburguerBuilder setPao(boolean pao);
    public HamburguerBuilder setCarne(boolean carne);
    public HamburguerBuilder setOvo(boolean ovo);
    public HamburguerBuilder setQueijo(boolean queijo);
    public HamburguerBuilder setPresunto(boolean presunto);
    public HamburguerBuilder setBacon(boolean bacon);
    public HamburguerBuilder setSalada(boolean salada);
    public void reset();
    public Hamburguer getResult();
}
