package br.com.techflow.app;
import java.util.Scanner;
import br.com.techflow.service.LoginService;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginService service = new LoginService();

        while (true) {
            System.out.println("\n--- SISTEMA DE LOGIN ---");
            System.out.println("1. Registrar novo usuário");
            System.out.println("2. Fazer Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": // CREATE
                    System.out.print("Digite o username: ");
                    String regUser = scanner.nextLine();
                    System.out.print("Digite a senha: ");
                    String regPass = scanner.nextLine();

                    if (service.registrar(regUser, regPass)) {
                        System.out.println("Usuário registrado com sucesso!");
                    } else {
                        System.out.println("Erro: Usuário já existe.");
                    }
                    break;

                case "2": // READ
                    System.out.print("Digite o username: ");
                    String loginUser = scanner.nextLine();
                    System.out.print("Digite a senha: ");
                    String loginPass = scanner.nextLine();

                    if (service.fazerLogin(loginUser, loginPass)) {
                        System.out.println("Login bem-sucedido! Bem-vindo, " + loginUser);
                    } else {
                        System.out.println("Erro: Usuário ou senha incorretos.");
                    }
                    break;

                case "3": // SAIR
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}