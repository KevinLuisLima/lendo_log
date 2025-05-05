package example;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Classe para os recursos não respondidos pêgos em novembro de 2021.
 */
public class RecursosNaoRespondidos {
    ManipuladorFile file = new ManipuladorFile();
    public void recursosNaoRespondidos(ArrayList<String> linhas) {
        ArrayList<String> resultado = new ArrayList<>();
        Pattern objeto = Pattern.compile(".*?/Nov/2021.*?\\s(4\\d\\d)\\s.*?(http://\\S+)");

        for (String linha : linhas) {
            Matcher matcher = objeto.matcher(linha);
            if (matcher.find()) {
                int codigo = Integer.parseInt(matcher.group(1));
                String endereco = (matcher.group(2));

                if (codigo >= 400 && codigo <= 499) {
                    resultado.add(codigo + " " + endereco + " " + "Nov/2021");
                }
            }
        }
        file.escritor(resultado, "naoRespondidosNovembro.txt");
    }
}
