package hw_2;

public class Notebook implements Comparable<Notebook> {
int price;
int memory;
    Producer producer;

    public Notebook(int price, int memory, Producer producer) {
        this.price = price;
        this.memory = memory;
        this.producer = producer;
    }

    public enum Producer{
        XAMIOU, ESER,LENOVO, ASOR
    }

    @Override
    public int compareTo(Notebook o) {
       int result = Integer.compare(price, o.getPrice());
       if (result==0){
           result = Integer.compare(memory,o.getMemory());
           if (result==0){
               return producer.compareTo(o.getProducer());
           }
           return result;
       }
        return result;
    }

    public int getPrice() {
        return price;
    }

    public int getMemory() {
        return memory;
    }

    public Producer getProducer() {
        return producer;
    }
}
