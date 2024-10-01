package br.edu.iff.ccc.bsi.perfumaria.hateoas;

import br.edu.iff.ccc.bsi.perfumaria.controller.apirest.ApiRestUsuarioController;
import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UsuarioModelAssembler extends RepresentationModelAssemblerSupport<Usuario, UsuarioModel> {

    public UsuarioModelAssembler() {
        super(ApiRestUsuarioController.class, UsuarioModel.class);
    }

    @Override
    public UsuarioModel toModel(Usuario entity)
    {
        UsuarioModel usuarioModel = instantiateModel(entity);

        usuarioModel.add(linkTo(
                methodOn(ApiRestUsuarioController.class)
                        .encontrarUserPorId(entity.getId()))
                .withSelfRel());

        usuarioModel.(entity.getId());
        usuarioModel.setUsername()(entity.getUsername());
        usuarioModel.setSenha(entity.getSenha());
        return usuarioModel;
    }

    @Override
    public CollectionModel<UsuarioModel> toCollectionModel(Iterable<? extends Usuario> entities) {

        CollectionModel<UsuarioModel> usuarioModels = super.toCollectionModel(entities);

        return usuarioModels;
    }
}
