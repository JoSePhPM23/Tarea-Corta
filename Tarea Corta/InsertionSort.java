import java.util.Arrays;

//Código tomado de: www.programiz.com

class InsertionSort {

    void insertionSort(int[] array) {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }

            // Place key at after the element just smaller than it.
            array[j + 1] = key;
        }
    }

    // Driver code
    public static void main(String[] args) {
        int x = 1000000;
        int j = 0;
        int w = 0;
        int[] d = new int[15];
        while (j != 15) {

            int[] data = new int[x];
            int i;
            for (i = 0; i < x; i++) {
                data[i] = (int) (Math.random()*10000);
            }
            InsertionSort ss = new InsertionSort();
            long inicio = System.nanoTime();
            ss.insertionSort(data);
            long fin = System.nanoTime();
            long tiempo = (fin - inicio);
            d[w] = (int) tiempo;
            j++;
            w++;
        }
        System.out.println(Arrays.toString(d));
        w = 0;
        for (j=0; j<15; j++){
            w += d[j];
        }
        w = w/15;
        System.out.println(w/1000);
    }
}
