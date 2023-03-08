package Java.FrogRace;
import java.util.LinkedList;
import java.util.Scanner;

public class FrogRace {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        
        int numSapos;
        int distanciaCorrida;

        LinkedList<Frog> sapos = new LinkedList<Frog>();

        System.out.println("Digite o tamanho da corrida");
        distanciaCorrida = scn.nextInt();

        System.out.println("Quantos sapos haverão na corrida?");
        numSapos = scn.nextInt();

        for(int i = 0; i < numSapos; i++){
            System.out.println("Digite o nome & tamanho do pulo do sapo " + (i+1));
            Frog s = new Frog(scn.next());
            s.setDistanciaPulo(scn.nextInt());
            s.setDistanciaCorrida(distanciaCorrida);
            s.setDaemon(false);
            sapos.add(s);
        }

        for(Frog f: sapos){
            f.start();
        }
    }
}