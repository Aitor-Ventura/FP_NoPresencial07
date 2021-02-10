package es.ulpgc.eii.containers.unbounded;

public class QueueOfInt {
    protected class Node { // Nodos que almacenan los elementos de la cola
        int info;        // Información almacenada en el nodo
        Node next;       // Encadenamiento al siguiente nodo 
    }

    protected Node front = null; // Referencia al primer elemento
    protected Node rear = null;  // Referencia al último elemento

    /**
     * Inserta element en la cola referenciada por this.
     * @param element
     */
    public void insert(int element) {
        if (rear == null) { // La cola está vacía
            rear = new Node(); // se crea un nodo y rear y front
            front = rear;      // apuntan a él, que es el único
        } else { //La cola no está vacía 
            rear.next = new Node(); // se crea un nuevo nodo que
            rear = rear.next;       // se engancha al final y se
        }                           // actualiza rear
        
        rear.info = element; // se almacena el elemento en el nuevo nodo
    }
    
    /**
     * @return primer elemento de la cola this
     */
    public int getFirst() {
        return front.info; // ¡¡ Da error si la cola está vacía !!
    }
    
    /**
     * Elimina el primer elemento de la cola
     */
    public void remove() {
        if (front != null) { // La cola no está vacía
            front = front.next; // El segundo elemento pasa al frente
            
            if (front == null) { // Solo había un nodo, la cola
                rear = null;     // ha quedado vacía
            }
        }
    }
}