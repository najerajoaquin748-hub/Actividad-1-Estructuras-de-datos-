public class Node {

    String titulo;
    String autor;
    String codigo;

    Node next;

    // Constructor
    public Node(String titulo, String autor, String codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.next = null;
    }

    // Mostrar información del libro
    @Override
    public String toString() {
        return "Código: " + codigo +
               " | Título: " + titulo +
               " | Autor: " + autor;
    }
}