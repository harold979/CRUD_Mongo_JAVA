package com.example.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.documentos.Usuarios;

public interface UsuarioRepository extends MongoRepository<Usuarios,Integer>{

}
