package HotelRESTSpringBClient.models;

public class Chambre {
	private int id;
    private Integer numChambre;
    private String type;
    private Integer nombreLit;
    private Double prix;
    public Chambre() {
		// TODO Auto-generated constructor stub
	}
	public Chambre(int id, Integer numChambre, String type, Integer nombreLit, Double prix) {
		super();
		this.id = id;
		this.numChambre = numChambre;
		this.type = type;
		this.nombreLit = nombreLit;
		this.prix = prix;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getNumChambre() {
		return numChambre;
	}
	public void setNumChambre(Integer numChambre) {
		this.numChambre = numChambre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getNombreLit() {
		return nombreLit;
	}
	public void setNombreLit(Integer nombreLit) {
		this.nombreLit = nombreLit;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
    
}
