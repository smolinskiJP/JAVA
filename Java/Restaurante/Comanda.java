package Java.Restaurante;

public class Comanda {
    private String consumo = "";
    private double valor;

    public void listarConsumo(){
        System.out.println(this.consumo);
    }

    public double dezPorcento(){
        return (this.valor * 1.1);
    }

    public double divConta(int numPessoa){
        return (dezPorcento() / (numPessoa * 1.0));
    }

    public void addConsumo(String prod, double val){
        this.valor += val;
        this.consumo += prod;
    }

    public double getValor(){
        return this.valor;
    }
}
