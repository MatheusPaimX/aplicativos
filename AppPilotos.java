package aplicativos;

import java.io.IOException;
import java.util.Scanner;

import aplicativos.model.Aeronave;
import aplicativos.model.Pessoa;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int MAX_ELEMENTOS = 2;
        int opcao;
        int qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Pessoa pessoa = new Pessoa("Matheus", "10", "112004");
        Scanner scan = new Scanner(System.in);
        

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar pilotos");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("5 - Entrar na aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = scan.nextInt();
            scan.nextLine();

            if (opcao == 1) {
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(scan);
                    continue;
                }   
                else{System.out.println("Digite o nome do piloto: ");
                    String nome = scan.nextLine();
                    System.out.println("Digite o número do CPF do " +nome);
                    String cpf = scan.nextLine();
                    System.out.println("Digite o número da habilitação do " +nome);
                    String habilitacao = scan.nextLine();
                    Pessoa piloto = new Pessoa(nome, cpf, habilitacao);
                    pilotos[qtdCadastrados] = piloto;
                    qtdCadastrados++;
                    
                    
                    }   System.out.println("\nPiloto cadastrado com sucesso.");
                        voltarMenu(scan);

                
            
            
                }else if (opcao == 2) {
                    if (qtdCadastrados == 0) {
                        System.out.println("\nNão há pilotos cadastrados para exibir.");
                        voltarMenu(scan);
                        continue;
                }

                else{
                    for (int i = 0; i < qtdCadastrados; i++) {
                        System.out.println(pilotos[i]);
                    }  

                }    voltarMenu(scan);

                
            } else if (opcao == 3) {
                System.out.println("Digite o CPF da pessoa que deseja procurar: ");
                String cpfArmazenadora = scan.nextLine();
                    
                    for (int i = 0; i < qtdCadastrados; i++) {
                       if (pilotos[i].getCpf().equals(cpfArmazenadora)){
                        System.out.println("As informações da pessoa são: ");
                        System.out.println(pilotos[i]);
                        voltarMenu(scan);
                        
                    }
                       if (!pilotos[i].getCpf().equals(cpfArmazenadora) && i == qtdCadastrados) {
                        System.out.println("Esse CPF não pertence a ninguém do sistema!");
                        voltarMenu(scan);
                        
                    }
            }   

               
            }
            else if (opcao == 4) {
                System.out.println("Digite a quantidade de armazenamento que deseja: ");
                int armazenamento = scan.nextInt();
                scan.nextLine();
                Pessoa[] pilotos2 = new Pessoa[armazenamento];
                
                for (int i = 0; i < MAX_ELEMENTOS; i++) {
                   
                    pilotos2[i] = pilotos[i];
                    pilotos[i] = pilotos2[i];
                    
                }
                    MAX_ELEMENTOS = armazenamento;
                    pilotos = pilotos2;
                    System.out.println("O seu armazenamento foi aumentado para " + armazenamento);
                    voltarMenu(scan);
            
            }        
            else if(opcao==5){
                
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão é possível entrar na aeronave sem um piloto!.");
                    voltarMenu(scan);
                }
                    
                
                if(qtdCadastrados>0){
                System.out.println("Digite o modelo da aeronave: ");
                String modeloNave = scan.nextLine();
                System.out.println("Digite a identificação da aeronave: ");
                String identificacao = scan.nextLine();
                System.out.println("Digite a velocidade máxima da aeronave: ");
                int velocidadeMax = scan.nextInt();
                scan.nextLine();
                
                for (int i = 0; i < qtdCadastrados; i++) {
                        System.out.println(pilotos[i]);
                
                }
                System.out.println("Escolha um dos pilotos acima para prosseguir: ");
                String escolhido = scan.nextLine();
                    Aeronave nave = new Aeronave(modeloNave, identificacao, velocidadeMax, pessoa);
                        for (int i = 0; i < qtdCadastrados; i++){
                            if (pilotos[i].getNome().equals(escolhido)){
                            System.out.println("O piloto " + escolhido + " vai pilotar a aeronave " + nave.getModeloNave());
                            
                            for (int contadora = 0; contadora < nave.getVelocidadeMax(); contadora++) {
                                System.out.println(nave.acelerar());
                            }
                            System.out.println("\nA Aeronave " +nave.getModeloNave() + " atingiu " + nave.getVelocidadeNave() + " Kilômetros por hora!!!"); 
                            voltarMenu(scan);
                        }else{
                            if (!pilotos[i].getCpf().equals(escolhido) && i == qtdCadastrados) {
                                System.out.println("O piloto não foi reconhecido pelo sistema!");
                                voltarMenu(scan);
                                }       
                    }

                }
            }


        }

        }while(opcao != 0);

        System.out.println("Fim do programa!");

        scan.close();
    }

    private static void voltarMenu(Scanner scan) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        scan.nextLine();

        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }   
    
}