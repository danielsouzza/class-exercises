package model.client;

public class Client {
    private String nome;
    private String cpf;
    private char sexo;
    private String phone;
    
    public Client(String nome, String cpf, char sexo, String phone){
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.phone = phone;
    }
    
    public void setName(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setSexo(char sexo){
        this.sexo = sexo;
    }

    public String setPhone(String phone){
        return phone;
    }

    public String getName(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public char getSexo(){
        return this.sexo;
    }

    public String getPhone(){
        return this.phone;
    }
}