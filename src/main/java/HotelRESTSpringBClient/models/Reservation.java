package HotelRESTSpringBClient.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Reservation {
	int id;
	private Date dateArrivee;
    private Date dateDepart;
    private int nombrePersonnes;
    private String nomClient;
    private String prenomClient;
    private String numCarteBancaire;
    private String codeCVC;
    private Date dateExpiration;
    private double prix;
    
    private Hotel hotel;
    private Chambre chambre;
    private Agence agence;
    
    public Reservation() {
		// TODO Auto-generated constructor stub
	}

	
	

	public Reservation( Date dateArrivee, Date dateDepart, int nombrePersonnes, String nomClient,
			String prenomClient, String numCarteBancaire, String codeCVC, Date dateExpiration, double prix, Hotel hotel,
			Chambre chambre, Agence agence) {
		super();
		
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.nombrePersonnes = nombrePersonnes;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.numCarteBancaire = numCarteBancaire;
		this.codeCVC = codeCVC;
		this.dateExpiration = dateExpiration;
		this.prix = prix;
		this.hotel = hotel;
		this.chambre = chambre;
		this.agence = agence;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public int getNombrePersonnes() {
		return nombrePersonnes;
	}

	public void setNombrePersonnes(int nombrePersonnes) {
		this.nombrePersonnes = nombrePersonnes;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getNumCarteBancaire() {
		return numCarteBancaire;
	}

	public void setNumCarteBancaire(String numCarteBancaire) {
		this.numCarteBancaire = numCarteBancaire;
	}

	public String getCodeCVC() {
		return codeCVC;
	}

	public void setCodeCVC(String codeCVC) {
		this.codeCVC = codeCVC;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}




	public void setHotel(Hotel hotel2) {
		this.hotel = hotel2;
		
	}




	public Hotel getHotel() {
		// TODO Auto-generated method stub
		return hotel;
	}




	public Chambre getChambre() {
		return chambre;
	}




	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}




	public Agence getAgence() {
		return agence;
	}




	public void setAgence(Agence agence) {
		this.agence = agence;
	}




	






	
    
}
