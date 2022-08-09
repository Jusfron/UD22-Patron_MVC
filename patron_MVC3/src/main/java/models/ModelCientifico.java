package models;

public class ModelCientifico {

	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	private String date;
	
//	constructor with all parameters by default
	public ModelCientifico() {
	}
	
	
//	constructor with all parameters but date divided by year, month, day
	public ModelCientifico(int id, String nombre, String apellido, String direccion, int dni, int day, int month, int year) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.dni = dni;
		this.date = year + "-" + month + "-" + day;;
	}



//	getters
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getDni() {
		return dni;
	}

	public String getDate() {
		return date;
	}

	public void setId(int id) {
		this.id = id;
	}

//	setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public void setDate(int day, int month, int year) {
		this.date = year + "-" + month + "-" + day;
	}
	
	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "ModelCliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", dni=" + dni + ", date=" + date + "]";
	}
	
	
	
	
}
