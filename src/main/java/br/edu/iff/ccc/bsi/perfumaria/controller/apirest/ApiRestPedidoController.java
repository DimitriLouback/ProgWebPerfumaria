package br.edu.iff.ccc.bsi.perfumaria.controller.apirest;

import br.edu.iff.ccc.bsi.perfumaria.entities.Pedido;
import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
import br.edu.iff.ccc.bsi.perfumaria.service.PedidoService;
import br.edu.iff.ccc.bsi.perfumaria.service.PerfumeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
                    content = @Content) })
    @GetMapping("/api/v1/pedido/{id}")
    public Pedido encontrarPedidoPorId(@PathVariable long id) {
        return pedidoService.buscarPorId(id);
    }

    @Operation(summary = "Adicionar um novo pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido adicionado com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pedido.class))}),
            @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na validação dos campos",
                    content = @Content) })
    @GetMapping("/api/v1/pedido")
    public Pedido adicionarUsuario(@RequestBody Pedido pedido) {

        return pedidoService.inserirPedido(pedido);
    }

    @Operation(summary = "Listar todos os pedidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "pedidos listados com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pedido.class))}),
            @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na listagem dos pedidos",
                    content = @Content) })
    @GetMapping("/api/v1/pedidos")
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }
}