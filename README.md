# CADASTRO DE PESSOAS(Usuários)
## Tecnologias utilizadas:
### JAVA | JSF | PRIMEFACES | JPA-HIBERNATE | CSS | MYSQL 

![lista de usuários](https://github.com/roberto-araripe/jsf-hibernate-primefaces/assets/114492366/6d2ec2ac-bbe2-4dd5-a258-f58a8fede9e8)

![wb](https://github.com/roberto-araripe/jsf-hibernate-primefaces/assets/114492366/718817e4-01c9-4900-bb83-7027f5cd0f5b)


O projeto consiste em registrar nomes e e-mails de pessoas, sendo assim, é exibido em tela uma 
lista de pessoas cadastradas como usuários, demonstrando o “Id”, “nome” e “e-mail”. Desta forma, 
foi criado na estrutura Dynamic Web Projec na IDE Eclipse(2023-06) utilizando o maven como 
gerenciador de build, há uma única classe controller chamada “UserBean” que é responsável pelas 
regras da aplicação. O gerenciamento do banco de dados é feito pela abstração e encapsulamento DAO.

O framework utilizado é o JSF juntamente com a biblioteca PrimeFaces, que apresenta a vantagem da 
evidente separação entre a visualização da página e as regras de negócios. A persistência de dados foi
construída através do Hibernate e, na classe controller, foi utilizada a anotação @Named no lugar da 
@ManegedBeans pelo fato da flexibilidade e possibilidade de upgrade utilizando o EJB, por exemplo. 
A escolha do banco de dados MySql se deve a suficiente usabilidade de seus recursos.

As bibliotecas utilizadas são: PrimeFaces (10.0.0),  Javax Faces e Javax Api(2.3),  Javax Persistence(2.2), 
Hibernate-Core e Hibernate-Entitymanager(5.4.33), MySql conector(8.0.33), OpenWebBeans(2.0.27), Xtream(1.4.9),  
JSF Api e JSF Impl(2.2.13), Jakarta.xml(2.3.2), CDI-Api(2.0) e por fim, o Jaxb-runtime(2.3.2). Ambas carregadas 
no arquivo pom.xml com a intensão de abranger novas possibilidades de upgrade.

O servidor de aplicação utilizado é o TomCat na versão 9, a escolha se deve pelo fato de poder ser 
considerado um contêiner de aplicação, o que apesar de requerer um código mais preciso, permite uma 
boa integração com outros aplicativos. Uma outra opção seria o WildFly, no entanto, a escolha se deve 
a pequena escalabilidade da aplicação e a facilidade com possíveis interações.

Para a execução do projeto é necessária a descompactação do arquivo ZIP para que seja recepcionado pela 
IDE como um novo projeto Maven, a execução do arquivo pom.xml acrescentará as bibliotecas necessárias. 
Também será necessário a instalação do apache TomCat 9. Para o banco de dados, foi utilizado o banco relacional
MySQL e conexão feita através do Xampp (versão atual) e visualização via WorkBench 8.0 CE. O modelo de 
conexão persistene.xml pode ser utilizado de escopo e está localizado na aba JPA-content.
