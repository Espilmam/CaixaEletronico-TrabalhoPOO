Sistema de um caixa eletrônico

Antes das informações gerais, primeiramente as informações críticas:
 - É necessário instalar o Microsoft SQL Server Management Studio 2017 (Deve ser a 2017, 2008 ou versões anteriores NÃO vão funcionar);
   - O banco de dados desse sistema esta nos servidores do Microsoft Azure, logo não é necessário configurar os drivers do SQL. Basta
     instalar o Microsoft SQL Server Management Studio 2017.
   - Irei fornecer o usuário, senha e o nome do servidor para o acesso ao banco de dados. Uma vez conectado, não é preciso criar
     uma nova consulta. Irei fornecer o código fonte do banco.
     
 - O sistema foi programado no JAVA 8/JRE 1.8.0 na IDE Eclipse
 
 - É necessário conexão com a internet.
 
 Informações gerais: 
 
 - Ao utilizar pela primeira vez, clique em "Adicionar Valores". Esses dados serão importantes para futuras operações.
 
 - Lembre sempre do número da conta e da senha para acessar.
 
 - No menu, a operações de:
   
   - Realizar o saque de notas, de acordo com o limite do seu saldo bancário e do caixa
   - Possibilidade de realizar depósitos, tanto para valores que não estão cadastrados no BD quanto para valores cadastrados.
   - Possibilidade de realizar tranferencias, tambem tanto para valores que não estão cadastrados no BD quanto para valores cadastrados.   
   - Ver seu saldo disponível.
 
 - Clique em "Admin" para colocar os valores das cédulas no banco de dados, visto que ele tera todos os valores zerados.
 
   - Operações como adicionar notas, remover quantidades, zerar tudo do BD e mostrar as quantidades de notas vão estar disponiveis
   
 OBS: caso adicione um número de cartão, mas ele ja esteja cadastrado, provavelmente alguem ja utilizou esse valor, visto que o BD estará
 em um servidor com múltiplos acessos.
