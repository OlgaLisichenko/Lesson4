import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.copyOf;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int[] array = {-7, 2, 81, 3, -11, 32, 3, 58, -3, 6, 4};

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        scanner.close();
    }

    //  1. Создайте массив целых чисел. Напишете программу, которая выводит
    //  сообщение о том, входит ли заданное число в массив или нет.
    //  Пусть число для поиска задается с консоли (класс Scanner).
    public static void task1() {
        System.out.println("\n--------------- Task 1 ---------------");
        System.out.println("Enter any integer");
        int num = scanner.nextInt();
        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
        int index = Arrays.binarySearch(array, num);

        if (index >= 0) {
            System.out.println("There is a number " + num + " in the array. Its index is " + index);
        } else {
            System.out.println("There is no number " + num + " in the array");
        }
    }

    //  2. Создайте массив целых чисел. Удалите все вхождения заданного числа из массива.
    //  Пусть число задается с консоли (класс Scanner). Если такого числа нет - выведите сообщения об этом.
    //  В результате должен быть новый массив без указанного числа.
    public static void task2() {
        System.out.println("\n--------------- Task 2 ---------------");
        System.out.println("Enter any integer");
        int num = scanner.nextInt();
        System.out.println("Initial array: " + Arrays.toString(array));
        int[] array2 = array;
        int i = 0;

        for (int j : array) {
            if (j != num) {
                array2[i] = j;
                i++;
            }
        }
        array2 = copyOf(array, i);
        if (array2.length != array.length) {
            System.out.println("Array without number " + num + ": " + Arrays.toString(array2));
        } else {
            System.out.println("There is no number " + num + " in the array. The array is the same.");
        }
    }

    //  3. Создайте и заполните массив случайным числами и выведете максимальное, минимальное и среднее значение.
    //  Для генерации случайного числа используйте метод Math.random().
    //  Пусть будет возможность создавать массив произвольного размера. Пусть размер массива вводится с консоли.
    public static void task3() {
        System.out.println("\n--------------- Task 3 ---------------");
        System.out.println("Enter a number that sets the size of the array");
        int arraySize = scanner.nextInt();
        int[] arrayRandom = new int[arraySize];
        int min = 0;
        int max = 0;
        int average;
        System.out.print("Array: ");

        for (int i = 0; i < arraySize; i++) {
            arrayRandom[i] = getRandomInt(30);
            System.out.print(arrayRandom[i] + " ");
            if (arrayRandom[min] > arrayRandom[i]) {
                min = i;
            }
            if (arrayRandom[max] < arrayRandom[i]) {
                max = i;
            }
        }
        average = (arrayRandom[max] + arrayRandom[min]) / 2;

        System.out.println("\nMinimum value in the array: " + arrayRandom[min]);
        System.out.println("Maximum value in the array: " + arrayRandom[max]);
        System.out.println("Average value: " + average);
    }

    //  4. Создайте 2 массива из 5 чисел. Выведите массивы на консоль в двух отдельных строках.
    //  Посчитайте среднее арифметическое элементов каждого массива и сообщите,
    //  для какого из массивов это значение оказалось больше (либо сообщите, что их средние арифметические равны).
    public static void task4() {
        System.out.println("\n--------------- Task 4 ---------------");
        int arrayLength = 5;
        int[] array1 = new int[arrayLength];
        int[] array2 = new int[arrayLength];
        double averageArray1;
        double averageArray2;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < arrayLength; i++) {
            array1[i] = getRandomInt(20);
            array2[i] = getRandomInt(20);
            sum1 += array1[i];
            sum2 += array2[i];
        }
        averageArray1 = (double) sum1 / array1.length;
        averageArray2 = (double) sum2 / array2.length;

        System.out.println("First  array: " + Arrays.toString(array1) + "\nSecond array: " + Arrays.toString(array2));

        if (averageArray1 == averageArray2) {
            System.out.println("The arithmetic mean values of the elements of the first and second arrays are equal.\n"
                    + averageArray1 + " = " + averageArray2);
        } else if (averageArray1 > averageArray2) {
            System.out.println("The arithmetic mean of the elements of the first array is greater than the second.\n"
                    + averageArray1 + " > " + averageArray2);
        } else {
            System.out.println("The arithmetic mean of the elements of the second array is greater than the first.\n"
                    + averageArray1 + " < " + averageArray2);
        }
    }

    //  Дополнительные задания
    //  5. Создайте массив из n случайных целых чисел и выведите его на экран.
    //  Размер массива пусть задается с консоли и размер массива может быть больше 5 и меньше или равно 10.
    //  Если n не удовлетворяет условию - выведите сообщение об этом.
    //  Если пользователь ввёл не подходящее число, то программа должна просить пользователя повторить ввод.
    //  Создайте второй массив только из чётных элементов первого массива, если они там есть, и вывести его на экран.
    public static void task5() {
        System.out.println("\n--------------- Task 5 ---------------");
        System.out.println("Enter a number that sets the size of the array.\nYou can use the numbers 6, 7, 8, 9 or 10.");
        int arraySize = scanner.nextInt();

        while (arraySize <= 5 || arraySize > 10) {
            System.out.println("Entered wrong integer. You can use the numbers 6, 7, 8, 9 or 10.");
            arraySize = scanner.nextInt();
            if (arraySize > 5 && arraySize <= 10)
                break;
        }
        int[] array1 = new int[arraySize];
        int[] array2 = new int[arraySize];
        int j = 0;

        for (int i = 0; i < arraySize; i++) {
            array1[i] = getRandomInt(20);
            if (array1[i] % 2 == 0) {
                array2[j] = array1[i];
                j++;
            }
        }
        System.out.println("First  array: " + Arrays.toString(array1));

        array2 = copyOf(array2, j);
        if (array2.length > 0) {
            System.out.println("Array of even numbers: " + Arrays.toString(array2));
        } else {
            System.out.println("There is no even numbers in the first array. ");
        }
    }

    //  6. Создайте массив и заполните массив. Выведите массив на экран в строку.
    //  Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на экран на отдельной строке.
    public static void task6() {
        System.out.println("\n--------------- Task 6 ---------------");
        int[] array1 = new int[10];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = getRandomInt(30);
        }
        System.out.println("Initial   array:   " + Arrays.toString(array1));

        int[] array2 = Arrays.copyOf(array1, array1.length);
        for (int j = 0; j < array1.length; j++) {
            if (array1[j] % 2 != 0) {
                array2[j] = 0;
            }
        }
        System.out.println("Array after changes: " + Arrays.toString(array2));
    }

    //  7. Создайте массив строк. Заполните его произвольными именами людей. Отсортируйте массив.
    //  Результат выведите на консоль.
    public static void task7() {
        System.out.println("\n--------------- Task 7 ---------------");
        String[] arrayNames = {"Sophia", "Victoria", "Maria", "Anna", "Eva"};
        Arrays.sort(arrayNames);
        System.out.println("Array of strings: " + Arrays.toString(arrayNames));
    }

    //  8.Реализуйте алгоритм сортировки пузырьком.
    public static void task8() {
        System.out.println("\n--------------- Task 8 ---------------");
        int[] array1 = new int[15];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = getRandomInt(50);
        }
        System.out.println("Array before sorting: " + Arrays.toString(array1));

        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array1.length - 1; i++) {
                if (array1[i] > array1[i + 1]) {
                    temp = array1[i];
                    array1[i] = array1[i + 1];
                    array1[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println("Array after sorting:  " + Arrays.toString(array1));
    }

    private static int getRandomInt(int max) {
        return (int) (Math.random() * max);
    }
}



