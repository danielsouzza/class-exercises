
public class HamburguerBuilder implements HamburguerInterface {
    private boolean pão;
	private boolean carne;
	private boolean ovo;
	private boolean queijo;
	private boolean presunto;
	private boolean bacon;
	private boolean salada;

	public HamburguerBuilder() {
		this.pão = true;
		this.carne = true;
	}
	
	public HamburguerBuilder setPao(boolean pão) {
		this.pão = pão;
        return this;
	}


	public HamburguerBuilder setCarne(boolean carne) {
		this.carne = carne;
        return this;
	}


	public HamburguerBuilder setOvo(boolean ovo) {
		this.ovo = ovo;
        return this;
	}


	public HamburguerBuilder setQueijo(boolean queijo) {
		this.queijo = queijo;
        return this;
	}


	public HamburguerBuilder setPresunto(boolean presunto) {
		this.presunto = presunto;
        return this;
	}


	public HamburguerBuilder setBacon(boolean bacon) {
		this.bacon = bacon;
        return this;
	}


	public HamburguerBuilder setSalada(boolean salada) {
		this.salada = salada;
        return this;
	}

	public void reset(){
		this.pão = false;
		this.carne = false;
		this.ovo = false;
		this.queijo = false;
		this.bacon = false;
		this.salada = false;
	  }

    public Hamburguer getResult(){
        return new Hamburguer(pão, carne, ovo, queijo, presunto, bacon, salada);
    }
}
