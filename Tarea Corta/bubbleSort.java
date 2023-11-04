import java.util.Arrays;

//Código tomado de: www.programiz.com

class Main {

    // perform the bubble sort
    static void bubbleSort(int[] array) {
        int size = array.length;

        // loop to access each array element
        for (int i = 0; i < size - 1; i++)

            // loop to compare array elements
            for (int j = 0; j < size - i - 1; j++)

                // compare two adjacent elements
                // change > to < to sort in descending order
                if (array[j] > array[j + 1]) {

                    // swapping occurs if elements
                    // are not in the intended order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

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
            long inicio = System.nanoTime();
            Main.bubbleSort(data);
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
