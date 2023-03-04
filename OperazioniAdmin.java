import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class OperazioniAdmin {

	private static ArrayList<String> piatti = new ArrayList<String>(Arrays.asList(GestioneRistorante.listFood));     //ArrayList derivato dal menù 
	
	public static void esegui() {
		
		boolean exit = false;                                   //esci dal ciclo while delle operazioni admin
		int operation1 = 0;                                     //operazione 1
		Scanner inInt = new Scanner(System.in);
		Scanner inString = new Scanner(System.in);
		String nomePiatto = "";                                 //variabile per l'input del nome del piatto
		String ingredienti = "";								//variabile per l'input degli ingredienti
		int prezzo = 0;											//variabile per l'input del prezzo
		int codice = 0;											//variabile per la scelta del piatto da modificare
		int index = 0;											//variabile di aiuto per la modifica del menù
		
		while (!exit) {
			/*Scegli quale operazione fare*/
			System.out.println("Premi 0 per chiudere menù admin, premi 1 per aggiungere un piatto, 2 per eliminare un piatto, 3 per modificare un piatto");
			operation1 = inInt.nextInt();
			
			switch (operation1) {
			/*Chiudi menù admin*/
			case 0:
				exit = true;
				break;
			/*Aggiungi un nuovo piatto*/	
			case 1:
				System.out.println("Nome nuovo piatto:");
				nomePiatto = inString.nextLine();
				System.out.println("Ingredienti nuovo piatto:");
				ingredienti = inString.nextLine();
				System.out.println("Prezzo nuovo piatto:");
				prezzo = inString.nextInt();
				piatti.add((GestioneRistorante.listFood.length + 1) + "," + nomePiatto + "," + ingredienti + "," + prezzo);
				GestioneRistorante.listFood = piatti.toArray(GestioneRistorante.listFood);
				GestioneRistorante.numeroPiatti++;
				System.out.println("Piatto aggiunto");
				break;
			/*Elimina piatto*/	
			case 2:
				System.out.println("Codice piatto da eliminare:");
				codice = inInt.nextInt();
				piatti.remove(codice - 1);
				/*Modifica del codice dei piatti, necessaria per poter ordinare*/
				for (int i=0; i<piatti.size(); i++) {
					index = piatti.get(i).indexOf(",");
					piatti.set(i, (i + 1) + piatti.get(i).substring(index));
				}
				GestioneRistorante.listFood = piatti.toArray(GestioneRistorante.listFood);
				GestioneRistorante.numeroPiatti--;
				System.out.println("Piatto eliminato");
				break;
			/*Modifica piatto*/	
			case 3:
				System.out.println("Codice piatto da modificare:");
				codice = inInt.nextInt();
				System.out.println("Nuovo nome del piatto:");
				nomePiatto = inString.nextLine();
				System.out.println("Nuovi ingredienti del piatto:");
				ingredienti = inString.nextLine();
				System.out.println("Nuovo prezzo del piatto:");
				prezzo = inString.nextInt();
				piatti.set(codice - 1, codice + "," + nomePiatto + "," + ingredienti + "," + prezzo);
				GestioneRistorante.listFood = piatti.toArray(GestioneRistorante.listFood);
				System.out.println("Piatto modificato");
				break;
			/*Comando non valido*/	
			default:
				System.out.println("Comando non valido");
			break;
			}
		}
	}
}
