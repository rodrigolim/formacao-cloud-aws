# API DE PRODUTOS
> API REST simples utilizada no curso de cloud para demonstrar o deploy na AWS.

### Tecnologia utilizadas:
- JAVA
- SPRING BOOT
- OPEN API
- JPA
- MYSQL
- Actuator

### Pré-requisitos
Você vai precisar de uma IDE como por exemplo: IntelliJ IDEA, Eclipse, VSCode.
- Instale MYSQL 5+
- Instale a JDK 11+
- Instale o Apache Maven 3.5.3+


## Utilizando MySql em DOCKER

Se possuir DOCKER, instale o MySQL com o comando abaixo.
```
docker run --name mysql -p 3306:3306 -p 33060:33060 -e MYSQL_ROOT_HOST='%' -e MYSQL_ROOT_PASSWORD='admin' -d mysql:latest
```

## Deploy da Aplicação

A aplicação está disponível na [AWS](http://apiproduto-env.eba-2wzud2pe.sa-east-1.elasticbeanstalk.com/)

### Deploy AWS

Para realizar o deploy para a AWS definir as variáveis:

```
${URL_DATABASE}
${NAME_DATABASE}
${USER}
${PASSWORD}
```

## Endpoints e Documentação de APIs

Os endpoints para testes e a documentação das APIs segue o Padrão OpenApi V3. Está disponível na [swagger](http://apiproduto-env.eba-2wzud2pe.sa-east-1.elasticbeanstalk.com/swagger-ui/index.html)

## Status da Aplicação

Para validar se o serviço está no ar chamar a URL: [actuator](http://apiproduto-env.eba-2wzud2pe.sa-east-1.elasticbeanstalk.com/actuator/health)


Status do Projeto: Em desenvolvimento :warning: