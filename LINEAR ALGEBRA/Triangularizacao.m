% Triangularização
% Daniel Lima de Souza

close all; clc;

A=[3 2 4; 1 1 2; 4 3 -2]

B=[1;2;3]

n=length(A);

for k=1:n-1
    for i=k+1:n
        m(i,k)=A(i,k)/A(k,k);

        B(i)=B(i)-m(i,k)*B(k);

        for j=1:n

        A(i,j)=A(i,j)-m(i,k)*A(k,j);
        end
    end
end

%print
A
B