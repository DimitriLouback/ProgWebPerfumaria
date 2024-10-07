package br.edu.iff.ccc.bsi.perfumaria.controller.apirest;

import br.edu.iff.ccc.bsi.perfumaria.entities.Carrinho;
import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import br.edu.iff.ccc.bsi.perfumaria.service.CarrinhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ApiRestCarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    public ApiRestCarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @Operation(summary = "Adicionar um perfume ao carrinho")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Perfume adicionado com sucesso ao carrinho",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Carrinho.class))}),
        @ApiResponse(responseCode = "404", description = "Carrinho ou perfume não encontrado",
                content = @Content)
    })
    @PostMapping("/api/v1/carrinho/{carrinhoId}/perfume/{perfumeId}")
    public EntityModel<Carrinho> adicionarPerfumeAoCarrinho(@PathVariable long carrinhoId, @PathVariable long perfumeId) {
        Carrinho carrinho = carrinhoService.adicionarPerfume(carrinhoId, perfumeId);
        EntityModel<Carrinho> resource = EntityModel.of(carrinho);

        resource.add(linkTo(methodOn(ApiRestCarrinhoController.class).adicionarPerfumeAoCarrinho(carrinhoId, perfumeId)).withSelfRel());
        resource.add(linkTo(methodOn(ApiRestCarrinhoController.class).buscarCarrinhoPorCliente(carrinhoId)).withRel("buscarCarrinhoPorCliente"));

        return resource;
    }

    @Operation(summary = "Remover um perfume do carrinho")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Perfume removido com sucesso do carrinho",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Carrinho.class))}),
        @ApiResponse(responseCode = "404", description = "Carrinho ou perfume não encontrado",
                content = @Content)
    })
    @DeleteMapping("/api/v1/carrinho/{carrinhoId}/perfume/{perfumeId}")
    public EntityModel<Carrinho> removerPerfumeDoCarrinho(@PathVariable long carrinhoId, @PathVariable long perfumeId) {
        Carrinho carrinho = carrinhoService.removerPerfume(carrinhoId, perfumeId);
        EntityModel<Carrinho> resource = EntityModel.of(carrinho);

        resource.add(linkTo(methodOn(ApiRestCarrinhoController.class).removerPerfumeDoCarrinho(carrinhoId, perfumeId)).withSelfRel());
        resource.add(linkTo(methodOn(ApiRestCarrinhoController.class).buscarCarrinhoPorCliente(carrinhoId)).withRel("buscarCarrinhoPorCliente"));

        return resource;
    }

    @Operation(summary = "Buscar carrinho pelo ID do cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Carrinho encontrado com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Carrinho.class))}),
        @ApiResponse(responseCode = "404", description = "Carrinho não encontrado",
                content = @Content)
    })
    @GetMapping("/api/v1/carrinho/cliente/{clienteId}")
    public EntityModel<Carrinho> buscarCarrinhoPorCliente(@PathVariable long clienteId) {
        Carrinho carrinho = carrinhoService.buscarPorCliente(clienteId);
        EntityModel<Carrinho> resource = EntityModel.of(carrinho);

        resource.add(linkTo(methodOn(ApiRestCarrinhoController.class).buscarCarrinhoPorCliente(clienteId)).withSelfRel());
        resource.add(linkTo(methodOn(ApiRestCarrinhoController.class).adicionarPerfumeAoCarrinho(clienteId, 0L)).withRel("adicionarPerfume"));

        return resource;
    }
}
