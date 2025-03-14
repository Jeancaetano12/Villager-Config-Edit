import java.util.Scanner;

class SummonVillager {
    int vDirecao;
    int vAi;

    // Construtor que já lê e define a direção
    public SummonVillager() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a direção que o villager vai nascer olhando (0 = Norte, 1 = Leste, 2 = Sul, 3 = Oeste): ");
        this.vDirecao = input.nextInt(); // Lê e armazena o valor da direção
        System.out.println("O villager terá inteligência? (0 = não, 1 = sim)");
        this.vAi = input.nextInt(); // Lê e armazena se tera inteligência
        input.close();
    }

    // Método para obter a direção correspondente
    public String getDirecao() {
        switch (vDirecao) {
            case 0:
                return "[180f,0f]"; // Norte
            case 1:
                return "[270f,0f]"; // Leste
            case 2:
                return "[0f,0f]";   // Sul
            case 3:
                return "[90f,0f]";  // Oeste
            default:
                return "Direção inválida";
        }
    }

    // Método para definir se terá IA ou não
    public String getAi() {
        if (vAi == 0) {
            return "NoAI:1b"; // Villager sem inteligência
        } else if (vAi == 1) {
            return ""; // ? Villager com inteligência
        } else {
            return "Valor inválido para AI"; // Caso vAi tenha um valor inesperado
        }
    }    
}

public class Main {
    public static void main(String[] args) {
        SummonVillager villager = new SummonVillager(); // Criando o objeto já pedindo a direção
        System.out.println("O aldeão está olhando para: " + villager.getDirecao() + "\nCom a IA: " + villager.getAi());

        // Codigo de saída a ser copiado
        System.out.println("Copie o codigo e cole o codigo abaixo para gerar um Villager com as customizações acima: \n");
        System.out.println("/summon minecraft:villager ~ ~ ~ {" + villager.getAi() + ",Rotation:" + villager.getDirecao() + "}\n");

    }

}