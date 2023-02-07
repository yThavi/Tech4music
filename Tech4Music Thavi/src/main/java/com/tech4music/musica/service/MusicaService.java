package com.tech4music.musica.service;

import java.util.List;
import java.util.Optional;

import com.tech4music.musica.model.Musica;
import com.tech4music.musica.shared.MusicaDTO;

import org.springframework.stereotype.Service;

@Service
public interface MusicaService {
    
    List<MusicaDTO> obterTodos();

    Optional<MusicaDTO> obterPorId(String idMusica);

    MusicaDTO adicionar(MusicaDTO musicaDto);

    Musica atualizar(String idMusica, MusicaDTO musicaDto);

    void deletar(String idMusica);
}
