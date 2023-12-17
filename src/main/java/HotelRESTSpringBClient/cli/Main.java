package HotelRESTSpringBClient.cli;

import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import HotelRESTSpringBClient.models.Agence;
import HotelRESTSpringBClient.models.Chambre;
import HotelRESTSpringBClient.models.Hotel;
import HotelRESTSpringBClient.models.Reservation;

public class Main {
	 

    public static void main(String[] args) throws Exception {
    	

        
        
        Scanner sc = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        boolean continuer = true;

        while (continuer) {
            // Affichage du menu
            System.out.println("Bienvenue dans le programme !");
            System.out.println("1. Utiliser le comparateur");
            System.out.println("2. Afficher les offres");
            System.out.println("3. Quitter");

            // Demande à l'utilisateur de choisir une option
            System.out.print("Veuillez choisir une option (1, 2 ou 3) : ");
            int choix = scanner.nextInt();

            // Utilisation du switch case pour traiter le choix de l'utilisateur
            switch (choix) {
                case 1:
                    System.out.println("Vous avez choisi d'utiliser le comparateur.");
                    System.out.println("Donnez Une ville de séjour");
                    String villeC = sc.nextLine();
                    System.out.println("Donnez Une date d'arrivée");
                    String dateArriveC = sc.nextLine();
                    System.out.println("Donnez Une date de départ");
                    String dateDepartC = sc.nextLine();
                    System.out.println("Donnez un prix max");
                    Double prixMaxC = scInt.nextDouble();
                    System.out.println("Donnez un prix min");
                    Double prixMinC = scInt.nextDouble();
                    System.out.println("Donnez la catégorie");
                    int nombreEtoileeC = scInt.nextInt();
                    System.out.println("Donnez le nombre de personnes à héberger");
                    int nombrePersonneC = scInt.nextInt();
//                    System.out.println("Entrez l'id d'agence");
//                    int IdAgenceC = scInt.nextInt();

                    // Appel au service REST pour obtenir les offres
                    List<Object[]> listeOffreC = getOffresC(villeC, nombreEtoileeC, nombrePersonneC, prixMinC, prixMaxC, dateArriveC,
                            dateDepartC);
                    //Object x=listeOffre.get(1)[18];
                    //System.out.println(x);
                    for (Object[] objArray : listeOffreC) {
                        //System.out.println("offre N°: " + objArray[0]);
                        System.out.println("Nom Agence: " + objArray[21]);

                        System.out.println("hotel " + objArray[4]);
                        System.out.println("adresse: " + objArray[14] + " " + objArray[17] + ", " + objArray[18] + ", " + objArray[15]);
                        System.out.println("N° Chambre: " + objArray[8]);
                        System.out.println("image de Chambre: " + objArray[10]);
                        System.out.println("nombre etoile: " + objArray[3] + " etoiles");
                        System.out.println("nombre de lit: " + objArray[7]);
                        System.out.println("prix par nuit " + objArray[19] + " euro");
                        System.out.println("cette chambre est " + objArray[22] + " pour le moment");

                        System.out.println();
                    }
                    // Ajoutez ici le code correspondant à cette option
                    break;

                case 2:
                    System.out.println("Vous avez choisi d'afficher les offres.");

                    System.out.println("Donnez Une ville de séjour");
                    String ville = sc.nextLine();
                    System.out.println("Donnez Une date d'arrivée");
                    String dateArrive = sc.nextLine();
                    System.out.println("Donnez Une date de départ");
                    String dateDepart = sc.nextLine();
                    System.out.println("Donnez un prix max");
                    Double prixMax = scInt.nextDouble();
                    System.out.println("Donnez un prix min");
                    Double prixMin = scInt.nextDouble();
                    System.out.println("Donnez la catégorie");
                    int nombreEtoilee = scInt.nextInt();
                    System.out.println("Donnez le nombre de personnes à héberger");
                    int nombrePersonne = scInt.nextInt();
                    System.out.println("Entrez l'id d'agence");
                    int IdAgence = scInt.nextInt();

                    // Appel au service REST pour obtenir les offres
                    List<Object[]> listeOffre = getOffres(ville, nombreEtoilee, nombrePersonne, IdAgence, prixMin, prixMax, dateArrive,
                            dateDepart);
                    //Object x=listeOffre.get(1)[18];
                    //System.out.println(x);
                    for (Object[] objArray : listeOffre) {
                        System.out.println("offre N°: " + objArray[0]);
                        System.out.println("hotel " + objArray[4]);
                        System.out.println("adresse: " + objArray[14] + " " + objArray[17] + ", " + objArray[18] + ", " + objArray[15]);
                        System.out.println("N° Chambre: " + objArray[8]);
                        System.out.println("image de Chambre: " + objArray[10]);
                        System.out.println("nombre etoile: " + objArray[3] + " etoiles");
                        System.out.println("nombre de lit: " + objArray[7]);
                        System.out.println("prix par nuit " + objArray[19] + " euro");
                        System.out.println("cette chambre est " + objArray[20] + " pour le moment");

                        System.out.println();
                    }
                    
                    System.out.println();
                    Scanner scanner1 = new Scanner(System.in);
                    int reponse1=1;
                    
                    do {
                        System.out.println("Souhaiterez-vous voir la photo d'une chambre si oui entrer le N° offre sinon 0 ");
                        reponse1 = scanner1.nextInt();
                        
                        if(reponse1 != 0) {
                        	for (Object[] objArray : listeOffre) {
                        		if((int)objArray[0] == reponse1) {
                        			String url8 = (String)objArray[10];
                        	    	//String url8 = "https://www.deco.fr/sites/default/files/styles/article_970x500/public/migration-images/101525.webp?itok=-9s_4iV8";
                        	        Desktop desktop = Desktop.getDesktop();
                        	        if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
                        	            desktop.browse(new URI(url8));
                        	        } else {
                        	            System.out.println("La fonctionnalité de navigation n'est pas supportée sur ce système.");
                        	            // Vous pouvez également afficher le lien dans la console si la navigation n'est pas supportée.
                        	            System.out.println("Lien : " + url8);
                        	        }
                        		}
                        		
                        	}
                        	
                        };

                    } while (reponse1 != 0);


                    


//                    for (Offre o : listeOffre) {
//                        System.out.println("Offre N°: " + o.getIdOffre());
//                        // Affichez les détails de l'offre comme vous le faisiez dans le service SOAP
//                        // ...
//                    }

                    System.out.println();

                    System.out.println("Souhaiterez-vous faire une réservation ? Répondez par oui ou non");
                    String reponse = sc.nextLine();

                    if (reponse.equalsIgnoreCase("oui")) {
                        int cmp = 0;
                        System.out.println("Entrez le N° offre qui vous convient !");
                        int nOffre = scInt.nextInt();
                        
                    	for(Object[] obj:listeOffre) {
            				if((int)obj[0]==nOffre && obj[20].equals("disponible")) {
            					int idHotel=(int) obj[6];
            					int idChambre=(int) obj[0];
            					//int idAgence=(int) obj[8];
            					
            					String nomHotel=(String) obj[4];
            					int numeroChambre=(int) obj[8];
            					Double prix=(Double) obj[19];
            					
            					
            					System.out.println("entrez le login");
            					String login=sc.nextLine();
            					System.out.println("entrez le mot de passe");
            					String motDePasse=sc.nextLine();
            					System.out.println("entrez votre nom");
            					String nomCli=sc.nextLine();
            					System.out.println("entrez votre prenom");
            					String prenomCli=sc.nextLine();
            					System.out.println("entrez le numero de votre CB");
            					String numCB=sc.nextLine();
            					System.out.println("entrez la date dexpiration de la carte en format: MMMM-DD-LL");
            					String datExpCB=sc.nextLine();
            					System.out.println("entrez le code cvc");
            					String codecvc=sc.nextLine();
            					
            					String url = "http://localhost:8080/service/api/reservation";
            					//HotelRESTSpringBClient.models.Reservation reservation = new HotelRESTSpringBClient.models.Reservation(convertStringToDate("2023-12-19"),convertStringToDate("2023-12-25"),2,"bilem","ayoub","125545","125",convertStringToDate("2025-12-12"),150,new Hotel(),new Chambre(),new Agence());
            					Reservation reservation1 = new Reservation();
            					reservation1.setDateArrivee(convertStringToDate(dateArrive));
            					reservation1.setDateDepart(convertStringToDate(dateDepart));
            					reservation1.setNombrePersonnes(nombrePersonne);
            					reservation1.setNomClient(nomCli);
            					reservation1.setPrenomClient(prenomCli);
            					reservation1.setNumCarteBancaire(numCB);
            					reservation1.setCodeCVC(codecvc);
            					reservation1.setDateExpiration(convertStringToDate(datExpCB));
            					reservation1.setPrix(prix);

            					Hotel hotel = new Hotel();
            					hotel.setId(idHotel);
            					reservation1.setHotel(hotel);

            					Chambre chambre = new Chambre();
            					chambre.setId(idChambre);
            					reservation1.setChambre(chambre);

            					Agence agence = new Agence();
            					agence.setId(IdAgence);
            					reservation1.setAgence(agence);

            					RestTemplate restTemplate = new RestTemplate();
            			        ResponseEntity<String> rep=restTemplate.postForEntity(url, reservation1, String.class);
            			        System.out.println(rep.getBody());
            			        cmp++;

            					
            					
//            			        String url = "http://localhost:8080/employeeservice/api/reservation";
//            					HotelRESTSpringBClient.models.Reservation reservation;
//            					try {
//            						reservation = new HotelRESTSpringBClient.models.Reservation(convertStringToDate("2023-12-19"),convertStringToDate("2023-12-25"),2,"bilem","ayoub","125545","125",convertStringToDate("2025-12-12"),150,new Hotel(),new Chambre(),new Agence());
//            					} catch (Exception e) {
//            						// TODO Auto-generated catch block
//            						e.printStackTrace();
//            					}
//            					RestTemplate restTemplate = new RestTemplate();
//            			        ResponseEntity<String> rep=restTemplate.postForEntity(url, reservation, String.class);
//            			        System.out.println(rep.getBody());
            					
//            					URL url2 = new URL("http://localhost:8089/Ireservation?wsdl");
//            					ReservationImplService serviceImpl2 = new ReservationImplService(url2);
//            					Ireservation proxy2 = serviceImpl2.getReservationImplPort();
//            					Reservation reservation=proxy2.afficherReservation(IdAgence, login, motDePasse, nomHotel, numeroChambre, dateArrive, dateDepart, nombrePersonne, nomCli, prenomCli, numCB, datExpCB, codecvc, idHotel, idChambre, prix);
//            					if(reservation!=null) {
//            						System.out.println("reservation effectué avec success !");
//            						System.out.println("N° reservation: "+reservation.getIdReservation());
//            						System.out.println("Hotel "+reservation.getNomHotel());
//            						System.out.println("N° de Chambre: "+reservation.getNumChambre());
//            						System.out.println("Nom Client: "+reservation.getNomClient());
//            						System.out.println("Prenom Client: "+reservation.getPrenomClient());
//            						System.out.println("N° Carte Bancaire: "+reservation.getNumcarteCB());
//            						System.out.println("Du :"+reservation.getDateArrive());
//            						System.out.println("Au :"+reservation.getDateDepart());
//            						System.out.println("prix par nuit :"+reservation.getPrixparnuit()+"euro");
//            						System.out.println("prix total du sejour :"+reservation.getPrixtotal()+"euro");
            //
            //
//            						cmp++;
//            						break;
//            					}
//            					else
//            						System.out.println("reservation echoué");
//            					
            					
            					
            				}
            				
            				
            			}
                    	if (cmp==0) {
            				System.out.println("offre ou chambre indisponible");

                    	}

                        // Appel au service REST pour effectuer la réservation
//                        ResponseEntity<String> reservationResponse = createReservation(nOffre, IdAgence);
//                        String reservationStatus = reservationResponse.getBody();

//                        if (reservationStatus != null && reservationStatus.equals("success")) {
//                            System.out.println("Réservation effectuée avec succès !");
//                            // Affichez les détails de la réservation comme vous le faisiez dans le service
//                            // SOAP
//                            // ...
//                            cmp++;
//                        } else {
//                            System.out.println("Réservation échouée");
//                        }
                    }

                
                    // Ajoutez ici le code correspondant à cette option
    				else System.out.println("chambre ou offre indisponible");

                    break;

                case 3:
                    System.out.println("Vous avez choisi de quitter le programme. Au revoir !");
                    continuer = false; // Met fin à la boucle
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }

        // Fermeture du scanner
        scanner.close();
        
        
        
    }

