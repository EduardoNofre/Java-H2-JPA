package com.h2.jpa.exemplo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2.jpa.exemplo.model.H2Model;
import com.h2.jpa.exemplo.repository.H2Repository;

@Service
public class H2Service {

  @Autowired
	private H2Repository h2Repository;
  
  public List<H2Model> recuperarTodosTudo() {
		return h2Repository.findAll();
	}
}
