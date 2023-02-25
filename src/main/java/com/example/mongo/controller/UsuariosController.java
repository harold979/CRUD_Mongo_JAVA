package com.example.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.documentos.Usuarios;
import com.example.mongo.repository.UsuarioRepository;

@RestController
@RequestMapping("/Usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@PostMapping
	public ResponseEntity<?> saveUsuario(@RequestBody Usuarios usuario){
		try {
			Usuarios usersave = usuarioRepo.save(usuario);
			return new ResponseEntity<Usuarios>(usersave, HttpStatus.CREATED);
		}catch(Exception e){
			return new ResponseEntity<String>(e.getCause().toString(),
					                          HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	
	public ResponseEntity<?> findAllUsuarios(){
		try {
			List<Usuarios> usuarios= usuarioRepo.findAll();
			return new ResponseEntity<List<Usuarios>>(usuarios, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<String>(e.getCause().toString(),
					                      HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateUsuario(@RequestBody Usuarios usuario){
		try {
			Usuarios usersave = usuarioRepo.save(usuario);
			return new ResponseEntity<Usuarios>(usersave, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<String>(e.getCause().toString(),
					                          HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable("id") Integer id){
		try {
		    usuarioRepo.deleteById(id);
			return new ResponseEntity<String>("Fue Eliminado", HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<String>(e.getCause().toString(),
					                          HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		

}
