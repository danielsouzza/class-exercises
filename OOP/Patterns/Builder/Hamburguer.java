

public class Hamburguer
{
	private boolean pão;
	private boolean carne;
	private boolean ovo;
	private boolean queijo;
	private boolean presunto;
	private boolean bacon;
	private boolean salada;

	

	
	public Hamburguer(boolean pão, boolean carne, boolean ovo, boolean queijo, boolean presunto, boolean bacon,boolean salada) {
		this.pão = pão;
		this.carne = carne;
		this.ovo = ovo;
		this.queijo = queijo;
		this.presunto = presunto;
		this.bacon = bacon;
		this.salada = salada;
	}


	public void setPão(boolean pão) {
		this.pão = pão;
	}


	public void setCarne(boolean carne) {
		this.carne = carne;
	}


	public void setOvo(boolean ovo) {
		this.ovo = ovo;
	}


	public void setQueijo(boolean queijo) {
		this.queijo = queijo;
	}


	public void setPresunto(boolean presunto) {
		this.presunto = presunto;
	}


	public void setBacon(boolean bacon) {
		this.bacon = bacon;
	}


	public void setSalada(boolean salada) {
		this.salada = salada;
	}


	@Override
	public String toString() {
		return "Humburguer [bacon=" + bacon + ", carne=" + carne + ", ovo=" + ovo
				+ ", presunto=" + presunto + ", pão=" + pão + ", queijo=" + queijo + ", salada=" + salada + "]";
	}

	
}