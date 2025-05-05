package example;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Classe para calcular a media de requisições post.
 */
public class MediaRequisicoesPOST {
	public Double CalcularMediaPOST(ArrayList<String> linhas){
		ArrayList<Integer> tamanhoSucessos = new ArrayList<>();
		Pattern pattern = Pattern.compile("\\[(\\d{2}/\\w{3}/(\\d{4}):\\d{2}:\\d{2}:\\d{2} \\+\\d{4})\\] \"(POST) .*\" (\\d{3}) (\\d+) .*");
		
		for (String linha : linhas) {
			Matcher matcher = pattern.matcher(linha);
			if(matcher.find()) {
				String Tempo = matcher.group(1);
				int ano = Integer.parseInt(matcher.group(2));
				String tipo = matcher.group(3);
				int codigo = Integer.parseInt(matcher.group(4));
				int tamanho = Integer.parseInt(matcher.group(5));
			
				if(ano==2021 && tipo.equals("POST") && codigo >=200 && codigo<=299 ) {
					tamanhoSucessos.add(tamanho);
				}
			}
		}
		double soma = 0;
		for(int tamanho : tamanhoSucessos) {
			soma += tamanho;
		}
		return soma/tamanhoSucessos.size();
		}
	}
	

