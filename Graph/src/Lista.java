/***
 *Crea y trabaja con listas enlazadas y los nodos de la misma
 */
public class Lista {

    Nodo cabeza;
    int size;

    /***
     * @see
     *  Nodo cabeza, es el primer nodo de
     *  la lista enlazada
     */
    public Lista() {
        cabeza = null;
        setSize(0);
    }


    /**
     * Agrega objetos al final de una lista enlazada
     * @param e objeto que se quiere agregar al final de la lista
     */
    void addLast(Object e) {

        if (this.cabeza != null) {

            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            Nodo n = new Nodo(e);
            temp.siguiente = n;
            n.prev = temp;
            size++;

        } else {
            cabeza = new Nodo(e);
            size++;
        }

    }

    /**
     * Imprime una lista enlazada
     * @param lista lista por imprimir
     */
    static void printList(Lista lista) {
        if(lista.cabeza == null){
            System.out.println("No hay archivos");
        }else {
            for (int i = 0; i < lista.size; i++)
                if(lista.ver(i) != null) {
                    System.out.print(lista.ver(i) + " ");
                }else{
                    System.out.println("esta vacio");
                }
        }
    }

    /**
     * Imprime una lista enlazada especificamente de GraphNodes
     * @param lista lista por imprimir
     */
    static void printNodeList(Lista lista) {
        if(lista.cabeza == null){
            System.out.println("No hay archivos");
        }else {
            for (int i = 0; i < lista.size; i++)
                if(lista.ver(i) != null && lista.ver(i) instanceof GraphNode) {
                    System.out.print(((GraphNode) lista.ver(i)).getName() + " ");
                }else{
                    System.out.println("esta vacio");
                }
        }
    }

    /**
     * Imprime una lista que contiene unicamente Edges
     * @param lista lista por imprimir
     */
    static void printEdgeList(Lista lista) {
        System.out.println("\n_______________// CHANGED GRAPH //________________");
        if (lista.cabeza == null) {
            System.out.println("No hay archivos");
        } else {
            for (int i = 0; i < lista.size; i++) {
                if (lista.ver(i) != null && lista.ver(i) instanceof Edge) {
                    if(((Edge) lista.ver(i)).destination == null){
                        System.out.println("\n Edge [origin=" + ((Edge) lista.ver(i)).origin.getName() + ", destination= null" + ", distance="
                                + ((Edge) lista.ver(i)).distance + "]");
                    }else {
                        System.out.println("\n Edge [origin=" + ((Edge) lista.ver(i)).origin.getName() + ", destination=" + ((Edge) lista.ver(i)).destination.getName() + ", distance="
                                + ((Edge) lista.ver(i)).distance + "]");
                    }
                } else {
                    System.out.println("esta vacio");
                }
            }
        }
    }


    /***
     * @param index indice en la lista a eliminar
     * Elimina nodos por medio de la posición en la que se encuentra
     */
    public void eliminar(int index) {
        if (cabeza == null) {
            return;
        }
        Nodo temp = cabeza;

        if (index == 0)
        {
            cabeza = temp.siguiente;
        }

        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<index-1; i++) {
            temp = temp.siguiente;
        }

        if (temp == null || temp.siguiente == null) {
            return;
        }

        Nodo next = temp.siguiente.siguiente;

        temp.siguiente = next;  // Unlink the deleted node from list
        size--;
    }

    /***
     * @param indice indice donde se encuentra el elemento que se busca
     * observar el elemento de la lista usando el indice dode se encuentra
     * @return retorna el elemento en la posición seleccionada
     */

    public Object ver(int indice) {
        Nodo temp = cabeza;
        for (int i = 0; i < indice; i++) {
            temp = temp.siguiente;
        }
        if(temp != null) {
            if (temp.VerDato() != null) {
                return temp.VerDato();
            } else {
                return null;
            }
        }else{
            return null;
        }
    }




    /**
     * Define el tamano de la lista
     * @param size nuevo tamano de la lista
     */
    public void setSize(int size) {
        this.size = size;
    }

    public int getIndex(GraphNode elemento) {
        Nodo temp = cabeza;
        int index = 0;
        for (int i=0; i < size; i++) {
            if(temp.dato.equals(elemento)){
                return i;
            }else{
                temp = temp.siguiente;
                index = i;
            }
        }return index-1;
    }

    }



