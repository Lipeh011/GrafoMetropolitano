package app;

import model.*;
import service.MetroSP;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MetroSP metro = new MetroSP();
        Scanner scanner = new Scanner(System.in);

        // Definir estação atual
        System.out.print("Digite sua estação atual: ");
        String nomeAtual = scanner.nextLine();
        Estacao estacaoAtual = metro.getEstacaoPorNome(nomeAtual);
        if (estacaoAtual == null) {
            System.out.println("Estação não encontrada!");
            return;
        }
        metro.definirEstacaoAtual(estacaoAtual);
        System.out.println("📍 Você está em: " + estacaoAtual);

        System.out.print("Digite o destino: ");
        String nomeDestino = scanner.nextLine();
        Estacao destino = metro.getEstacaoPorNome(nomeDestino);
        if (destino == null) {
            System.out.println("Estação não encontrada!");
            return;
        }

        System.out.print("Buscar por tempo (s) ou distância (d)? ");
        String criterio = scanner.nextLine();
        boolean porTempo = criterio.equalsIgnoreCase("s");

        ResultadoRota resultado = metro.encontrarMelhorRota(destino, porTempo);

        System.out.println("\n🚇 ROTA PARA " + destino);
        System.out.println("=================================");
        System.out.println(resultado.getResumo());
        System.out.println("=================================");

        for (InstrucaoRota instrucao : resultado.getInstrucoes()) {
            System.out.println("➡️ " + instrucao);
        }

        System.out.println("=================================");
        System.out.println("🏁 Chegou ao destino!");
    }
}