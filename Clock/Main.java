package Java.Clock;

public class Main {
    public static void main(String[] args) {
        Clock relogio = new Clock();
        relogio.setDaemon(false);

        relogio.start();

        System.out.println("Leo Prado");
    }
}
