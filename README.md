# Tech4music
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
http://localhost:8080/api/musicas/(ID GERADO PELO METODO POST)
__________________________________________

Para deletar uma música ( DELETE )
http://localhost:8080/api/musicas/(ID GERADO PELO METODO POST)
__________________________________________

Para atualizar uma música ( PUT )
http://localhost:8080/api/musicas/(ID GERADO PELO METODO POST)
__________________________________________

By: Thavi, aluno da Tech4me 
