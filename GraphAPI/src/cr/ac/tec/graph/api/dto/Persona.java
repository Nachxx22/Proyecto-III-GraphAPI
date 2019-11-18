package cr.ac.tec.graph.api.dto;

import java.util.UUID;

public class Persona {
	private UUID id;
	private String nombre;
	private String edad;

	public Persona() {
		this.id = UUID.randomUUID();
	}

	public Persona(String nombre, String edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}