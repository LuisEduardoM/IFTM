package br.edu.iftm.extensaoSTS.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.extensaoSTS.service.AtividadeService;

@RestController
@RequestMapping(value = "/atividades")
public class AtividadeResource {
	
	@Autowired
	private AtividadeService service;

	public ResponseEntity<?> find(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(service.buscar(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
