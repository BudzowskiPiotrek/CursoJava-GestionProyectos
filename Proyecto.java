public class Proyecto {
	private String nombre;
	private EstadoProyecto estado;
	private Prioridad prioridad;
	
	// CONSTRUCTOR Y SUS SETER Y GETER
	public Proyecto(String nombre, Prioridad prioridad) {
		this.nombre = nombre;
		this.estado = EstadoProyecto.NO_INICIADO;
		this.prioridad = prioridad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EstadoProyecto getEstado() {
		return estado;
	}

	public void setEstado(EstadoProyecto estado) {
		this.estado = estado;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	// METODO PARA AVANZAR CON SEGURO SI YA ESTA COMPLETADO
	public boolean avanzar() {
		boolean exito = false;
		if (estado != EstadoProyecto.COMPLETADO) {
			switch (estado) {
			case NO_INICIADO:
				estado = EstadoProyecto.EN_PROGRESO;
				break;
			case EN_PROGRESO:
				estado = EstadoProyecto.COMPLETADO;
				break;
			}
			exito = true;
		}
		return exito;
	}

	// METODO DE IMPRIMIR PARA MOSTAR PROYECTO Y SUS VARIABLES
	public void mostrar() {
		System.out.println("\nNombre del Proyecto: " + nombre);
		System.out.println("El estado del Proyecto: " + estado);
		System.out.println("La prioridad: " + prioridad);
	}

}
