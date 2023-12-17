package HotelRESTSpringBClient.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Hotel {
	private int id;
    private String nomHotel;
    private Integer nombreEtoile;
    
    public Hotel(int i) {
		this.id = i;
	}

	public Hotel(int id, String nomHotel, Integer nombreEtoile) {
		super();
		this.id = id;
		this.nomHotel = nomHotel;
		this.nombreEtoile = nombreEtoile;
	}

	public Hotel() {
		// TODO Auto-generated constructor stub
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomHotel() {
		return nomHotel;
	}

	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}

	public Integer getNombreEtoile() {
		return nombreEtoile;
	}

	public void setNombreEtoile(Integer nombreEtoile) {
		this.nombreEtoile = nombreEtoile;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nomHotel, nombreEtoile);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return id == other.id && Objects.equals(nomHotel, other.nomHotel)
				&& Objects.equals(nombreEtoile, other.nombreEtoile);
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nomHotel=" + nomHotel + ", nombreEtoile=" + nombreEtoile + "]";
	}

	

	
    

    
 


}
