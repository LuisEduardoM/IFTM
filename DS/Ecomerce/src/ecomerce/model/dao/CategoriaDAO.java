package ecomerce.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import ecomerce.model.domain.Categoria;

public class CategoriaDAO {

	@PersistenceContext(unitName = "EcomercePU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Categoria> getCategoria(){
		return entityManager.createQuery("from Categoria").getResultList();
	}
	
	public Categoria getCategoriaPorId(Long id) {
		return entityManager.find(Categoria.class, id);
	}
	
	@Transactional
	public void salvarCategoria(Categoria categoria) {
		entityManager.persist(categoria);
	}
	
	@Transactional
	public void atualizarCategoria(Categoria categoria) {
		entityManager.merge(categoria);
	}
	
	@Transactional
	public void excluirCategoria(Long id) {
		entityManager.remove(getCategoriaPorId(id));
	}
}
