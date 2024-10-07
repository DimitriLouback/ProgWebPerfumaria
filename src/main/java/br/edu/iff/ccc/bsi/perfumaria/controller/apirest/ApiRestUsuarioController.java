package br.edu.iff.ccc.bsi.perfumaria.controller.apirest;

import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
import br.edu.iff.ccc.bsi.perfumaria.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
                content = @Content)
    })
    @GetMapping("/api/usuario/{id}")
    public EntityModel<Usuario> encontrarUserPorId(@PathVariable long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        EntityModel<Usuario> resource = EntityModel.of(usuario);

        resource.add(linkTo(methodOn(ApiRestUsuarioController.class).encontrarUserPorId(id)).withSelfRel());
        resource.add(linkTo(methodOn(ApiRestUsuarioController.class).listarUsuarios()).withRel("usuarios"));

        return resource;
    }

    @Operation(summary = "Adicionar um novo usuário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuário adicionado com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Usuario.class))}),
        @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na validação dos campos",
                content = @Content)
    })
    @PostMapping("/api/usuario")
    public Usuario adicionarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.inserirUsuario(usuario);
    }

    @Operation(summary = "Listar todos os usuários")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuários listados com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Usuario.class))}),
        @ApiResponse(responseCode = "400", description = "Ocorreu algum erro na listagem dos usuários",
                content = @Content)
    })
    @GetMapping("/api/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @Operation(summary = "Remover um usuário pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuário removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @DeleteMapping("/api/usuario/{id}")
    public void removerUsuario(@PathVariable long id) {
        usuarioService.removerUsuarioPorId(id);
    }

    @Operation(summary = "Atualizar um usuário existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Usuario.class))}),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
        @ApiResponse(responseCode = "400", description = "Erro na validação dos dados")
    })
    @PutMapping("/api/usuario/{id}")
    public Usuario atualizarUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(id, usuario);
    }
}
