public class LinkedList {

    // Referencia al primer nodo de la lista
    private Node head;

    // Constructor
    public LinkedList() {
        head = null;
    }

    // INSERTAR AL INICIO
    public void insertarInicio(String titulo, String autor, String codigo) {

        Node nuevo = new Node(titulo, autor, codigo);

        // El nuevo nodo apunta al antiguo head
        nuevo.next = head;

        // El nuevo nodo se convierte en el nuevo head
        head = nuevo;
    }

    // INSERTAR AL FINAL
    public void insertarFinal(String titulo, String autor, String codigo) {

        Node nuevo = new Node(titulo, autor, codigo);

        // Si la lista está vacía
        if (head == null) {
            head = nuevo;
            return;
        }

        // Recorrer hasta encontrar el último nodo
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        // El último nodo apunta al nuevo
        current.next = nuevo;
    }

    // INSERTAR EN UNA POSICIÓN
    public boolean insertarPosicion(
            String titulo,
            String autor,
            String codigo,
            int posicion) {

        // Posición inválida
        if (posicion < 0) {
            return false;
        }

        // Insertar al inicio
        if (posicion == 0) {
            insertarInicio(titulo, autor, codigo);
            return true;
        }

        Node current = head;

        // Buscar el nodo anterior a la posición
        for (int i = 0; i < posicion - 1 && current != null; i++) {
            current = current.next;
        }

        // La posición no existe
        if (current == null) {
            return false;
        }

        Node nuevo = new Node(titulo, autor, codigo);

        // Ajustar las referencias
        nuevo.next = current.next;
        current.next = nuevo;

        return true;
    }

    // MOSTRAR TODOS LOS LIBROS
    public void mostrar() {

        // Lista vacía
        if (head == null) {
            System.out.println("La lista de libros está vacía.");
            return;
        }

        Node current = head;
        int posicion = 0;

        System.out.println("\n===== LIBROS REGISTRADOS =====");

        while (current != null) {

            System.out.println("Posición " + posicion + ":");
            System.out.println(current);
            System.out.println("--------------------------------");

            current = current.next;
            posicion++;
        }
    }

    // BUSCAR UN LIBRO POR CÓDIGO
    public Node buscar(String codigo) {

        Node current = head;

        while (current != null) {

            if (current.codigo.equalsIgnoreCase(codigo)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    // OBTENER LIBRO POR POSICIÓN
    public Node obtenerPorPosicion(int posicion) {

        if (posicion < 0) {
            return null;
        }

        Node current = head;
        int contador = 0;

        while (current != null) {

            if (contador == posicion) {
                return current;
            }

            current = current.next;
            contador++;
        }

        return null;
    }

    // ELIMINAR UN LIBRO POR CÓDIGO
    public boolean eliminar(String codigo) {

        // Lista vacía
        if (head == null) {
            return false;
        }

        // Si el libro que buscamos es el primero
        if (head.codigo.equalsIgnoreCase(codigo)) {

            head = head.next;
            return true;
        }

        Node current = head;

        // Buscar el nodo anterior al que queremos eliminar
        while (current.next != null) {

            if (current.next.codigo.equalsIgnoreCase(codigo)) {

                // Saltamos el nodo que queremos eliminar
                current.next = current.next.next;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    // ELIMINAR POR POSICIÓN
    public boolean eliminarPorPosicion(int posicion) {

        // Posición inválida
        if (posicion < 0 || head == null) {
            return false;
        }

        // Eliminar el primer elemento
        if (posicion == 0) {

            head = head.next;
            return true;
        }

        Node current = head;

        // Llegar al nodo anterior
        for (int i = 0; i < posicion - 1 && current != null; i++) {
            current = current.next;
        }

        // Posición inexistente
        if (current == null || current.next == null) {
            return false;
        }

        // Eliminar el nodo
        current.next = current.next.next;

        return true;
    }

    // OBTENER TAMAÑO
    public int tamaño() {

        int contador = 0;
        Node current = head;

        while (current != null) {

            contador++;
            current = current.next;
        }

        return contador;
    }

    // MÉTODO EXTRA: COMPROBAR SI ESTÁ VACÍA
    public boolean estaVacia() {
        return head == null;
    }
}