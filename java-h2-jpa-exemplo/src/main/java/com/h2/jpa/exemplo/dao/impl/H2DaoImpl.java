package com.h2.jpa.exemplo.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.h2.jpa.exemplo.dao.H2Dao;
import com.h2.jpa.exemplo.model.H2Model;
import com.h2.jpa.exemplo.repository.H2Repository;

@Repository
public class H2DaoImpl implements H2Dao {

	@Autowired
	private H2Repository h2Repository;

	
	public List<H2Model> selectGetMapping() {

		return h2Repository.findAll();
	}

	
	public Optional<H2Model> selectIdGetMapping(Long id) {

		return h2Repository.findById(id);
	}


	public H2Model inserePostMapping(H2Model h2Model) {

		return h2Repository.save(h2Model);
	}

	
	public void updatePutMapping(H2Model h2Model) {

		h2Repository.save(h2Model);
	}

	
	public void deleteDeleteMapping(Long id) {

		h2Repository.deleteById(id);
	}

}
