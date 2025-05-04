import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecursosNaoRespondidos {
    public ArrayList<String> recursosNaoRespondidos(ArrayList<String> linhas) {
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
        return resultado;
    }
}
