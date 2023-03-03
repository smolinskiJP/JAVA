package Java.Instapet;

public class Fotos {
    private String url;
    private String descricao;

    //funcao de print
    public void mostra(){
        System.out.println("    Link: " + this.url);
        System.out.println("    Descrição: " + this.descricao);
        System.out.println();
    }

    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