    private static List<Object[]> getOffres(String ville, int nombreEtoilee, int nombrePersonne, int IdAgence,
            Double prixMin, Double prixMax, String dateArrive, String dateDepart) {
        // Utilisez RestTemplate pour faire un appel GET au service REST
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/service/api/hotels?ville=" + ville + "&nombreEtoile=" + nombreEtoilee
                + "&nombreLit=" + nombrePersonne + "&idAgence=" + IdAgence + "&prixMin=" + prixMin + "&prixMax=" + prixMax
                + "&dateEntree=" + dateArrive + "&dateSortie=" + dateDepart;

       // ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
        ResponseEntity<List<Object[]>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Object[]>>() {}
        );
        return response.getBody();
    }
    
    private static List<Object[]> getOffresC(String ville, int nombreEtoilee, int nombrePersonne,
            Double prixMin, Double prixMax, String dateArrive, String dateDepart) {
        // Utilisez RestTemplate pour faire un appel GET au service REST
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/service/api/comparator?ville=" + ville + "&nombreEtoile=" + nombreEtoilee
                + "&nombreLit=" + nombrePersonne + "&prixMin=" + prixMin + "&prixMax=" + prixMax
                + "&dateEntree=" + dateArrive + "&dateSortie=" + dateDepart;

       // ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
        ResponseEntity<List<Object[]>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Object[]>>() {}
        );
        return response.getBody();
    }
    private static java.sql.Date convertStringToDate(String dateString) throws Exception {
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date utilDate = format.parse(dateString);
	    return new java.sql.Date(utilDate.getTime());
	}

    //private static ResponseEntity<String> createReservation(int nOffre, int IdAgence) {
        // Utilisez RestTemplate pour faire un appel POST au service REST
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/employeeservice/api/reservation";

        // Remplacez les valeurs ci-dessous par les détails nécessaires pour créer une
        // réservation
        // ...
//        String requestBody = "{\"key\":\"value\"}";

//        return restTemplate.postForEntity(url, requestBody, String.class);
    //}
}
