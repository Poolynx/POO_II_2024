package quizz_perguntas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Perguntas {
    private List<String> perguntasTodas = new ArrayList<>();
    private String[][] perguntasEscolhidas;
    private String[]respostasCorretas = new String[10];

    private String path;

    public Perguntas() {
    }
    public Perguntas(String path) {
        this.path = path;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                perguntasTodas.add(line);
                line = br.readLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        perguntasEscolhidas = escolherPerguntas(perguntasTodas);
        gerarRespostasCorretas();
    }

    private String[][] escolherPerguntas(List<String> perguntas){
        String[][] perguntasEscolhidas = new String[10][2];
        List<Integer>numeroSorteado = new ArrayList<>();
        for(int i = 1; i < 11; i++){
            Random random = new Random();
            int rand = random.nextInt(50);

            while (numeroSorteado.contains(rand)){
                rand = random.nextInt(50);
            }
            numeroSorteado.add(rand);
            String[] arr = perguntas.get(rand).split(",");
            perguntasEscolhidas[i - 1][0] = arr[0].trim();
            perguntasEscolhidas[i - 1][1] = arr[1].trim();
        }
        return perguntasEscolhidas;
    }

    public void gerarRespostasCorretas(){
        for(int i = 0; i < 10; i++){
            respostasCorretas[i] = perguntasEscolhidas[i][1];
        }
    }

    public String[] getRespostasCorretas() {
        return respostasCorretas;
    }

    public String exibirPerguntaEscolhida(int numeroPergunta){
        return perguntasEscolhidas[numeroPergunta - 1][0];
    }

    public String exibirRespostaCorreta(int numeroPergunta){
        return perguntasEscolhidas[numeroPergunta - 1][1];
    }

    public List<String> getPerguntasTodas() {
        return perguntasTodas;
    }

    public String[][] getPerguntasEscolhidas() {
        return perguntasEscolhidas;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}