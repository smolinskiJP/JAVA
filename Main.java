package Java.FrogRace;

public class Main {
    public static void main(String[] args) {
        
        Frog cururu = new Frog("Sapo cururu");
        cururu.setDaemon(false);
        Frog boi = new Frog("Sapo boi");
        boi.setDaemon(false);

        cururu.start();
        boi.start();
    }
}