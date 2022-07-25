public class Conteudo {

    private final String titulo;
    private final String urlImagem;

    public Conteudo(String urlImagem, String titulo) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
    }

    public String getUrlImagem() {
        return urlImagem;
    }
    public String getTitulo() {
        return titulo;
    }
}
