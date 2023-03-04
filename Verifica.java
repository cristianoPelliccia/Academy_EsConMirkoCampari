import java.util.ArrayList;
import java.util.Arrays;

public class Verifica {

	public static void main(String[] args) {
		
		GestioneUtente.imposta();
		
		while (!GestioneUtente.close) {
			GestioneUtente.esegui();
		
			if (GestioneUtente.logged && GestioneUtente.attuale.getAdmin()) {
				OperazioniAdmin.esegui();
			}
		
			if (GestioneUtente.logged) {
				GestioneRistorante.esegui();
				if (GestioneRistorante.spesa > 0) {
					System.out.println("Grazie " + GestioneUtente.attuale.getNome() + " per aver ordinato!");
					System.out.println("Hai speso " + GestioneRistorante.spesa + "$");
				}
			}
		}
		System.out.println("Applicazione chiusa");
	}
}
