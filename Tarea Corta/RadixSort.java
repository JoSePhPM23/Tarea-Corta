import java.util.Arrays;
// Este código de ordenamiento Radix Sort fue adaptado de GeeksforGeeks en:
// https://www.geeksforgeeks.org/radix-sort/
class RadixSortBenchmark {

    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void radixsort(int arr[], int n) {
        int m = getMax(arr, n);

        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int[] testSizes = {10000, 100000, 1000000};

        for (int size : testSizes) {
            int[] testScores = new int[size];

            // Llenar el arreglo con valores aleatorios para cada prueba
            for (int i = 0; i < size; i++) {
                testScores[i] = (int) (Math.random() * 1000);
            }

            long startTime = System.nanoTime();
            radixsort(testScores, size);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // Duración en milisegundos

            System.out.println("Tiempo de ejecución para " + size + " elementos: " + duration + " milisegundos");
        }
    }
}
