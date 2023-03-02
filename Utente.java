
public class Utente {
	private String nome;
	private String password;
	private int id;
	private boolean admin;
	
	public Utente() {
		
	}
	
	public Utente(String nome, String password, int id, boolean admin) {
		this.nome = nome;
		this.password = password;
		this.id = id;
		this.admin = admin;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean getAdmin() {
		return this.admin;
	}
}
