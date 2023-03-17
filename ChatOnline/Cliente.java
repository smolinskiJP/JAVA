package Java.ChatOnline;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    private Socket cliente;
    private BufferedReader buffR;
    private BufferedWriter buffW;
    private String nome;

    public static void main(String[] args) throws UnknownHostException, IOException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = scan.nextLine();
        Socket socket = new Socket("127.0.0.1", 6969);
        Cliente cliente = new Cliente(socket, nome);
        cliente.esperaLine();
        cliente.mandarLine();
        scan.close();
    }

    public Cliente(Socket cliente, String nome){
        try{
            this.cliente = cliente;
            this.buffW = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));
            this.buffR = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            this.nome = nome;
        } catch (IOException e){
            fechaCliente(cliente, buffR, buffW);
        }
    }

    public void mandarLine(){
        try{
            buffW.write(nome);
            buffW.newLine();
            buffW.flush();

            Scanner scan = new Scanner(System.in);
            while(cliente.isConnected()){
                String line = scan.nextLine();
                buffW.write("\u001B[31m" + nome + ": " + line + "\u001B[m");
                buffW.newLine();
                buffW.flush();
            }
            scan.close();
        } catch (IOException e){
            fechaCliente(cliente, buffR, buffW);
        }
    }

    public void esperaLine(){
        new Thread(new Runnable() {
            @Override
            public void run(){
                String line;
                while(cliente.isConnected()){
                    try{
                        line = buffR.readLine();
                        System.out.println(line);
                    } catch (IOException e){
                        fechaCliente(cliente, buffR, buffW);
                    }
                }
            }
        }).start();
    }

    public void fechaCliente(Socket cliente, BufferedReader buffR, BufferedWriter buffW){
        try{
            if(buffR != null) buffR.close();
            if(buffW != null) buffW.close();
            if(cliente != null) cliente.close();
        } catch(IOException e){}
    }
}
