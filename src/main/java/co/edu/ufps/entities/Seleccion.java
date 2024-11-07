package co.edu.ufps.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="seleccion")
public class Seleccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="continente_id")
	private Continente continente_id;
	
	@OneToMany(mappedBy = "seleccion_id", cascade= CascadeType.ALL)
	@JsonIgnore
	List<Resultado> resultado = null;
	
	private String grupo;
	
}
