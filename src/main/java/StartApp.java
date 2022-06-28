import util.Proc;

import java.io.FileInputStream;
import java.util.Scanner;

public class StartApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true){
            printMenu();
            option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Введите название файла:");
                    FileInputStream file = Proc.loadFile(scanner.next());
                    Proc.processing(file);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Выбран не верный пункт меню.");
            }
        }

    }

    private static void printMenu() {
        System.out.println("\n");
        System.out.println("------------МЕНЮ------------");
        System.out.println("Название файла - 1");
        System.out.println("Выход          - 0");
        System.out.println("\n");
        System.out.println("Введите значение:");
    }


}
