package com.meuapp.dao;

import com.meuapp.model.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserDAO {
	
    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(UserModel usuario) {
        entityManager.persist(usuario);
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
