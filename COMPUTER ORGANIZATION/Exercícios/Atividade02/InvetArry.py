#Inverte os elementos do vetor
#Não sei podia usar arry = arry[::-1] então fiz assim:
def InvertArry(vetor):
    aux,k= 0,1
    size = len(vetor)
    for i in range(int(size/2)):
        aux = vetor[i]
        vetor[i] = vetor[size - k]
        vetor[size-k] = aux
        k += 1
    return vetor
    

#Soma os elementos de índice par do vetor
def SumArry(vetor):
    soma = 0
    for i,v in enumerate(vetor):
        soma += v if(i % 2 == 0) else 0
    return soma


#Função principal
def main():
    arry = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    InvertArry(arry)
    print("Arry invertido :",arry)
    print("A soma dos elementos de índice par é = {}".format(SumArry(arry)))

main()