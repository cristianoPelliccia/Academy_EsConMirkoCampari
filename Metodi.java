
public class Metodi {

	/*Metodo somma, prende in ingresso due interi e 
	 * restituisce direttamente il risultato della loro somma, non sono necessarie conversioni*/
	public static int somma(int a, int b) {
		return (a + b);
	}
	
	/*Metodo media, prende in input un array di interi e restituisce la loro media, poichè
	 * effettuare la divisione direttamente su un valore intero porterebbe alla perdita delle cifre decimali
	 * (se esistenti) si effettua unaconversione in double di tutti gli elementi dell'array prima di sommarli */
	public static double media(int[] num) {
		double media = 0;
		
		for (int i = 0; i < num.length; i++) {
			media += (double)num[i];
		}
		
		media /= num.length;
		
		return media;
	}
	
	/*Metodo inverti, prende una stringa in ingresso e ne restituisce una uguale ma invertita,
	 * si utilizza il metodo .charAt() per leggere i singoli caratteri della stringa (dall'ultimo al primo)
	 * in un ciclo for e concatenarli alla stringa (vuota in partenza) che verrà restituita*/
	public static String inverti(String par) {
		String result = "";
		
		for (int i = 0; i < par.length(); i++) {
			result += par.charAt(par.length() -1 - i);
		} 
		
		return result;
	}
	
	/*Esempio applicazioni dei metodi sopra scritti*/
	public static void main(String[] args) {
		int result1;
		double result2;
		int [] arr = {2, 4, 6, 8, 10};
		
		result1 = somma(5, 7);
		result2 = media(arr);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(inverti("ciao"));
	}
}
