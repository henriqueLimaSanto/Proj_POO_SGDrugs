create database bdFarmacia;
use bdFarmacia;


create table tbEndereco(
idEndereco int primary key auto_increment, 
cidade varchar(2) not null , 
estado varchar(30) not null,
numero numeric,
cep numeric(9), 
complemento varchar(20),
rua varchar(100),
bairro varchar (100) not null 
);
  
create table tbCliente(  
idCliente int primary key auto_increment,
rg int not null, 
cpf varchar(20),
nome varchar(100) not null, 
sexo char(1) check (sexoCliente='M' or sexoCliente='F'),
datanasc date,
telefone numeric,
idEndereco int, Foreign key (idEndereco) references tbEndereco (idEndereco),
email varchar (100) not null,
cartaoSus int
);

create table tbFarmacia(
idFarmacia int primary key auto_increment,
idEndereco int, Foreign key(idEndereco) references tbEndereco (idEndereco),
statusFarmacia varchar(15) not null 
);
create table tbClienteParceiro(
  idCliente int not null,Foreign key(idCliente) references tbCliente (idCliente),
  idFarmacia int not null Foreign key(Foreign key(idFarmacia) references tbFarmacia (idFarmacia)
);

 create table tbFuncao(
 idFuncao int primary key auto_increment, 
 descFuncao varchar(100) not null
 ); 
 
create table tbFuncionario(
 idFuncionario int primary key auto_increment,
 nome varchar(100) not null ,
 sobrenome varchar (100) not null,
 cpf varchar(20),  
 idFuncao int, Foreign key (idFuncao) references tbFuncao(idFuncao),
 idFarmacia int, Foreign key (idFarmacia) references tbFarmacia(idFarmacia),
 idEndereco int, Foreign key (idEndereco) references tbEndereco(idEndereco),
 salario Decimal (5, 2) not null
 ); 

create table tbFornecedor(
idFornecedor int primary key auto_increment,
nomeFantasia varchar(100) not null, 
cnpj int,
idEndereco int, Foreign key(idEndereco) references tbEndereco (idEndereco)
);

create table tbProduto(
idProduto int primary key auto_increment,
descricao varchar(100) not null,
categoria varchar (100) not null, 
idFornecedor int, foreign key(idFornecedor) references tbFornecedor (idFornecedor) 
);




create table tbGrupo(
idGrupo int primary key auto_increment,
nomeGrupo varchar(100) not null
);

create table tbSecao(
idSecao int primary key auto_increment,
descSecao varchar(100) not null
);

create table tbClienteProduto(
clienteProduto int primary key auto_increment,
idCliente int, Foreign key (idCliente) references tbCliente(idCliente),
idProduto int, Foreign key (idProduto) references tbProduto(idProduto),
statusCP varchar (100) not null,
preco decimal (5, 2) not null,
dia numeric(2),
mes numeric(2), 
ano numeric(4)
);

create table tbFarmaciaProduto(
idFarmaciaProduto int primary key auto_increment,
idFarmacia int, Foreign key(idFarmacia) references tbFarmacia(idFarmacia),
idProduto int, Foreign key(idProduto) references tbProduto(idProduto),
idGrupo int, Foreign key(idGrupo) references tbGrupo(idGrupo),
idSecao int, Foreign key(idSecao) references tbSecao(idSecao)
); 

create table tbConjFornecedor(
  idFornecedor int not null,Foreign key(idFornecedor) references tbFornecedor(idFornecedor),
  idFarmacia int not null,Foreign key(idFarmacia) references tbFarmacia(idFarmacia),
);

 create table tbVenda(
 idVenda int primary key auto_increment,
 precoTotal decimal (5, 2) not null,
 idCliente int, Foreign key (idCliente) references tbCliente(idCliente),
 idFuncionario int, Foreign key (idFuncionario) references tbFuncionario(idFuncionario),
 idFarmacia int, Foreign key (idFarmacia) references tbFarmacia(idFarmacia)
 );

 create table tbItemVenda(
 idItemVenda int primary key auto_increment,
 idFarmaciaProduto int, Foreign key (idFarmaciaProduto) references tbFarmaciaProduto (idFarmaciaProduto),
 quantidade int,
 subtotal decimal (5 ,2) not null,
 idVenda int, Foreign key (idVenda) references tbVenda (idVenda) 
 );

create table tbSintoma(
idSintoma int primary key auto_increment,
descSintoma varchar(100) not null
);

create table tbConjSintomas(
idConjSintomas int primary key auto_increment,
idSintoma int, Foreign key (idSintoma) references tbSintoma(idSintoma),
idProduto int, foreign key (idProduto) references tbProduto(idProduto) 
); 
 

create table tbProblemaSaude(
idProblema int primary key auto_increment,
descProblema varchar (100)
);


create table tbConjProblemas(
idConjProblemas int primary key auto_increment,
idProblema int, Foreign key (idProblema) references tbProblemaSaude(idProblema),
cpfCliente int, Foreign key (cpfCliente) references tbCliente(cpf)
);
