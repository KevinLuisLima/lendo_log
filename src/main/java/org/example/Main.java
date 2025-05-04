package org.example;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner getInput = new Scanner(System.in);

    public static void main(String[] args) {
        ManipuladorFile file = new ManipuladorFile();
        MediaRequisicoesPOST mediaRequisicoes = new MediaRequisicoesPOST();
        RecursosRespondidos respondidos = new RecursosRespondidos();
        RecursosNaoRespondidos naoRespondidos = new RecursosNaoRespondidos();
        RequisicoesPorSO porSO = new RequisicoesPorSO();
        ArrayList<String> linhas = new ArrayList<String>();
        linhas = file.leitor();
        Boolean loop = true;
        while(loop) {
            System.out.println("1 - Recursos grandes respondidos\n2 - Não respondidos\n3 - % de requisições por SO\n4 - Média das requisições POST\n0 - Sair\n");
            try {
                int input = getInput.nextInt();
                getInput.nextLine();
                switch (input) {
                    case 1:
                        respondidos.recursosRespondidos(linhas);
                        break;
                    case 2:
                        naoRespondidos.recursosNaoRespondidos(linhas);
                        break;
                    case 3:
                        porSO.percentualPorSO(linhas);
                        break;
                    case 4:
                        System.out.println("Média dos tamanhos das requisições POST com sucesso em 2021: " + mediaRequisicoes.CalcularMediaPOST(linhas) + "\n");
                        break;
                    case 0:
                        loop = false;
                        break;
                }

            } catch (InputMismatchException IME) {
                System.out.println("Input mismatch");
            }
        }
        getInput.close();


    }
}