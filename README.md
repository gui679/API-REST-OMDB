# API-REST-OMDB

Esta é uma API que interage com um banco de dados MySQL enquanto consome uma API externa, a OMDB (disponível em: http://omdbapi.com/).
Foi feito como um projeto do meu curso de graduação.


O sistema foi desenvolvido utilizando com Spring Boot, baseado no framework Spring, e utiliza também o Apache Maven para automatização de compilação. O sistema também faz interface com um banco de dados MySQL para salvar suas informações, e realiza isso através de JPA, e toda a comunicação é feita em formato JSON.

O sistema simula uma locadora de filmes, e para isso ela cadastra clientes, locações, e nas locações ela cadastra apenas o id do imdb dos filmes, mas não cadastra os filmes, a informação sobre os filmes fica a cargo da API externa OMDB.

# Instalação

A princípio a implementação foi baseada no projeto pré-fabricado Spring
Boot, que pode ser gerado através do site <http://start.spring.io>.
Para este projeto foram selecionadas as dependências DevTools, Web, JPA
e MySQL, a imagem abaixo ilustra a configuração:
![alt text](https://i.imgur.com/D6hoVsP.png)

Em seguida, o projeto foi criado no Eclipse EE como novo “Existing Maven Project” (Projeto Maven Existente), e logo após isso o Eclipse já baixa todas as dependências automaticamente.

Logo em sequência foram criadas as classes modelos no pacote “model”,
que definem o formato dos objetos que serão manipulados, foram criadas as
interfaces dentro do pacote “repository”, e criadas as classes controladoras no
pacote “resource”, estas trabalham com as requisições HTML, como GET, POST,
PUT e DELETE.

# Banco de Dados

Disponibilizado um script para criação de um banco de dados MySQL para testes, arquivo banco.sql, na pasta raiz.

As configurações do banco de dados na aplicação ficam em: _“src/main/resources/application.properties”_.

# Utilização

## Cliente

A interface de clientes funciona no endereço:

**localhost:8080/api/cliente** - aceita POST, PUT E DELETE

Para adquirir uma lista com todos os clientes, o endereço é:

**localhost:8080/api/clientes** - aceita somente GET

Para visualizar um cliente específico por id o endereço é:

**localhost:8080/api/clientes/1** - aceita GET, PUT E DELETE.

(substituir 1 por id do cliente desejado)

Abaixo existe um modelo json para POST e PUT (setando ID na URL) e
DELETE cliente:
```
{
 "endereco": "string",
 "nome": "string",
 "telefone": "string"
}
```
Abaixo o modelo json para PUT e DELETE (ambos sem ID na URL) é:
```
{
“id”: 1,
 "endereco": "string",
 "nome": "string",
 "telefone": "string"
}
```
_(substituir valor da “id” pelo cliente desejado)_

## Locação

A interface de locações funciona no endereço:

**localhost:8080/api/locacao** - aceita POST, PUT E DELETE

Para adquirir uma lista com todas as locações, o endereço é:

**localhost:8080/api/locacoes** - aceita somente GET

Para visualizar uma locacao específico por id o endereço é:

**localhost:8080/api/locacao/1** - aceita GET, PUT E DELETE.

Abaixo existe um modelo json para POST e PUT (setando ID na URL) e
DELETE cliente:
```
{
 "cliente": 1,
 "data": "2018-01-01T00:00:01.000+0000",
 "devolucao": "2100-12-31T23:59:59.000+0000",
 "valor": 0.01,
 "filme": "tt4532826"
}
```
Cliente recebe um id de um cliente já cadastrado em clientes, agora o
atributo “filme” recebe uma id de um filme do IMDB. Para ver um id do imdb acesse
o imdb.com, escolha um filme e o id é o que aparece no endereço depois do '/title/'
algumas ids de filmes do IMDB Para testes:
**tt0120338** : Titanic
**tt2709692** : The Grinch (2018)
**tt0110357** : The Lion King (1994)
**tt4532826** : Robin Hood (2018)

Abaixo o modelo json para PUT e DELETE (ambos sem ID na URL) é:
```
{
 "id": 4,
 "cliente": 1,
 "data": "2018-01-01T00:00:01.000+0000",
 "devolucao": "2100-12-31T23:59:59.000+0000",
 "valor": 0.01,
 "filme": "tt4532826"
}
```

Se tudo correr como deveria, ao realizar GET por quaisquer dos métodos,
deve retornar uma estrutura parecida com a abaixo:
```
{ "id": 3,
 "cliente": {
 "id": 1,
 "nome": "bbb",
 "endereco": "aaa",
 "telefone": "ccc"
 },
 "data": "2018-01-01T00:00:01.000+0000",
 "devolucao": "2100-12-31T23:59:59.000+0000",
 "valor": 0.01,
 "filme": {
 "Title": "The Grinch",
 "Year": "2018",
 "Rated": "N/A",
 "Released": "09 Nov 2018",
 "Runtime": "86 min",
 "Genre": "Animation, Comedy, Family, Fantasy",
 "Director": "Yarrow Cheney, Scott Mosier",
 "Writer": "Michael LeSieur (screenplay by), Tommy
Swerdlow (screenplay by), Dr. Seuss (based on the book \"How The Grinch
Stole Christmas\" by)",
 "Actors": "Benedict Cumberbatch, Cameron Seely, Rashida
Jones, Pharrell Williams",
 "Plot": "A grumpy Grinch plots to ruin Christmas for the
village of Whoville.",
 "Language": "English",
 "Country": "China, USA",
 "Awards": "N/A",
 "Poster":
"https://m.media-amazon.com/images/M/MV5BYmE5Yjg0MzktYzgzMi00YTFiLWJjYTItY2
M5MmI1ODI4MDY3XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg",
 "Ratings": [
 {
 "Source": "Internet Movie Database",
 "Value": "6.3/10"
 },
 {
 "Source": "Metacritic",
 "Value": "50/100"
 }
 ],
 "Metascore": "50",
 "imdbRating": "6.3",
 "imdbVotes": "4,121",
 "imdbID": "tt2709692",
 "Type": "movie",
 "DVD": "N/A",
 "BoxOffice": "N/A",
 "Production": "Universal Pictures",
 "Website": "http://www.grinchmovie.com/",
 "Response": "True"
 }
 }
 ```
 
_Toda a informação dentro do atributo “filme” é proveniente de API externa OMDB, e
(além da ID) não são salvas em momento algum no banco de dados, enquanto as
outras informações são provenientes do banco de dados da própria aplicação
desenvolvida._

