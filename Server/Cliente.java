package Java.Server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket cliente = new Socket("127.0.0.1", 12345);
        System.out.println("O Cliente se conectou ao servidor!");

        Scanner in = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());

        while (in.hasNextLine()) {
            saida.println(in.nextLine());
        }

        saida.close();
        in.close();
        cliente.close();
    }
}
