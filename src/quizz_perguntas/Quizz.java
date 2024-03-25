package quizz_perguntas;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Quizz {
    private final Perguntas perguntas = new Perguntas("perguntas.txt");
    private String[] respostasDoUsuario = new String[10];
    private String[] correcao = new String[11];
    private int pontuacao = 0;
    public Quizz() {
    }

    public void initRodada(){
        Scanner sc = new Scanner(System.in);
        String option = "";
        do {
            System.out.println("1.Iniciar rodada\n2.Pontuação\n3.Sair");
            option = sc.nextLine();
            if(option.equals("1")){
                for (int i = 0; i < perguntas.getPerguntasEscolhidas().length; i++) {
                    System.out.println(perguntas.getPerguntasEscolhidas()[i][0]);
                    respostasDoUsuario[i] = sc.nextLine();
                }
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("respostas.txt"))) {
                    for (int i = 0; i < perguntas.getPerguntasEscolhidas().length; i++) {
                        if (respostasDoUsuario[i].equalsIgnoreCase(perguntas.getRespostasCorretas()[i])) {
                            pontuacao++;
                            bw.write(perguntas.getPerguntasEscolhidas()[i][0] + ", acerto\n");
                        } else {
                            bw.write(perguntas.getPerguntasEscolhidas()[i][0] + ", erro\n");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(option.equals("2")){
                acessarRespostas();
                System.out.println("Pontuação: " + pontuacao);
            }
        } while(!option.equals("3"));
    }

    public void acessarRespostas(){
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("respostas.txt"))) {
            String line = br.readLine();
            while (line != null) {
                correcao[contador] = line;
                line = br.readLine();
                contador++;
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        Arrays.stream(correcao).filter(str -> str != null).forEach(System.out::println);
    }

    public String[] getRespostas() {
        return respostasDoUsuario;
    }

    public void setRespostas(String[] respostas) {
        this.respostasDoUsuario = respostas;
    }

    public int getPontuacao() {
        return pontuacao;
    }
}