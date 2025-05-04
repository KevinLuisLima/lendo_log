package org.example;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecursosRespondidos {
    ManipuladorFile file = new ManipuladorFile();
    public void recursosRespondidos(ArrayList<String> linhas) {
        ArrayList<String> resultado = new ArrayList<>();

        Pattern objeto = Pattern.compile("(\\d+\\.\\d+\\.\\d+\\.\\d+).*?\\s(2\\d\\d)\\s+(\\d{4,})\\b");

        for (String linha : linhas) {
            Matcher matcher = objeto.matcher(linha);
            if (matcher.find()) {
                String IP = matcher.group(1);
                int codigo = Integer.parseInt(matcher.group(2));
                int tamanho = Integer.parseInt(matcher.group(3));

                if (codigo >= 200 && codigo <= 299 && tamanho > 2000) {
                    resultado.add(codigo + " " + tamanho + " " + IP);
                }
            }
        }
        file.escritor(resultado, "recursosGrandes.txt");
    }
}