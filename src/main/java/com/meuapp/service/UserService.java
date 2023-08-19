package com.meuapp.service;

import com.meuapp.dao.UserDAO;
import com.meuapp.model.UserModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UserService {

    @Inject
    private UserDAO userDAO;

    public void salvarUsuario(UserModel usuario) {
        userDAO.salvar(usuario);
    }

    public void atualizarUsuario(UserModel usuario) {
        userDAO.atualizar(usuario);
    }

    public void excluirUsuario(Long id) {
        userDAO.excluir(id);
    }

    public UserModel buscarUsuarioPorId(Long id) {
        return userDAO.buscarPorId(id);
    }

    public List<UserModel> listarUsuarios() {
        return userDAO.listarTodos();
    }

}
