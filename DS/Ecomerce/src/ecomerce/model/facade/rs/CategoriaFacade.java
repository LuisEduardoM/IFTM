package ecomerce.model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ecomerce.model.dao.CategoriaDAO;
import ecomerce.model.domain.Categoria;

@Path(value = "/categoria")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CategoriaFacade {

	@Inject
	private CategoriaDAO categoriaDAO;
	
	@GET
	public List<Categoria> getCategorias(){
		return categoriaDAO.getCategoria();
	}
	
	@GET
	@Path(value = "/{id}")
	public Categoria getCategoriaPorID(@PathParam("id") Long id) {
		return categoriaDAO.getCategoriaPorId(id);
	}
	
	@POST
	public void salvarCategoria(Categoria categoria) {
		categoriaDAO.salvarCategoria(categoria);
	}
	
	@PUT
	public void atualizarCategoria(Categoria categoria) {
		categoriaDAO.atualizarCategoria(categoria);
	}
	
	@DELETE
	@Path(value = "/{id}")
	public void excluirCategoria(@PathParam("id") Long id) {
		categoriaDAO.excluirCategoria(id);
	}
}
