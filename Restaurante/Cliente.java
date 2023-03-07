package Java.Restaurante;

public class Cliente {
    private String nome;
    private String email;

    public void setNome(String n){
        this.nome = n;
    }

    public void setEmail(String e){
        this.email = e;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }

    public Cliente(String n, String e){
        this.nome = n;
        this.email = e;
    }
}