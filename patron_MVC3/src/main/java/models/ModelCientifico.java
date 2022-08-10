package models;

public class ModelCientifico {

	private String DNI;
	private String nomApels;
	
//	constructor with all parameters by default
	public ModelCientifico() {
	}
	
	
//	constructor with all parameters but date divided by year, month, day
	public ModelCientifico(String id, String nombre) {
		this.DNI = id;
		this.nomApels = nombre;
	}


	public String getDNI() {
		return DNI;
	}


	public String getNomApels() {
		return nomApels;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}


	@Override
	public String toString() {
		return "ModelCientifico [DNI=" + DNI + ", nomApels=" + nomApels + "]";
	}




	
	
	
}
