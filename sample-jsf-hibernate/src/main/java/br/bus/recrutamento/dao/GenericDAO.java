package br.bus.recrutamento.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T , ID extends Serializable> {

	T findById(ID id);

	List<T> findAll(String colunaOrdenacao);

	T save(T entity) throws Exception;

	void delete(T entity);

}
