package com.meuapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.meuapp.model.UserModel;


public class UserDAO {
	
	private EntityManagerFactory entityFactory;
	private EntityManager entityManager;
	
    public UserDAO() {
    	this.entityFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
    	this.entityManager = entityFactory.createEntityManager();
    }
	
    public void salvar(UserModel usuario) {
    	entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
    }

    public UserModel atualizar(UserModel usuario) {
        return entityManager.merge(usuario);
    }

    public void excluir(Long id) {
        UserModel usuario = entityManager.find(UserModel.class, id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }

    public UserModel buscarPorId(Long id) {
        return entityManager.find(UserModel.class, id);
    }

    public List<UserModel> listarTodos() {
        return entityManager.createQuery("SELECT u FROM UserModel u", UserModel.class)
                .getResultList();
    }
}
