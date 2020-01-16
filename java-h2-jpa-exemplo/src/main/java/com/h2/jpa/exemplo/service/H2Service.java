package com.h2.jpa.exemplo.service;


@Service
public class H2Service {

  @Autowired
	private H2Repository h2Repository;
  
  public List<H2Model> recuperarTodosTudo() {
		return h2Repository.findAll();
	}
}
