# Tech4music

_______________________________________________________________________________________________________________________________________________________________

MongoDB Compass

Para criar o banco de dados

mongodb://localhost:27017/tech4music            /
use tech4music

Cadastrando as músicas direto do MongoDB:

db.musicas.insert({"titulo" : "Forever", "artista" : "Kiss", "album" : "Hot in the Shade", "genero" : "Rock", "anoLancamento" : "1989", "Compositor" : "Paul Stanley"})

db.musicas.insert({"titulo" : "Algo parecido", "artista" : "Skank", "album" : "Os três primeiros", "genero" : "Pop", "anoLancamento" : "2018", "Compositor" : "Samuel Rosa"})

db.musicas.insert({"titulo" : "O que me importa", "artista" : "Marisa Monte", "album" : "Memórias, crônicas e declarações de amor", "genero" : "MPB", "anoLancamento" : "2000", "Compositor" : "Jose Ribamar Cury"})

_______________________________________________________________________________________________________________________________________________________________


Projeto de cadastramento de músicas, usando CRUD básico

Para cadastrar músicas ( POST )
http://localhost:8080/api/musicas/

Formato de arquivo JSON para cadastramento de músicas:

OBS: PULE AS LINHAS NO FINAL DE CADA VIRGULA

{
    "titulo": "",
    "artista": "",
    "album": "",
    "genero": "",
    "anoLancamento": ,
    "compositor": ""
    }
__________________________________________

Para consultar a música por ID ( GET )
http://localhost:8080/api/musicas/ (ID DA MUSICA GERADO PELO METODO POST)
__________________________________________

Para deletar uma música ( DELETE )
http://localhost:8080/api/musicas/ (ID DA MUSICA GERADO PELO METODO POST)
__________________________________________

Para atualizar uma música ( PUT )
http://localhost:8080/api/musicas/ (ID DA MUSICA GERADO PELO METODO POST)
__________________________________________

By: Thavi, aluno da Tech4me 
