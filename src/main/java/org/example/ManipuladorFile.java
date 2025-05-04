package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ManipuladorFile {
    public ArrayList<String> leitor() {
        ArrayList<String> output = new ArrayList<>();
        String path = "src/file_de_leitura_e_gerados/access.log";

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
        String path = "src/file_de_leitura_e_gerados/" + nomeDoArquivo;
        try{
            boolean isArchiveExisting = new File(path).exists();
            FileWriter writer = new FileWriter(path, StandardCharsets.UTF_8,true);

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
