package co.edu.ufps.entities;

import java.time.LocalDateTime;
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
@Table(name="partido")
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime fecha;
	
	@ManyToOne
	@JoinColumn(name="estadio_id")
	private Estadio estadio_id;
	
	@OneToMany(mappedBy = "partido_id", cascade= CascadeType.ALL)
	@JsonIgnore
	List<Resultado> resultado = null;
	
}
