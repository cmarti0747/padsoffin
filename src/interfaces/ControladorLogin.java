package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import academia.AcademiaLopez;

/**
 * Modulo de la clase ControladorLogin
 * @author e336706
 *
 */
public class ControladorLogin {

	private VistaLogin vista;
	private AcademiaLopez academia;

	/**
	 * Constructor de la clase ControladorLogin
	 * @param vista panel del login
	 * @param academia academia
	 */
	public ControladorLogin(VistaLogin vista, AcademiaLopez academia) {

		this.vista = vista;
		this.academia = academia;
		

	}

	/**
	 * Funcion que entra en la aplicacion
	 * @throws FileNotFoundException file no encontrado
	 * @throws ClassNotFoundException clase no encontrada
	 * @throws IOException IO exception
	 */
	public void entrar() throws FileNotFoundException, ClassNotFoundException, IOException {
		char[] pas = vista.getPassword();
		String nie = vista.getNia2();
		if (pas.length != 0 && nie.isEmpty() == false) {
			String pass = new String(pas);
			int nia = Integer.parseInt(nie);
			if ( academia.loggin(nia, pass) == null) {
				JOptionPane.showMessageDialog(null, "Ese usuario no existe");
			}else{

				PanelControlador vista = new PanelControlador();
				ControladorPanelControlador controlador = new ControladorPanelControlador(vista,this.academia);
				
				vista.setControlador(controlador);
				controlador.cargarDatos();
				vista.login();
				this.vista.setVisibilidad(false);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Introduce un nia y una contrasenia");
		}
	}

	/**
	 * Funcion que sale de la aplicacion
	 * @throws FileNotFoundException file no encontrado
	 * @throws IOException IO Exception
	 */
	public void salir() throws FileNotFoundException, IOException {
		System.exit(0);
	}

}
