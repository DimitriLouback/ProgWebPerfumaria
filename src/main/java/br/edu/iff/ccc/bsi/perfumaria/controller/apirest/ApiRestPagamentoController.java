package br.edu.iff.ccc.bsi.perfumaria.controller.apirest;

import br.edu.iff.ccc.bsi.perfumaria.entities.Pagamento;
import br.edu.iff.ccc.bsi.perfumaria.service.PagamentoService;
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
public class ApiRestPagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    public ApiRestPagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @Operation(summary = "Encontrar o pagamento pelo seu ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pagamento encontrado",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Pagamento.class))}),
        @ApiResponse(responseCode = "400", description = "Id fornecido é inválido",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Pagamento não encontrado",
                content = @Content)
    })
    @GetMapping("/api/v1/pagamento/{id}")
    public EntityModel<Pagamento> encontrarPagamentoPorId(@PathVariable long id) {
        Pagamento pagamento = pagamentoService.buscarPorId(id);
        EntityModel<Pagamento> resource = EntityModel.of(pagamento);

        resource.add(linkTo(methodOn(ApiRestPagamentoController.class).encontrarPagamentoPorId(id)).withSelfRel());
        resource.add(linkTo(methodOn(ApiRestPagamentoController.class).listarPagamentos()).withRel("pagamentos"));

        return resource;
    }

    @Operation(summary = "Adicionar um novo pagamento")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pagamento adicionado com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Pagamento.class))}),
        @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na validação dos campos",
                content = @Content)
    })
    @PostMapping("/api/v1/pagamento")
    public Pagamento adicionarPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.inserirPagamento(pagamento);
    }

    @Operation(summary = "Listar todos os pagamentos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pagamentos listados com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Pagamento.class))}),
        @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na listagem dos pagamentos",
                content = @Content)
    })
    @GetMapping("/api/v1/pagamentos")
    public List<Pagamento> listarPagamentos() {
        return pagamentoService.listarPagamentos();
    }

    @Operation(summary = "Remover um pagamento pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pagamento removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Pagamento não encontrado")
    })
    @DeleteMapping("/api/v1/pagamento/{id}")
    public void removerPagamento(@PathVariable long id) {
        pagamentoService.removerPagamentoPorId(id);
    }

    @Operation(summary = "Atualizar um pagamento existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pagamento atualizado com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Pagamento.class))}),
        @ApiResponse(responseCode = "404", description = "Pagamento não encontrado"),
        @ApiResponse(responseCode = "400", description = "Erro na validação dos dados")
    })
    @PutMapping("/api/v1/pagamento/{id}")
    public Pagamento atualizarPagamento(@PathVariable long id, @RequestBody Pagamento pagamento) {
        return pagamentoService.atualizarPagamento(id, pagamento);
    }
}
