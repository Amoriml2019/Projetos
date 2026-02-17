import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        System.out.println("=== CALCULADORA ===\n");
        
        while (continuar) {
            try {
                System.out.println("Escolha o modo:");
                System.out.println("1 - Básico (+, -, *, /)");
                System.out.println("2 - Científico");
                System.out.print("Opção: ");
                int modo = scanner.nextInt();
                
                if (modo == 1) {
                    calcularBasico(scanner);
                } else if (modo == 2) {
                    calcularCientifico(scanner);
                } else {
                    System.out.println("Modo inválido!\n");
                    continue;
                }
                
                System.out.print("Deseja continuar? (s/n): ");
                char resposta = scanner.next().charAt(0);
                continuar = (resposta == 's' || resposta == 'S');
                System.out.println();
                
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite números válidos.\n");
                scanner.nextLine();
            }
        }
        
        System.out.println("Obrigado por usar a calculadora!");
        scanner.close();
    }
    
    static void calcularBasico(Scanner scanner) {
        try {
            System.out.print("Digite o primeiro número: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Digite a operação (+, -, *, /): ");
            char operacao = scanner.next().charAt(0);
            
            System.out.print("Digite o segundo número: ");
            double num2 = scanner.nextDouble();
            
            double resultado = 0;
            boolean operacaoValida = true;
            
            switch (operacao) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        System.out.println("Erro: Divisão por zero!\n");
                        operacaoValida = false;
                    }
                    break;
                default:
                    System.out.println("Operação inválida!\n");
                    operacaoValida = false;
            }
            
            if (operacaoValida) {
                System.out.printf("Resultado: %.2f\n", resultado);
            }
            
        } catch (Exception e) {
            System.out.println("Entrada inválida! Digite números válidos.\n");
            scanner.nextLine();
        }
    }
    
    static void calcularCientifico(Scanner scanner) {
        try {
            System.out.println("\nOperações científicas:");
            System.out.println("1 - Potência (x^y)");
            System.out.println("2 - Raiz quadrada");
            System.out.println("3 - Seno (em graus)");
            System.out.println("4 - Cosseno (em graus)");
            System.out.println("5 - Tangente (em graus)");
            System.out.println("6 - Logaritmo natural (ln)");
            System.out.println("7 - Logaritmo base 10 (log)");
            System.out.println("8 - Valor absoluto");
            System.out.println("9 - Fatorial");
            System.out.print("Escolha: ");
            int op = scanner.nextInt();
            
            double resultado = 0;
            boolean valida = true;
            
            switch (op) {
                case 1:
                    System.out.print("Digite a base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Digite o expoente: ");
                    double expoente = scanner.nextDouble();
                    resultado = Math.pow(base, expoente);
                    break;
                    
                case 2:
                    System.out.print("Digite o número: ");
                    double num = scanner.nextDouble();
                    if (num < 0) {
                        System.out.println("Erro: Número negativo!\n");
                        valida = false;
                    } else {
                        resultado = Math.sqrt(num);
                    }
                    break;
                    
                case 3:
                    System.out.print("Digite o ângulo (em graus): ");
                    double angulo = scanner.nextDouble();
                    resultado = Math.sin(Math.toRadians(angulo));
                    break;
                    
                case 4:
                    System.out.print("Digite o ângulo (em graus): ");
                    angulo = scanner.nextDouble();
                    resultado = Math.cos(Math.toRadians(angulo));
                    break;
                    
                case 5:
                    System.out.print("Digite o ângulo (em graus): ");
                    angulo = scanner.nextDouble();
                    resultado = Math.tan(Math.toRadians(angulo));
                    break;
                    
                case 6:
                    System.out.print("Digite o número: ");
                    num = scanner.nextDouble();
                    if (num <= 0) {
                        System.out.println("Erro: Logaritmo de número não-positivo!\n");
                        valida = false;
                    } else {
                        resultado = Math.log(num);
                    }
                    break;
                    
                case 7:
                    System.out.print("Digite o número: ");
                    num = scanner.nextDouble();
                    if (num <= 0) {
                        System.out.println("Erro: Logaritmo de número não-positivo!\n");
                        valida = false;
                    } else {
                        resultado = Math.log10(num);
                    }
                    break;
                    
                case 8:
                    System.out.print("Digite o número: ");
                    num = scanner.nextDouble();
                    resultado = Math.abs(num);
                    break;
                    
                case 9:
                    System.out.print("Digite um número inteiro: ");
                    int n = scanner.nextInt();
                    if (n < 0) {
                        System.out.println("Erro: Fatorial de número negativo!\n");
                        valida = false;
                    } else {
                        resultado = calcularFatorial(n);
                    }
                    break;
                    
                default:
                    System.out.println("Operação inválida!\n");
                    valida = false;
            }
            
            if (valida) {
                System.out.printf("Resultado: %.6f\n", resultado);
            }
            
        } catch (Exception e) {
            System.out.println("Entrada inválida!\n");
            scanner.nextLine();
        }
    }
    
    static double calcularFatorial(int n) {
        if (n == 0 || n == 1) return 1;
        double resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
