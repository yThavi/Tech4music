package com.tech4music.musica.controller;

import java.util.List;
import java.util.Optional;


import com.tech4music.musica.service.MusicaServiceImpl;
import com.tech4music.musica.shared.MusicaDTO;
import com.tech4music.musica.model.Musica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/musicas")
public class MusicaController {
    
    @Autowired
    MusicaServiceImpl servicoMusica;

    @GetMapping
    public ResponseEntity<List<MusicaDTO>>obterTodos() {
        List<MusicaDTO> listaMusicas = servicoMusica.obterTodos();

        return new ResponseEntity<>(listaMusicas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MusicaDTO>> obterPorId(@PathVariable String id) {
        Optional<MusicaDTO> musica = servicoMusica.obterPorId(id);

        return new ResponseEntity<>(musica, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<MusicaDTO> adicionar(@RequestBody MusicaDTO musicaDto){
        musicaDto = servicoMusica.adicionar(musicaDto);

        return new ResponseEntity<> (musicaDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizar(@PathVariable String id, 
                                                @RequestBody MusicaDTO musicaDto){

        return new ResponseEntity<>(servicoMusica.atualizar(id, musicaDto), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity <String> excluirProduto(@PathVariable String id) {
        servicoMusica.deletar(id);
        return new ResponseEntity<>("Música deletada com sucesso", HttpStatus.OK);
    }
}

