package academia;

import java.io.Serializable;

/**
 * Modulo que se encarga de gestionar los esultados de los ejercicios y preguntas
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class Resultado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int nia;
	double nota;

	
	
	/**
	 * Constructor de la clase Resultado
	 * @param nia: NIA del alumno 
	 * @param nota: Nota del alumno
	 */
	public Resultado(int nia, double nota) {
		this.nia = nia;
		this.nota = nota;
	}
	/**
	 * Funcion que obtiene el nia del alumno
	 * @return nia del alumno
	 */
	public int getNia() {
		return nia;
	}
	
	/**
	 * Funcion que modifica el nia del alumno
	 * @param nia: nuevo nia
	 */
	public void setNia(int nia) {
		this.nia = nia;
	}
	/**
	 * Funcion que obtiene la nota del alumno
	 * @return nota del alumno
	 */
	public double getNota() {
		return nota;
	}
	
	/**
	 *Funcion que modifica la nota del alumno 
	 * @param nota: nueva nota
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}
	@Override
	/**
	 * Funcion que impime los datos de un resultado
	 * @return Cadena con todos los datos de un resultado
	 */
	public String toString() {
		return "Resultado [nia=" + nia + ", nota=" + nota + "]\n";
	}

	
	
	

}
