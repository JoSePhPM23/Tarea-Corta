import java.util.Arrays;

//Código tomado de: www.programiz.com


// Shell sort
class ShellSort {

    // Rearrange elements at each n/2, n/4, n/8, ... intervals
    void shellSort(int[] array, int n) {
        for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
                    array[j] = array[j - interval];
                }
                array[j] = temp;
            }
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
            ShellSort ss = new ShellSort();
            long inicio = System.nanoTime();
            int size = data.length;
            ss.shellSort(data, size);
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
