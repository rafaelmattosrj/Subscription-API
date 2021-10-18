DESAFIO GLOBO 


API de atualização da assinatura do usuário!


Bem-vindo ao ReadMe da API DesafioGlobo.
________________________________________
Esta aplicação foi desenvolvida com arquitetura API REST e tem por objetivo criar, atualizar e armazenar histórico assinaturas do usuário de acordo com as notificações.
URL Base: http://localhost:8080/desafioglobo/

A aplicação utiliza como o MySQL como banco de dados com o schema desafioglobo criado. E no application-dev.properties utiliza as variáveis de ambiente para definição de usuário(DB_USERNAME) e senha(DB_PASSWORD) do banco de dados.


________________________________________
Observação:
•	Pode ser encontrado no path http://localhost:8080/swagger-ui.html informações sobre os recursos da aplicação.

A API DesafioGlobo está em constante evolução e até o momento foram utilizados no desenvolvimento:

•	Linguagem de programação Java 11;

•	Apache Maven;

•	Spring Boot;

•	Swagger;

•	Hibernate Validator;

•	Spring Boot Starter Data JPA;

•	Spring Boot DevTools;

•	Junit;

•	Mock/Mockito;

•	Docker;

•	Docker Compose.


________________________________________

Tests:

Para rodar os testes da aplicação é necessário ter o Maven instalado e digitar o comando abaixo na cli de preferência:

mvn test

É necessário estar dentro da pasta da aplicação.

Docker:

Para rodar a aplicação com o Docker é necessário como pré requisito ter instalados Docker & Docker Compose. Na cli, dentro da pasta da aplicação, basta digitar:

mvn clean package -DskipTests 

docker-compose up --build

________________________________________
Recursos:

[GET] /desafioglobo/eventhistory/subscription/{id} 

Obter todo o histórico de notificações da assinatura do usuário.


Modelo de objeto de retorno em caso de sucesso (Status Code 200): 

[

    {

        "id": 1,

        "type": "SUBSCRIPTION PURCHASED",

        "subscriptionId": {

            "id": "402880987c77d565017c77d5a5be0000",

            "status": {

                "id": 2,

                "type": "SUBSCRIPTION CANCELED"

            },

            "createdAt": "13/10/2021 01:07:43",

            "updatedAt": "13/10/2021 01:07:59"

        },

        "createdAt": "13/10/2021 01:07:43"

    },

    {

        "id": 2,

        "type": "SUBSCRIPTION CANCELED",

        "subscriptionId": {

            "id": "402880987c77d565017c77d5a5be0000",

            "status": {

                "id": 2,

                "type": "SUBSCRIPTION CANCELED"

            },

            "createdAt": "13/10/2021 01:07:43",

            "updatedAt": "13/10/2021 01:07:59"

        },

        "createdAt": "13/10/2021 01:07:59"

    }

]

Modelo de objeto de retorno em caso da assinatura do usuário não for encontrada (Status Code 404):

{

    "status": 404, 

    "msg": "Object not found! Id: 5, Type: br.com.rafaelmattos.desafioglobo.domain.Subscription", 

    "timeStamp": 1633580652006  

}


________________________________________

[GET] /desafioglobo/eventhistory/{id}

Obter o histórico de notificações por id.


Modelo de objeto de retorno em caso de sucesso (Status Code 200):

{

    "id": 1,

    "type": "SUBSCRIPTION PURCHASED",

    "subscriptionId": {

        "id": "402880987c77d565017c77d5a5be0000",

        "status": {

            "id": 2,

            "type": "SUBSCRIPTION CANCELED"

        },

        "createdAt": "13/10/2021 01:07:43",

        "updatedAt": "13/10/2021 01:07:59"

    },

    "createdAt": "13/10/2021 01:07:43"

}

Modelo de objeto de retorno em caso da assinatura do usuário não for encontrada (Status Code 404):

{

    "status": 404,

    "msg": "Object not found! Id: 10, Type: br.com.rafaelmattos.desafioglobo.domain.EventHistory", 

    "timeStamp": 1633581650824  

}


________________________________________

[GET] /subscription/{id}   

Obter dados de registro da assinatura. 


Modelo de objeto de retorno em caso de sucesso (Status Code 200):

{

    "id": 1,

    "type": "SUBSCRIPTION PURCHASED",

    "subscriptionId": {

        "id": "402880987c77d565017c77d5a5be0000",

        "status": {

            "id": 2,

            "type": "SUBSCRIPTION CANCELED"
            
        },

        "createdAt": "13/10/2021 01:07:43",

        "updatedAt": "13/10/2021 01:07:59"

    },

    "createdAt": "13/10/2021 01:07:43"

}

Modelo de objeto de retorno em caso da assinatura do usuário não for encontrada (Status Code 404):

{

    "status": 404,

    "msg": "Object not found! Id: 10, Type: br.com.rafaelmattos.desafioglobo.domain.Subscription",

    "timeStamp": 1633581869070

}


________________________________________

[POST] /subscription 

Cadastrar assinatura. 


Modelo de objeto de retorno em caso de sucesso (Status Code 201):

{

    "id": "402880987c77d565017c77d5a5be0000",

    "statusId": {

        "id": 1,  

        "name": "SUBSCRIPTION PURCHASED"  

    },

    "createdAt": "07/10/2021 01:07:43",

    "updatedAt": "07/10/2021 01:07:43"

}


________________________________________

[PATCH] /subscription/{id} 

Atualizar assinatura. 


Modelo de objeto de retorno em caso de sucesso (Status Code 204):

{


}

Modelo de objeto de retorno em caso de não encontrado (Status Code 404):

{

    "status": 404,  

    "msg": "Object not found! Id: 10, Type: br.com.rafaelmattos.desafioglobo.domain.Subscription",

    "timeStamp": 1633582211042 

}


________________________________________

Para quaisquer dúvidas enviar e-mail para: rafaelrj@live.com

