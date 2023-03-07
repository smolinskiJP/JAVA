package Java.Clock;

public class Clock extends Thread{

    private int seg = 0, min = 0, hor = 0;

    @Override
    public void run(){
        while(true){
            seg++;
            if (seg >= 60){
                min++;
                seg = 0;
            }
            if (min >= 60){
                hor++;
                min = 0;
            }
            try{
                sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(hor + ":" + min + ":" + seg);
        }
    }
}
