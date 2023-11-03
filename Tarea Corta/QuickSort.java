import java.util.Arrays;
// Este código de ordenamiento Quick Sort fue adaptado de GeeksforGeeks en:
// https://www.geeksforgeeks.org/quick-sort/
class QuickSortBenchmark {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
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
            quickSort(testScores, 0, size - 1);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // Duración en milisegundos

            System.out.println("Tiempo de ejecución para " + size + " elementos: " + duration + " milisegundos");
        }
    }
}


// This code is contributed by Ayush Choudhary
// Improved by Ajay Virmoti
