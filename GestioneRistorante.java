import java.util.Scanner;

public class GestioneRistorante {

	static int spesa = 0;															//Spesa totale
	static String[] listFood = {"1,Pasta al sugo,pasta fresca e pomodoro,10",		//Lista dei piatti
	 							"2,Polpette al sugo,carne e pomodoro,15"};			
	static int numeroPiatti = 2;													//Numero di piatti disponibili nel menu
	
	public static void esegui() {
		Scanner inInt = new Scanner(System.in);
		String[] temp = {"","","",""};												//Stringa di appoggio per stampa menu
		boolean exit = false;														//Esci dal ciclo while principale
		int operation1 = 0;															//Operazione 1
		
		spesa = 0; 																	//resetta il valore di spesa
		
		while (!exit) {
			System.out.println("Scrivi 0 per chiuder l'ordine o il codice del piatto da ordinare o 99 per visualizzare tutti i piatti disponibili");
			operation1 = inInt.nextInt();
			/*Visualizzazione menù*/
			if (operation1 == 99) {
				for (int i=0; i<listFood.length; i++) {
					if (listFood[i] != null) {
						temp = listFood[i].split(",");
						System.out.println(temp[0] + " - " + temp[1] + ": " + temp[2]);	
					}
				}
			/*Chiusura ordine*/
			}else if(operation1 == 0){
				exit = true;
			/*Ordinazione piatto*/
			}else if(operation1 <= numeroPiatti){
				System.out.println("Hai ordinato: " + listFood[operation1 -1].split(",")[1]);	
				spesa += Integer.valueOf(listFood[operation1 -1].split(",")[3]);
			/*Comando non valido*/
			} else {
				System.out.println("Piatto inesistente");	
			}
		}
	}
}




