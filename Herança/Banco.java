package Java.Herança;

public class Banco {
    private int maxContas = 1;
    private int numContas = 0;
    private Conta[] contas = new Conta[this.maxContas];
    
    public void adicionaConta(Conta c){
        checaTamanho();
        this.contas[this.numContas] = c;
        this.numContas++;
    }

    public Conta pegaConta(int x){
        return this.contas[x];
    }

    public int pegaTotalDeContas(){
        return this.numContas;
    }

    public void checaTamanho(){
        if (this.numContas >= this.maxContas){
            this.maxContas += this.maxContas;
            Conta[] tmp = new Conta[this.maxContas];
            for (int i = 0; i < this.numContas; i++){
                tmp[i] = this.contas[i];
            }
            this.contas = tmp;
        }
    }

    public double Relatorio(double selic){
        AttConta att = new AttConta(selic);
        for(int i = 0; i < this.numContas; i++){
            att.roda(contas[i]);
        }
        return att.getSaldoTotal();
    }
}