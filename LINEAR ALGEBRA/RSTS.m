%Resolucao sistema triangular superior

% Daniel Lima de Souza

close all; clc;

A = [2, 1, 3; 0, -1, 1; 0, 0, 1]
B = [9; 1; 2]

x = zeros(3,1);
n = 3;

x(n)=B(n)/A(n,n);

for i = n-1:-1:1
    soma = 0;
    for j = i+1:n
        soma = soma + A(i,j)*x(j);
    end
    x(i)=(B(i)-soma)/A(i,i);
end

% print
x