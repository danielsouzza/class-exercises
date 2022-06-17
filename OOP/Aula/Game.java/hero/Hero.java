package hero;

import armas.Armas;

public abstract class Hero {
    private String name;
    private int forca;
    private int velocidade;
    private int saude;
    private Armas arma = null;

    public Hero(String name, int forca, int velocidade){
        this.name = name;
        this.forca = forca;
        this.velocidade = velocidade;
        this.saude = 100;
    }

    public abstract String HandAttack();

    public void attack(){
        if(getArma() == null){
            System.out.println(getName() + ": Ataca com um" + HandAttack() + getForca());
        } else {
            getArma().action();
        }
    }

    public void jump() {
        System.out.println(this.name + ": Pula");
    }

    public void run() {
        System.out.println(this.name + ": Está correndo na velocidade " + this.velocidade);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getForca() {
        return forca;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public int getSaude() {
        return saude;
    }
    
    public void setArma(Armas arma) {
        if(this.forca >= arma.getPeso()){
            this.arma = arma;
            System.out.println(this.name + " coletou um(a) " + arma.getDescricao());
        } else {
            System.out.println(this.name + "não pode carregar a arma" + arma.getDescricao());
        }
    }

    public Armas getArma() {
        return arma;
    }


    
}