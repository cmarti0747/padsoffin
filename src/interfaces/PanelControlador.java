package interfaces;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import academia.Visibilidad;

public class PanelControlador {

	private JFrame ventana;
	private JPanel panelcontenedor;
	private ControladorPanelControlador controlador;
	private PanelHomeProfesor panelhomeprofesor;
	private PanelCrearAsignatura panelcrearasignatura;
	private JPanel ExitField;
	private JLabel icono;
	private Container academia;
	private JButton desconectar;
	private Container contenedor;
	private PanelAsignatura panelasignatura;
	private PanelCrearApuntes panelcrearapuntes;
	private PanelTema paneltema;
	private PanelCrearEjercicio panelcrearejercicio;
	private PanelCrearTema panelcreartema;
	private PanelHomeAlumno panelhomealumno;
	private CardLayout cl;
	private PanelAsignaturaAlumno panelasignaturaalumno;
	private PanelTemaAlumno paneltemaalumno;
	private PanelApuntes panelapuntes;
	private PanelApuntesAlumno panelapuntesalumno;
	private PanelCrearSubtema panelcrearsubtema;
	private PanelCrearLibre panelcrearlibre;
	private PanelCrearMultiple panelcrearmultiple;
	private PanelCrearTest panelcreartest;
	private PanelPreguntaLibre panelpreguntalibre;
	private PanelPreguntaTest panelpreguntaunica;
	private PanelPreguntaMultiple panelpreguntamultiple;
	private PanelEstadisticas panelestadistica;

