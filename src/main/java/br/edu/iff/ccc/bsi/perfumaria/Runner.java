package br.edu.iff.ccc.bsi.perfumaria;
import br.edu.iff.ccc.bsi.perfumaria.entities.Administrador;
import br.edu.iff.ccc.bsi.perfumaria.entities.Cliente;
import br.edu.iff.ccc.bsi.perfumaria.entities.Endereco;
import br.edu.iff.ccc.bsi.perfumaria.entities.*;
import br.edu.iff.ccc.bsi.perfumaria.repository.*;
import br.edu.iff.ccc.bsi.perfumaria.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {


//    @Autowired
//    private UsuarioService usuarioService;
//
//    @Autowired
//    private PerfumeService perfumeService;
//
//    @Autowired
//    private PedidoService pedidoService;
//
//    @Autowired
//    private PagamentoService pagamentoService;
//
//    @Autowired
//    private ClienteService clienteService;
//
//    @Autowired
//    private CarrinhoService carrinhoService;
//
    @Override
    public void run(String... args) throws Exception {
//
//        // Endereco
//        Endereco endereco = new Endereco();
//        endereco.setRua("Barão da Lagoa Dourada");
//        endereco.setNumero("123");
//        endereco.setBairro("Centro");
//        endereco.setCidade("Campos");
//        endereco.setUF("RJ");
//        endereco.setCEP("28055-000");
//
//        // Criar e salvar Perfumes
//        Perfume perfume1 = new Perfume();
//        perfume1.setNome("Perfume1");
//        perfume1.setPreco(100.0f);
//        perfume1.setQuantidadeEmEstoque(10);
//        perfume1.setFragrancia("Floral");
//        perfume1.setMarca("Marca1");
//        perfume1.setVolume(50);
//        perfumeService.inserirPerfume(perfume1);
//
//        Perfume perfume2 = new Perfume();
//        perfume2.setNome("Perfume2");
//        perfume2.setPreco(150.0f);
//        perfume2.setQuantidadeEmEstoque(5);
//        perfume2.setFragrancia("Amadeirado");
//        perfume2.setMarca("Marca2");
//        perfume2.setVolume(75);
//        perfumeService.inserirPerfume(perfume2);
//
//        System.out.println("Perfumes criados:");
//        System.out.println(perfumeService.listarPerfumes());
//
//        // Criar e salvar Cliente
//        Cliente cliente = new Cliente();
//        cliente.setUsername("cliente");
//        cliente.setSenha("cliente123");
//        cliente.setEmail("cliente@exemplo.com");
//        cliente.setCPF("98765432100");
//        cliente.setCelular("22987654322");
//        cliente.setEndereco(endereco);
//        cliente.setDataNascimento(new Date(90, 1, 1));
//        cliente.setDataCadastro(new Date());
//        Cliente clienteSalvo = clienteService.inserirCliente(cliente);
//
//        System.out.println("Clientes criados:");
//        System.out.println(clienteService.listarClientes());
//
//
//        // Criar e salvar Carrinho
//        Carrinho carrinho = new Carrinho();
//        carrinho.setCliente(clienteSalvo);
//        carrinhoService.inserirCarrinho(carrinho);
//
//        // Adicionar perfumes ao carrinho
//        carrinhoService.adicionarPerfume(carrinho.getId(), perfume1.getId());
//        carrinhoService.adicionarPerfume(carrinho.getId(), perfume2.getId());
//
//        System.out.println("Carrinhos criados:");
//        System.out.println(carrinhoService.listarCarrinhos());
//
//        // Criar e salvar Pagamento
//        Pagamento pagamento = new Pagamento();
//        pagamento.setCarrinho(carrinho);
//        pagamento.setMetodoPagamento("Cartão de Crédito");
//        pagamento.setStatusPagamento("Pendente");
//        pagamentoService.inserirPagamento(pagamento);
//
//        System.out.println("Pagamentos criados:");
//        System.out.println(pagamentoService.listarPagamentos());
//
//        // Criar e salvar Pedido
//        Pedido pedido = new Pedido();
//        pedido.setCarrinho(carrinho);
//        pedido.setPagamento(pagamento);
//        pedido.setDataPedido(new Date());
//        pedidoService.inserirPedido(pedido);
//
//        System.out.println("Pedidos criados:");
//        System.out.println(pedidoService.listarPedidos());
//

    }

}