package es.ulpgc.eii.containers.unbounded;

/* Aitor Ventura Delgado
 * 26.04.2019
 */


public class ExtendedQueueOfInt extends QueueOfInt
    implements Comparable<QueueOfInt>, Cloneable{

    /* Método compareTo:
     * Compararemos el primer elemento siempre y cuando sepamos que su valor es
     * diferente de null. Dependiendo de la comparación, devolveremos 1, 0, o -1.
     * Si fueran iguales, o alguno de ellos fuera null, iríamos al bucle. SI dentro
     * del bucle todavía son iguales, acabaremos devolviendo 0, pero si alguna
     * cola acaba, sabremos cual es la mayor.
     */
    @Override
    public int compareTo(QueueOfInt arg0) {
        Node aux = front;
        Node aux2 = arg0.front;
        
        if (aux != null && aux2 != null){
            if (aux.info > aux2.info){
                return -1;
            } else if (aux.info < aux2.info){
                return 1;
            }
        }
        
        while (aux != null || aux2 != null){
            if (aux == null && aux2 != null){
                return 1;
            } else if (aux != null && aux2 == null){
                return -1;
            }
            
            aux = aux.next;
            aux2 = aux2.next;
        }
        return 0;
    }
    
    /* Método equals:
     * Vamos comparando en ratio 1:1 cada cola. Mientras ambas sean diferentes
     * de null, iremos recorriendo, y mientras recorremos, si algún dato es
     * diferente entre ambas, devolveremos false. SI llegamos al final de la
     * cola y no ha abortado, devolveremos true.
     */
    @Override
    public boolean equals(Object arg0) {
        QueueOfInt arg = (QueueOfInt) arg0;
        Node aux = front;
        Node aux2 = arg.front;
        while (aux != null && aux2 != null){
            if (aux.info != aux2.info){
                return false;
            }
            
            aux = aux.next;
            aux2 = aux2.next;
        }
        if (aux == null && aux2 == null){
            return true;
        }
        return false;
    }

    /* Método toString:
     * Creamos un nodo que será el primer elemento de la cola, si es nulo,
     * devolvemos la cola vacía (<<), si no lo fuera, vamos añadiendo los
     * elementos de la cola en una String resultante.
     */
    @Override
    public String toString() {
        String res = "<";
        Node aux = front;
        while (aux != null){
            res += aux.info;
            if (aux.next != null){
                res += "-";
            }
            aux = aux.next;
        }
        return res + "<";
    }
    
    /* Método clone:
     * Utilizamos el método insert que se nos da ya en QueueOfInt con un puntero
     * refiriéndose a la dirección de la cola referenciada por this.
     */
    @Override
    public ExtendedQueueOfInt clone() {
        ExtendedQueueOfInt clon = new ExtendedQueueOfInt();
        Node aux = front;
        while (aux != null){
            clon.insert(aux.info);
            aux = aux.next;
        }
        return clon;
    }
}
