package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ширину матриці: ");
        int width = scanner.nextInt();

        System.out.print("Введіть висоту матриці: ");
        int height = scanner.nextInt();

        System.out.println("1 - Заповнити рандомно");
        System.out.println("2 - Заповнити з клавіатури");
        int choice = scanner.nextInt();

        Matrix matrix;
        switch (choice) {
            case 1:
                matrix = new Matrix(width, height);
                matrix.fillRandomly();
                break;
            case 2:
                matrix = new Matrix(width, height);
                matrix.fillFromKeyboard();
                break;
            default:
                System.out.println("Невірний вибір!");
                return;
        }

        matrix.print();

        int min = matrix.findMin();
        int max = matrix.findMax();
        double average = matrix.findAverage();

        System.out.println("Мінімальне значення: " + min);
        System.out.println("Максимальне значення: " + max);
        System.out.println("Середнє арифметичне: " + average);
    }
}

class Matrix {

    private final int[][] data;
    private final int width;
    private final int height;

    public Matrix(int width, int height) {
        this.width = width;
        this.height = height;
        data = new int[height][width];
    }

    public void fillRandomly() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                data[i][j] = (int) (Math.random() * 100);
            }
        }
    }

    public void fillFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.printf("Введіть елемент [%d][%d]: ", i, j);
                data[i][j] = scanner.nextInt();
            }
        }
    }

    public int findMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (data[i][j] < min) {
                    min = data[i][j];
                }
            }
        }
        return min;
    }

    public int findMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (data[i][j] > max) {
                    max = data[i][j];
                }
            }
        }
        return max;
    }
    public double findAverage() {
        double sum = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sum += data[i][j];
            }
        }
        return sum / (width * height);
    }

    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}