package org.example;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequisicoesPorSO {
    ManipuladorFile file = new ManipuladorFile();

    public void percentualPorSO(ArrayList<String> linhas) {
        Map<String, Integer> contagemPorSO = new HashMap<>();
        contagemPorSO.put("Windows", 0);
        contagemPorSO.put("Macintosh", 0);
        contagemPorSO.put("Ubuntu", 0);
        contagemPorSO.put("Fedora", 0);
        contagemPorSO.put("Mobile", 0);
        contagemPorSO.put("Linux, outros", 0);

        int total = 0;
        Pattern pattern = Pattern.compile("\\[\\d{2}/\\w{3}/2021:\\d{2}:\\d{2}:\\d{2} [+-]\\d{4}\\] \".*?\" \\d+ \\d+ \".*?\" \"([^\"]*)\"");

        for (String linha : linhas) {
            Matcher matcher = pattern.matcher(linha);
            if (matcher.find()) {
                String userAgent = matcher.group(1).toLowerCase();
                total++;
                if (userAgent.contains("windows")) {
                    contagemPorSO.put("Windows", contagemPorSO.get("Windows") + 1);
                } else if (userAgent.contains("macintosh")) {
                    contagemPorSO.put("Macintosh", contagemPorSO.get("Macintosh") + 1);
                } else if (userAgent.contains("ubuntu")) {
                    contagemPorSO.put("Ubuntu", contagemPorSO.get("Ubuntu") + 1);
                } else if (userAgent.contains("fedora")) {
                    contagemPorSO.put("Fedora", contagemPorSO.get("Fedora") + 1);
                } else if (userAgent.contains("mobile") || userAgent.contains("android")) {
                    contagemPorSO.put("Mobile", contagemPorSO.get("Mobile") + 1);
                } else if (userAgent.contains("x11") || userAgent.contains("linux")) {
                    contagemPorSO.put("Linux, outros", contagemPorSO.get("Linux, outros") + 1);
                }
            }
        }

        Map<String, Double> percentualPorSO = new HashMap<>();
        if (total > 0) {
            for (Map.Entry<String, Integer> entry : contagemPorSO.entrySet()) {
                double percentual = (double) entry.getValue() * 100/ total;
                percentualPorSO.put(entry.getKey(), percentual);
            }
        } else {
            for (String so : contagemPorSO.keySet()) {
                percentualPorSO.put(so, 0.0);
            }
        }

        ArrayList<String> linhasFormatadas = new ArrayList<>();
        for (Map.Entry<String, Double> entry : percentualPorSO.entrySet()) {
            linhasFormatadas.add(entry.getKey() + " - " + String.format("%.4f", entry.getValue()) + "%");
        }

        file.escritor(linhasFormatadas, "sistemasOperacionais.txt");
    }
}