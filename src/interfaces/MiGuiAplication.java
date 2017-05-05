package interfaces;

import academia.AcademiaLopez;

public class MiGuiAplication {

	public static void main(String[] args) {
		
		VistaLogin vista = new VistaLogin();
		
		AcademiaLopez academia = new AcademiaLopez();
		
		ControladorLogin controlaLogin = new ControladorLogin(vista,academia);
		
		vista.setControlador(controlaLogin);
		//VistaHomeAlumno vista2 = new VistaHomeAlumno();
		

	}

}
