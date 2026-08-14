import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static LinkedList biblioteca = new LinkedList();

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();
            opcion = leerEntero("Selecciona una opción: ");

            switch (opcion) {

                case 1:
                    agregarInicio();
                    break;

                case 2:
                    agregarFinal();
                    break;

                case 3:
                    insertarPosicion();
                    break;

                case 4:
                    biblioteca.mostrar();
                    break;

                case 5:
                    buscarLibro();
                    break;

                case 6:
                    consultarPosicion();
                    break;

                case 7:
                    eliminarLibro();
                    break;

                case 8:
                    eliminarPosicion();
                    break;

                case 9:
                    System.out.println(
                            "\nCantidad de libros: "
                            + biblioteca.tamaño()
                    );
                    break;

                case 10:
                    System.out.println("\nPrograma finalizado.");
                    break;

                default:
                    System.out.println(
                            "\nOpción inválida. "
                            + "Selecciona una opción del 1 al 10."
                    );
            }

        } while (opcion != 10);

        scanner.close();
    }

    // MENÚ PRINCIPAL
    public static void mostrarMenu() {

        System.out.println("SISTEMA DE BIBLIOTECA");
        System.out.println("1. Agregar libro al inicio");
        System.out.println("2. Agregar libro al final");
        System.out.println("3. Insertar libro en posición");
        System.out.println("4. Mostrar libros");
        System.out.println("5. Buscar libro");
        System.out.println("6. Consultar libro por posición");
        System.out.println("7. Eliminar libro");
        System.out.println("8. Eliminar libro por posición");
        System.out.println("9. Mostrar cantidad de libros");
        System.out.println("10. Salir");
        
    }

    // AGREGAR AL INICIO
    public static void agregarInicio() {

        System.out.println("\n===== AGREGAR AL INICIO =====");

        String titulo = leerTexto("Título: ");
        String autor = leerTexto("Autor: ");
        String codigo = leerTexto("Código: ");

        if (biblioteca.buscar(codigo) != null) {
            System.out.println("Error: ese código ya existe.");
            return;
        }

        biblioteca.insertarInicio(titulo, autor, codigo);

        System.out.println("Libro agregado correctamente al inicio.");
    }

    // AGREGAR AL FINAL
    public static void agregarFinal() {

        System.out.println("\n===== AGREGAR AL FINAL =====");

        String titulo = leerTexto("Título: ");
        String autor = leerTexto("Autor: ");
        String codigo = leerTexto("Código: ");

        if (biblioteca.buscar(codigo) != null) {
            System.out.println("Error: ese código ya existe.");
            return;
        }

        biblioteca.insertarFinal(titulo, autor, codigo);

        System.out.println("Libro agregado correctamente al final.");
    }

    // INSERTAR EN UNA POSICIÓN
    public static void insertarPosicion() {

        System.out.println("\n===== INSERTAR EN POSICIÓN =====");

        int posicion = leerEntero("Posición: ");

        String titulo = leerTexto("Título: ");
        String autor = leerTexto("Autor: ");
        String codigo = leerTexto("Código: ");

        if (biblioteca.buscar(codigo) != null) {
            System.out.println("Error: ese código ya existe.");
            return;
        }

        boolean resultado = biblioteca.insertarPosicion(
                titulo,
                autor,
                codigo,
                posicion
        );

        if (resultado) {
            System.out.println(
                    "Libro insertado correctamente en la posición "
                    + posicion + "."
            );
        } else {
            System.out.println(
                    "Error: la posición " + posicion + " no es válida."
            );
        }
    }

    // BUSCAR LIBRO
    public static void buscarLibro() {

        System.out.println("\n===== BUSCAR LIBRO =====");

        String codigo = leerTexto("Introduce el código del libro: ");

        Node resultado = biblioteca.buscar(codigo);

        if (resultado != null) {

            System.out.println("\nLibro encontrado:");
            System.out.println(resultado);

        } else {

            System.out.println(
                    "No existe ningún libro con ese código."
            );
        }
    }

    // CONSULTAR POR POSICIÓN
    public static void consultarPosicion() {

        System.out.println("\n===== CONSULTAR POR POSICIÓN =====");

        int posicion = leerEntero("Introduce la posición: ");

        Node resultado = biblioteca.obtenerPorPosicion(posicion);

        if (resultado != null) {

            System.out.println("\nLibro encontrado en la posición "
                    + posicion + ":");

            System.out.println(resultado);

        } else {

            System.out.println(
                    "Error: la posición " + posicion + " no existe."
            );
        }
    }

    // ELIMINAR POR CÓDIGO
    public static void eliminarLibro() {

        System.out.println("\n===== ELIMINAR LIBRO =====");

        String codigo = leerTexto(
                "Introduce el código del libro a eliminar: "
        );

        boolean eliminado = biblioteca.eliminar(codigo);

        if (eliminado) {

            System.out.println(
                    "El libro fue eliminado correctamente."
            );

        } else {

            System.out.println(
                    "No se encontró ningún libro con ese código."
            );
        }
    }

    // ELIMINAR POR POSICIÓN
    public static void eliminarPosicion() {

        System.out.println("\n===== ELIMINAR POR POSICIÓN =====");

        int posicion = leerEntero(
                "Introduce la posición del libro: "
        );

        boolean eliminado =
                biblioteca.eliminarPorPosicion(posicion);

        if (eliminado) {

            System.out.println(
                    "El libro de la posición "
                    + posicion
                    + " fue eliminado correctamente."
            );

        } else {

            System.out.println(
                    "Error: la posición "
                    + posicion
                    + " no existe."
            );
        }
    }

    // LEER TEXTO
    public static String leerTexto(String mensaje) {

        String texto;

        do {

            System.out.print(mensaje);
            texto = scanner.nextLine().trim();

            if (texto.isEmpty()) {

                System.out.println(
                        "El campo no puede estar vacío."
                );
            }

        } while (texto.isEmpty());

        return texto;
    }

    // LEER ENTERO
    public static int leerEntero(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                String entrada = scanner.nextLine();

                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: debes introducir un número entero."
                );
            }
        }
    }
}