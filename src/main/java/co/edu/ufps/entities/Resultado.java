package co.edu.ufps.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="resultado")
public class Resultado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="partido_id")
	private Partido partido_id;
	
	@ManyToOne
	@JoinColumn(name="seleccion_id")
	private Seleccion seleccion_id;
	
	private Integer goles;
	private Integer amarillas;
	private Integer rojas;
	
}
