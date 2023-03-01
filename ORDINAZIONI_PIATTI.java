import java.util.ArrayList;
import java.util.Scanner;

public class ORDINAZIONI_PIATTI {

	public static void main(String[] args) {
		Scanner inInt = new Scanner(System.in);
		String[] listFood = {"1,Pasta al sugo,pasta fresca e pomodoro,10",
							 "2,Polpette al sugo,carne e pomodoro,15"};
		String[] temp = {"","","",""};
		boolean exit = false;
		int operation1 = 0;
		int operation2 = 0;
		int spesa = 0;
		
		while (!exit) {
			System.out.println("Scrivi 1 per ordinare o 0 per uscire");
			operation1 = inInt.nextInt();
			if (operation1 == 1) {
				System.out.println("Scrivi 0 per visualizzare tutti i piatti disponibili o il codice del piatto da ordinare");
				operation2 = inInt.nextInt();
				if (operation2 == 0) {
					for (int i=0; i<listFood.length; i++) {
						temp = listFood[i].split(",");
						System.out.println(temp[0] + " - " + temp[1] + ": " + temp[2]);	
					}
				}else {
					System.out.println("Hai ordinato: " + listFood[operation2 -1].split(",")[1]);	
					spesa += Integer.valueOf(listFood[operation2 -1].split(",")[3]);
				}
			} else {
				exit = true;
				System.out.println("Hai speso " + spesa + "$");
			}
			System.out.println("");
		}
	}

}
