package ecomerce.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import ecomerce.model.domain.ItemPedido;

public class ItemPedidoDAO {

	@PersistenceContext(unitName = "EcomercePU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<ItemPedido> getItemPedido(){
		return entityManager.createQuery("from ItemPedido").getResultList();
	}
	
	public ItemPedido getItemPedidoPorId(Long id) {
		return entityManager.find(ItemPedido.class, id);
	}
	
	@Transactional
	public void salvarItemPedido(ItemPedido itemPedido) {
		entityManager.persist(itemPedido);
	}
	
	@Transactional
	public void atualizarItemPedido(ItemPedido itemPedido) {
		entityManager.merge(itemPedido);
	}
	
	@Transactional
	public void excluirItemPedido(Long id) {
		entityManager.remove(getItemPedidoPorId(id));
	}
}
