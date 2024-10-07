package br.edu.iff.ccc.bsi.perfumaria.controller.apirest;

import br.edu.iff.ccc.bsi.perfumaria.entities.Pedido;
import br.edu.iff.ccc.bsi.perfumaria.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ApiRestPedidoController {

    @Autowired
    private PedidoService pedidoService;

    public ApiRestPedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Operation(summary = "Encontrar o pedido pelo seu ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedido encontrado",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Pedido.class))}),
        @ApiResponse(responseCode = "400", description = "Id fornecido é inválido",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Pedido não encontrado",
                content = @Content)
    })
    @GetMapping("/api/v1/pedido/{id}")
    public EntityModel<Pedido> encontrarPedidoPorId(@PathVariable long id) {
        Pedido pedido = pedidoService.buscarPorId(id);
        EntityModel<Pedido> resource = EntityModel.of(pedido);

        resource.add(linkTo(methodOn(ApiRestPedidoController.class).encontrarPedidoPorId(id)).withSelfRel());
        resource.add(linkTo(methodOn(ApiRestPedidoController.class).listarPedidos()).withRel("pedidos"));

        return resource;
    }

    @Operation(summary = "Adicionar um novo pedido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedido adicionado com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Pedido.class))}),
        @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na validação dos campos",
                content = @Content)
    })
    @PostMapping("/api/v1/pedido")
    public Pedido adicionarPedido(@RequestBody Pedido pedido) {
        return pedidoService.inserirPedido(pedido);
    }

    @Operation(summary = "Listar todos os pedidos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedidos listados com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Pedido.class))}),
        @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na listagem dos pedidos",
                content = @Content)
    })
    @GetMapping("/api/v1/pedidos")
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @Operation(summary = "Remover um pedido pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedido removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    })
    @DeleteMapping("/api/v1/pedido/{id}")
    public void removerPedido(@PathVariable long id) {
        pedidoService.removerPedidoPorId(id);
    }

    @Operation(summary = "Atualizar um pedido existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Pedido.class))}),
        @ApiResponse(responseCode = "404", description = "Pedido não encontrado"),
        @ApiResponse(responseCode = "400", description = "Erro na validação dos dados")
    })
    @PutMapping("/api/v1/pedido/{id}")
    public Pedido atualizarPedido(@PathVariable long id, @RequestBody Pedido pedido) {
        return pedidoService.atualizarPedido(id, pedido);
    }
}
