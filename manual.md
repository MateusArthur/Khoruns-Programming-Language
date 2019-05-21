# Quick Reference Guide of Khronus-Programming-Language



- Declaração de variáveis;
- Atribuição de valor a variável;
- Operações que podem ser efetuadas: " + ", " - ", " / ", " * ";
- Expressões com dois valores operando;
- Laço;
- Comandos de saída, mostrar algo na tela;
- Controlador de fluxo;
- Aninhamento de comandos.
   
  
   
## Declaração de Variável:
Para declaração de variável, é necessário sempre declarar antes a palavra `new` que é uma palavra derivada da Linguagem Khronus, sendo assim:  
```java
new variavel;
```

## Atribuição de valores a variáveis:
Para atribuir valores a variáveis na Khronus Language, pode ser realizado de duas maneiras, a primeira é atribuir o valor na hora de declarar a 
variável, juntamente o comando `new`, como no exemplo:
```java
new variavel = 10;
```
ou,
```java
new variavel;
variavel = 10;
```
os dois jeitos são aceitos pela linguagem
## Operações Aritméticas:
Para realização de operações aritméticas, o Khronus Language disponibiliza as seguintes operações:

| Operações     |           |         |             |           |           |
| ------------- |-----------|---------|-------------|-----------|-----------|
|    +          | x++;      | x+=10;  | x = 10 + 2; | x = a + 2;| x = a + b;|
|    -          | x--;      | x-=10;  |x = 10 - 2;  | x = a - 2;| x = a - b;|
|    /          |           |         |x = 10 / 2;  | x = a / 2;| x = a / b;|
|    *          |           |         |x = 10 * 2;  | x = a * 2;| x = a * b;|

## Expressões com duas variáveis:
Na Khronus Language pode se realizar operações aritméticas conforme demonstrada na tabela anterior com duas variáveis operando, sendo:
```java
x = a + b;
x = 1 + b;
x = 1 + 1;
```
## Laço:
Na Khronus Language pode se utilizr o laço `while` 
//FAZER

## Comandos de saída:
Na Khronus Language pode se utilizar do operador `print("",)` para se imprimir algo na tela, somente imprime uma variável por vez, porém, a cada `print("")` quebra se linha automaticamente, exemplos:
```java
print("Valor de a: ",a);
```
Nesse caso a saída será:         

TELA              |
---               |
*Valor de a: 10*  |

Outro exemplo:
```java
print("Valor de a: ",a);
print("");
print("Valor de b: ",b);
```
Nesse outro caso a saída será:

| Tela            | 
| -------------   |
| *Valor de a: 10*| 
|                 | 
| *Valor de b: 20*| 

ou seja, a segunda linha do código irá quebrar linha.

## Controlador de Fluxo:
Na Khronus Language tem o controlador de fluxo `if` e `else`, usando a sintaxe:
```java
if (expressão booleana) {
    // bloco de código 1
} else {
    // bloco de código 2
} 
```
Na expressão booleana, pode se usar somente variáveis já declaradas, não pode usar números, e também pode se usar somente um operador para cada `if(a < b);` os operadores são:

| Operações          | 
| -------------      |
| < | MENOR          | 
| > | MAIOR          |
| <= | MENOR OU IGUAL|
| >= | MAIOR OU IGUAL|
