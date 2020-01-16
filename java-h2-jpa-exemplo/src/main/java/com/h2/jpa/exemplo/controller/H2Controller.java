package com.h2.jpa.exemplo.controller;


@Api(value = "/v1/h2", description = "Responsável por h2")
@RestController
@Validated
@RequestMapping("/controlerh2")
@CrossOrigin(origins="*")
public class H2Controller {

  @Autowired
	private H2Service h2Service;
  
  @GetMapping(path = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity buscaTudo() {

		List<H2Model> h2ModelResponse = h2Service.recuperarTodosTudo();

		return new ResponseEntity<>(h2ModelResponse, HttpStatus.OK);
	}
	
}
