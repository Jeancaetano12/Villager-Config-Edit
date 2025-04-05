import java.util.Scanner;

class SummonVillager {
    int vDirecao;
    int vAi;
    int vSpawn;
    boolean bTrava = true;
    Scanner input = new Scanner(System.in);
    // Construtor que já lê e define a direção
    public SummonVillager() {
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
}
// Classe pra tratar de métodos usados pra reiniciar processos
class Reinicio {
    int vReiniciar;
    int vConfirm;
    Scanner input = new Scanner(System.in);
    // Método para ler a variavel vReiniciar
    public int lerREINICIAR() {
        return vReiniciar;
    }
    // Método para gravar na variavel de vReiniciar
    public void setREINICIAR() {
        while (true) {
            System.out.println("Você quer refazer o processo? (0 = Sim, 1 = Não)");
            this.vConfirm = input.nextInt();
            if (vConfirm == 0 || vConfirm == 1) {
                vReiniciar = vConfirm;
                break;
            } else {
                System.out.println("Digite um valor valido");
            }
        }
    }
}
class Objeto {
    Scanner input = new Scanner(System.in);
    String vObjeto; 
    String vNomeCodigo;
    String vNome;
    int vCorNomeInt;
    String vCorNomeString;
    int vCorMsgInt;
    String vCorMsgString;
    String vMsg;
    // Método para gravar o nome do Objeto
    public void setObjeto() {
        System.out.print("Declare o Objeto: ");
        this.vObjeto = input.nextLine();
        System.out.printf("Objeto salvo como: %s%s", vObjeto, "\n");
    }
    // Método para ler o nome do Objeto
    public String lerObjeto() {
        return vObjeto;
    }
    // Método para REFERENCIAR o Villager spawnado no código e definir o nome escrito em tela
    public void setNomeCodigo() {
        System.out.print("Digite o nome da sua ENTIDADE Villager (nome que aparece em cima dele): ");
        this.vNomeCodigo = input.nextLine();
        System.out.printf("Nome salvo no código como: %s%s", vNomeCodigo, "\n");
        System.out.print("Digite o nome que irá EXIBIR no CHAT para esse Villager: ");
        this.vNome = input.nextLine();
        System.out.printf("Nome que será exibido: %s%s", vNome, "\n");
    }
    // Método para ler o nome de REFERENCIA no CODIGO
    public String lerNomeCodigo() {
        return vNomeCodigo;
    }
    // Método para ler o nome a ser EXIBIDO
    public String lerNome() {
        return vNome;
    }
    // Método para definir a cor do NOME EXIBIDO
    public void setCorNome() {
        System.out.print("Qual cor o nome de exibição deve ter?\n(0 = Verde, 1 = Dourado, 2 = Vermelho, 3 = Azul, 4 = Roxo Escuro) \n");
        this.vCorNomeInt = input.nextInt();
        switch (vCorNomeInt) {
            case 0:
                vCorNomeString = "green"; // Verde
                break;
            case 1:
                vCorNomeString = "gold"; // Dourado
                break;
            case 2:
                vCorNomeString = "red"; // Vermelho
                break;
            case 3:
                vCorNomeString = "blue"; // Azul
                break;
            case 4:
                vCorNomeString = "dark_purple"; // Roxo Escuro
                break;
            default:
                vCorNomeString = "white"; // branco
                break;
        }
        System.out.printf("Cor selecionada: %s%s", vCorNomeString, "\n");  
    }
    //Método para ler a cor do nome EXIBIDO
    public String lerCorNome() {
        return vCorNomeString;
    }
    // Método para gravar a Mensagem exibida
    public void setMsg() {
        System.out.println("O que o Villager em questão vai dizer?");
        this.vMsg = input.nextLine();
        System.out.printf("O Villager vai dizer:\n%s%s", vMsg, "\n");
    }
    // Método para ler a Mensagem exibida
    public String lerMsg() {
        return vMsg;
    }
    // Método para gravar a cor da Mensagem
    public void setCorMsg() {
        System.out.print("Qual cor a Mensagem deve ter?\n(0 = Branco, 1 = Dourado, 2 = Vermelho, 3 = Azul, 4 = Roxo Escuro) \n");
        this.vCorMsgInt = input.nextInt();
        switch (vCorMsgInt) {
            case 0:
                vCorMsgString = "white"; // Branco
                break;
            case 1:
                vCorMsgString = "gold"; // Dourado
                break;
            case 2:
                vCorMsgString = "red"; // Vermelho
                break;
            case 3:
                vCorMsgString = "blue"; // Azul
                break;
            case 4:
                vCorMsgString = "dark_purple"; // Roxo Escuro
                break;
            default:
                vCorMsgString = "white"; // branco
                break;
        }
        System.out.printf("Cor selecionada: %s%s", vCorMsgString, "\n");  
    }
    // Método para ler a cor da mensagem
    public String lerCorMsg() {
        return vCorMsgString;
    }
}
public class Main {
    public static void main(String[] args) {
        Reinicio reiniciar = new Reinicio(); // Objeto usado para funções de reinicio
        do {
            SummonVillager villager = new SummonVillager(); // Criando o objeto já pedindo a direção
            // Verifica de onde começa o código
            if (villager.lerSpawn() == 0) {
            System.out.println("O aldeão está olhando para: " + villager.getDirecao() + "\nCom a IA: " + villager.getAi());
            // Codigo de saída para sumonar a ser copiado
            System.out.println("Copie o codigo e cole o codigo abaixo para gerar um Villager com as customizações acima: \n");
            if (villager.getAi().isEmpty()) { // Menssagem para NPC com IA
                System.out.println("/summon minecraft:villager ~ ~ ~ {Rotation:" + villager.getDirecao() + "}\n");
                // Separando as fazes de criação manualmente :)
                System.out.println("Passando para criação de mensagem -->");
                // Criando um objeto para referenciar
                Objeto nomeObjeto = new Objeto();
                // Criando um objeto para tratar do nome em CÓDIGO e EXIBIÇÂO
                Objeto nomeVillager = new Objeto();
                // Criando um objeto para tratar da mensagem EXIBIDA
                Objeto mensagemVillager = new Objeto();
                System.out.println("Primeiro você precisa criar um OBJETO para se referenciar a esse villager: ");
                nomeObjeto.setObjeto();
                // Imprimindo o codigo para criar o objeto interativo
                System.out.println("Copie e cole o codigo abaixo para começar a criação de dialogo: \n");
                System.out.println("/scoreboard objectives add " + nomeObjeto.lerObjeto() + " minecraft.custom:minecraft.talked_to_villager" + "\n");
                // Definindo o nome no código e de exibição do villager
                nomeVillager.setNomeCodigo(); 
                // Definindo a cor do nome
                nomeVillager.setCorNome();
                // Definindo a Mensagem 
                mensagemVillager.setMsg();
                // Definindo a cor da Mensagem
                mensagemVillager.setCorMsg();
                // Mensagem de saida
                System.out.println("Copie e cole o codigo abaixo em um Command Block Setado em: Repetição, e Sempre Ativo\n");
                System.out.println("execute as @a[scores={" 
                    + nomeObjeto.lerObjeto() 
                    + "=1}] at @s run execute if entity @e[type=villager,name=\"" 
                    + nomeVillager.lerNomeCodigo() 
                    + "\",distance=..6] run tellraw @s [\"\",{\"text\":\"" 
                    + nomeVillager.lerNome() 
                    + " \",\"color\":\"" 
                    + nomeVillager.lerCorNome() 
                    + "\"},{\"text\":\"" 
                    + mensagemVillager.lerMsg() 
                    + "\",\"color\":\"" 
                    + mensagemVillager.lerCorMsg() 
                    + "\"}]\n");
                System.out.println("Cole o codigo abaixo para resetar o dialogo em um 2° Command Block Setado em: Em Cadeia, e Sempre Ativo\n");
                System.out.println("scoreboard players set @a[scores={" + nomeObjeto.lerObjeto() + "=1}] " + nomeObjeto.lerObjeto() + " 0\n");
                // Chamando verificação de reiniciar
                reiniciar.setREINICIAR();
                if (reiniciar.lerREINICIAR() == 1) {
                    System.out.println("Fechando o programa...");
                    System.exit(0);
                }
            } else {    // Menssagem para NPC sem IA
                System.out.println("/summon minecraft:villager ~ ~ ~ {" + villager.getAi() + ",Rotation:" + villager.getDirecao() + "}\n");
                // Separando as fazes de criação manualmente :)
                System.out.println("Passando para criação de mensagem -->");
                // Criando um objeto para referenciar
                Objeto nomeObjeto = new Objeto();
                // Criando um objeto para tratar do nome em CÓDIGO e EXIBIÇÂO
                Objeto nomeVillager = new Objeto();
                // Criando um objeto para tratar da mensagem EXIBIDA
                Objeto mensagemVillager = new Objeto();
                System.out.println("Primeiro você precisa criar um OBJETO para se referenciar a esse villager: ");
                nomeObjeto.setObjeto();
                // Imprimindo o codigo para criar o objeto interativo
                System.out.println("Copie e cole o codigo abaixo para começar a criação de dialogo: \n");
                System.out.println("/scoreboard objectives add " + nomeObjeto.lerObjeto() + " minecraft.custom:minecraft.talked_to_villager" + "\n");
                // Definindo o nome no código e de exibição do villager
                nomeVillager.setNomeCodigo(); 
                // Definindo a cor do nome
                nomeVillager.setCorNome();
                // Definindo a Mensagem 
                mensagemVillager.setMsg();
                // Definindo a cor da Mensagem
                mensagemVillager.setCorMsg();
                // Mensagem de saida
                System.out.println("Copie e cole o codigo abaixo em um Command Block Setado em: Repetição, e Sempre Ativo\n");
                System.out.println("execute as @a[scores={" 
                    + nomeObjeto.lerObjeto() 
                    + "=1}] at @s run execute if entity @e[type=villager,name=\"" 
                    + nomeVillager.lerNomeCodigo() 
                    + "\",distance=..6] run tellraw @s [\"\",{\"text\":\"" 
                    + nomeVillager.lerNome() 
                    + " \",\"color\":\"" 
                    + nomeVillager.lerCorNome() 
                    + "\"},{\"text\":\"" 
                    + mensagemVillager.lerMsg() 
                    + "\",\"color\":\"" 
                    + mensagemVillager.lerCorMsg() 
                    + "\"}]\n");
                System.out.println("Cole o codigo abaixo para resetar o dialogo em um 2° Command Block Setado em: Em Cadeia, e Sempre Ativo\n");
                System.out.println("scoreboard players set @a[scores={" + nomeObjeto.lerObjeto() + "=1}] " + nomeObjeto.lerObjeto() + " 0\n");
                // Chamando verificação de reiniciar
                reiniciar.setREINICIAR();
                if (reiniciar.lerREINICIAR() == 1) {
                    System.out.println("Fechando o programa...");
                    System.exit(0);
                }
            }
            // Verifica de onde começa o código
        } else if (villager.lerSpawn() == 1) {
            Objeto nomeObjeto = new Objeto();
            Objeto nomeVillager = new Objeto();
            Objeto mensagemVillager = new Objeto();
            // Separando as fazes de criação manualmente :)
            System.out.println("Passando para criação de mensagem -->");
            // Criando um objeto para referenciar
            System.out.println("Primeiro você precisa criar um OBJETO para se referenciar a esse villager: ");
            nomeObjeto.setObjeto();
            // Imprimindo o codigo para criar o objeto interativo
            System.out.println("Copie e cole o codigo abaixo para começar a criação de dialogo: \n");
            System.out.println("/scoreboard objectives add " + nomeObjeto.lerObjeto() + " minecraft.custom:minecraft.talked_to_villager" + "\n");
            // Definindo o nome no código e de exibição do villager
            nomeVillager.setNomeCodigo(); 
            // Definindo a cor do nome
            nomeVillager.setCorNome();
            // Definindo a Mensagem 
            mensagemVillager.setMsg();
            // Definindo a cor da Mensagem
            mensagemVillager.setCorMsg();
            // Mensagem de saida
            System.out.println("Copie e cole o codigo abaixo em um Command Block Setado em: Repetição, e Sempre Ativo\n");
            System.out.println("execute as @a[scores={" 
                + nomeObjeto.lerObjeto() 
                + "=1}] at @s run execute if entity @e[type=villager,name=\"" 
                + nomeVillager.lerNomeCodigo() 
                + "\",distance=..6] run tellraw @s [\"\",{\"text\":\"" 
                + nomeVillager.lerNome() 
                + " \",\"color\":\"" 
                + nomeVillager.lerCorNome() 
                + "\"},{\"text\":\"" 
                + mensagemVillager.lerMsg() 
                + "\",\"color\":\"" 
                + mensagemVillager.lerCorMsg() 
                + "\"}]\n");
            System.out.println("Cole o codigo abaixo para resetar o dialogo em um 2° Command Block Setado em: Em Cadeia, e Sempre Ativo\n");
            System.out.println("scoreboard players set @a[scores={" + nomeObjeto.lerObjeto() + "=1}] " + nomeObjeto.lerObjeto() + " 0\n");
            // Chamando verificação de reiniciar
            reiniciar.setREINICIAR();
            if (reiniciar.lerREINICIAR() == 1) {
                System.out.println("Fechando o programa...");
                System.exit(0);
            }
        }
    } while (reiniciar.lerREINICIAR() == 0);
        System.out.println("Loop caiu no tratamento de saida errado... (reiniciar.lerREINICIAR() == 0);");
    }
}