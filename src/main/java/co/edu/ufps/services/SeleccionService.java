package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Seleccion;
import co.edu.ufps.repositories.SeleccionRepository;

@Service
public class SeleccionService {
	
	@Autowired
	private SeleccionRepository seleccionRepository;
	
	public List<Seleccion> list(){
		return seleccionRepository.findAll();
	}
	
	public Seleccion create(Seleccion seleccion) {
		return seleccionRepository.save(seleccion);
	}
	
	public Seleccion update(Integer id, Seleccion seleccionDetails) {
		Optional<Seleccion> SelecionOpt = seleccionRepository.findById(id);

		if (!SelecionOpt.isPresent()) {
			return null;
		}

		Seleccion seleccion = SelecionOpt.get();
		seleccion.setNombre(seleccionDetails.getNombre());
		seleccion.setContinente_id(seleccionDetails.getContinente_id());
		seleccion.setGrupo(seleccionDetails.getGrupo());

		return seleccionRepository.save(seleccion);
	}
	
	public Seleccion get(Integer id) {
		Optional<Seleccion> SelecionOpt = seleccionRepository.findById(id);
		if (SelecionOpt.isPresent()) {
			return SelecionOpt.get();
		}
		return null;
	}
	
	public Seleccion delete(Integer id) {
		Optional<Seleccion> seleccionOpt = seleccionRepository.findById(id);

		if (seleccionOpt.isPresent()) {

			Seleccion seleccion = seleccionOpt.get();
			seleccionRepository.delete(seleccion);
			return seleccion;
		}

		return null;
	}
	
	public List<Seleccion> getSeleccionesPorGrupo(String grupo) {
	    if (!seleccionRepository.existsByGrupo(grupo)) {
	        return null; 
	    }
	    return seleccionRepository.findAllByGrupo(grupo);
	}

}

