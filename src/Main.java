public class Main {

    public static void main(String[] args) {

        System.out.println("=== Cola normal ===");
        Queue col = new Queue();
        System.out.println("Vacia: " + col.isEmpty());

        col.insert("d");
        col.insert("e");
        col.insert("f");
        System.out.println("Cola: " + col);
        System.out.println("Tamano: " + col.size());
        System.out.println("Insert con prioridad: " + col.insert("x", 5));

        System.out.println("Busca b: " + col.search("d"));
        System.out.println("Busca z: " + col.search("z"));

        System.out.println("Extract: " + col.extract());
        System.out.println("Cola: " + col);
        System.out.println("Tamano: " + col.size());

        col.clear();
        System.out.println("Despues de clear: " + col);
        System.out.println("Vacia: " + col.isEmpty());
        System.out.println("Extract en vacia: " + col.extract());

        System.out.println();

        System.out.println("=== Cola de prioridad ===");
        Queue cp = new Queue(true);
        System.out.println("Vacia: " + cp.isEmpty());

        cp.insert("bajo", 1);
        cp.insert("alto", 9);
        cp.insert("medio", 5);
        cp.insert("medio2", 5);
        System.out.println("Cola: " + cp);
        System.out.println("Tamaño: " + cp.size());
        System.out.println("Insert sin prioridad: " + cp.insert("x"));

        System.out.println("Busca medio: " + cp.search("medio"));
        System.out.println("Busca z: " + cp.search("z"));

        System.out.println("Extract: " + cp.extract());
        System.out.println("Extract: " + cp.extract());
        System.out.println("Cola: " + cp);
        System.out.println("Tamano: " + cp.size());

        cp.clear();
        System.out.println("Despues de clear: " + cp);
        System.out.println("Vacia: " + cp.isEmpty());
        System.out.println("Extract en vacia: " + cp.extract());
    }

}