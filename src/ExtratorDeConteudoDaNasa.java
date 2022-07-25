import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json) {

        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String urlImage = atributos.get("url");
            String titulo = atributos.get("title");

            var conteudo = new Conteudo(urlImage, titulo);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
