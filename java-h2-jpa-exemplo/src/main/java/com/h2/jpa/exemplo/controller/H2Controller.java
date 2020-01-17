package com.h2.jpa.exemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2.jpa.exemplo.model.H2Model;
import com.h2.jpa.exemplo.service.H2Service;

import io.swagger.annotations.Api;

@Api(value = "/v1/h2", description = "Responsável por h2")
@RestController
@Validated
@RequestMapping("/controlerh2")
@CrossOrigin(origins="*")
public class H2Controller {

  @Autowired
	private H2Service h2Service;
  
  @GetMapping(path = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscaTudo() {

		List<H2Model> h2ModelResponse = h2Service.recuperarTodosTudo();

		return new ResponseEntity<>(h2ModelResponse, HttpStatus.OK);
	}
	
}
