package br.edu.iff.ccc.bsi.perfumaria.controller.apirest;

import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import br.edu.iff.ccc.bsi.perfumaria.service.PerfumeService;
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
public class ApiRestPerfumeController {

    @Autowired
    private PerfumeService perfumeService;

    public ApiRestPerfumeController(PerfumeService perfumeService) {
        this.perfumeService = perfumeService;
    }

    @Operation(summary = "Encontrar o perfume pelo seu ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Perfume encontrado",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Perfume.class))}),
        @ApiResponse(responseCode = "400", description = "Id fornecido é inválido",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Perfume não encontrado",
                content = @Content)
    })
    @GetMapping("/api/v1/perfume/{id}")
    public EntityModel<Perfume> encontrarPerfumePorId(@PathVariable long id) {
        Perfume perfume = perfumeService.buscarPorId(id);
        EntityModel<Perfume> resource = EntityModel.of(perfume);

        resource.add(linkTo(methodOn(ApiRestPerfumeController.class).encontrarPerfumePorId(id)).withSelfRel());
        resource.add(linkTo(methodOn(ApiRestPerfumeController.class).listarPerfumes()).withRel("perfumes"));

        return resource;
    }

    @Operation(summary = "Adicionar um novo perfume")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Perfume adicionado com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Perfume.class))}),
        @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na validação dos campos",
                content = @Content)
    })
    @PostMapping("/api/v1/perfume")
    public Perfume adicionarPerfume(@RequestBody Perfume perfume) {
        return perfumeService.inserirPerfume(perfume);
    }

    @Operation(summary = "Listar todos os perfumes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Perfumes listados com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Perfume.class))}),
        @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na listagem dos perfumes",
                content = @Content)
    })
    @GetMapping("/api/v1/perfumes")
    public List<Perfume> listarPerfumes() {
        return perfumeService.listarPerfumes();
    }

    @Operation(summary = "Remover um perfume pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Perfume removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Perfume não encontrado")
    })
    @DeleteMapping("/api/v1/perfume/{id}")
    public void removerPerfume(@PathVariable long id) {
        perfumeService.removerPerfumePorId(id);
    }

    @Operation(summary = "Atualizar um perfume existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Perfume atualizado com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Perfume.class))}),
        @ApiResponse(responseCode = "404", description = "Perfume não encontrado"),
        @ApiResponse(responseCode = "400", description = "Erro na validação dos dados")
    })
    @PutMapping("/api/v1/perfume/{id}")
    public Perfume atualizarPerfume(@PathVariable long id, @RequestBody Perfume perfume) {
        return perfumeService.atualizarPerfume(id, perfume);
    }
}
