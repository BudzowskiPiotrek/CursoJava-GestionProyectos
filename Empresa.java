public class Empresa {
	private Proyecto[] proyectos;

	public Empresa(Proyecto[] proyecto) {
		this.proyectos = proyecto;
	}

	// METEO APRA AGREGAR PROYECTOS
	public boolean agregarProyecto(Proyecto proyecto) {
		boolean exito = false, seguro = true;
		for (int i = 0; i < proyectos.length && seguro; i++) {
			if (proyectos[i] == null) {
				proyectos[i] = proyecto;
				exito = true;
				seguro = false;
			}
		}
		return exito;
	}

	//METODO PARA LSITAR PROYECTO
	public boolean listarProyecto() {
		boolean exito = false;
		for (int i = 0; i < proyectos.length; i++) {
			if (proyectos[i] != null) {
				proyectos[i].mostrar();
				exito = true;
			}
		}
		return exito;
	}

	// METODO PARA FILTRAR PROYECTO
	public boolean filtrar(int opcion) {
		boolean exito = false;
		for (int i = 0; i < proyectos.length; i++) {
			if (proyectos[i] != null && opcion == 1 && proyectos[i].getPrioridad() == Prioridad.BAJA) {
				proyectos[i].mostrar();
				exito = true;
			} else if (proyectos[i] != null && opcion == 2 && proyectos[i].getPrioridad() == Prioridad.MEDIA) {
				proyectos[i].mostrar();
				exito = true;
			} else if (proyectos[i] != null && opcion == 3 && proyectos[i].getPrioridad() == Prioridad.ALTA) {
				proyectos[i].mostrar();
				exito = true;
			} else if (proyectos[i] != null && opcion == 4 && proyectos[i].getEstado() == EstadoProyecto.NO_INICIADO) {
				proyectos[i].mostrar();
				exito = true;
			} else if (proyectos[i] != null && opcion == 5 && proyectos[i].getEstado() == EstadoProyecto.EN_PROGRESO) {
				proyectos[i].mostrar();
				exito = true;
			} else if (proyectos[i] != null && opcion == 6 && proyectos[i].getEstado() == EstadoProyecto.COMPLETADO) {
				proyectos[i].mostrar();
				exito = true;
			}
		}
		return exito;
	}
}
