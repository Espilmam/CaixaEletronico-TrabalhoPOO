Sistema de um caixa eletrônico

Antes das informações gerais, primeiramente as informações críticas:
  - O sistema conecta com um banco de dados SQL, mas não é necessario instalar o SQL Server/SQL Server Management Studio, visto que ele        esta hospedado nos servidos do Microsoft Azure. Logo, basta apenas adicionar os dados no código do java.
 
  - Outras pessoas vão acessar esse banco de dados, logo não coloque dados que sejam vitais para você
   
  - O código do SQL estará no GitGud tambem. Caso queira testar o banco de dados: 
    - Instale o SQL Server Management Studio 2017 (deve ser o 2017 por causa do M$ Azure)
    - Caso não apareça nenhuma tela de login, clique no canto superior esquerdo, em "Conectar" e depois em "Mecanismo de banco de             dados"
    - Na tela de login, em Tipo de servidor, deixe selecionado "Mecanismo de banco de dados"
    - Em "Nome do servidor", coloque "trabalhopoo-conta.database.windows.net"
    - Em "Autenticação", selecione "Autenticação do SQL Server"
    - Em "Logon", coloque "UserADM"
    - E na senha, coloque "Trabalhopoo123"
    - Para abrir o arquivo .sql que deixei aqui, clique ctrl + O e procure ele no seu pc
    - Do lado do botão "Executar", haverá um ComboBox, nomeado primeiramente de "master". Clique nele e selecione "BDConta"
    - Para verificar se os dados foram adicionados/alterados/excluidos, selecione "select * from (tabela)" e aperte f5 ou "Executar" 
    
 - O sistema foi programado no JAVA 8/JRE 1.8.0 na IDE Eclipse
 
 - É necessário conexão com a internet.
 
 - Importe a pasta do código no eclipse para funcionar
 
 Informações gerais: 
 
 - Ao utilizar pela primeira vez, clique em "Adicionar Valores". Esses dados serão importantes para futuras operações.
 
 - Lembre sempre do número do cartão e da senha para acessar.
 
 - Para apagar/alterar algum campo, selecione ele inteiro com o duplo clique e digite o que deseja alterar
 
- No menu, à operações de:
   
   - Realizar o saque de notas, de acordo com o limite do seu saldo bancário e do caixa
   - Possibilidade de realizar depósitos para dados ja cadastrados
   - Possibilidade de realizar pagamentos, sendo que o código do pagamento é apenas ilustrativo.
   - Ver seu saldo disponível.
 
 - Clique em "Admin" para colocar os valores das cédulas no banco de dados, visto que ele tera todos os valores zerados.
 
   - Operações como adicionar notas, remover quantidades, zerar tudo do BD e mostrar as quantidades de notas vão estar disponiveis
   
 OBSERVAÇÕES: 
 
 - Caso adicione um número de cartão, mas ele ja esteja cadastrado, provavelmente alguem ja utilizou esse valor, visto que o BD estará      em um servidor com múltiplos acessos.
 - Caso tenha testado o código no SQL Management Studio, lembre-se: CUIDADO PARA NÃO FAZER NENHUMA CAQUINHA. SE DER UM DROP TABLE, ELE      VAI APAGAR A TABELA NO M$ AZURE TAMBEM. Irei olhar o servidor e o BD com certa frequencia, para que não ocorra problemas.
