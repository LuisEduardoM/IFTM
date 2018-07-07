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

import ecomerce.model.dao.ProdutoDAO;
import ecomerce.model.domain.Produto;

@Path(value = "/produto")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ProdutoFacade {

	@Inject
	private ProdutoDAO produtoDAO;
	
	@GET
	public List<Produto> getProdutos(){
		return produtoDAO.getProduto();
	}
	
	@GET
	@Path(value = "/{id}")
	public Produto getProdutoPorId(@PathParam("id") Long id) {
		return produtoDAO.getProdutoPorId(id);
	}
	
	@POST
	public void salvarProduto(Produto produto) {
		produtoDAO.salvarProduto(produto);
	}
	
	@PUT
	public void atualizarProduto(Produto produto) {
		produtoDAO.atualizarProduto(produto);
	}
	
	@DELETE
	@Path(value = "/{id}")
	public void excluirProduto(@PathParam("id") Long id) {
		produtoDAO.excluirProduto(id);
	}
}
