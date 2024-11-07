package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Resultado;
import co.edu.ufps.entities.Seleccion;
import co.edu.ufps.services.SeleccionService;

@RestController
@RequestMapping("/selecciones")
public class SeleccionController {
	
	@Autowired
	private SeleccionService seleccionService;
	
	@GetMapping
	public ResponseEntity<List<Seleccion>> list() {
		return ResponseEntity.ok(seleccionService.list());
	}
	
	@PostMapping()
	public ResponseEntity<Seleccion> create(@RequestBody Seleccion seleccion) {
		Seleccion nuevaSeleccion = seleccionService.create(seleccion);
		return ResponseEntity.ok(nuevaSeleccion);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Seleccion> update(@PathVariable Integer id, @RequestBody Seleccion seleccionDetails) {
		Seleccion updatedSeleccion = seleccionService.update(id, seleccionDetails);
		return ResponseEntity.ok(updatedSeleccion);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Seleccion> get(@PathVariable Integer id) {
		return ResponseEntity.ok(seleccionService.get(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Seleccion> delete(@PathVariable Integer id) {
		Seleccion deletedSeleccion = seleccionService.delete(id);
		return ResponseEntity.ok(deletedSeleccion);
	}
	
	@GetMapping("/{id}/resultados")
	public ResponseEntity<List<Resultado>> getResultado(@PathVariable Integer id) {
		return ResponseEntity.ok(seleccionService.get(id).getResultado());
	}
	
	@GetMapping("/grupo/{grupo}")
	public ResponseEntity<List<Seleccion>> getSeleccionesPorGrupo(@PathVariable String grupo) {
		return ResponseEntity.ok(seleccionService.getSeleccionesPorGrupo(grupo));
	}
	
}
