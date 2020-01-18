package com.h2.jpa.exemplo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2.jpa.exemplo.model.H2Model;
import com.h2.jpa.exemplo.service.H2Service;

import io.swagger.annotations.Api;

@Api(value = "/crud", description = "Responsável por h2")
@RestController
@Validated
@RequestMapping("/crud")
@CrossOrigin(origins = "*")
public class H2Controller {

	@Autowired
	private H2Service h2Service;

	@GetMapping(path = "/consultartodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscaTodos() {

		List<H2Model> h2ModelResponse = h2Service.recuperarTodosTudo();

		return new ResponseEntity<>(h2ModelResponse, HttpStatus.OK);
	}

	@GetMapping(path = "/consultarPorId/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscaPorID(@PathVariable("id") Long id) {

		Optional<H2Model> H2ModelResponse = h2Service.recuperarPeloID(id);
		return new ResponseEntity<>(H2ModelResponse, HttpStatus.OK);
	}

	@DeleteMapping(path = "/deletaPorId/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deletePorID(Long id) {

		h2Service.delete(id);
		return new ResponseEntity<>("delete", HttpStatus.OK);
	}

	@PostMapping(path = "/insere/nome/{nome}/idade/{idade}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insere(@PathVariable("nome") String nome, 
			@PathVariable("idade") Integer idade) {

		h2Service.save(nome, idade);
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	@PutMapping(path = "/atualizaPorId/id/{id}/nome/{nome}/idade/{idade}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePorID(@PathVariable("id") Long id, 
			@PathVariable("nome") String nome,
			@PathVariable("idade") Integer idade) {

		h2Service.update(id, nome, idade);
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	@PutMapping(path = "/atualizacomobjeto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePorIDComObjeto(@RequestBody H2Model h2Model) {

		h2Service.updateComObjeto(h2Model);
		return new ResponseEntity<>("", HttpStatus.OK);
	}

}
