package br.edu.iff.ccc.bsi.perfumaria.controller.apirest;

import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
import br.edu.iff.ccc.bsi.perfumaria.service.PerfumeService;
import br.edu.iff.ccc.bsi.perfumaria.service.UsuarioService;
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
                    content = @Content) })
    @GetMapping("/api/v1/perfume/{id}")
    public Perfume encontrarPerfumePorId(@PathVariable long id) {
        return perfumeService.buscarPorId(id);
    }

    @Operation(summary = "Adicionar um novo perfume")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfume adicionado com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Perfume.class))}),
            @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na validação dos campos",
                    content = @Content) })
    @GetMapping("/api/v1/perfume")
    public Perfume adicionarUsuario(@RequestBody Perfume perfume) {

        return perfumeService.inserirPerfume(perfume);
    }

    @Operation(summary = "Listar todos os perfumes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfumes listados com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Perfume.class))}),
            @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na listagem dos perfumes",
                    content = @Content) })
    @GetMapping("/api/v1/perfumes")
    public List<Perfume> listarPerfumes() {
        return perfumeService.listarPerfumes();
    }
}
