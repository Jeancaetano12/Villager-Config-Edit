import java.util.Scanner;

class SummonVillager {
    int vDirecao;
    int vAi;
    int vSpawn;
    boolean bTrava = true;
    int vReiniciar;
    boolean bTrava2 = true;
    int vConfirm;
    
    // Construtor que já lê e define a direção
    public SummonVillager() {
        Scanner input = new Scanner(System.in);
        while (bTrava == true) {
            System.out.println("Você quer Spawnar um villager do zero? (0 = Sim, 1 = Não)");
            this.vSpawn = input.nextInt();
            if (vSpawn == 0) {
                System.out.println("Digite a direção que o villager vai nascer olhando (0 = Norte, 1 = Leste, 2 = Sul, 3 = Oeste): ");
                this.vDirecao = input.nextInt(); // Lê e armazena o valor da direção
                System.out.println("O villager terá inteligência? (0 = não, 1 = sim)");
                this.vAi = input.nextInt(); // Lê e armazena se tera inteligência
                bTrava = !bTrava;
            } else if (vSpawn == 1) {
                bTrava = !bTrava;
            } else {
                System.out.println("Digite um valor valido");
            }    
        }     
        
    }
    // Méodo para verificar vSpawn
    public int lerSpawn() {
        return vSpawn;
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
    // Método para ler a variavel de REINICIO
    public int lerREINICIAR() {
        return vReiniciar;
    }
    // Método para gravar na variavel de REINICIO
    public void setREINICIAR() {
        Scanner input = new Scanner(System.in);
        while (bTrava2) {
            System.out.println("Você quer refazer o processo? (0 = Sim, 1 = Não)");
            this.vConfirm = input.nextInt();
            if (vConfirm == 0) {
                bTrava2 = !bTrava2;
                break;
            } else if (vConfirm == 1) {
                bTrava2 = !bTrava2;
                break;
            } else {
                System.out.println("Digite um valor valido");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SummonVillager villager = new SummonVillager(); // Criando o objeto já pedindo a direção
            if (villager.lerSpawn() == 0) {
            System.out.println("O aldeão está olhando para: " + villager.getDirecao() + "\nCom a IA: " + villager.getAi());
            // Codigo de saída para sumonar a ser copiado
            System.out.println("Copie o codigo e cole o codigo abaixo para gerar um Villager com as customizações acima: \n");
            if (villager.getAi() == "") { // Menssagem para NPC com IA
                System.out.println("/summon minecraft:villager ~ ~ ~ {Rotation:" + villager.getDirecao() + "}\n");
            } else {    // Menssagem para NPC sem IA
                System.out.println("/summon minecraft:villager ~ ~ ~ {" + villager.getAi() + ",Rotation:" + villager.getDirecao() + "}\n");
                
                villager.setREINICIAR();
                if (villager.lerREINICIAR() == 1) {
                    System.exit(0);
                } 
            }
        } else if (villager.lerSpawn() == 1) {
            System.out.println("Em construção");



            villager.setREINICIAR();
            if (villager.lerREINICIAR() == 1) {
                System.exit(0);
            } 
        }
    }
}