
public class Ring {
	
	private static Object object = new Object();
	private int numCombates;
	
	public int getNumCombates() {
		synchronized (object) {
			return numCombates;
		}
	}
	
	public void competir(Boxeador boxeador1, Boxeador boxeador2) {
		
		//boxeador 1 pega
		boxeador1.pegar();
		//boxeador 2 recibe
		boxeador2.recibir();
		
		//aumentar el numero de golpes en el ring
		synchronized (object) {
			numCombates++;
		}		
		
		System.out.println(boxeador1.getName() + " pega a " + boxeador2.getName());
	}

}
