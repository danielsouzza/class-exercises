'Daniel Lima de Souza
'jdoodle.com/ia/plO

dim vetor(9)
aux = 0
soma = 0
j = 9
'Cria um vetor de 10 elementos.
for i = 0 to 9 : vetor(i) = i+1 : next i

'Inverte o vetor.
for i = 0 to 4
aux = vetor(i) : vetor(i) = vetor(j-i) : vetor(j-i) = aux
next i

'Soma os elementos pares do vetor.
for i = 0 to 9
if (MOD(i,2) = 0) then : soma = soma + vetor(i) : endif
next i

'Mostra na tela o reultado final.
for i = 0 to 9 : print vetor(i), : next i
print "\nA soma dos elemtos pares é = ",soma