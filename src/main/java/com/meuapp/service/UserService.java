package com.meuapp.service;

import java.util.List;

import com.meuapp.dao.UserDAO;
import com.meuapp.model.UserModel;

public class UserService {

	private UserDAO userDAO = new UserDAO();

    public void salvarUsuario(UserModel usuario) {
        userDAO.salvar(usuario);
    }

    public void atualizarUsuario(UserModel usuario) {
        userDAO.update(usuario);
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
