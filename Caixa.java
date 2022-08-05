import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double saldo = 1000;
        double deposito, saque;
        int escolha, block;
        String CPF, senha;
        block = 1;

        while (block != 0) { // permite a repetição do código
            System.out
                    .println("=============== Seja bem-vindo ================\nDigite seu CPF, com pontos e traços: "); // janela
                                                                                                                        // inicial
            CPF = input.next();
            // colhe informação do CPF

            if (!CPF.equals("123.456.789-00")) {
                System.out.println("CPF inválido, tente novamente\nmais tarde.");
                break;
                // se CPF falso, acesso negado
            }

            System.out.println("Por favor, digite a senha: "); // se CPF verdadeiro, pede a senha
            senha = input.next();
            if (!senha.equals("01020304")) {
                for (int i = 0; i < 2; i++) {
                    if (!senha.equals("01020304")) {
                        System.out.println("Senha incorreta! Tente novamente: ");
                        senha = input.next();
                    }
                    // se senha falsa, pede a senha novamente
                }
                if (!senha.equals("01020304")) {
                    System.out.println("Conta bloqueada!");
                    break;
                } // após 2 tentativas incorretas, conta bloqueada
            }
            escolha = 1;
            // se senha verdadeira, vai para o menu de operações

            while (escolha != 0) { // enquanto o usuário não escolhe sair, continua exibindo o menu e realizando
                                   // operações
                System.out.println(
                        "\n============ Escolha uma operação: ============ \n1: Saldo \n2: Depósito \n3: Saque \n0: Sair");
                escolha = input.nextInt();
                while (escolha < 0 || escolha > 3) {
                    System.out.println("==== Por favor, digite uma operação válida ====");
                    escolha = input.nextInt();
                } // Se a escolha é inválida, pede a operação novamente
                switch (escolha) {
                    case 1:
                        System.out
                                .println("\n=================== SALDO =====================\nSaldo atual:  \n" + saldo);
                        break;
                    // operação mostra o saldo
                    case 2:
                        System.out.println(
                                "\n================= DEPÓSITO ====================\nPor favor, insira o valor do depósito: ");
                        deposito = input.nextDouble();
                        if (deposito > 0) {
                            saldo += deposito;
                            break;
                            // operação pede o valor para depósito e atualiza o saldo
                        } else {
                            System.out.println("=============== VALOR INVÁLIDO! ===============");
                        } // se valor é negativo, printa mensagem de erro
                        break;
                    case 3:
                        System.out.println(
                                "\n=================== SAQUE =====================\nPor favor, insira o valor do saque: ");
                        saque = input.nextDouble();
                        if (saque <= saldo && saque > 0) {
                            saldo -= saque;
                            break;
                            // operação pede o valor para saque e atualiza o saldo
                        } else {
                            System.out.println("=============== VALOR INVÁLIDO! ===============");
                        } // se valor é menor que o saldo ou negativo, printa mensagem de erro
                        break;
                }
            }
        }
    }
}