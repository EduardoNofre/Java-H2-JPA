package com.h2.jpa.exemplo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.h2.jpa.exemplo.model.H2Model;


public interface H2Dao {

	public List<H2Model> selectGetMapping();

	public Optional<H2Model> selectIdGetMapping(Long id);

	public H2Model inserePostMapping(H2Model h2Model);

	public void updatePutMapping(H2Model h2Model);

	public void deleteDeleteMapping(Long id);

}
