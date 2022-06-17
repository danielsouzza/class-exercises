package armas;

public abstract class Armas {
    private String descricao;
    private int peso;
    private int dano;

    public Armas(String descricao, int peso, int dano) {
        this.descricao = descricao;
        this.peso = peso;
        this.dano = dano;
    }

    public abstract void action();

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
    

}
