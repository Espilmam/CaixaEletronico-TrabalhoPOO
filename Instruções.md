Sistema de um caixa eletrônico

Antes das informações gerais, primeiramente as informações críticas:
 - O sistema conecta com um banco de dados SQL, mas não é necessario instalar o SQL Server, visto que ele esta hospedado nos servidos do      Microsoft Azure. Logo, basta apenas adicionar os dados código do java.
   - Outras pessoas vão acessar esse banco de dados, logo não coloque dados que sejam vitais para você
   - Enviarei o código do SQL 
     
 - O sistema foi programado no JAVA 8/JRE 1.8.0 na IDE Eclipse
 
 - É necessário conexão com a internet.
 
 Informações gerais: 
 
 - Ao utilizar pela primeira vez, clique em "Adicionar Valores". Esses dados serão importantes para futuras operações.
 
 - Lembre sempre do número da conta e da senha para acessar.
 
- No menu, à operações de:
   
   - Realizar o saque de notas, de acordo com o limite do seu saldo bancário e do caixa
   - Possibilidade de realizar depósitos para valores ja cadastrados
   - Possibilidade de realizar pagamentos, sendo que o código do pagamento é apenas ilustrativo.
   - Ver seu saldo disponível.
 
 - Clique em "Admin" para colocar os valores das cédulas no banco de dados, visto que ele tera todos os valores zerados.
 
   - Operações como adicionar notas, remover quantidades, zerar tudo do BD e mostrar as quantidades de notas vão estar disponiveis
   
 OBS: caso adicione um número de cartão, mas ele ja esteja cadastrado, provavelmente alguem ja utilizou esse valor, visto que o BD estará
 em um servidor com múltiplos acessos.
