package Java.FrogRace;

public class Frog extends Thread{

    private String name;
    private int distanciaPercorrida = 0;

    private static boolean first = false;
    private int distanciaPulo;
    private static int distanciaCorrida;

    public Frog(String name){
        this.name = name;
    }

    public void setDistanciaPulo(int distanciaPulo) {
        this.distanciaPulo = distanciaPulo;
    }

    public void setDistanciaCorrida(int distanciaCorr){
        distanciaCorrida = distanciaCorr;
    }

    @Override
    public void run(){
        while(!first && this.distanciaPercorrida <= distanciaCorrida){
            //informar e modificar a distanciaPercorridaicao
            System.out.println(this.name + " está na " + this.distanciaPercorrida + "º milha");
            this.distanciaPercorrida += distanciaPulo;

            //definir e executar tempo de sleep
            System.out.println();
            
            //verificar se chegou ao fim
            if(this.distanciaPercorrida >= distanciaCorrida){
                first = true;
                System.out.println("ACABOUUUUU!!!!!");
                System.out.println(this.name + " venceu");
            }
        }

    }

}