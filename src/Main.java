import java.io.InputStream;
import java.net.URL;
import java.util.List;



public class Main {
    public static void main(String[] args) throws Exception {

        String url = "https://api.nasa.gov/planetary/apod?api_key=V5eNJSevipoJqgSPOOUzSwuPAOV5NhFvoaSJzH34&start_date=2021-10-12&end_date=2021-10-14";

        Client client = new Client();
        String json = client.response(url);

        // Exibir e manipular os dados
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var fabrica = new FabricaDeFigurinhas();

        for (int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i);

            System.out.println(conteudo.getTitulo());
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo().replace(":", "-") + ".png";

            fabrica.cria(inputStream, nomeArquivo);
        }


    }

}