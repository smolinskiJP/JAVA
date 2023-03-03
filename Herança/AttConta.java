package Java.Herança;

public class AttConta {
    
    private double saldoTotal = 0;
    private double selic;

    public AttConta(double selic){
        this.selic = selic;
    }

    public void roda(Conta c){
        System.out.println("Antigo saldo é: " + c.getSaldo());
        c.atualiza(this.selic);
        this.saldoTotal += c.getSaldo();
        System.out.println();
    }

    public double getSaldoTotal(){
        return this.saldoTotal;
    }

    public double getSelic(){
        return this.selic;
    }
}