package Java.ProdutorConsumidor;

public class Producer extends Thread{
    PilhaSincronizada pilha;

    public Producer(PilhaSincronizada pilha){
        this.pilha = pilha;
    }

    @Override
    public void run(){
        int colorIdx;
        for(int i = 0; i < 40; i++){
            colorIdx = (i + (int)Math.random() * 10);
            pilha.push(colorIdx);
            System.out.println("Criado: " + colorIdx);
            try{
                sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e){}
        }
    }
}