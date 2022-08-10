package models;

public class ModelAsignado {
	private int id;
	private String cientifico;
	private String proyecto;
	
//	constructor with all parameters by default
	public ModelAsignado() {
	}
// constructor with all parameters
	public ModelAsignado(int id, String cientifico, String proyecto) {
		this.id = id;
		this.cientifico = cientifico;
		this.proyecto = proyecto;
	}

//	Getters
	public int getId() {
		return id;
	}

	public String getcientifico() {
		return cientifico;
	}

	public String getproyecto() {
		return proyecto;
	}

//	Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setcientifico(String cientifico) {
		this.cientifico = cientifico;
	}

	public void setproyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public String toString() {
		return "ModelAsignado [id=" + id + ", cientifico=" + cientifico + ", proyecto=" + proyecto + "]";
	}
	
	
	
}
