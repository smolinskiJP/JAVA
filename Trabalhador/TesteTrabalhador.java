package Java.Trabalhador;
import java.util.Scanner;

public class TesteTrabalhador {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Digite 0 quando o trabalhador deve parar de trabalhar (enter para continuar)");
        scan.nextLine();

        Trabalhador sebastiao = new Trabalhador("RTX 3060", 10000);
        sebastiao.start();
        Trabalhador roberto = new Trabalhador("Chinelo", 1000);
        roberto.start();

        if (scan.nextInt() == 0){
            roberto.parar();
            sebastiao.parar();
        }
    }
}


