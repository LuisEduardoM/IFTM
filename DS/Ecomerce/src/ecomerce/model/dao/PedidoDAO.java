package ecomerce.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import ecomerce.model.domain.Pedido;

public class PedidoDAO {

	@PersistenceContext(unitName = "EcomercePU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getPedido(){
		return entityManager.createQuery("from Pedido").getResultList();
	}
	
	public Pedido getPedidoPorId(Long id) {
		return entityManager.find(Pedido.class, id);
	}
	
	@Transactional
	public void salvarPedido(Pedido pedido) {
		entityManager.persist(pedido);
	}
	
	@Transactional
	public void atualizarPedido(Pedido pedido) {
		entityManager.merge(pedido);
	}
	
	@Transactional
	public void excluirPedido(Long id) {
		entityManager.remove(getPedidoPorId(id));
	}
}
