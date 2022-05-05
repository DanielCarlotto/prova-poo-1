

import java.util.Scanner;


import Aplicativos.Piloto;


public class AppPilotos {
    private static int qtdCadastrados = 0;
    private static int MAX_ELEMENTOS = 2;
    private static int MAX_ELEMENTOS_SOLICITADOS = 0;
    private static Piloto[] _pilotos = new Piloto[MAX_ELEMENTOS];
    private static Scanner in = new Scanner(System.in);
    private static String localizarCpf = "0";

    public static void main(String[] args) throws Exception {
    
        boolean continuarExecutando = true;
        do {
        try {
        imprimirMenu();
        int opcao = lerOpcao();
        continuarExecutando = executarOpcao(opcao);
        } catch (Exception e) {
        System.out.println("Ocorreu um erro durante a operação: " + e.getMessage());
        continuarExecutando = true;
        }
        } while (continuarExecutando);

    }
    
    private static boolean executarOpcao(int opcao) throws Exception {
    switch (opcao) {
        case 1: {
            cadastrarPiloto();
            break;
        }
        case 2: {
            listarPilotos();
            break;
        }
        case 3: {
            localizarPilotoCPF();
            break;
        }
        case 4: {
            aumentarArmazenamento();
            break;
        }    
        case 0: {
            System.out.println("Saindo do sistema.");
            return false;
        }
        default: {
            System.out.println("Ainda não implementado!");
            break;
        }
        }
        return true;
        }

     private static void imprimirMenu() {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
        }

    private static void aumentarArmazenamento() {
        System.out.println("Informe quantos pilotos deseja cadastrar: ");
        MAX_ELEMENTOS_SOLICITADOS = in.nextInt();
        if (MAX_ELEMENTOS_SOLICITADOS <= MAX_ELEMENTOS) {
            System.out.println("Espaço solicitaddo é inferior ao espeaço atual disponivel!");
        }
        else {
            MAX_ELEMENTOS = MAX_ELEMENTOS_SOLICITADOS;
            System.out.println("Capacidade aumentada com sucesso!");
        }
    }

     private static void cadastrarPiloto() throws Exception {
        if (qtdCadastrados == _pilotos.length) {
            System.out.println("Não há armazenamento disponivel!");
        } 
        else {
        System.out.println("Cadastro de Pilotos");
        System.out.println("Nome: ");
        String nome = in.nextLine();
        System.out.println("CPF: ");
        String cpf = in.nextLine();
    
        Piloto pilotos = new Piloto(nome, cpf);
        adicionarPilotoLista(pilotos);
        System.out.println("Piloto cadastrado com sucesso!");
        }
        }
    private static void listarPilotos() {
        System.out.println("Lista de pilotos cadastrados:");
        for (int i = 0; i < qtdCadastrados; i++){
            System.out.println(_pilotos[i]);
           }
         }
    private static void adicionarPilotoLista(Piloto pilotos) {
        _pilotos[qtdCadastrados] = pilotos;
        qtdCadastrados++;
         
        }

    private static Piloto localizarPilotoCPF() throws Exception {
        System.out.println("Digite o CPF que seseja localizar: ");
        localizarCpf = in.nextLine();
        for (Piloto pilotos: _pilotos) {
            if (pilotos != null && pilotos.get_cpf().equals(localizarCpf)) {
                System.out.println(pilotos);
                return (pilotos);
                }
            }
        return null;
        
        }

    private static boolean validarOpcaoMenu(int opcao) {
        return (opcao >= 0 && opcao <= 4);
    }

    private static int lerOpcao() throws Exception {
        int opcao = 0;
        do{
            System.out.println("Selecione a opção desejada: ");
            try {
                opcao = Integer.parseInt(in.nextLine());
                if (!validarOpcaoMenu(opcao)) {
                    System.out.println("Opção inválida!");
                }
            } catch (Exception e)  {
                System.out.println("Opção inválida!");
                in.nextLine();

            }
        } while (!validarOpcaoMenu(opcao));

        return opcao;
    }
    
}
