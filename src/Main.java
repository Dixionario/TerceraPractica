import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MinHeap heap = new MinHeap();

        while (true) {
            System.out.println("\nMenú del Montículo Mínimo");
            System.out.println("1. Insertar valor");
            System.out.println("2. Eliminar mínimo");
            System.out.println("3. Ver mínimo");
            System.out.println("4. cargar lista (heapify)");
            System.out.println("5. Imprimir montículo");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el valor entero a insertar: ");
                    int valor = scanner.nextInt();
                    heap.insertar(valor);
                    System.out.println("Insertado: " + valor);
                    break;

                case 2:
                    if (!heap.estaVacio()) {
                        int min = heap.eliminarMin();
                        System.out.println("Eliminado el mínimo: " + min);
                    } else {
                        System.out.println("El montículo está vacío.");
                    }
                    break;

                case 3:
                    if (!heap.estaVacio()) {
                        System.out.println("Mínimo actual: " + heap.peek());
                    } else {
                        System.out.println("El montículo está vacío.");
                    }
                    break;

                case 4:
                    System.out.print("Ingresa cuántos números deseas cargar: ");
                    int n = scanner.nextInt();
                    ArrayList<Integer> lista = new ArrayList<>();
                    System.out.println("Ingresa " + n + " números:");
                    for (int i = 0; i < n; i++) {
                        lista.add(scanner.nextInt());
                    }
                    heap.heapify(lista);
                    System.out.println("Heapify aplicado. Montículo reorganizado.");
                    break;

                case 5:
                    heap.imprimir();
                    break;

                case 6:
                    System.out.println("¡Gracias por usar el montículo! Hasta luego.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }
}