package ecomerce.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import ecomerce.model.domain.Produto;

public class ProdutoDAO {

	@PersistenceContext(unitName = "EcomercePU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Produto> getProduto(){
		return entityManager.createQuery("from Produto").getResultList();
	}
	
	public Produto getProdutoPorId(Long id) {
		return entityManager.find(Produto.class, id);
	}
	
	@Transactional
	public void salvarProduto(Produto produto) {
		entityManager.persist(produto);
	}
	
	@Transactional
	public void atualizarProduto(Produto produto) {
		entityManager.merge(produto);
	}
	
	@Transactional
	public void excluirProduto(Long id) {
		entityManager.remove(getProdutoPorId(id));
	}
}
