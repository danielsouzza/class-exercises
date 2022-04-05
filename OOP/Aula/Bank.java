public class Bank {
    public static void main(String[] args) {
        Conta c1 = new Conta("Daniel L.S","369020-1");
        
        c1.depositar(50);
        c1.sacar(20);

        c1.toString();
        System.out.println(c1.toString());
        //System.out.println("Conta #1");
        //System.out.println("Titular: " + c1.getTitular());
        //System.out.println("Numero.: " + c1.getNumero());
        //System.out.println("Saldo..: " + c1.getSaldo());
    }
}