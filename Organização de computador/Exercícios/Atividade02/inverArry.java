public class inverArry {

    //Função principal
    public static void main(String[] args) {
        int vetor[] = {1,2,3,4,5,6,7,8,9,10};
        invertVetor(vetor);
        System.out.println("Vetor invertido:");
        for(int valuer : vetor) System.out.printf("%d ",valuer);
        System.out.printf("\nA soma dos elementos de índice par é = [%d]\n",SumArry(vetor));
        
    }

    //Inverte os elementos do vetor
    public static void invertVetor(int vetor[]){
        int aux,i,j;
        for (i = 0, j = 9; i < 5; i++, j--){
            aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }

    //Soma os elementos de índice par do vetor
    public static int SumArry(int vetor[]) {
        int soma=0;
        for(int i=0; i < 10; i++){
            soma += (i % 2 == 0) ? vetor[i] : 0;
        }
        return (soma);
    }
}