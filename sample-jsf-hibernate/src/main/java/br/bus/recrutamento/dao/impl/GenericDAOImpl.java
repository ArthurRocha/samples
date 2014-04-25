package br.bus.recrutamento.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import br.bus.recrutamento.dao.GenericDAO;
import br.bus.recrutamento.util.HibernateUtil;

public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID>{

	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		if(id == null){
			return null;
		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		T entity = (T) session.get(getPersistentClass(), id);
		transaction.commit();
		session.close();
		return entity;
	}

	public List<T> findAll(String colunaOrdenacao) {
		return findByCriteria(Order.asc(colunaOrdenacao));
	}

	public T save(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(entity);

		transaction.commit();
		session.close();

		return entity;
	}

	public void delete(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.delete(entity);

		transaction.commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Order ordem, Criterion... criterion) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Criteria crit = session.createCriteria(getPersistentClass()).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if (ordem != null) {
			crit.addOrder(ordem);
		}
		for (Criterion c : criterion) {
			crit.add(c);
		}
		List<T> list = crit.list();

		transaction.commit();
		session.close();

		return list;
	}


}
