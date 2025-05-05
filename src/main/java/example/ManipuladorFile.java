package example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
/*
Classe para manipualr os arquivos.
 */
public class ManipuladorFile {
    public ArrayList<String> leitor() {
        ArrayList<String> output = new ArrayList<>();
        String path = "src/main/resources/access.log";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] vector = line.split("\n");
                String instancia = vector[0];
                output.add(instancia);
            }
            reader.close();
        } catch (IOException IOE) {
            IOE.printStackTrace();
        }
        return output;
    }
    public void escritor(ArrayList<String> input, String nomeDoArquivo){
        String directoryPath = "src/main/java/org/example/Analise";
        String filePath = directoryPath + "/" + nomeDoArquivo;

        try {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            FileWriter writer = new FileWriter(filePath, StandardCharsets.UTF_8,true);

            for (String s : input) {
                writer.write(s + "\n");
            }
            writer.flush();
            writer.close();
        }catch (IOException IOE){
            IOE.printStackTrace();
        }
    }
}
