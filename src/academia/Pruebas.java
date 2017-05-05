package academia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pruebas {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		AcademiaLopez aca = new AcademiaLopez();
		Asignaturas a;
		Usuario u1=null,u2;
		ArrayList<Temas> temas;
		ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
		List<Matriculado> m =new ArrayList<Matriculado>();
		ArrayList <Respuesta> respuestas = new ArrayList<Respuesta>();
		ArrayList <Respuesta> respuestas2 = new ArrayList<Respuesta>();
		//Accedemos con el profesor
		u1 = aca.loggin(1234, "prof");
		System.out.println(u1);
		//intenta acceder otro usuario
		aca.loggin(2562, "o.Navro.Navar");
		//Se crea una asignatura
		aca.crearAsignaturas("PADSOF");
		//Se busca esa asignatura y se crean dos temas dentro
		a=aca.buscarAsignatura("PADSOF");
		a.crearTemas("TEMA1");
		System.out.println(a);
		a.crearTemas("TEMA2");
		System.out.println(a);
		//Se cambia la visibilidas de la asignatura
		a.setVisibilidad(academia.Visibilidad.VISIBLE);
		System.out.println(a);
		//Se obtiene un tema
		temas=a.getTemas();
		
			//Se crea un subtema, un ejercicio y unos apuntes en el primer tema que haya
			temas.get(0).crearSubTemas("SUBTEMAS");
			temas.get(0).crearEjercicio("EJERCICIO1",LocalDate.now(), LocalDate.parse("2073-04-10"),2,5);
			temas.get(0).crearApuntes("Apuntes", "Esta asignatura es la mejor.");
			System.out.println(temas.get(0));
		
		//Se desconecta el profesor
		u1=aca.desconectar();
		
		//Se conecta un alumno
		u1 = aca.loggin(2562, "o.Navro.Navar");
		System.out.println(u1);
		//Busca una asignatura y solicita una matricula
		a=aca.buscarAsignatura("PADSOF");
		u1.solicitudAsignatura(a);
		//Se imprime la academia
		System.out.println(aca);
		//Se desconecta el alumno
		u1=aca.desconectar();
		//SE conecta el profesor y acepta todas las matriculas que haya
		u1=aca.loggin(1234,"prof");
		m=AcademiaLopez.getMatriculas();
		for(int i=0;i<m.size();i++){
			u1.aceptarAsignaturas(m.get(i));
			System.out.println(m.get(i));
		}
		//Se desconecta el profesor
		u1=aca.desconectar();
		//Hace login otro alumno y solicita otra matricula a la misma asignatura
		u1 = aca.loggin(2514, "rme.Mora");
		System.out.println(u1);
		a=aca.buscarAsignatura("PADSOF");
		u1.solicitudAsignatura(a);
		//Se desconecta el alumno
		u1=aca.desconectar();
		//Se conecta el profesor y acepta todas las solicitudes que haya
		u1=aca.loggin(1234,"prof");
		m=AcademiaLopez.getMatriculas();
		for(int i=0;i<m.size();i++){
			u1.aceptarAsignaturas(m.get(i));
			System.out.println(m.get(i));
		}
		//En el ejercicio que hay crea 4 preguntas, una de cada tipo
		ejercicios=temas.get(0).getEjercicios();
		int [] sol ={1,2};
			ejercicios.get(0).crearPreguntaLibre("Cuanto es 2+2? Responde con el numero:",2, "4",false);
			ejercicios.get(0).crearPreguntaUnica("Cuanto es 1+1? a. 2 b. 3 c. 4",3,1,false);
			ejercicios.get(0).crearPreguntaUnica("Es 1+1=2? a. Verdadero b. Falso",2,1,false);
			ejercicios.get(0).crearPreguntaMultiple("Eres estudiante? a. si b. si,pero de instituto c. no",1,sol,false);
		
		//Se desconecta el profesor
		u1=aca.desconectar();
		//Se conecta el alumno y responde al ejercicio
		u1=aca.loggin(2562, "o.Navro.Navar");
		int [] solu ={1,2};
		Respuesta resl = new RespuestaLibre(u1.getNia(),"3");
		respuestas.add(resl);
		Respuesta resu = new RespuestaUnica(u1.getNia(),1);
		respuestas.add(resu);
		resu = new RespuestaUnica(u1.getNia(),1);
		respuestas.add(resu);
		Respuesta resm = new RespuestaMultiple(u1.getNia(),solu);
		respuestas.add(resm);
		//Termina el ejercicio
		ejercicios.get(0).terminarEjercicio(respuestas, u1.getNia());
		//Se desconecta el alumno
		u1=aca.desconectar();
		//Se conecta el alumno y responde al ejercicio
		u1=aca.loggin(2514, "rme.Mora");
		int[]soluc ={1,3};
		Respuesta res1 = new RespuestaLibre(u1.getNia(),"3");
		respuestas2.add(res1);
		Respuesta res2 = new RespuestaUnica(u1.getNia(),1);
		respuestas2.add(res2);
		Respuesta res3 = new RespuestaUnica(u1.getNia(),2);
		respuestas2.add(res3);
		Respuesta res4 = new RespuestaMultiple(u1.getNia(),soluc);
		respuestas2.add(res4);
		//Termina el ejercicio
		ejercicios.get(0).terminarEjercicio(respuestas2, u1.getNia());
		//Se desconecta el alumno
		u1=aca.desconectar();
		//Se imprimen los resultados de todos los alumnos
		for(int i = 0;i<ejercicios.get(0).getResultados().size();i++){
			System.out.println(ejercicios.get(0).getResultados().get(i));
		}
		
		//Se muestran las estadisticas
		ejercicios.get(0).MostrarEstadisticas();
		//Se conecta el profesor
		u1=aca.loggin(1234, "prof");
		//Busca a un alumno, lo expulsa y luego lo readmite
		u2=aca.buscarAlumno(2514);
		a.expulsarAlumno((Alumno)u2);
		
		a.readmitirAlumno((Alumno)u2);
		
		
		
	}

}
