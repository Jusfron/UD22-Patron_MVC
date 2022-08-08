package models;

public class ModelVideo {
	private int id;
	private String title;
	private String director;
	private int cli_id;
	
	public ModelVideo(int id, String title, String director, int cli_id) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.cli_id = cli_id;
	}
	
	public ModelVideo() {
	}

//	Getters
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDirector() {
		return director;
	}

	public int getCli_id() {
		return cli_id;
	}

//	Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setCli_id(int cli_id) {
		this.cli_id = cli_id;
	}

	@Override
	public String toString() {
		return "ModelVideo [id=" + id + ", title=" + title + ", director=" + director + ", cli_id=" + cli_id + "]";
	}
	
	
	
}
