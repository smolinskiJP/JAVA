package Java.ProdutorConsumidor;

public class Consumer extends Thread{
    PilhaSincronizada pilha;
    
    public Consumer(PilhaSincronizada pilha){
        this.pilha = pilha;
    }

    @Override
    public void run(){
        int colorIdx;
        for(int i = 0; i < 20; i++){
            colorIdx = pilha.pop();
            System.out.println("Usado: " + colorIdx);
            try{
                sleep((int)(Math.random() * 5000));
            } catch(InterruptedException e){}
        }
    }
}