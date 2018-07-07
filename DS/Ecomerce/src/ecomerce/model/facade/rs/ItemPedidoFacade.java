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

import ecomerce.model.dao.ItemPedidoDAO;
import ecomerce.model.domain.ItemPedido;

@Path(value = "/itemPedido")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ItemPedidoFacade {

	@Inject
	private ItemPedidoDAO itemPedidoDAO;
	
	@GET
	public List<ItemPedido> getItemPedidos(){
		return itemPedidoDAO.getItemPedido();
	}
	
	@GET
	@Path(value = "/{id}")
	public ItemPedido getItemPedidoPorId(@PathParam("id") Long id) {
		return itemPedidoDAO.getItemPedidoPorId(id);
	}
	
	@POST
	public void salvarItemPedido(ItemPedido itemPedido) {
		itemPedidoDAO.salvarItemPedido(itemPedido);
	}
	
	@PUT
	public void atualizarItemPedido(ItemPedido itemPedido) {
		itemPedidoDAO.atualizarItemPedido(itemPedido);
	}
	
	@DELETE
	@Path(value = "/{id}")
	public void excluirItemPedido(@PathParam("id") Long id) {
		itemPedidoDAO.excluirItemPedido(id);
	}
}
