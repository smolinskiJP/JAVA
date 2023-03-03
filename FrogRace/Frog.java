package Java.FrogRace;
import java.util.Random;

public class Frog extends Thread{

    private String name;
    private int pos = 0;

    private Random rdm = new Random();
    private static boolean first = false;

    public Frog(String name){
        this.name = name;
    }

    @Override
    public void run(){
        
        int endPos = 100;

        while(!first && this.pos <= endPos){
            //informar e modificar a posicao
            System.out.println(this.name + " está na " + this.pos + "º milha");
            this.pos++;

            //definir e executar tempo de sleep
            try{
                sleep(this.rdm.nextInt(300));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println();
            
            //verificar se chegou ao fim
            if(this.pos >= endPos){
                first = true;
                System.out.println("ACABOUUUUU!!!!!");
                System.out.println(this.name + " venceu");
            }
        }

    }

}