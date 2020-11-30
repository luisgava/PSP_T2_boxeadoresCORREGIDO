
public class Boxeador extends Thread {
	
	private Ring ring;
	private boolean booNoqueado;
	private int golpesDados;
	private int golpesRecibidosTotales;
	private Boxeador rival;
	private int golpes;
	
	public Boxeador(String nombre, Ring ring) {
		
		this.setName(nombre);
		this.ring = ring;
		this.booNoqueado = false;
		this.golpesDados = 0;
		this.golpesRecibidosTotales = 0;
	}
	
	public void setRival(Boxeador rival) {
		this.rival = rival;
		System.out.println("El rival de "+this.getName()+" es "+rival.getName());
	}
	
	public int getGolpes() {
		return this.golpesDados;
	}
	
	public void pegar() {
		golpesDados = golpesDados + 1;
	}
	
	public void recibir() {
		golpesRecibidosTotales = golpesRecibidosTotales + 1;
		
		if (this.golpes >= 3) {
			booNoqueado = true;
			this.golpes = 0;
		}
		else {
			this.golpes = this.golpes + 1;
		}
	}
	
	@Override
	public void run() {
		
		while (ring.getNumCombates() < 100) {
			
			if (booNoqueado) {
				System.out.println("-- "+this.getName()+" está noqueado.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {}
				
				booNoqueado = false;
			}
			else {
				ring.competir(this, this.rival);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ie) {}
			}
		}
	}

	@Override
	public String toString() {
		return this.getName()+" [golpesDados=" + golpesDados + ", golpesRecibidos=" + golpesRecibidosTotales + "]";
	}

	

}
