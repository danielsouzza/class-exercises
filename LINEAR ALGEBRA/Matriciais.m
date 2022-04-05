%Daniel Lima de Souza
A = []
B = []

% Cria os vetores A e B
for i = 1: 6
    for j = 1:5
        A(i,j) = i-(2*j)
        B(i,j) = (7*j)-(5*i)
    endfor
endfor

% QUESTÃO A
Qa = 2*A + 3*B

% QUESTÃO B
Qb = A' - B'
Qc = A^2 - B
Qd = A*B - B*A
% A questão C e D Não é possivel
% porque o número de coluna de A é diferente do número de linhas de B.