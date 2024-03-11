# TODO List
##Descrição do projeto

API REST feita em java springboot, para gerenciar tarefas (CRUD). Possui buscas como 
buscar por tarefas realizadas, prioridade (ALTA ou NORMAL) e possui um serviço 
que modifica a tarefa realizada de false para true, indicando que a tarefa já foi realizada,
a API possui tratamento de erros com mensagens customizadas.

Como essa aplicação é somente o Backend, ela não renderisa os dados em página html.

# Tecnologias utilizadas

* **Git** : Controle de versionamento do sistema.
* **Spring Boot** : Framework mais usado e mais completo hoje em dia para desenvolvimento Web Java.
* **Spring Tool Suite**: IDE para desenvolvimento Java feito para usar o Spring Boot.
* **Maven 4** : Disponibiliza várias bibliotecas e Api que facilitam o desenvolvimento.
* **Postman**: É uma API client que facilita criar, compartilhar, testar e documentar APIs, ele foi usado nesse projeto para efetuar todos os testes.
* **PostgreSQL** : Sistema gerenciador de banco de dados objeto relacional (SGBD), fácil de usar com a sua interface gráfica.
* **Swagger**: Ele foi usado para fazer a documentação do projeto.


# Instruções de como rodar e utilizar o sistema

## Pré-requisito

* Git
* Spring Tool Suite
* PgAdmin
* Postman

## Passos

- Abrir um terminal ou linha de comando(Botão Windows + R, digitar cmd e apertar Enter (no Windows))
- Navegar até onde quiser baixar o repositório
- No terminal, colar essa linha e apertar Enter
  ```
  https://github.com/Alison-silva/todolist.git
  ```
- Abrir O PgAdmin e criar um banco de dados com o nome tododb
- Abrir o Spring Tool Suite e clicar em File e depois em Import
- Na nova janela que aparece, escrever no campo do pesquisa maven
- Uma pasta com o nome Maven aparece. Dentro dessa pasta, clicar em Existing Maven Projects e clicar em Next
- Na próxima página, clicar em Browse... e navegar até a pasta todolist e clicar abrir.
- Clicar em Finish
- Esperar o download das dependências do Maven
- Clique com o botão direito no projeto e escolhe a opção 'Run as' e depois escolher 'Spring Boot App'
- O projeto está agora rodando.

Se ele apresentar um erro, abra o pacote src/main/resources e depois abra o arquivo application.properties.
Coloque o usuário e a senha que você atribuiu ao postgres
 ```
spring.datasource.username= <coloque seu username>
spring.datasource.password= <coloque sua senha>
```

## Usando a aplicação

Os enpoints da aplicação estão documentado nesse [link.](http://localhost:8080/swagger-ui/index.html).
**Pode se efetuar os testes dos controllers nessa página selecionando o end-point e apertando no botão Try Out**

* Primeiro devemos cadastrar uma tarefa.
```
{
  "nome": "Primeira tarefa teste",
  "descricao": "Realizar todos os testes",
  "prioridade": "ALTA"
}
```
**OBS: Se tentar cadastrar com o nome ou descrição em branco, uma mensagem de erro será informada**

Após isso podemos, listar, atualizar e deletar tarefas (CRUD).
Usando o end-point **/todos/listarPorPrioridade** , o sistema vai listar os dados
organizado por data e por prioridade ALTA depois NORMAL.
```
{
 {
        "id": 1,
        "nome": "Tarefa 1",
        "descricao": "Terminar a tarefa 1",
        "datatarefa": "01/02/2024",
        "realizado": false,
        "prioridade": "ALTA"
    },
    {
        "id": 2,
        "nome": "Tarefa 2",
        "descricao": "Fazer a tarefa 2, sem pressa",
        "datatarefa": "02/02/2024",
        "realizado": false,
        "prioridade": "NORMAL"
    }
}
```
Usando o endpoint **/todos/alterarRealizado/{id}** o usuário poderá alterar o status da
tarefa, ou sejá, 'realizado: false' para true, substituindo o /{id} pelo id da tarefa EX:
**/todos/alterarRealizado/1** , após isso uma mensagem será exibida no console.
```
A tarefa foi concluída!
```

As tarefas realizadas não serão vistas na listagem de prioridades, para visualiza-las
deve-se usar o endpoint  **/todos/listarPorTarefesRealizadas**

```
{
 {
        "id": 1,
        "nome": "Tarefa 1",
        "descricao": "Terminar a tarefa 1",
        "datatarefa": "01/02/2024",
        "realizado": true,
        "prioridade": "ALTA"
 }
}
```

* Toda a documentação dos endpoints está disponível nesse [link.](http://localhost:8080/swagger-ui/index.html)

