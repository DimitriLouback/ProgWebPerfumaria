package br.edu.iff.ccc.bsi.perfumaria.controller.apirest;

import br.edu.iff.ccc.bsi.perfumaria.entities.Cliente;
import br.edu.iff.ccc.bsi.perfumaria.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ApiRestClienteController {

    @Autowired
    private ClienteService clienteService;

    public ApiRestClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Encontrar o cliente pelo seu ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente encontrado",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Cliente.class))}),
        @ApiResponse(responseCode = "400", description = "ID fornecido é inválido",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado",
                content = @Content)
    })
    @GetMapping("/api/v1/cliente/{id}")
    public EntityModel<Cliente> encontrarClientePorId(@PathVariable long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        EntityModel<Cliente> resource = EntityModel.of(cliente);

        resource.add(linkTo(methodOn(ApiRestClienteController.class).encontrarClientePorId(id)).withSelfRel());
        resource.add(linkTo(methodOn(ApiRestClienteController.class).listarClientes()).withRel("clientes"));

        return resource;
    }

    @Operation(summary = "Adicionar um novo cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente adicionado com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Cliente.class))}),
        @ApiResponse(responseCode = "400", description = "Erro na validação dos dados",
                content = @Content)
    })
    @PostMapping("/api/v1/cliente")
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {
        return clienteService.inserirCliente(cliente);
    }

    @Operation(summary = "Listar todos os clientes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Clientes listados com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Cliente.class))}),
        @ApiResponse(responseCode = "400", description = "Erro na listagem dos clientes",
                content = @Content)
    })
    @GetMapping("/api/v1/clientes")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @Operation(summary = "Buscar clientes por nome")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente(s) encontrado(s)",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Cliente.class))}),
        @ApiResponse(responseCode = "404", description = "Cliente(s) não encontrado(s)",
                content = @Content)
    })
    @GetMapping("/api/v1/clientes/nome/{nome}")
    public Cliente buscarClientePorNome(@PathVariable String nome) {
        return clienteService.buscarPorNome(nome);
    }

    @Operation(summary = "Buscar clientes por data de nascimento")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente(s) encontrado(s)",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Cliente.class))}),
        @ApiResponse(responseCode = "404", description = "Cliente(s) não encontrado(s)",
                content = @Content)
    })
    @GetMapping("/api/v1/clientes/data-nascimento/{data}")
    public List<Cliente> buscarPorDataNascimento(@PathVariable Date data) {
        return clienteService.buscarPorDataNascimento(data);
    }

    @Operation(summary = "Buscar clientes por data de cadastro")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente(s) encontrado(s)",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Cliente.class))}),
        @ApiResponse(responseCode = "404", description = "Cliente(s) não encontrado(s)",
                content = @Content)
    })
    @GetMapping("/api/v1/clientes/data-cadastro/{data}")
    public List<Cliente> buscarPorDataCadastro(@PathVariable Date data) {
        return clienteService.buscarPorDataCadastro(data);
    }

    @Operation(summary = "Remover um cliente pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @DeleteMapping("/api/v1/cliente/{id}")
    public void removerCliente(@PathVariable long id) {
        clienteService.removerClientePorId(id);
    }

    @Operation(summary = "Atualizar um cliente existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Cliente.class))}),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
        @ApiResponse(responseCode = "400", description = "Erro na validação dos dados")
    })
    @PutMapping("/api/v1/cliente/{id}")
    public Cliente atualizarCliente(@PathVariable long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }
}
