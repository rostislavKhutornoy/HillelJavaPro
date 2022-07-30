package ua.ithillel.hw9.console;

import ua.ithillel.hw9.entity.Bouquet;
import ua.ithillel.hw9.service.FlowersShop;
import ua.ithillel.hw9.util.InputUtil;

/* Создать консольное приложение, удовлетворяющее следующим требованиям:
Цветочница. Определить иерархию цветов. Создать несколько объектов-цветов.
Собрать букет (используя аксессуары) с определением его стоимости.
Провести сортировку цветов в букете на основе уровня свежести.
Найти цветок в букете, соответствующий заданному диапазону длин стеблей.
Создать свой Exception (унаследовать от Exception), бросать его в случае передачи методу
по поиску цветков по длине отрицательного аргумента и соответственно обработать его в месте вызова этого метода. */

public class FlowerShopConsoleService implements InputUtil {
    private FlowersShop flowersShop;

    public FlowerShopConsoleService(FlowersShop flowersShop) {
        this.flowersShop = flowersShop;
    }

    public static void main(String[] args) {
        FlowersShop shop = new FlowersShop();
        FlowerShopConsoleService flowerShopConsoleService = new FlowerShopConsoleService(shop);
        flowerShopConsoleService.start();
    }

    public void start() {
        int choice = 0;
        do {
            System.out.println("1. Create bouquet");
            System.out.println("2. Bouquets operations");
            System.out.println("3. Print current bouquets");
            System.out.println("0. Exit");

            choice = getInt("Enter -> ");

            switch (choice) {
                case 1 -> {
                    Bouquet bouquet;
                    bouquet = createBouquet();
                    flowersShop.addBouquet(bouquet);
                    System.out.println("\nCreated bouquet price: " + bouquet.price() + "\n");
                }
                case 2 -> {
                    bouquetChoosing();
                }
                case 3 -> {
                    System.out.println(flowersShop);
                }
            }
        } while (choice != 0);
    }

    private Bouquet createBouquet() {
        int choice = 0;
        Bouquet bouquet = new Bouquet();

        do {
            System.out.println("\n1. Add flower");
            System.out.println("2. Add accessory");
            System.out.println("0. Back");

            choice = getInt("Enter -> ");

            switch (choice) {
                case 1 -> {
                    bouquet.addFlower();
                }
                case 2 -> {
                    bouquet.addAccessory();
                }
            }
        } while (choice != 0);
        return bouquet;
    }

    private void bouquetChoosing() {
        System.out.println("\nChoose bouquet: ");
        for (int i = 0; i < flowersShop.getBouquets().length; i++) {
            System.out.println((i + 1) + " -> " + flowersShop.getBouquets()[i].toString());
        }
        int choice = 0;
        while (true) {
            choice = getPositiveInt("Enter -> ");
            if (choice - 1 < flowersShop.getBouquets().length && choice - 1 >= 0) {
                processBouquet(flowersShop.getBouquets()[choice - 1]);
                break;
            } else if (choice == 0){
                break;
            } else {
                System.out.println("Enter the number of the existing bouquet: ");
            }
        }
    }

    private void processBouquet(Bouquet bouquet) {
        int choice = 0;

        do {
            System.out.println("\n1. Sort flowers by days to live");
            System.out.println("2. Find flowers by stem length");
            System.out.println("3. Bouquet price");
            System.out.println("4. Add flower");
            System.out.println("5. Add accessory");
            System.out.println("0. Exit");

            choice = getInt("Enter -> ");

            switch (choice) {
                case 1 -> {
                    bouquet.sortFlowersByDaysOfLife();
                    System.out.println(bouquet);
                }
                case 2 -> {
                    bouquet.findFlowersByStemLength();
                }
                case 3 -> {
                    System.out.println("\nThis bouquet price: " + bouquet.price());
                }
                case 4 -> {
                    bouquet.addFlower();
                }
                case 5 -> {
                    bouquet.addAccessory();
                }
            }
        } while (choice != 0);
    }

    public FlowersShop getFlowersShop() {
        return flowersShop;
    }

    public void setFlowersShop(FlowersShop flowersShop) {
        this.flowersShop = flowersShop;
    }
}
