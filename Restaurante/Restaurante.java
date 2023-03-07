package Java.Restaurante;

import java.util.LinkedList;

public class Restaurante {
    private String nome;
    private String end;
    private LinkedList<Mesa> mesas = new LinkedList<Mesa>();

    public void addClienteReserva(Cliente c, int numMesa){
        (mesas.get(numMesa)).addCliente(c);
    }

    public void addClienteReserva(Cliente c){
        int i = 0;
        while (i < mesas.size()){
            if ((mesas.get(i)).getReserv() == false){
                mesas.get(i).addCliente(c);
                break;
            } else i++;
        }
        if (i == mesas.size()){
            System.out.println("RESTAURANTE CHEIO, AS MESAS RESTANTES ESTÃO RESERVADAS");
        }
    }

    public void fazerPedido(int numMesa, double valor, String desc){
        System.out.println(desc + " de " + valor + " reais sendo pedido na mesa " + (numMesa + 1));
        (mesas.get(numMesa)).fazerPedido(valor, desc);
    }

    public void encerrar(int numMesa){
        System.out.println("Mesa " + (numMesa + 1) + " encerrando");
        (mesas.get(numMesa)).encerrar();
        System.out.println();
    }

    public boolean reservar(int numMesa, String data){
        return (mesas.get(numMesa)).reservar(data);
    }

    public Restaurante(String n, String e){
        this.nome = n;
        this.end = e;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public void setEnd(String e){
        this.end = e;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEnd(){
        return this.end;
    }

    public void printaMesas(){
        int i = 0;
        for(Mesa m : mesas){
            System.out.print((i + 1) + " Mesa: ");
            if(m.getReserv() == true){
                System.out.println("Reservada para o dia " + m.getData());
                for(Cliente c : m.getClientes()){
                    System.out.println("    Cliente " + c.getNome() + " do email " + c.getEmail());
                }
            } else {
                System.out.println("Não está reservada");
                for(Cliente c : m.getClientes()){
                    System.out.println("    Cliente " + c.getNome() + " do email " + c.getEmail());
                }
            }
            i++;
        }
    }

    public void addMesa(Mesa m){
        mesas.add(m);
    }
}