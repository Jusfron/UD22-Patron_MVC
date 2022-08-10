package models;

public class ModelProyecto {
	private int id;
	private String nombre;
	private int horas;
	
//	constructor with all parameters by default
	public ModelProyecto() {
	}
// constructor with all parameters
	public ModelProyecto(int id, String nombre, int horas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
	}
	
//	Getters and setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getHoras() {
		return horas;
	}
	
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
//	toString method	
	@Override
	public String toString() {
		return "ModelProyecto [id=" + id + ", nombre=" + nombre + ", horas=" + horas + "]";
	}
		
}
