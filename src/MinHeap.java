import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private int padre(int i) {
        return (i - 1) / 2;
    }

    private int hijoIzquierdo(int i) {
        return 2 * i + 1;
    }

    private int hijoDerecho(int i) {
        return 2 * i + 2;
    }

    public void insertar(int valor) {
        heap.add(valor);
        upHeapify(heap.size() - 1);
    }

    private void upHeapify(int i) {
        while (i > 0) {
            int padre = padre(i);
            if (heap.get(i) < heap.get(padre)) {
                intercambiar(i, padre);
                i = padre;
            } else {
                break;
            }
        }
    }

    private void intercambiar(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public int peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("El montículo está vacío.");
        }
        return heap.get(0);
    }

    public int eliminarMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("El montículo está vacío.");
        }

        int min = heap.get(0);

        int ultimo = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, ultimo);
            downHeapify(0);
        }

        return min;
    }

    private void downHeapify(int i) {
        int n = heap.size();
        while (true) {
            int izq = hijoIzquierdo(i);
            int der = hijoDerecho(i);
            int menor = i;

            if (izq < n && heap.get(izq) < heap.get(menor)) {
                menor = izq;
            }

            if (der < n && heap.get(der) < heap.get(menor)) {
                menor = der;
            }

            if (menor != i) {
                intercambiar(i, menor);
                i = menor;
            } else {
                break;
            }
        }
    }

    public void heapify(ArrayList<Integer> lista) {
        heap = new ArrayList<>(lista);
        int n = heap.size();
        for (int i = (n / 2) - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    public void imprimir() {
        System.out.println("Montículo: " + heap);
    }

    public boolean estaVacio() {
        return heap.isEmpty();
    }
}