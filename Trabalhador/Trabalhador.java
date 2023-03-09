package Java.Trabalhador;

public class Trabalhador extends Thread{
    String produto;
    int tempo, i = 0;
    boolean working = true;

    public Trabalhador(String produto, int tempo){
        this.produto = produto;
        this.tempo = tempo;
    }

    @Override
    public void run(){
        while (working){
            System.out.println(i + " " + produto);
            try {
                sleep((long)(Math.random() * tempo));
            } catch (InterruptedException e){}
            System.out.println("Terminei " + produto);
            i++;
        }
    }

    public void parar(){
        working = false;
    }
}
