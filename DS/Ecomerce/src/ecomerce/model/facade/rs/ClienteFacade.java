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

import ecomerce.model.dao.ClienteDAO;
import ecomerce.model.domain.Cliente;

@Path(value = "/cliente")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ClienteFacade {

	@Inject
	private ClienteDAO clienteDAO;
	
	@GET
	public List<Cliente> getClientes(){
		return clienteDAO.getCliente();
	}
	
	@GET
	@Path(value = "/{id}")
	public Cliente getClientePorId(@PathParam("id") Long id) {
		return clienteDAO.getClientePorId(id);
	}
	
	@POST
	public void salvarCliente(Cliente cliente) {
		clienteDAO.salvarCliente(cliente);
	}
	
	@PUT
	public void atualizarCliente(Cliente cliente) {
		clienteDAO.atualizarCliente(cliente);
	}
	
	@DELETE
	@Path(value = "/{id}")
	public void excluirCliente(@PathParam("id") Long id) {
		clienteDAO.excluirCliente(id);
	}
}
