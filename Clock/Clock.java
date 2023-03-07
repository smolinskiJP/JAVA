package Java.Clock;

public class Clock extends Thread{

    private int sec = 0;

    @Override
    public void run(){
        while(true){
            sec++;
            System.out.println(sec + " segundos");
            try{
                sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}