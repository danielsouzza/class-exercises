
% Solução de Sistemas Triangulares
% Daniel Lima de Souza

close all; clc;

A = [1, 0 , 0; 0, 1, 0; 0.5, 0.5, 1]
B = [9; 1; 7]

x = zeros(3,1);
n = 3;

for i = 1 : n
    soma = 0.0;
    for j = 1 : i-1
        soma += A(i,j) * x(j);
    endfor
    x(i) = (B(i) - soma) / A(i,i);
endfor

% print
x