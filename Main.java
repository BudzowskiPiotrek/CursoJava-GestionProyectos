import java.util.Scanner;

public class Main {

	// CREO 4 FUERA PARA TENER FACIL ACCESO A ELLOS
	public static Scanner sn = new Scanner(System.in);
	public static Scanner st = new Scanner(System.in);
	public static Proyecto[] pr = new Proyecto[100];
	public static Empresa em = new Empresa(pr);

	public static void main(String[] args) {
		menu();

	}

	// PRIMER MENU DE LOS DOS
	private static void menu() {
		int flag = 0;
		do {
			System.out.println("\nPulsa 1. Crear proyecto nuevo");
			System.out.println("Pulsa 2. Listar proyectos");
			System.out.println("Pulsa 3. Para cambiar estado de proyecto");
			System.out.println("Pulsa 4. Listar por prioridad o estado");
			System.out.println("Pulsa 5. Para salir");
			flag = sn.nextInt();
			menuDos(flag);
		} while (flag != 5);

	}

	// SEGUNDO MENU DE LOS DOS
	private static void menuDos(int flag) {
		switch (flag) {
		case 1:
			crearProyecto();
			break;
		case 2:
			listaProyectos();
			break;
		case 3:
			cambiarPrioridad();
			break;
		case 4:
			filtrar();
			break;
		default:
			System.out.println("Opcion no existente");
			break;
		}

	}

	// METODO FILTRAR, PREGUNTA POR NUMERO QUE PASA A CLASE DONDE ESTA DESAROLLADO
	// ELECCION A CUALES FILTRAR
	private static void filtrar() {
		System.out.println("Listado de cuales proyectos quieres\n1.Prioridad: BAJA\n2.Prioridad: Media"
				+ "\n3.Prioridad: ALTA\n4.Estado: NO_INICIADO\n5.Estado: EN_PROGRESO\n6.Estado: COMPLETADO");
		int numero = sn.nextInt();
		em.filtrar(numero);

	}

	// METODO QUE PREGUNTA NOMBRE DE PROYECTO Y LUEGO PERMITE SUBIR SU PRIOPRIDAD TE
	// AVISA SI SALE FALLO
	private static void cambiarPrioridad() {
		System.out.println("Dime nombre del proyecto");
		String nombre = st.nextLine();
		boolean exito = false;
		for (int i = 0; i < pr.length; i++) {
			if (pr[i] != null && nombre.equalsIgnoreCase(pr[i].getNombre())) {
				exito = pr[i].avanzar();
			}
		}
		if (exito) {
			System.out.println("Se consiguo avanzar proyecto");
		} else {
			System.out.println("No se pudo avanzar, o proyecto no se encuentra o ya esta terminado");
		}

	}

	// METODO QUE RECORRE LA ARRAY Y TE DEJA LSITADO DE LOS PROYECTOS ACTUALES
	private static void listaProyectos() {
		boolean exito = em.listarProyecto();
		if (!exito) {
			System.out.println("No hay proyectos disponibles");
		}

	}

	// METODO PARA CREAR PROYECTOS NUVOS
	private static void crearProyecto() {
		System.out.println("Dime el nombre de proyecto");
		String nombre = st.nextLine();
		System.out.println("Dime la prioridad del proyecto\nOpciones\nBAJA, MEDIA, ALTA");
		String prioridad = st.nextLine();
		prioridad = prioridad.toUpperCase();
		Prioridad prioridadTipo = Prioridad.valueOf(prioridad);
		boolean exito = em.agregarProyecto(new Proyecto(nombre, prioridadTipo));
		if (exito) {
			System.out.println("Agregado con exito");
		} else {
			System.out.println("Error, no se pudo agregar proyecto");
		}

	}

}
