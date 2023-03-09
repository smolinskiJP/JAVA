package Java.ProdutorConsumidor;

public class TesteProdCons {
    public static void main(String[] args) {
        PilhaSincronizada pil = new PilhaSincronizada();
        Producer prod = new Producer(pil);
        Consumer cons = new Consumer(pil);

        prod.start();
        cons.start();
    }
}