package br.edu.iff.ccc.bsi.perfumaria.controller.apirest;

import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
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
public class ApiRestUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public ApiRestUsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation(summary = "Encontrar o usuário pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "400", description = "Id fornecido é inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado",
                    content = @Content) })
    @GetMapping("/api/usuario/{id}")
    public Usuario encontrarUserPorId(@PathVariable long id) {
        return usuarioService.buscarPorId(id);
    }

    @Operation(summary = "Adicionar um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário adicionado com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na validação dos campos",
                    content = @Content) })
    @GetMapping("/api/usuario")
    public Usuario adicionarUsuario(@RequestBody Usuario usuario) {

        return usuarioService.inserirUsuario(usuario);
    }

    @Operation(summary = "Listar todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários listados com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na listagem dos usuários",
                    content = @Content) })
    @GetMapping("/api/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
}
