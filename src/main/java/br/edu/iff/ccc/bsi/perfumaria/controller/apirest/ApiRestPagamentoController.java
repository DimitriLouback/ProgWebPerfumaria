package br.edu.iff.ccc.bsi.perfumaria.controller.apirest;


import br.edu.iff.ccc.bsi.perfumaria.entities.Pagamento;
import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
import br.edu.iff.ccc.bsi.perfumaria.service.PagamentoService;
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
                    content = @Content) })
    @GetMapping("/api/pagamento/{id}")
    public Pagamento encontrarPagamentoPorId(@PathVariable long id) {
        return pagamentoService.buscarPorId(id);
    }

    @Operation(summary = "Adicionar um novo pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento adicionado com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pagamento.class))}),
            @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na validação dos campos",
                    content = @Content) })
    @GetMapping("/api/pagamento")
    public Pagamento adicionarPagamento(@RequestBody Pagamento pagamento) {

        return pagamentoService.inserirPagamento(pagamento);
    }

    @Operation(summary = "Listar todos os pagamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "pagamentos listados com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pagamento.class))}),
            @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na listagem dos pagamentos",
                    content = @Content) })
    @GetMapping("/api/pagamentos")
    public List<Pagamento> listarPagamentos() {
        return pagamentoService.listarPagamentos();
    }
}


