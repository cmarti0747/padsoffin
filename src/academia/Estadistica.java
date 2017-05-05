 package academia;

import java.io.Serializable;

/**
 * Modulo que se encarga de gestionar las estadisticas de los ejercicios
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class Estadistica implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numContestadosCorrectos;
	private int numContestadosIncorrectos;
	private int sinContestar;
	
	/**
	 * Constructor de la clase Estadistica
	 */
	public Estadistica(){
		this.numContestadosCorrectos=0;
		this.numContestadosIncorrectos=0;
		this.sinContestar=0;
	}

	/**
	 * funcion que obtiene el numero de contestados correctos
	 * @return contestados corectos
	 */
	public int getNumContestadosCorrectos() {
		return numContestadosCorrectos;
	}

	/**
	 * funcion que modifica el numero de contestados correctos
	 * @param numContestadosCorrectos: nuevos contestados correctos
	 */
	public void setNumContestadosCorrectos(int numContestadosCorrectos) {
		this.numContestadosCorrectos = numContestadosCorrectos;
	}

	/**
	 * funcion que obtiene el numero de contestados incorectos
	 * @return contestados incorrectos
	 */
	public int getNumContestadosIncorrectos() {
		return numContestadosIncorrectos;
	}

	/**
	 * funcion que modifica los contestados incorectos
	 * @param numContestadosIncorrectos: nuevos contestados incorrectos
	 */
	public void setNumContestadosIncorrectos(int numContestadosIncorrectos) {
		this.numContestadosIncorrectos = numContestadosIncorrectos;
	}

	/**
	 * funcion que obtiene los sin contestar
	 * @return sin contestar
	 */
	public int getSinContestar() {
		return sinContestar;
	}

	/**
	 * funcion que modifica los sin contestar
	 * @param sinContestar: nuevo sin contestar
	 */
	public void setSinContestar(int sinContestar) {
		this.sinContestar = sinContestar;
	}
	
	/**
	 * funcion que incrementa en uno los contestados incorectos
	 */
	public void sumarContestadosIncorrectos(){
		this.numContestadosIncorrectos=this.numContestadosIncorrectos+1;
		
	}
	
	/**
	 * funcion que decrementa en uno los contestados incorectos
	 */
	public void restarContestadosIncorrectos(){
		this.numContestadosIncorrectos=this.numContestadosIncorrectos-1;
		
	}
	
	/**
	 * funcion que incrementa en uno los contestados correctos
	 */
	public void sumarContestadosCorrectos(){
		this.numContestadosCorrectos=this.numContestadosCorrectos+1;
		
	}
	
	/**
	 * funcion que decrementa en uno los contestados corectos
	 */
	public void restarContestadosCorrectos(){
		this.numContestadosCorrectos=this.numContestadosCorrectos-1;
		
	}
	
	
	/**
	 * funcion que decrementa en uno los sin contestar
	 */
	public void restarSinContestar(){
		this.sinContestar=this.sinContestar-1;
		
	}
	
	/**
	 * funcion que aumenta en uno los sin contestar
	 */
	public void sumarSinContestar(){
		this.sinContestar=this.sinContestar+1;
		
	}

	@Override
	/**
	 * funcion que imprime los datos de una estadistica
	 * @return cadena con todos los datos de estadistica
	 */
	public String toString() {
		return "Estadistica [numContestadosCorrectos=" + numContestadosCorrectos + ", numContestadosIncorrectos="
				+ numContestadosIncorrectos + ", sinContestar=" + sinContestar + "]";
	}

	
	

}
