package com.emerson.vendas;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emerson.vendas.domain.Categoria;
import com.emerson.vendas.domain.Cidade;
import com.emerson.vendas.domain.Cliente;
import com.emerson.vendas.domain.Endereco;
import com.emerson.vendas.domain.Estado;
import com.emerson.vendas.domain.ItemPedido;
import com.emerson.vendas.domain.Pagamento;
import com.emerson.vendas.domain.PagamentoComBoleto;
import com.emerson.vendas.domain.PagamentoComCartao;
import com.emerson.vendas.domain.Pedido;
import com.emerson.vendas.domain.Produto;
import com.emerson.vendas.enums.EstadoPagamento;
import com.emerson.vendas.enums.TipoCLiente;
import com.emerson.vendas.repositories.CategoriaRepository;
import com.emerson.vendas.repositories.CidadeRepository;
import com.emerson.vendas.repositories.ClienteRepository;
import com.emerson.vendas.repositories.EnderecoRepository;
import com.emerson.vendas.repositories.EstadoRepository;
import com.emerson.vendas.repositories.ItemPedidoRepository;
import com.emerson.vendas.repositories.PagamentoRepository;
import com.emerson.vendas.repositories.PedidoRepository;
import com.emerson.vendas.repositories.ProdutoRepository;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

    /*
	 * Esse método será executado quando a aplicação spring for iniciada.
     */
    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        Categoria cat3 = new Categoria(null, "Cama Mesa e Banho");
        Categoria cat4 = new Categoria(null, "Eletrônicos");
        Categoria cat5 = new Categoria(null, "Jardinagem");
        Categoria cat6 = new Categoria(null, "Decoração");
        Categoria cat7 = new Categoria(null, "Perfumaria");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente(null, "Emerson J S Costa", "emersonjscosta@gmail.com",
                "36378912377", TipoCLiente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("3332712325", "991941234"));

        Endereco e1 = new Endereco(null, "Rua das Carmelitas", "300", "Casa",
                "Vila Olinda", "3420456", cli1, c1);

        Endereco e2 = new Endereco(null, "Rua Castelo Branco", "500", "APT-01",
                "Estrela Sul", "34204345", cli1, c1);

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
                null);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
    }
}
