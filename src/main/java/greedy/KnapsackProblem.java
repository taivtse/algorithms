package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KnapsackProblem {
    static class Item {
        String name;
        int weight;
        int value;
        int quantity;

        public Item(String name, int weight, int value, int quantity) {
            this.name = name;
            this.weight = weight;
            this.value = value;
            this.quantity = quantity;
        }

        static class WeightComparator implements Comparator<Item> {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        }

        static class ValueComparator implements Comparator<Item> {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o2.value, o1.value);
            }
        }

        static class UnitPriceComparator implements Comparator<Item> {
            @Override
            public int compare(Item o1, Item o2) {
                return Float.compare((float) o2.value / o2.weight, (float) o1.value / o1.weight);
            }
        }
    }

    private int knapsackWeight;
    private List<Item> itemList;
    private List<Integer> itemMark;

    public KnapsackProblem(List<Item> itemList, int knapsackWeight) {
        this.itemList = itemList;
        this.knapsackWeight = knapsackWeight;
        itemMark = new ArrayList<>();
    }

    private void sortByItemWeight() {
        itemList.sort(new Item.WeightComparator());
    }

    private void sortByItemValue() {
        itemList.sort(new Item.ValueComparator());
    }

    private void sortByItemUnitPrice() {
        itemList.sort(new Item.UnitPriceComparator());
    }

    public void greedyByWeight() {
        this.sortByItemWeight();
        int num;
        int weightTemp = this.knapsackWeight;
        for (int i = 0; i < itemList.size(); i++) {
            num = weightTemp / itemList.get(i).weight;
            weightTemp %= itemList.get(i).weight;
            itemMark.add(num);
        }
        this.displayResult();
    }

    public void greedyByValue() {
        this.sortByItemValue();
        int num;
        int weightTemp = this.knapsackWeight;
        for (int i = 0; i < itemList.size(); i++) {
            num = weightTemp / itemList.get(i).weight;
            weightTemp %= itemList.get(i).weight;
            itemMark.add(num);
        }
        this.displayResult();
    }

    private void greedyByUnitPrice() {
        this.sortByItemUnitPrice();
        int num;
        int weightTemp = this.knapsackWeight;
        for (int i = 0; i < itemList.size(); i++) {
            num = weightTemp / itemList.get(i).weight;
            weightTemp %= itemList.get(i).weight;
            itemMark.add(num);
        }
        this.displayResult();
    }

    private void displayResult() {
        System.out.println("Ket qua trom duoc: ");
        int totalWeight = 0;
        int totalValue = 0;
        for (int i = 0; i < itemMark.size(); i++) {
            System.out.printf("%4d cai %20s\n", itemMark.get(i), itemList.get(i).name);
            totalWeight += itemList.get(i).weight * itemMark.get(i);
            totalValue += itemList.get(i).value * itemMark.get(i);
        }
        System.out.println("\n----------------------------");
        System.out.println("Tong so kg trong tui: " + totalWeight);
        System.out.println("Tong gia tri thu duoc: " + totalValue);
    }

    public static void main(String[] args) {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("TV Samsung", 18, 18, 10));
        itemList.add(new Item("TV Sony", 25, 25, 5));
        itemList.add(new Item("Laptop Acer", 9, 18, 30));
        itemList.add(new Item("Macbook Pro", 5, 60, 15));
        itemList.add(new Item("Dan loa 7.1", 20, 80, 15));
        itemList.add(new Item("Tablet Samsung", 3, 9, 13));
        itemList.add(new Item("Iphone X", 2, 20, 19));
        KnapsackProblem knapsackProblem = new KnapsackProblem(itemList, 37);
//        knapsackProblem.greedyByWeight();
//        knapsackProblem.greedyByValue();
        knapsackProblem.greedyByUnitPrice();
    }
}
