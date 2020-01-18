package com.h2.jpa.exemplo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2.jpa.exemplo.dao.H2Dao;
import com.h2.jpa.exemplo.model.H2Model;

@Service
public class H2Service {

	@Autowired
	private H2Dao h2Dao;

	public List<H2Model> recuperarTodosTudo() {
		return h2Dao.selectGetMapping();
	}

	public Optional<H2Model> recuperarPeloID(Long id) {
		return h2Dao.selectIdGetMapping(id);
	}

	public H2Model save(String nome, Integer idade) {

		H2Model h2Model = new H2Model();
		h2Model.setNome(nome);
		h2Model.setIdade(idade);

		return h2Dao.inserePostMapping(h2Model);
	}

	public void delete(Long id) {
		h2Dao.deleteDeleteMapping(id);
	}

	public void update(Long id, String nome, Integer idade) {
		
		H2Model h2Model = new H2Model();
		h2Model.setId(id);
		h2Model.setNome(nome);
		h2Model.setIdade(idade);

		h2Dao.updatePutMapping(h2Model);
	}
	
	
	
	public void updateComObjeto(H2Model h2Model) {

		h2Dao.updatePutMapping(h2Model);
	}
}
