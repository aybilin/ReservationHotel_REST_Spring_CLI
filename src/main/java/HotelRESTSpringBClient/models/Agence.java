package HotelRESTSpringBClient.models;

public class Agence {
	private int id;

    private String nomAgence;
    
    public Agence() {
		// TODO Auto-generated constructor stub
	}

	public Agence(int id, String nomAgence) {
		super();
		this.id = id;
		this.nomAgence = nomAgence;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}
    

}
