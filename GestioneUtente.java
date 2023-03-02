import java.util.ArrayList;
import java.util.Scanner;

public class GestioneUtente {

	public static void main(String[] args) {
		ArrayList<Utente> utenti = new ArrayList<Utente>();
		boolean exitGestioneUtenti = false;
		int operation1 = 0;
		Scanner inInt = new Scanner(System.in);
		Scanner inString = new Scanner(System.in);
		String nomeUtente = "";
		String password = "";
		boolean esiste = false;
		boolean logged = false;
		
		Utente cristiano = new Utente("Cristiano", "Pelliccia", 1, true);
		Utente guest = new Utente("Guest", "Guest", 2, false);
		Utente attuale = new Utente();
		int nextId = 3;

		utenti.add(cristiano);
		utenti.add(guest);
		while (!exitGestioneUtenti) {
			System.out.println("Premi 0 per uscire, premi 1 per login, 2 per registrarti");
			operation1 = inInt.nextInt();
			switch (operation1) {
			case 0:
				exitGestioneUtenti = true;
				break;
				
			case 1:
				System.out.println("Nome utente:");
				nomeUtente = inString.nextLine();
				System.out.println("Password:");
				password = inString.nextLine();
				for (int i = 0; i < utenti.size(); i++) {
					if ((utenti.get(i).getNome().equals(nomeUtente)) && (utenti.get(i).getPassword().equals(password))) {
						logged = true;
						attuale = utenti.get(i);
						System.out.println("Accesso eseguito");
					}
				}
				break;
			
			case 2:
				System.out.println("Scegli nome utente:");
				nomeUtente = inString.nextLine();
				System.out.println("Scegli password:");
				password = inString.nextLine();
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
			}
		
		
		}
	}

}
