package com.h2.jpa.exemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h2.jpa.exemplo.model.H2Model;

@Repository
public interface H2Repository extends JpaRepository<H2Model, Long>{

}
