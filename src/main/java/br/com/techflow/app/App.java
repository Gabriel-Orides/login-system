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
            System.out.println("3. Atualizar senha");
            System.out.println("4. Deletar usuário (Delete)");
            System.out.println("5. Sair");
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

                case "3": // UPDATE
                    System.out.print("Digite o username: ");
                    String updateUser = scanner.nextLine();
                    System.out.print("Digite a SENHA ANTIGA: ");
                    String oldPass = scanner.nextLine();
                    System.out.print("Digite a SENHA NOVA: ");
                    String newPass = scanner.nextLine();

                    if (service.atualizarSenha(updateUser, oldPass, newPass)) {
                        System.out.println("Senha atualizada com sucesso!");
                    } else {
                        System.out.println("Erro: Usuário ou senha antiga incorretos.");
                    }
                    break;

                case "4": // DELETE
                    System.out.print("Digite o username para deletar: ");
                    String delUser = scanner.nextLine();
                    System.out.print("Digite a senha para confirmar: ");
                    String delPass = scanner.nextLine();

                    if (service.deletarUsuario(delUser, delPass)) {
                        System.out.println("Usuário deletado com sucesso.");
                    } else {
                        System.out.println("Erro: Usuário ou senha incorretos.");
                    }
                    break;

                case "5": // SAIR
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}