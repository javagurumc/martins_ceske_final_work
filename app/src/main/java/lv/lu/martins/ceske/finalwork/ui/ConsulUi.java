package lv.lu.martins.ceske.finalwork.ui;

import lv.lu.martins.ceske.finalwork.model.ProductInputData;
import lv.lu.martins.ceske.finalwork.service.ProductService;

import java.util.Scanner;

public class ConsulUi {

    private ProductService productService = new ProductService();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        while (true) {

            printMenu();
            userChoice = scanner.nextInt();

            if (userChoice == 1) {
                ProductInputData productInputData = new ProductInputData();
                productService.save(productInputData);
            } else if (userChoice == 2) {
                productService.findAll().stream()
                        .forEach(System.out::println);
            }

            if (userChoice == 0) {
                break;
            }
        }
    }

    private void printMenu() {
        System.out.println("\n\n === Product Accounting Application === ");
        System.out.println(" Choose one option: \n");
        System.out.println(" Save product - 1");
        System.out.println(" List all products - 2");
        System.out.println(" Exit application - 0");
        System.out.println(" Please enter the choice");
    }
}
