package com.tech4music.musica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tech4music.musica.model.Musica;

@Repository
public interface MusicaRepository extends MongoRepository<Musica, String>{
    
}
