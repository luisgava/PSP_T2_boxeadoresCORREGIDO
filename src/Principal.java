import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) throws Exception {
		//Creamos el ring
		Ring ring = new Ring();
		
		//Creamos 4 boxeadores
		Boxeador boxeador1 = new Boxeador("Boxeador 1", ring);
		Boxeador boxeador2 = new Boxeador("Boxeador 2", ring);
		Boxeador boxeador3 = new Boxeador("Boxeador 3", ring);
		Boxeador boxeador4 = new Boxeador("Boxeador 4", ring);
		
		List<Boxeador> boxeadores = new ArrayList();
		boxeadores.add(boxeador1);
		boxeadores.add(boxeador2);
		boxeadores.add(boxeador3);
		boxeadores.add(boxeador4);
		
		//fijar rivales (se pueden pegar a si mismos)
		boxeador1.setRival(boxeadores.get((int)(4 * Math.random())));
		boxeador2.setRival(boxeadores.get((int)(4 * Math.random())));
		boxeador3.setRival(boxeadores.get((int)(4 * Math.random())));
		boxeador4.setRival(boxeadores.get((int)(4 * Math.random())));
		
		//arrancar
		boxeador1.start();
		boxeador2.start();
		boxeador3.start();
		boxeador4.start();
		
		//esperar a que terminen
		boxeador1.join();
		boxeador2.join();
		boxeador3.join();
		boxeador4.join();
		
		//mostrar golpes dados y recibidos
		System.out.println(boxeador1);
		System.out.println(boxeador2);
		System.out.println(boxeador3);
		System.out.println(boxeador4);

	}

}
