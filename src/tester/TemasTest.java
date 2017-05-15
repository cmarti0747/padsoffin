package tester;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import academia.Asignaturas;
import academia.Temas;

public class TemasTest {

	Asignaturas asignatura;
	Temas tema;

	@Before
	public void before() {
		tema = new Temas("Titulo1");
	}

	@Test
	public void testGetTitulo() {
		assertEquals("Titulo1", tema.getTitulo());
	}

	@Test
	public void testSetTitulo() {
		tema.setTitulo("Titulo2");
		assertEquals("Titulo2", tema.getTitulo());
	}

	@Test
	public void testGetVisibilidad() {
		assertEquals(academia.Visibilidad.INVISIBLE, tema.getVisibilidad());
	}

	@Test
	public void testModificarTema() {
		tema.setTitulo("Titulo2");

		tema.setVisibilidad(academia.Visibilidad.VISIBLE_COMENZADO);
		assertEquals("Titulo2", tema.getTitulo());

		assertEquals(academia.Visibilidad.VISIBLE_COMENZADO, tema.getVisibilidad());
	}

	@Test
	public void testEliminarSubTema() {
		tema.crearSubTemas("TituloAux");
		assertEquals(1, tema.getSubtemas().size());
		assertEquals("TituloAux", tema.getSubtemas().get(0).getTitulo());
		tema.eliminarSubTema(tema.getSubtemas().get(0));

		assertEquals(0, tema.getSubtemas().size());

	}

	@Test
	public void testCrearApuntes() {
		tema.crearApuntes("TituloAux", "TextoAux");
		assertEquals(1, tema.getApuntes().size());
		assertEquals("TituloAux", tema.getApuntes().get(0).getTitulo());
		assertEquals("TextoAux", tema.getApuntes().get(0).getTexto());

	}

	@Test
	public void testCrearSubtemas() {

		tema.crearSubTemas("TituloAux");
		assertEquals(1, tema.getSubtemas().size());
		assertEquals("TituloAux", tema.getSubtemas().get(0).getTitulo());
	}

	@Test
	public void testSetVisibilidad() {
		tema.setVisibilidad(academia.Visibilidad.VISIBLE_COMENZADO);
		assertEquals(academia.Visibilidad.VISIBLE_COMENZADO, tema.getVisibilidad());
	}

	@Test
	public void testCrearEjercicio() {
		tema.crearEjercicio("TituloAux", LocalDate.now(), LocalDate.now(), 1.0, 0);
		assertEquals(1, tema.getEjercicios().size());
		assertEquals("TituloAux", tema.getEjercicios().get(0).getTitulo());
		assertEquals(LocalDate.now(), tema.getEjercicios().get(0).getFechaInicio());
		assertEquals(LocalDate.now(), tema.getEjercicios().get(0).getFechaFin());
		assertEquals(1.0, tema.getEjercicios().get(0).getNota(), 0);

	}

	@Test
	public void testEliminarEjercicio() {
		tema.crearEjercicio("TituloAux", LocalDate.now(), LocalDate.now(), 1.0, 0);
		assertEquals(1, tema.getEjercicios().size());
		assertEquals("TituloAux", tema.getEjercicios().get(0).getTitulo());
		assertEquals(LocalDate.now(), tema.getEjercicios().get(0).getFechaInicio());
		assertEquals(LocalDate.now(), tema.getEjercicios().get(0).getFechaFin());
		assertEquals(1.0, tema.getEjercicios().get(0).getNota(), 0);
		tema.eliminarEjercicio(tema.getEjercicios().get(0));

		assertEquals(0, tema.getEjercicios().size());
	}

	@Test
	public void testGetSubtemas() {

		assertEquals(0, tema.getSubtemas().size());

	}

	@Test
	public void testEliminarApuntes() {

		tema.crearApuntes("TituloAux", "TextoAux");
		assertEquals(1, tema.getApuntes().size());
		assertEquals("TituloAux", tema.getApuntes().get(0).getTitulo());
		assertEquals("TextoAux", tema.getApuntes().get(0).getTexto());
		tema.eliminarApuntes(tema.getApuntes().get(0));
		assertEquals(0, tema.getApuntes().size());

	}

}
