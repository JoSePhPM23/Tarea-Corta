import java.util.Arrays;


//Código tomado de: www.programiz.com


class SelectionSort {
    void selectionSort(int[] array) {
        int size = array.length;

        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;

            for (int i = step + 1; i < size; i++) {

                // To sort in descending order, change > to < in this line.
                // Select the minimum element in each loop.
                if (array[i] < array[min_idx]) {
                    min_idx = i;
                }
            }

            // put min at the correct position
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
    }

    // driver code
    public static void main(String[] args) {
        int x = 100000;
        int j = 0;
        int w = 0;
        int[] d = new int[15];
        while (j != 15) {

            int[] data = new int[x];
            int i;
            for (i = 0; i < x; i++) {
                data[i] = (int) (Math.random()*10000);
            }
            SelectionSort ss = new SelectionSort();
            long inicio = System.nanoTime();
            ss.selectionSort(data);
            long fin = System.nanoTime();
            long tiempo = (fin - inicio);
            d[w] = (int) tiempo;
            j++;
            w++;
        }
        System.out.println(Arrays.toString(d));
        for (j=0; j<15; j++){
            w += d[j];
        }
        w = w/15;
        System.out.println(w/1000);
    }
}
