package hw_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int NOTEBOOKS_COUNT = 10000;

    public static void main(String[] args) {
        List<Notebook> notebooks = generateListNotebooks();
        notebooks = sort(notebooks);
        displayNotebooks(notebooks);
    }

    private static void displayNotebooks(List<Notebook> list) {
        for (Notebook n: list){
            System.out.println("Ноутбук: цена: "+ n.getPrice()+ "память: "+ n.getMemory() + "производитель: "+ n.getProducer());
        }
    }


    private static ArrayList<Notebook> generateListNotebooks() {
        ArrayList<Notebook> arrayList = new ArrayList<>();
        for (int i = 0; i < NOTEBOOKS_COUNT; i++) {
            arrayList.add(createNotebook());
        }
        return arrayList;
    }

    private static Notebook createNotebook() {
        Random random = new Random();
        int price = (random.nextInt(20) * 100 + 500);
        int memory = (random.nextInt(5) + 1) * 4;
        int producerCount = Notebook.Producer.values().length;
        Notebook.Producer producer = Notebook.Producer.values()[random.nextInt(producerCount)];
        return new Notebook(price, memory, producer);
    }

    private static List sort(List<Notebook> notebooks) {
        int min = 0;
        for (int i = 0; i < notebooks.size() - 1; i++) {
            min = i;
            for (int j = i + 1; j < notebooks.size(); j++) {
                if (notebooks.get(j).compareTo(notebooks.get(min)) < 0) {
                    min = j;
                }
            }
            if (i == min) {
                continue;
            }
            Notebook temp = notebooks.get(i);
            notebooks.set(i, notebooks.get(min));
            notebooks.set(min, temp);
        }
        return notebooks;
    }
}
