# Sele��o Desenvolvedor Java
O objetivo do projeto � ler um arquivo CSV e filtrar os dados de acordo com comando de consulta.

A prova consiste em criar um programa que leia todas as linhas do arquivo CSV e utilize esse arquivo como base para consultas, onde a primeira linha (cabe�alho) cont�m o nome das propriedades e as linhas subsequentes os valores. Ap�s ler o arquivo, o programa deve come�ar a ouvir o console a espera dos comandos de consulta. Abaixo segue a lista dos comandos que devem ser interpretados:

### Comandos
- **count** * - escreve no console a contagem total de registros importados (n�o deve considerar a linha de cabe�alho)
- **count distinct [propriedade]** - escreve no console o total de valores distintos da propriedade (coluna) enviada 
- **filter [propriedade] [valor]** - escreve no console a linha de cabe�alho e todas as linhas em que a propriedade enviada possua o valor enviado
- **exit** - sair do programa

### Executar o programa
* Fazer o clone do projeto: ```git clone https://github.com/felipe-nardon/selecaoinvolves.git```
* Entrar na pasta: ```cd selecaoinvolves```
* Compilar: ```mvn package```
* Executar o projeto: ```Run.bat```

### Executar os testes
Os testes ser�o executados ao compilar o projeto

### Cobertura dos testes
96,6 %