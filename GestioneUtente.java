import java.util.ArrayList;
import java.util.Scanner;

public class GestioneUtente {
	
	static boolean close = false;															//chiudi applicazione
	static boolean logged = false;															//un utente è loggato
	static Utente attuale = new Utente();                                                   //utente attuale
	private static Utente cristiano = new Utente("Cristiano", "Pelliccia", 1, true);  		//utente admin
	private static Utente guest = new Utente("Guest", "Guest", 2, false);					//utente guest
	private static int nextId = 3;															//ID del prossimo nuovo utente
	private static ArrayList<Utente> utenti = new ArrayList<Utente>();						//ArrayList di tutti gli utenti
  
	/*Metodo che imposta gli utenti di default*/
	public static void imposta() {
		utenti.add(cristiano);
		utenti.add(guest);
	}
	
	public static void esegui() {
		boolean exit = false;																//chiudi gestione utenti
		int operation1 = 0;																	//opearzione 1
		Scanner inInt = new Scanner(System.in);
		Scanner inString = new Scanner(System.in);
		String nomeUtente = "";																//variabile per input nome utente
		String password = "";																//variabile per input password
		boolean esiste = false;                                                             //utente esiste
		
		
		while (!exit) {
			/*Scegli cosa fare*/
			System.out.println("Premi 0 per uscire, premi 1 per login, 2 per registrarti");
			operation1 = inInt.nextInt();
			/*Chiudi applicazione*/
			switch (operation1) {
			case 0:
				exit = true;
				logged = false;
				close = true;
				break;
			/*Login*/
			case 1:
				System.out.println("Nome utente:");
				nomeUtente = inString.nextLine();
				System.out.println("Password:");
				password = inString.nextLine();
				for (int i = 0; i < utenti.size(); i++) {
					if ((utenti.get(i).getNome().equals(nomeUtente)) && (utenti.get(i).getPassword().equals(password))) {
						logged = true;
						attuale = utenti.get(i);
						exit = true;
						System.out.println("Accesso eseguito");
					}
				}
				break;
			/*Nuovo utente*/
			case 2:
				System.out.println("Scegli nome utente:");
				nomeUtente = inString.nextLine();
				System.out.println("Scegli password:");
				password = inString.nextLine();
				/*Controlla che non esista già un utente con lo stesso nome*/
				for (int i = 0; i < utenti.size(); i++) {
					if (utenti.get(i).getNome().equals(nomeUtente)) {
						esiste = true;
					}
				}
				if (!esiste) {
					utenti.add(new Utente(nomeUtente, password, nextId, false));
					nextId++;
					System.out.println("Utente creato");
				}else {
					System.out.println("Nome utente non disponibile");
				}
				esiste = false;
				break;
			/*Comando non valido*/
			default:
				System.out.println("Comando non valido");
			break;
			}
		}
	}

}
