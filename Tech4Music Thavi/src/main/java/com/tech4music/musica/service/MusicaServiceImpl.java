package com.tech4music.musica.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4music.musica.model.Musica;
import com.tech4music.musica.repository.*;
import com.tech4music.musica.shared.MusicaDTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MusicaServiceImpl implements MusicaService {
    
    @Autowired
    MusicaRepository repositorioMusica;

    @Override
    public List<MusicaDTO> obterTodos() {

        List<Musica> musicas = repositorioMusica.findAll();

        ModelMapper mapper = new ModelMapper();
        return musicas.stream().map(musica -> mapper
        .map(musica, MusicaDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<MusicaDTO> obterPorId(String idMusica) {
        Optional<Musica> optionalMusica = repositorioMusica.findById(idMusica);

        if(optionalMusica.isEmpty()){
            throw new InputMismatchException("Não foi possivel encontrar sua musica com esse id: "+ idMusica);
        }

        MusicaDTO musicaDto = new ModelMapper().map(optionalMusica.get(), MusicaDTO.class);

        return Optional.of(musicaDto);
    }

    @Override
    public MusicaDTO adicionar(MusicaDTO musicaDto) {
        ModelMapper mapper = new ModelMapper();

        Musica musica = mapper.map(musicaDto, Musica.class);

        musica.setId(null);

        musica = repositorioMusica.save(musica);

        return mapper.map(musica, MusicaDTO.class);
    }

    @Override
    public void deletar(String idMusica) {

        repositorioMusica.deleteById(idMusica);
    }

    @Override
    public Musica atualizar(String idMusica, MusicaDTO musicaDto) {
        if(repositorioMusica.findById(idMusica).isPresent()){
            Musica musicaExistente = repositorioMusica.findById(idMusica).get();
        
            musicaExistente.setAlbum(musicaDto.getAlbum());
            musicaExistente.setAnoLancamento(musicaDto.getAnoLancamento());
            musicaExistente.setArtista(musicaDto.getArtista());
            musicaExistente.setGenero(musicaDto.getGenero());
            musicaExistente.setCompositor(musicaDto.getCompositor());
            musicaExistente.setTitulo(musicaDto.getTitulo());
            return repositorioMusica.save(musicaExistente);
        }
        else{
            throw new InputMismatchException("Não foi possivel encontrar sua musica com esse id!!"); 
        }
        
    }
}
