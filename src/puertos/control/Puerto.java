package puertos.control;

import java.util.ArrayList;
import java.util.List;

import puertos.entidades.Barco;
import puertos.entidades.Carguero;
import puertos.entidades.Velero;

/**
 * Clase donde se registran los barcos que llegan al puerto,
 * y tiene la principales funciones del programa (es el control).
 * @version 2.0
 */
public class Puerto {

	private List<Barco> barcos;
	
	public Puerto() {
		barcos = new ArrayList<Barco>();
	}
	
	/**
	 * Calcula la capacidad de todos los barcos en el puerto,
	 * para poder determinar la carga que puede recibir.
	 * @return	la capacidad total de los barcos, en m3
	 */
	public double calcularCapacidadTotal() {
		double capacidadTotal = 0;
		for (Barco barco : barcos) {
			capacidadTotal += barco.calcularCapacidad();
		}
		return capacidadTotal;
	}
	
	/**
	 * Se adiciona un barco al puerto, es decir, se registra su información y se guarda.
	 * @see puertos.entidades.Barco#Barco(String, String, double)
	 * @param tipo	qué tipo de barco es: 'v' para velero, 'c' para carguero
	 * @param pasajeros	la cantidad de pasajeros que lleva el barco (solo sirve para veleros)
	 * @param liquidos	indicación (true/false) de si puede llevar líquidos o no (solo aplica para cargueros)
	 */
	public void adicionarBarco(String matricula, String nacionalidad, double volumen, char tipo, int pasajeros, boolean liquidos) {
		switch (tipo){
			case 'v':
			case 'V': 	barcos.add(new Velero(matricula,nacionalidad,volumen, pasajeros));
						break;
			case 'c':
			case 'C': 	barcos.add(new Carguero(matricula,nacionalidad,volumen, liquidos));
						break;
		}
	}

}
