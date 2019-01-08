# API-REST-OMDB

Esta é uma API que interage com um banco de dados MySQL enquanto consome uma API externa, a OMDB (disponível em: http://omdbapi.com/).
Foi feito como um projeto do meu curso de graduação.


O sistema foi desenvolvido utilizando com Spring Boot, baseado no framework Spring, e utiliza também o Apache Maven para automatização de compilação. O sistema também faz interface com um banco de dados MySQL para salvar suas informações, e realiza isso através de JPA, e toda a comunicação é feita em formato JSON.

O sistema simula uma locadora de filmes, e para isso ela cadastra clientes, locações, e nas locações ela cadastra apenas o id do imdb dos filmes, mas não cadastra os filmes, a informação sobre os filmes fica a cargo da API externa OMDB.

# Utilização

A princípio a implementação foi baseada no projeto pré-fabricado Spring
Boot, que pode ser gerado através do site <http://start.spring.io>.
Para este projeto foram selecionadas as dependências DevTools, Web, JPA
e MySQL, a imagem abaixo ilustra a configuração:

