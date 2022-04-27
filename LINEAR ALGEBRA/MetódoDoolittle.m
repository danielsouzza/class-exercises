% LU factorization
% Daniel Lima de Souza
% % https://octav.onl/gebcl155

close all; clc;
% example matrix
matriz = [2 -1 -2; -4 6 3; -4 -2, 8]
Lower = zeros(3,3);
Upper = zeros(3,3);

% Doolittle method
for j = 1 : 3
    Lower(j,j) = 1;
    for i = 1 : j
        summation = 0;
        for k = 1 : i-1
            summation += Lower(i,k) * Upper(k,j);
        endfor
        Upper(i,j) = matriz(i,j) - summation;
    endfor
    for i = j+1 : 3
        summation = 0;
        for k = 1 : j+1
            summation += Lower(i,k) * Upper(k,j) ; 
        endfor
        Lower(i,j) = (matriz(i,j) - summation) / Upper(j,j);
    endfor
endfor


% Print
Lower
Upper