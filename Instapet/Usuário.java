package Java.Instapet;

public class Usuário {
    private static int totalUser = 0;
    private String nome;
    private String email;
    private int numFotos = 0;
    private int maxFotos = 1;
    private Fotos[] fotos = new Fotos[maxFotos];

    public Usuário() {
        totalUser++;
    }

    //funcao de print
    public void mostra(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
        if (this.numFotos > 0){
            for (int i = 0; i < this.numFotos; i++){
                System.out.println("    Foto " + (i + 1));
                this.fotos[i].mostra();
            }
        }
        System.out.println();
    }

    //funcao de atualizacao do vetor fotos
    public void checaTamanho(){
        if (this.numFotos >=  this.maxFotos){
            this.maxFotos += this.maxFotos;
            Fotos[] tmp = new Fotos[this.maxFotos];
            for (int i = 0; i < this.numFotos; i++){
                tmp[i] = this.fotos[i];
            }
            this.fotos = tmp;
        }
    }

    //funcao de cadastro de foto
    public void cadastra_foto(String url, String desc){
        checaTamanho();
        this.fotos[this.numFotos] = new Fotos();
        this.fotos[this.numFotos].setDescricao(desc);
        this.fotos[this.numFotos].setUrl(url);
        this.numFotos++;
    }

    //funcao de alterar descricao da foto n
    public void altera_descricao(int n, String desc){
        if (n < this.numFotos){
            this.fotos[n].setDescricao(desc);
        } else {
            System.out.println("Foto invalida");
        }
    }

    public String getEmail(){
        return this.email;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public int qnt_usuariosU(){
        return totalUser;
    }

    public int qnt_petsU(){
        return this.numFotos;
    }

    public Fotos[] getFotos(){
        return this.fotos;
    }
}