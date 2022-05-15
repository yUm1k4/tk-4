import java.util.Scanner;

public class main {
    //method untuk sorting menggunakan bubble sort
    public static void bubbleSort(int[] list, String direction) {
        for (int i = 1; i < list.length; i++) {
            System.out.println("Pass " + i);
            print(list);
            for (int j = 0; j < list.length - i; j++) {
                //mengecek apakah ascending atau descending
                if (direction.equals("asc")) {
                    if (list[j] > list[j + 1]) {
                        swap(list, j, j + 1);
                    }
                } else {
                    if (list[j] < list[j + 1]) {
                        swap(list, j, j + 1);
                    }
                }
                print(list);
            }
            System.out.println("\nResult of Pass " + i);
            print(list);
            System.out.println();
        }
    }

    //method swap untuk bubble sort
    public static void swap(int[] list, int i, int j) {
        int temp;
        temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    //method sorting menggunakan selection sort
    public static void selectionSort(int[] list, String direction) {
        for (int i = 0; i < list.length - 1; i++) {
            int currentMin = list[i];
            int currentMinIndex = i;

            System.out.println("Pass " + (i + 1));
            print(list);

            for (int j = i + 1; j < list.length; j++) {
                //mengecek apakah ascending atau descending
                if (direction.equals("asc")) {
                    if (currentMin > list[j]) {
                        currentMin = list[j];
                        currentMinIndex = j;
                    }
                } else {
                    if (currentMin < list[j]) {
                        currentMin = list[j];
                        currentMinIndex = j;
                    }
                }
                print(list);
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
            System.out.println("\nResult of Pass " + (i + 1));
            print(list);
            System.out.println();
        }
    }

    //method utk cetak array
    public static void print(int[] list) {
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + "\t");
        System.out.println();
    }

    //method utk generate random number
    public static int[] generateRandomNumber(int lower, int upper) {
        int[] listNumbers = new int[5];
        for (int i = 0; i < 5; i++) {
            //generate random number dari batas bawah sampai batas atas
            listNumbers[i] = (int) (lower + (Math.random() * ((upper - lower) + 1)));
        }
        return listNumbers;
    }

    public static void main(String[] args) {
        int[] listNumbers = new int[5];
        int menuSelected;
        int lower, upper;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Selamat Datang di Program Simulasi");
            System.out.println("Menu");
            System.out.println("1. Random Data");
            System.out.println("2. Simulasi Bubble Sort - Ascending");
            System.out.println("3. Simulasi Selection Sort - Ascending");
            System.out.println("4. Simulasi Bubble Sort - Descending");
            System.out.println("5. Simulasi Selection Sort - Descending");
            System.out.println("6. Keluar");

            System.out.print("Masukkan Pilihan Anda : ");
            menuSelected = input.nextInt();
            switch (menuSelected) {
                case 1:
                    System.out.print("Batas Bawah = ");
                    lower = input.nextInt();
                    System.out.print("Batas Atas = ");
                    upper = input.nextInt();

                    // method generate random number
                    listNumbers = generateRandomNumber(lower, upper);
                    print(listNumbers);
                    break;
                case 2:
                    // method sorting bubble sort (asc)
                    bubbleSort(listNumbers, "asc");
                    break;
                case 3:
                    //method sorting selection sort (asc)
                    selectionSort(listNumbers, "asc");
                    break;
                case 4:
                    // method sorting bubble sort (desc)
                    bubbleSort(listNumbers, "desc");
                    break;
                case 5:
                    // method sorting selection sort (desc)
                    selectionSort(listNumbers, "desc");
                    break;
            }

            System.out.println();
        } while (menuSelected != 6);
    }
}
