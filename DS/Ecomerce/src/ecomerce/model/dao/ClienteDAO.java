package ecomerce.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import ecomerce.model.domain.Cliente;

public class ClienteDAO {
	
	@PersistenceContext(unitName = "EcomercePU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getCliente(){
		return entityManager.createQuery("from Cliente").getResultList();
	}
	
	public Cliente getClientePorId(Long id) {
		return entityManager.find(Cliente.class, id);
	}
	
	@Transactional
	public void salvarCliente(Cliente cliente) {
		entityManager.persist(cliente);
	}
	
	@Transactional
	public void atualizarCliente(Cliente cliente) {
		entityManager.merge(cliente);
	}
	
	@Transactional
	public void excluirCliente(Long id) {
		entityManager.remove(getClientePorId(id));
	}
}
