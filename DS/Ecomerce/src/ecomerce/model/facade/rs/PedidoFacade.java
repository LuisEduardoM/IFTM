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

import ecomerce.model.dao.PedidoDAO;
import ecomerce.model.domain.Pedido;

@Path(value = "/pedido")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PedidoFacade {

	@Inject
	private PedidoDAO pedidoDAO;
	
	@GET
	public List<Pedido> getPedidos(){
		return pedidoDAO.getPedido();
	}
	
	@GET
	@Path(value = "/{id}")
	public Pedido getPedidoPorId(@PathParam("id") Long id) {
		return pedidoDAO.getPedidoPorId(id);
	}
	
	@POST
	public void salvarPedido(Pedido pedido) {
		pedidoDAO.salvarPedido(pedido);
	}
	
	@PUT
	public void atualizarPedido(Pedido pedido) {
		pedidoDAO.atualizarPedido(pedido);
	}
	
	@DELETE
	@Path(value = "/{id}")
	public void excluirPedido(@PathParam("id") Long id) {
		pedidoDAO.excluirPedido(id);
	}
}
