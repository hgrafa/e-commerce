# Dependencias utilizadas

* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.1/reference/htmlsingle/#web)

Essa dependência permite que criemos a REST API para ser consumida pelo nosso frontend.

* [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.0.1/reference/htmlsingle/#howto.data-initialization.migration-tool.flyway)

Flyway irá realizar a migração de versões dentro do banco de dados caso seja necessário.

* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.0.1/reference/htmlsingle/#data.nosql.mongodb)

Será nosso banco de dados orientado a documentos.

* [Validation](https://docs.spring.io/spring-boot/docs/3.0.1/reference/htmlsingle/#io.validation)

Irá validar os dados passados para nossa api. Irá retornar possível erros para o client.

* [Java Mail Sender](https://docs.spring.io/spring-boot/docs/3.0.1/reference/htmlsingle/#io.email)

Gerencia o envio de emails através do Spring. Será usado pois em um e-commerce fazemos a verificação de uma nova conta através de token.