	public PanelControlador() {

		ventana = new JFrame("Academia");

		contenedor = ventana.getContentPane();
		contenedor.setLayout(new BorderLayout());

		panelasignaturaalumno = new PanelAsignaturaAlumno();
		panelhomealumno = new PanelHomeAlumno();
		panelhomeprofesor = new PanelHomeProfesor();
		panelcrearasignatura = new PanelCrearAsignatura();
		panelasignatura = new PanelAsignatura();
		paneltema = new PanelTema();
		panelcrearapuntes = new PanelCrearApuntes();
		panelcrearejercicio = new PanelCrearEjercicio();
		panelcreartema = new PanelCrearTema();
		paneltemaalumno = new PanelTemaAlumno();
		panelcrearsubtema = new PanelCrearSubtema();
		panelapuntes = new PanelApuntes();
		panelapuntesalumno = new PanelApuntesAlumno();
		panelcrearlibre = new PanelCrearLibre();
		panelcrearmultiple = new PanelCrearMultiple();
		panelcreartest = new PanelCrearTest();
		panelpreguntalibre = new PanelPreguntaLibre();
		panelpreguntaunica = new PanelPreguntaTest();
		panelpreguntamultiple = new PanelPreguntaMultiple();
		panelestadistica = new PanelEstadisticas();

		panelcontenedor = new JPanel();

		desconectar = new JButton("Desconectar");

		ExitField = new JPanel();
		ExitField.setLayout(new BorderLayout());
		icono = new JLabel();
		academia = new JLabel("Academia Lopez");
		academia.setFont(new Font("Arial", Font.PLAIN, 70));
		icono.setIcon(new ImageIcon("src/imagenes/descarga.png"));
		ExitField.setBackground(new Color(255, 255, 255));
		ExitField.add(icono, BorderLayout.WEST);
		ExitField.add(academia, BorderLayout.CENTER);
		ExitField.add(desconectar, BorderLayout.EAST);

		desconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.desconectar();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error al desconectar");
				}
			}

		});

		cl = new CardLayout();

		panelcontenedor.setLayout(cl);
		panelcontenedor.add(panelasignatura, "panelAsignatura");
		panelcontenedor.add(panelhomeprofesor, "panelhomeProfesor");
		panelcontenedor.add(panelcrearasignatura, "panelcrearAsignatura");
		panelcontenedor.add(paneltema, "panelTema");
		panelcontenedor.add(panelcrearapuntes, "panelcrearApuntes");
		panelcontenedor.add(panelcrearejercicio, "panelcrearEjercicio");
		panelcontenedor.add(panelcreartema, "panelcrearTema");
		panelcontenedor.add(panelhomealumno, "panelhomeAlumno");
		panelcontenedor.add(panelasignaturaalumno, "panelasignaturaAlumno");
		panelcontenedor.add(paneltemaalumno, "paneltemaAlumno");
		panelcontenedor.add(panelapuntes, "panelApuntes");
		panelcontenedor.add(panelapuntesalumno, "panelapuntesAlumno");
		panelcontenedor.add(panelcrearsubtema, "panelcrearSubtema");
		panelcontenedor.add(panelcrearlibre, "panelcrearLibre");
		panelcontenedor.add(panelcrearmultiple, "panelcrearMultiple");
		panelcontenedor.add(panelcreartest, "panelcrearTest");
		panelcontenedor.add(panelpreguntalibre, "panelpreguntaLibre");
		panelcontenedor.add(panelpreguntaunica, "panelpreguntaUnica");
		panelcontenedor.add(panelpreguntamultiple, "panelpreguntaMultiple");
		panelcontenedor.add(panelestadistica, "panelEstadistica");

		contenedor.add(panelcontenedor, BorderLayout.CENTER);
		contenedor.add(ExitField, BorderLayout.NORTH);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setSize(1020, 850);
		ventana.setVisible(true);

		panelhomeprofesor.getCrearAsignatura().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelcontenedor, "panelcrearAsignatura");

			}
		});

		panelcrearasignatura.getVolver().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				cl.show(panelcontenedor, "panelhomeProfesor");

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// Estadisticas
				cl.show(panelcontenedor, "panelhomeProfesor");
			}
		});

		panelcrearasignatura.getCrear().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = panelcrearasignatura.getTitulo().getText();
				boolean visibilidad = panelcrearasignatura.getCheck1().isSelected();
				if (visibilidad == false) {
					controlador.crearAsignatura(titulo, Visibilidad.INVISIBLE);
				} else {
					controlador.crearAsignatura(titulo, Visibilidad.VISIBLE);
				}

				cl.show(panelcontenedor, "panelhomeProfesor");
				panelcrearasignatura.getTitulo().setText("");
				panelhomeprofesor.getModelo().addElement(titulo);

			}

		});

		panelhomeprofesor.getAceptar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String solicitud = panelhomeprofesor.getListaMatriculas().getSelectedValue();
				if (solicitud != null) {
					String[] trozos = solicitud.split("/");

					controlador.aceptarMatricula(trozos);
					((DefaultListModel<String>) panelhomeprofesor.getListaMatriculas().getModel())
							.remove(panelhomeprofesor.getListaMatriculas().getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "No hay ninguna matricula selccionada", "ERROR",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		panelhomeprofesor.getDenegar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String solicitud = panelhomeprofesor.getListaMatriculas().getSelectedValue();
				if (solicitud != null) {
					String[] trozos = solicitud.split("/");

					controlador.denegarMatricula(trozos);
					((DefaultListModel<String>) panelhomeprofesor.getListaMatriculas().getModel())
							.remove(panelhomeprofesor.getListaMatriculas().getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "No hay ninguna matricula selccionada", "ERROR",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		panelhomeprofesor.getCombobox().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				panelestadistica.getLabelalumno().setText((String) panelhomeprofesor.getCombobox().getSelectedItem());
				controlador.cargarEstadistica((String) panelhomeprofesor.getCombobox().getSelectedItem());
				cl.show(panelcontenedor, "panelEstadistica");
			}
		});

		panelhomeprofesor.getListaAsignaturas().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {

					panelasignatura.setNombreAsignatura(panelhomeprofesor.getListaAsignaturas().getSelectedValue());
					controlador.cargarTemasProfesor(panelhomeprofesor.getListaAsignaturas().getSelectedValue());
					controlador.alumnosMatriculados(panelhomeprofesor.getListaAsignaturas().getSelectedValue());
					// Double-click detected
					cl.show(panelcontenedor, "panelAsignatura");

				} else if (evt.getButton() == MouseEvent.BUTTON3) {
					if (panelhomeprofesor.getListaAsignaturas().getSelectedValue() != null) {
						String asignatura = panelhomeprofesor.getListaAsignaturas().getSelectedValue();

						JOptionPane.showMessageDialog(null, "Estado:" + controlador.visibilidadAsignatura(asignatura));
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione una asignatura");
					}

				}
			}

		});

		panelhomealumno.getListamisasignaturas().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {

					if (panelhomealumno.getListamisasignaturas().getSelectedValue() != null) {
						panelasignaturaalumno.setNombreAsignatura(
								(String) panelhomealumno.getListamisasignaturas().getSelectedValue());
						controlador.cargarTemasAlumno(
								(String) panelhomealumno.getListamisasignaturas().getSelectedValue());
						cl.show(panelcontenedor, "panelasignaturaAlumno");
					} else {
						JOptionPane.showMessageDialog(null, "No hay asignaturas seleccionadas");
					}
				}
			}

		});

		panelhomealumno.getPedirmatricula().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String asignatura = panelhomealumno.getTodasasignaturas().getSelectedValue();
				if (controlador.pedirMatricula(asignatura) == true) {
					panelhomealumno.getModel().remove(panelhomealumno.getTodasasignaturas().getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "No puedes realizar esta solicitud", "ERROR",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		panelasignatura.getCrearTema().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelcontenedor, "panelcrearTema");

			}
		});
		panelasignatura.getVolver().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelasignatura.getModel().clear();
				panelasignatura.getCombobox().removeAllItems();
				cl.show(panelcontenedor, "panelhomeProfesor");

			}
		});

		panelasignatura.getEliminarTema().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tema = panelasignatura.getLista().getSelectedValue();
				String asignatura = panelasignatura.getNombreAsignatura().getText();
				controlador.eliminarTema(tema, asignatura);
				panelasignatura.getModel().remove(panelasignatura.getLista().getSelectedIndex());

			}
		});
		panelasignatura.getLista().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {

					paneltema.setNombreTema(panelasignatura.getLista().getSelectedValue());
					controlador.cargarApuntesProfesor(panelasignatura.getLista().getSelectedValue());
					controlador.cargarSubtemasProfesor(panelasignatura.getLista().getSelectedValue());
					controlador.cargarEjerciciosProfesor(panelasignatura.getLista().getSelectedValue());
					// Double-click detected
					cl.show(panelcontenedor, "panelTema");

				} else if (evt.getButton() == MouseEvent.BUTTON3) {
					if (panelasignatura.getLista().getSelectedValue() != null) {
						String tema = panelasignatura.getLista().getSelectedValue();

						JOptionPane.showMessageDialog(null, "Estado:" + controlador.visibilidadTema(tema));
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione una asignatura");
					}

				}
			}

		});

		panelcreartema.getBoton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = panelcreartema.getTitulo().getText();
				String asignatura = panelasignatura.getNombreAsignatura().getText();
				boolean visibilidad = panelcreartema.getCheck1().isSelected();
				if (visibilidad == true) {
					controlador.crearTema(asignatura, titulo, Visibilidad.VISIBLE);
				} else {
					controlador.crearTema(asignatura, titulo, Visibilidad.INVISIBLE);
				}

				cl.show(panelcontenedor, "panelAsignatura");
				panelcreartema.getTitulo().setText("");
				panelasignatura.getModel().addElement(titulo);

			}
		});

		panelhomeprofesor.getCambiarvis().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String asignatura = panelhomeprofesor.getListaAsignaturas().getSelectedValue();
				controlador.cambiarVisAsignatura(asignatura);

			}
		});

		panelasignatura.getCambiarvis().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				controlador.cambiarVisTema(panelasignatura.getLista().getSelectedValue());
			}
		});

		panelasignaturaalumno.getVolver().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelasignaturaalumno.getModel().clear();
				cl.show(panelcontenedor, "panelhomeAlumno");

			}
		});

		panelasignaturaalumno.getListatemas().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {

					paneltemaalumno.setNombreTema(panelasignaturaalumno.getListatemas().getSelectedValue());
					controlador.cargarApuntesAlumno(panelasignaturaalumno.getListatemas().getSelectedValue());
					controlador.cargarEjerciciosAlumno(panelasignaturaalumno.getListatemas().getSelectedValue());
					controlador.cargarSubtemasAlumno(panelasignaturaalumno.getListatemas().getSelectedValue());
					// Double-click detected
					cl.show(panelcontenedor, "paneltemaAlumno");

				}

			}

		});

		paneltema.getCambiarvisA().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String apuntes = paneltema.getApuntes().getSelectedValue();
				controlador.cambiarVisApuntes(apuntes);

			}
		});

		paneltema.getCambiarvisSub().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = paneltema.getSubtemas().getSelectedValue();
				controlador.cambiarVisSub(titulo);

			}
		});

		paneltema.getCambiarvisE().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = paneltema.getEjercicios().getSelectedValue();
				controlador.cambiarVisE(titulo);

			}
		});

		paneltema.getApuntes().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
					if (paneltema.getApuntes().getSelectedValue() != null) {
						panelapuntes.setTitulo((String) paneltema.getApuntes().getSelectedValue());
						controlador.abrirApuntes((String) paneltema.getApuntes().getSelectedValue());
						// Double-click detected
						cl.show(panelcontenedor, "panelApuntes");

					} else {
						JOptionPane.showMessageDialog(null, "No hay seleccionado ningun apunte");
					}
				} else if (evt.getButton() == MouseEvent.BUTTON3) {
					if ((String) paneltema.getApuntes().getSelectedValue() != null) {
						String titulo = (String) paneltema.getApuntes().getSelectedValue();

						JOptionPane.showMessageDialog(null, "Estado:" + controlador.visibilidadApuntes(titulo));
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione una asignatura");
					}
				}
			}
		});

		paneltema.getEjercicios().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
					if (paneltema.getEjercicios().getSelectedValue() != null) {
						panelcrearejercicio.setTitulofield(paneltema.getEjercicios().getSelectedValue());
						controlador.abrirEjercicio(paneltema.getEjercicios().getSelectedValue());
						panelcrearejercicio.getCrearEjercicio().setText("Modificar Ejercicio");
						// Double-click detected
						cl.show(panelcontenedor, "panelcrearEjercicio");

					} else {
						JOptionPane.showMessageDialog(null, "No hay seleccionado ningun ejercicios");
					}
				} else if (evt.getButton() == MouseEvent.BUTTON3) {
					if ((String) paneltema.getEjercicios().getSelectedValue() != null) {
						String titulo = (String) paneltema.getEjercicios().getSelectedValue();

						JOptionPane.showMessageDialog(null, "Estado:" + controlador.visibilidadEjercicio(titulo));
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione un ejercicio");
					}
				}
			}
		});

		paneltema.getEliminarE().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = paneltema.getEjercicios().getSelectedValue();
				controlador.eliminarEjercicios(titulo);
				paneltema.getlEjercicios().remove(paneltema.getEjercicios().getSelectedIndex());

			}
		});

		paneltema.getCrearA().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelcontenedor, "panelcrearApuntes");

			}
		});
		paneltema.getEliminarA().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String titulo = (String) paneltema.getApuntes().getSelectedValue();
				controlador.eliminarApuntes(titulo);
				paneltema.getlApuntes().remove(paneltema.getApuntes().getSelectedIndex());
			}
		});

		paneltema.getVolver().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				String titulo = paneltema.getNombreTema().getText();
				String tema = controlador.buscartemaPadre(titulo);
				paneltema.getlApuntes().clear();
				paneltema.getlEjercicios().clear();
				paneltema.getlSubtemas().clear();
				if (tema == null) {
					cl.show(panelcontenedor, "panelAsignatura");
				} else {
					controlador.cargarApuntesProfesor(tema);
					controlador.cargarSubtemasProfesor(tema);
					controlador.cargarEjerciciosProfesor(tema);
					paneltema.getNombreTema().setText(tema);
					cl.show(panelcontenedor, "panelTema");
				}

			}
		});
		paneltema.getCrearSub().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelcontenedor, "panelcrearSubtema");

			}
		});

		panelcrearsubtema.getBoton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = panelcrearsubtema.getTitulo().getText();
				boolean visibilidad = panelcrearsubtema.getCheck1().isSelected();
				String tema = paneltema.getNombreTema().getText();
				if (visibilidad == true) {
					controlador.crearSubtema(titulo, Visibilidad.VISIBLE, tema);
				} else {
					controlador.crearSubtema(titulo, Visibilidad.INVISIBLE, tema);
				}
				cl.show(panelcontenedor, "panelTema");
				panelcrearsubtema.getTitulo().setText("");
				panelcrearsubtema.getCheck1().setSelected(false);
				paneltema.getlSubtemas().addElement(titulo);

			}
		});

		paneltema.getEliminarSub().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = paneltema.getSubtemas().getSelectedValue();
				String tema = paneltema.getNombreTema().getText();
				controlador.eliminarSubtemas(tema, titulo);
				paneltema.getlSubtemas().remove(paneltema.getSubtemas().getSelectedIndex());

			}
		});

		panelapuntes.getModificar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = panelapuntes.getTitulo().getText();
				controlador.modificarApuntes(titulo);
				paneltema.getlApuntes().clear();
				controlador.cargarApuntesProfesor(paneltema.getNombreTema().getText());
				cl.show(panelcontenedor, "panelTema");

			}
		});

		paneltema.getCrearE().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LocalDate date = LocalDate.parse("2012-10-30");
				controlador.crearEjercicio("titulo", date, date, 0);
				cl.show(panelcontenedor, "panelcrearEjercicio");

			}
		});

		paneltema.getSubtemas().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
					String t = (String) paneltema.getSubtemas().getSelectedValue();
					paneltema.setNombreTema(t);
					paneltema.getlApuntes().clear();
					paneltema.getlEjercicios().clear();
					paneltema.getlSubtemas().clear();
					controlador.cargarApuntesProfesor(t);
					controlador.cargarSubtemasProfesor(t);

					// Double-click detected
					cl.show(panelcontenedor, "panelTema");

				} else if (evt.getButton() == MouseEvent.BUTTON3) {
					if ((String) paneltema.getSubtemas().getSelectedValue() != null) {
						String tema = (String) paneltema.getSubtemas().getSelectedValue();

						JOptionPane.showMessageDialog(null, "Estado:" + controlador.visibilidadTema(tema));
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione una asignatura");
					}
				}
			}

		});

		panelcrearejercicio.getCrearPregunta().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (panelcrearejercicio.getPreguntalibre().isSelected() == true) {
					cl.show(panelcontenedor, "panelcrearLibre");
				} else if (panelcrearejercicio.getPreguntatest().isSelected() == true) {
					cl.show(panelcontenedor, "panelcrearTest");
				} else if (panelcrearejercicio.getPreguntamultiple().isSelected() == true) {
					cl.show(panelcontenedor, "panelcrearMultiple");
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un tipo de pregunta");
				}

			}
		});

		panelcrearejercicio.getCrearEjercicio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = panelcrearejercicio.getTitulofield().getText();
				String fechain = panelcrearejercicio.getFechainiciofield().getText();
				String fechater = panelcrearejercicio.getFechafinfield().getText();
				String pond = panelcrearejercicio.getPonderacionfield().getText();
				if (titulo == null || fechain == null || fechater == null || pond == null) {
					JOptionPane.showMessageDialog(null, "Campos incompletos");
					return;
				}
				LocalDate fechainicio = LocalDate.parse(fechain);
				LocalDate fechafin = LocalDate.parse(fechater);
				Double peso = Double.parseDouble(pond);
				boolean visibilidad = panelcrearejercicio.getCheck1().isSelected();
				if (visibilidad == true) {
					if (fechafin != null && fechainicio != null && pond != null) {
						controlador.crearEjercicioFin(titulo, fechainicio, fechafin, peso,
								Visibilidad.VISIBLE_NOCOMENZADO);
					} else {
						JOptionPane.showMessageDialog(null, "Formato incorrecto de fechas o ponderacion");
					}
				} else {
					if (fechafin != null && fechainicio != null && pond != null) {
						controlador.crearEjercicioFin(titulo, fechainicio, fechafin, peso, Visibilidad.INVISIBLE);
					} else {
						JOptionPane.showMessageDialog(null, "Formato incorrecto de fechas o ponderacion");
					}

				}

				paneltema.getlEjercicios().addElement(titulo);
				panelcrearejercicio.getCrearEjercicio().setText("Crear Ejercicio");
				panelcrearejercicio.getPonderacionfield().setText("");
				panelcrearejercicio.getModelo().clear();
				panelcrearejercicio.getFechafinfield().setText("");
				panelcrearejercicio.getFechainiciofield().setText("");
				panelcrearejercicio.getGroup().clearSelection();
				panelcrearejercicio.getTitulofield().setText("");
				paneltema.getlEjercicios().clear();
				controlador.cargarEjerciciosProfesor(paneltema.getNombreTema().getText());
				cl.show(panelcontenedor, "panelTema");

			}
		});

		panelcrearejercicio.getEliminarPregunta().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = panelcrearejercicio.getListapreguntas().getSelectedValue();
				if (controlador.eliminarPregunta(titulo) == true) {
					panelcrearejercicio.getModelo().remove(panelcrearejercicio.getListapreguntas().getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "Pregunta no eliminable");
				}
			}
		});

		panelcrearejercicio.getCancelar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tema = paneltema.getNombreTema().getText();

				controlador.cancelarCrearEjercicio(tema);
				paneltema.getlEjercicios().clear();
				controlador.cargarEjerciciosProfesor(tema);
				panelcrearejercicio.getCrearEjercicio().setText("Crear Ejercicio");
				panelcrearejercicio.getPonderacionfield().setText("");
				panelcrearejercicio.getModelo().clear();
				panelcrearejercicio.getFechafinfield().setText("");
				panelcrearejercicio.getFechainiciofield().setText("");
				panelcrearejercicio.getGroup().clearSelection();
				panelcrearejercicio.getTitulofield().setText("");
				cl.show(panelcontenedor, "panelTema");

			}
		});

		panelcreartest.getEliminarOpcion().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (panelcrearmultiple.getListaopciones().getSelectedIndex() != -1) {
					panelcrearmultiple.getModel().remove(panelcrearmultiple.getListaopciones().getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione una opcion que eliminar");
				}

			}
		});

		panelcreartest.getAnyadirOpcion().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String opcion = panelcreartest.getOpcionfield().getText();
				panelcreartest.getModel().addElement(opcion);
				panelcreartest.getOpcionfield().setText("");

			}
		});

		panelcreartest.getCrearPregunta().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<String> opciones = new ArrayList<String>();
				int i = 0;
				for (i = 0; i < panelcreartest.getModel().getSize(); i++) {
					opciones.add(panelcreartest.getModel().getElementAt(i));

				}

				int solucion = panelcreartest.getListaopciones().getSelectedIndex();
				String enunciado = panelcreartest.getEnunciadofield().getText();
				Double ponderacion = Double.parseDouble(panelcreartest.getPonderacionfield().getText());
				if (panelcreartest.getCheck1().isSelected() == true) {
					controlador.crearPreguntaTest(enunciado, ponderacion, solucion, opciones, Visibilidad.VISIBLE);
				} else {
					controlador.crearPreguntaTest(enunciado, ponderacion, solucion, opciones, Visibilidad.INVISIBLE);

				}

				panelcrearejercicio.getModelo().addElement(enunciado);
				panelcreartest.getEnunciadofield().setText("");
				panelcreartest.getModel().removeAllElements();
				panelcreartest.getPonderacionfield().setText("");
				panelcreartest.getCheck1().setSelected(false);
				cl.show(panelcontenedor, "panelcrearEjercicio");
			}
		});

		panelcreartest.getVolver().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelcreartest.getEnunciadofield().setText("");
				panelcreartest.getModel().removeAllElements();
				panelcreartest.getPonderacionfield().setText("");
				panelcreartest.getCheck1().setSelected(false);
				cl.show(panelcontenedor, "panelcrearEjercicio");

			}
		});

		panelcrearmultiple.getEliminarOpcion().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (panelcrearmultiple.getListaopciones().getSelectedIndex() != -1) {
					panelcrearmultiple.getModel().remove(panelcrearmultiple.getListaopciones().getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione una opcion que eliminar");
				}

			}
		});

		panelcrearmultiple.getAnyadirOpcion().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String opcion = panelcrearmultiple.getOpcionfield().getText();
				panelcrearmultiple.getModel().addElement(opcion);
				panelcrearmultiple.getOpcionfield().setText("");

			}
		});

		panelcrearmultiple.getCrearPregunta().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<String> opciones = new ArrayList<String>();
				int i = 0;
				for (i = 0; i < panelcrearmultiple.getModel().getSize(); i++) {
					opciones.add(panelcrearmultiple.getModel().getElementAt(i));

				}
				int[] soluciones = panelcrearmultiple.getListaopciones().getSelectedIndices();
				String enunciado = panelcrearmultiple.getEnunciadofield().getText();
				Double ponderacion = Double.parseDouble(panelcrearmultiple.getPonderacionfield().getText());
				if (panelcrearmultiple.getCheck1().isSelected() == true) {
					controlador.crearPreguntaMultiple(enunciado, ponderacion, soluciones, opciones,
							Visibilidad.VISIBLE);
				} else {
					controlador.crearPreguntaMultiple(enunciado, ponderacion, soluciones, opciones,
							Visibilidad.INVISIBLE);

				}

				panelcrearejercicio.getModelo().addElement(enunciado);
				panelcrearmultiple.getEnunciadofield().setText("");
				panelcrearmultiple.getModel().removeAllElements();
				panelcrearmultiple.getPonderacionfield().setText("");
				panelcrearmultiple.getCheck1().setSelected(false);
				cl.show(panelcontenedor, "panelcrearEjercicio");
			}
		});

		panelcrearmultiple.getVolver().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelcrearmultiple.getEnunciadofield().setText("");
				panelcrearmultiple.getModel().removeAllElements();
				panelcrearmultiple.getPonderacionfield().setText("");
				panelcrearmultiple.getCheck1().setSelected(false);
				cl.show(panelcontenedor, "panelcrearEjercicio");

			}
		});

		panelcrearlibre.getCrearPregunta().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean visibilidad = panelcrearlibre.getCheck1().isSelected();
				String enunciado = panelcrearlibre.getEnunciadofield().getText();
				String solucion = panelcrearlibre.getSolucionfield().getText();
				double ponderacion = Double.parseDouble(panelcrearlibre.getPonderacionfield().getText());
				if (visibilidad == true) {
					controlador.crearPreguntaLibre(enunciado, solucion, ponderacion, Visibilidad.VISIBLE);
				} else {
					controlador.crearPreguntaLibre(enunciado, solucion, ponderacion, Visibilidad.INVISIBLE);

				}
				panelcrearejercicio.getModelo().addElement(enunciado);
				panelcrearlibre.getEnunciadofield().setText("");
				panelcrearlibre.getPonderacionfield().setText("");
				panelcrearlibre.getSolucionfield().setText("");
				panelcrearlibre.getCheck1().setSelected(false);
				cl.show(panelcontenedor, "panelcrearEjercicio");

			}
		});

		panelcrearlibre.getVolver().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelcrearlibre.getEnunciadofield().setText("");
				panelcrearlibre.getPonderacionfield().setText("");
				panelcrearlibre.getSolucionfield().setText("");
				panelcrearlibre.getCheck1().setSelected(false);
				cl.show(panelcontenedor, "panelcrearEjercicio");

			}
		});

		paneltemaalumno.getSubtemas().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
					String t = (String) paneltemaalumno.getSubtemas().getSelectedValue();
					paneltemaalumno.setNombreTema(t);
					paneltemaalumno.getlApuntes().clear();
					paneltemaalumno.getlEjercicios().clear();
					paneltemaalumno.getlSubtemas().clear();
					controlador.cargarApuntesAlumno(t);
					controlador.cargarSubtemasAlumno(t);
					controlador.cargarEjerciciosAlumno(t);

					// Double-click detected
					cl.show(panelcontenedor, "paneltemaAlumno");

				} else if (evt.getButton() == MouseEvent.BUTTON3) {
					if ((String) paneltemaalumno.getSubtemas().getSelectedValue() != null) {
						String tema = (String) paneltemaalumno.getSubtemas().getSelectedValue();

						JOptionPane.showMessageDialog(null, "Estado:" + controlador.visibilidadTema(tema));
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione una asignatura");
					}
				}
			}

		});

		paneltemaalumno.getVolver().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				String titulo = paneltemaalumno.getNombreTema().getText();
				String tema = controlador.buscartemaPadre(titulo);
				paneltemaalumno.getlApuntes().clear();
				paneltemaalumno.getlEjercicios().clear();
				paneltemaalumno.getlSubtemas().clear();
				if (tema == null) {
					cl.show(panelcontenedor, "panelasignaturaAlumno");
				} else {
					controlador.cargarApuntesAlumno(tema);
					controlador.cargarSubtemasAlumno(tema);
					controlador.cargarEjerciciosAlumno(tema);
					paneltemaalumno.getNombreTema().setText(tema);
					cl.show(panelcontenedor, "paneltemaAlumno");
				}

			}
		});

		paneltemaalumno.getApuntes().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {

					panelapuntesalumno.getTitulo().setText((String) paneltemaalumno.getApuntes().getSelectedValue());
					controlador.abrirApuntesAlumno((String) paneltemaalumno.getApuntes().getSelectedValue());
					// Double-click detected
					cl.show(panelcontenedor, "panelapuntesAlumno");

				}
			}
		});

		paneltemaalumno.getEjercicios().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
					String titulo = paneltemaalumno.getEjercicios().getSelectedValue();
					if (controlador.realizarEjercicio(titulo) == false) {
						if (controlador.visibilidadEjercicio(titulo).equals("VISIBLE_CONTESTADO")) {
							JOptionPane.showMessageDialog(null,
									"Tu nota del ejercicio es: " + controlador.getNota(titulo));
							return;
						}
						JOptionPane.showMessageDialog(null, "El ejercicio no se puede realizar. Compruebe el estado.");
						return;
					}

					panelpreguntalibre.getPreguntas().setSelectedIndex(0);
					if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaLibre")) {
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						cl.show(panelcontenedor, "panelpreguntaLibre");
					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaUnica")) {
						panelpreguntaunica.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaUnica(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						cl.show(panelcontenedor, "panelpreguntaUnica");
					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaMultiple")) {
						panelpreguntamultiple.getEnunciado()
								.setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaMultiple(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						cl.show(panelcontenedor, "panelpreguntaMultiple");
					}
					// Double-click detected

				} else if (evt.getButton() == MouseEvent.BUTTON3) {
					if ((String) paneltemaalumno.getEjercicios().getSelectedValue() != null) {
						String tema = (String) paneltemaalumno.getEjercicios().getSelectedValue();

						JOptionPane.showMessageDialog(null, "Estado:" + controlador.visibilidadEjercicio(tema));
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione una asignatura");
					}

				}
			}

		});

		panelpreguntalibre.getCancelar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				controlador.cancelarEjercicio(paneltemaalumno.getEjercicios().getSelectedValue());
				panelpreguntaunica.getlOpciones().clear();
				panelpreguntamultiple.getlOpciones().clear();
				panelpreguntalibre.getTextofield().setText("");
				cl.show(panelcontenedor, "paneltemaAlumno");
			}
		});

		panelpreguntaunica.getCancelar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				controlador.cancelarEjercicio(paneltemaalumno.getEjercicios().getSelectedValue());
				panelpreguntaunica.getlOpciones().clear();
				panelpreguntamultiple.getlOpciones().clear();
				panelpreguntalibre.getTextofield().setText("");
				cl.show(panelcontenedor, "paneltemaAlumno");
			}
		});

		panelpreguntamultiple.getCancelar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				controlador.cancelarEjercicio(paneltemaalumno.getEjercicios().getSelectedValue());
				panelpreguntaunica.getlOpciones().clear();
				panelpreguntamultiple.getlOpciones().clear();
				panelpreguntalibre.getTextofield().setText("");
				cl.show(panelcontenedor, "paneltemaAlumno");
			}
		});

		panelpreguntalibre.getSiguiente().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String titulo = paneltemaalumno.getEjercicios().getSelectedValue();
				if (panelpreguntalibre.getlPreguntas().getSize() - 1 != panelpreguntalibre.getPreguntas()
						.getSelectedIndex()) {
					if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaLibre")) {
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaLibre();

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaMultiple")) {
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaMultiple();

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaUnica")) {
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaUnica();

					}

					int i = controlador.siguientePregunta(titulo);
					panelpreguntalibre.getPreguntas().setSelectedIndex(i);

					if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaLibre")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						cl.show(panelcontenedor, "panelpreguntaLibre");

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaMultiple")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");
						panelpreguntamultiple.getEnunciado()
								.setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaMultiple(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						cl.show(panelcontenedor, "panelpreguntaMultiple");

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaUnica")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");

						panelpreguntaunica.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaUnica(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						cl.show(panelcontenedor, "panelpreguntaUnica");

					}

				} else {
					JOptionPane.showMessageDialog(null, "No hay mas preguntas");
				}
			}
		});

		panelpreguntalibre.getAnterior().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String titulo = paneltemaalumno.getEjercicios().getSelectedValue();
				if (panelpreguntalibre.getPreguntas().getSelectedIndex() != 0) {
					if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaLibre")) {
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaLibre();

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaMultiple")) {
						panelpreguntamultiple.getEnunciado()
								.setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaMultiple();

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaUnica")) {
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaUnica();

					}

					int i = controlador.anteriorPregunta(titulo);
					panelpreguntalibre.getPreguntas().setSelectedIndex(i);
					String enunciado = panelpreguntalibre.getPreguntas().getSelectedValue();

					if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaLibre")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");
						panelpreguntalibre.getEnunciado().setText(enunciado);
						controlador.cargarPreguntaLibre(enunciado, i, titulo);
						cl.show(panelcontenedor, "panelpreguntaLibre");

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaMultiple")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");

						panelpreguntamultiple.getEnunciado()
								.setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaMultiple(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						panelpreguntamultiple.getEnunciado().setText(enunciado);
						controlador.cargarPreguntaMultiple(enunciado, i, titulo);
						cl.show(panelcontenedor, "panelpreguntaMultiple");

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaUnica")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");
						panelpreguntaunica.getEnunciado().setText(enunciado);

						panelpreguntamultiple.getEnunciado()
								.setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaUnica(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarPreguntaUnica(enunciado, i, titulo);
						cl.show(panelcontenedor, "panelpreguntaUnica");

					}

				} else {
					JOptionPane.showMessageDialog(null, "No hay mas preguntas");
				}
			}
		});

		panelasignatura.getReadmitir().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String alumno = (String) panelasignatura.getCombobox().getSelectedItem();
				String asignatura = panelasignatura.getNombreAsignatura().getText();
				controlador.readmitirAlumno(alumno, asignatura);

			}
		});

		panelasignatura.getBloquear().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String alumno = (String) panelasignatura.getCombobox().getSelectedItem();
				String asignatura = panelasignatura.getNombreAsignatura().getText();
				controlador.expulsarAlumno(alumno, asignatura);

			}
		});

		panelpreguntalibre.getTerminarEjercicio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String titulo = paneltemaalumno.getEjercicios().getSelectedValue();
				if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
						.equals("academia.PreguntaLibre")) {
					panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
					controlador.guardarRespuestaLibre();

				} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
						.equals("academia.PreguntaMultiple")) {

					panelpreguntamultiple.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
					controlador.guardarRespuestaMultiple();

				} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
						.equals("academia.PreguntaUnica")) {
					panelpreguntaunica.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
					controlador.guardarRespuestaUnica();

				}

				double nota = controlador.terminarEjercicio(titulo);
				JOptionPane.showMessageDialog(null, "Tu nota es " + nota);
				cl.show(panelcontenedor, "paneltemaAlumno");

			}
		});

		panelpreguntaunica.getSiguiente().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String titulo = paneltemaalumno.getEjercicios().getSelectedValue();
				if (panelpreguntalibre.getlPreguntas().getSize() - 1 != panelpreguntalibre.getPreguntas()
						.getSelectedIndex()) {
					if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaLibre")) {
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaLibre();

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaMultiple")) {

						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaMultiple();

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaUnica")) {
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaUnica();

					}

					int i = controlador.siguientePregunta(titulo);
					panelpreguntalibre.getPreguntas().setSelectedIndex(i);

					if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaLibre")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						cl.show(panelcontenedor, "panelpreguntaLibre");

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaMultiple")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");

						panelpreguntamultiple.getEnunciado()
								.setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaMultiple(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						cl.show(panelcontenedor, "panelpreguntaMultiple");

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaUnica")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");
						panelpreguntaunica.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaUnica(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						cl.show(panelcontenedor, "panelpreguntaUnica");

					}

				} else {
					JOptionPane.showMessageDialog(null, "No hay mas preguntas");
				}
			}
		});

		panelpreguntaunica.getAnterior().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String titulo = paneltemaalumno.getEjercicios().getSelectedValue();
				if (panelpreguntalibre.getPreguntas().getSelectedIndex() != 0) {
					if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaLibre")) {
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaLibre();

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaMultiple")) {
						panelpreguntamultiple.getEnunciado()
								.setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaMultiple();

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaUnica")) {
						panelpreguntaunica.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaUnica();

					}

					int i = controlador.anteriorPregunta(titulo);
					panelpreguntalibre.getPreguntas().setSelectedIndex(i);
					String enunciado = panelpreguntalibre.getPreguntas().getSelectedValue();

					if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaLibre")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");
						panelpreguntalibre.getEnunciado().setText(enunciado);
						controlador.cargarPreguntaLibre(enunciado, i, titulo);
						cl.show(panelcontenedor, "panelpreguntaLibre");

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaMultiple")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");

						panelpreguntamultiple.getEnunciado()
								.setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaMultiple(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						panelpreguntamultiple.getEnunciado().setText(enunciado);
						controlador.cargarPreguntaMultiple(enunciado, i, titulo);
						cl.show(panelcontenedor, "panelpreguntaMultiple");

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaUnica")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");
						panelpreguntamultiple.getEnunciado()
								.setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaUnica(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						panelpreguntaunica.getEnunciado().setText(enunciado);
						controlador.cargarPreguntaUnica(enunciado, i, titulo);
						cl.show(panelcontenedor, "panelpreguntaUnica");

					}

				} else {
					JOptionPane.showMessageDialog(null, "No hay mas preguntas");
				}
			}
		});

		panelpreguntaunica.getTerminarEjercicio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String titulo = paneltemaalumno.getEjercicios().getSelectedValue();
				if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
						.equals("academia.PreguntaLibre")) {
					panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
					controlador.guardarRespuestaLibre();

				} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
						.equals("academia.PreguntaMultiple")) {

					panelpreguntamultiple.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
					controlador.cargarOpcionesPreguntaMultiple(titulo,
							panelpreguntalibre.getPreguntas().getSelectedValue());
					controlador.guardarRespuestaMultiple();

				} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
						.equals("academia.PreguntaUnica")) {
					panelpreguntaunica.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
					controlador.cargarOpcionesPreguntaUnica(titulo,
							panelpreguntalibre.getPreguntas().getSelectedValue());
					controlador.guardarRespuestaUnica();

				}

				double nota = controlador.terminarEjercicio(titulo);
				JOptionPane.showMessageDialog(null, "Tu nota es " + nota);
				cl.show(panelcontenedor, "paneltemaAlumno");

			}
		});

		panelpreguntamultiple.getSiguiente().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String titulo = paneltemaalumno.getEjercicios().getSelectedValue();
				if (panelpreguntalibre.getlPreguntas().getSize() - 1 != panelpreguntalibre.getPreguntas()
						.getSelectedIndex()) {
					if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaLibre")) {
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaLibre();

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaMultiple")) {
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaMultiple();

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaUnica")) {
						panelpreguntaunica.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaUnica();

					}

					int i = controlador.siguientePregunta(titulo);
					panelpreguntalibre.getPreguntas().setSelectedIndex(i);

					if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaLibre")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						cl.show(panelcontenedor, "panelpreguntaLibre");

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaMultiple")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");
						panelpreguntaunica.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaMultiple(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						panelpreguntamultiple.getEnunciado()
								.setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						cl.show(panelcontenedor, "panelpreguntaMultiple");

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaUnica")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");

						panelpreguntaunica.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaUnica(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						panelpreguntaunica.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						cl.show(panelcontenedor, "panelpreguntaUnica");

					}

				} else {
					JOptionPane.showMessageDialog(null, "No hay mas preguntas");
				}
			}
		});

		panelpreguntamultiple.getAnterior().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String titulo = paneltemaalumno.getEjercicios().getSelectedValue();
				if (panelpreguntalibre.getPreguntas().getSelectedIndex() != 0) {
					if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaLibre")) {
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaLibre();

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaMultiple")) {
						panelpreguntamultiple.getEnunciado()
								.setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaMultiple();

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaUnica")) {
						panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.guardarRespuestaUnica();

					}

					int i = controlador.anteriorPregunta(titulo);
					panelpreguntalibre.getPreguntas().setSelectedIndex(i);
					String enunciado = panelpreguntalibre.getPreguntas().getSelectedValue();

					if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaLibre")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");
						panelpreguntalibre.getEnunciado().setText(enunciado);
						controlador.cargarPreguntaLibre(enunciado, i, titulo);
						cl.show(panelcontenedor, "panelpreguntaLibre");

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaMultiple")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");

						panelpreguntamultiple.getEnunciado()
								.setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaMultiple(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						panelpreguntamultiple.getEnunciado().setText(enunciado);
						controlador.cargarPreguntaMultiple(enunciado, i, titulo);
						cl.show(panelcontenedor, "panelpreguntaMultiple");

					} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
							.equals("academia.PreguntaUnica")) {
						panelpreguntaunica.getlOpciones().clear();
						panelpreguntamultiple.getlOpciones().clear();
						panelpreguntalibre.getTextofield().setText("");
						panelpreguntamultiple.getEnunciado()
								.setText(panelpreguntalibre.getPreguntas().getSelectedValue());
						controlador.cargarOpcionesPreguntaUnica(titulo,
								panelpreguntalibre.getPreguntas().getSelectedValue());
						panelpreguntaunica.getEnunciado().setText(enunciado);
						controlador.cargarPreguntaUnica(enunciado, i, titulo);
						cl.show(panelcontenedor, "panelpreguntaUnica");

					}

				} else {
					JOptionPane.showMessageDialog(null, "No hay mas preguntas");
				}
			}
		});

		panelpreguntamultiple.getTerminarEjercicio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String titulo = paneltemaalumno.getEjercicios().getSelectedValue();
				if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
						.equals("academia.PreguntaLibre")) {
					panelpreguntalibre.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
					controlador.guardarRespuestaLibre();

				} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
						.equals("academia.PreguntaMultiple")) {

					panelpreguntamultiple.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
					controlador.guardarRespuestaMultiple();

				} else if (controlador.comprobarClase(titulo, panelpreguntalibre.getPreguntas().getSelectedValue())
						.equals("academia.PreguntaUnica")) {
					panelpreguntaunica.getEnunciado().setText(panelpreguntalibre.getPreguntas().getSelectedValue());
					controlador.guardarRespuestaUnica();

				}

				double nota = controlador.terminarEjercicio(titulo);
				JOptionPane.showMessageDialog(null, "Tu nota es " + nota);
				cl.show(panelcontenedor, "paneltemaAlumno");

			}
		});

		panelcrearapuntes.getCrearapunte().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String titulo = panelcrearapuntes.getTitulofield().getText();
				String texto = panelcrearapuntes.getTextofield().getText();
				if (panelcrearapuntes.getCheck1().isSelected() == true) {
					controlador.crearApuntes(titulo, texto, Visibilidad.VISIBLE);
				} else {
					controlador.crearApuntes(titulo, texto, Visibilidad.INVISIBLE);
				}

				paneltema.getlApuntes().addElement(titulo);
				panelcrearapuntes.getTitulofield().setText("");
				panelcrearapuntes.getTextofield().setText("");
				cl.show(panelcontenedor, "panelTema");
			}
		});

		panelapuntesalumno.getVolver().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelapuntesalumno.getTextofield().removeAll();
				cl.show(panelcontenedor, "paneltemaAlumno");

			}
		});

	}

	public void login() {
		if (controlador.login() == 0) {
			cl.show(panelcontenedor, "panelhomeProfesor");
		} else {
			cl.show(panelcontenedor, "panelhomeAlumno");
		}
	}

	public void setControlador(ControladorPanelControlador controlador) {
		this.controlador = controlador;

	}

	public PanelHomeProfesor getPanelhomeprofesor() {
		return panelhomeprofesor;
	}

	public PanelCrearAsignatura getPanelcrearAsignatura() {
		return panelcrearasignatura;
	}

	public void setVisibilidad(boolean b) {
		ventana.setVisible(false);

	}

	public PanelHomeAlumno getPanelhomealumno() {
		return panelhomealumno;
	}

	public JPanel getPanelcontenedor() {
		return panelcontenedor;
	}

	public PanelAsignatura getPanelasignatura() {
		return panelasignatura;
	}

	public PanelCrearApuntes getPanelcrearApuntes() {
		return panelcrearapuntes;
	}

	public PanelTema getPaneltema() {
		return paneltema;
	}

	public PanelCrearEjercicio getPanelcrearEjercicio() {
		return panelcrearejercicio;
	}

	public PanelCrearTema getPanelcrearTema() {
		return panelcreartema;
	}

	public JFrame getVentana() {
		return ventana;
	}

	public ControladorPanelControlador getControlador() {
		return controlador;
	}

	public JPanel getExitField() {
		return ExitField;
	}

	public JLabel getIcono() {
		return icono;
	}

	public Container getAcademia() {
		return academia;
	}

	public JButton getDesconectar() {
		return desconectar;
	}

	public Container getContenedor() {
		return contenedor;
	}

	public CardLayout getCl() {
		return cl;
	}

	public PanelAsignaturaAlumno getPanelasignaturaalumno() {
		return panelasignaturaalumno;
	}

	public PanelCrearAsignatura getPanelcrearasignatura() {
		return panelcrearasignatura;
	}

	public PanelPreguntaLibre getPanelpreguntalibre() {
		return panelpreguntalibre;
	}

	public PanelCrearApuntes getPanelcrearapuntes() {
		return panelcrearapuntes;
	}

	public PanelCrearEjercicio getPanelcrearejercicio() {
		return panelcrearejercicio;
	}

	public PanelCrearTema getPanelcreartema() {
		return panelcreartema;
	}

	public PanelTemaAlumno getPaneltemaalumno() {
		return paneltemaalumno;
	}

	public PanelApuntes getPanelapuntes() {
		return panelapuntes;
	}

	public PanelApuntesAlumno getPanelapuntesalumno() {
		return panelapuntesalumno;
	}

	public PanelCrearSubtema getPanelcrearsubtema() {
		return panelcrearsubtema;
	}

	public PanelCrearLibre getPanelcrearlibre() {
		return panelcrearlibre;
	}

	public PanelCrearMultiple getPanelcrearmultiple() {
		return panelcrearmultiple;
	}

	public PanelCrearTest getPanelcreartest() {
		return panelcreartest;
	}

	public PanelPreguntaTest getPanelpreguntaunica() {
		return panelpreguntaunica;
	}

	public PanelPreguntaMultiple getPanelpreguntamultiple() {
		return panelpreguntamultiple;
	}

	public PanelEstadisticas getPanelestadistica() {
		return panelestadistica;
	}

}
