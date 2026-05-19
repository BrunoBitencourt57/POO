import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Brayan", "123", "brayan@email.com", 2000));
        usuarios.add(new Usuario("Lucas", "abc", "lucas@email.com", 2004));
        usuarios.add(new Usuario("Carlos", "456", "carlos@email.com", 2001));

        Loja loja = new Loja();

        Jogo gta = new Jogo("GTA V", 80, "Rockstar");
        Jogo minecraft = new Jogo("Minecraft", 100, "Mojang");
        DLC dlcGta = new DLC("GTA Online Pack", 30, "Rockstar", gta);

        loja.adicionarProduto(gta);
        loja.adicionarProduto(minecraft);
        loja.adicionarProduto(dlcGta);

        Usuario usuarioLogado = null;

        boolean rodando = true;

        while (rodando) {

            // LOGIN
            if (usuarioLogado == null) {

                System.out.println("=== LOGIN ===");

                usuarioLogado = fazerLogin(sc, usuarios);

                if (usuarioLogado == null) {
                    continue;
                }
            }

            System.out.println("\n=== MENU DE " + usuarioLogado.getNome() + " ===");

            System.out.println("1 - Acessar loja");
            System.out.println("2 - Acessar biblioteca");
            System.out.println("3 - Ver carteira");
            System.out.println("4 - Adicionar saldo");
            System.out.println("5 - Ver histórico de compras");
            System.out.println("6 - Ver perfil");
            System.out.println("7 - Avaliar perfil de outro usuário");
            System.out.println("8 - Sair da conta");
            System.out.println("0 - Encerrar programa");

            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    menuLoja(sc, loja, usuarioLogado);
                    break;

                case 2:
                    menuBiblioteca(sc, usuarioLogado);
                    break;

                case 3:
                    System.out.println(
                            "Saldo: R$ "
                                    + String.format("%.2f",
                                    usuarioLogado.getCarteira().getSaldo())
                    );
                    break;

                case 4:

                    System.out.print("Valor para adicionar: ");

                    double valor = sc.nextDouble();
                    sc.nextLine();

                    usuarioLogado.getCarteira().adicionarSaldo(valor);

                    System.out.println("Saldo adicionado com sucesso!");
                    break;

                case 5:
                    usuarioLogado.exibirHistoricoCompras();
                    break;

                case 6:
                    usuarioLogado.getPerfil().exibirPerfil();
                    break;

                case 7:
                    avaliarPerfilOutroUsuario(sc, usuarioLogado, usuarios);
                    break;

                case 8:

                    System.out.println("Saindo da conta...");
                    usuarioLogado = null;
                    break;

                case 0:

                    System.out.println("Encerrando programa...");
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }

    private static void menuLoja(Scanner sc, Loja loja, Usuario usuario) {
        loja.exibirProdutos();

        System.out.print("Escolha o número do produto para comprar: ");
        int indice = sc.nextInt() - 1;
        sc.nextLine();

        Produto produto = loja.getProdutoPorIndice(indice);

        if (produto == null) {
            System.out.println("Produto inválido.");
            return;
        }

        FormaDePagamento pagamento = escolherPagamento(sc, usuario);

        if (pagamento != null) {
            loja.venderProduto(usuario, produto, pagamento);
        }
    }

    private static FormaDePagamento escolherPagamento(Scanner sc, Usuario usuario) {
        System.out.println("Forma de pagamento:");
        System.out.println("1 - Carteira");
        System.out.println("2 - Cartão");
        System.out.println("3 - Pix");
        System.out.print("Escolha: ");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                return new PagamentoCarteira(usuario.getCarteira());

            case 2:
                System.out.print("Número do cartão: ");
                String numero = sc.nextLine();
                return new PagamentoCartao(numero);

            case 3:
                System.out.print("Chave Pix: ");
                String chave = sc.nextLine();
                return new PagamentoPix(chave);

            default:
                System.out.println("Pagamento inválido.");
                return null;
        }
    }

    private static void menuBiblioteca(Scanner sc, Usuario usuario) {
        usuario.exibirBiblioteca();

        System.out.print("Escolha o número do jogo para ver detalhes ou 0 para voltar: ");
        int indice = sc.nextInt() - 1;
        sc.nextLine();

        if (indice == -1) return;

        Jogo jogo = usuario.getBiblioteca().getJogoPorIndice(indice);

        if (jogo == null) {
            System.out.println("Jogo inválido.");
            return;
        }

        jogo.exibirDetalhes();

        System.out.println("1 - Avaliar jogo");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        int opcao = sc.nextInt();
        sc.nextLine();

        if (opcao == 1) {
            System.out.print("Nota: ");
            int nota = sc.nextInt();
            sc.nextLine();

            System.out.print("Comentário: ");
            String comentario = sc.nextLine();

            usuario.avaliar(jogo, nota, comentario);
        }
    }

    private static Usuario fazerLogin(Scanner sc, List<Usuario> usuarios) {
        System.out.print("Usuário: ");
        String nome = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nome) && u.validarSenha(senha)) {
                System.out.println("Login realizado com sucesso!");
                return u;
            }
        }

        System.out.println("Usuário ou senha inválidos.");
        return null;
    }

    private static void avaliarPerfilOutroUsuario(Scanner sc, Usuario usuarioLogado, List<Usuario> usuarios) {
        System.out.println("Usuários disponíveis:");

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);

            if (u != usuarioLogado) {
                System.out.println((i + 1) + ". " + u.getNome());
            }
        }

        System.out.print("Escolha o usuário: ");
        int indice = sc.nextInt() - 1;
        sc.nextLine();

        if (indice < 0 || indice >= usuarios.size()) {
            System.out.println("Usuário inválido.");
            return;
        }

        Usuario usuarioAvaliado = usuarios.get(indice);

        if (usuarioAvaliado == usuarioLogado) {
            System.out.println("Você não pode avaliar seu próprio perfil.");
            return;
        }

        System.out.print("Nota: ");
        int nota = sc.nextInt();
        sc.nextLine();

        System.out.print("Comentário: ");
        String comentario = sc.nextLine();

        usuarioLogado.avaliarPerfilDe(usuarioAvaliado, nota, comentario);
    }
}
