package com.meuapp.beans;

import com.meuapp.model.UserModel;
import com.meuapp.service.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class UserBean {

    @Inject
    private UserService usuarioService;
    
    private UserModel usuario = new UserModel();
    private List<UserModel> usuarios;

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }


    public void carregarUsuarios() {
        usuarios = usuarioService.listarUsuarios();
    }

    public void novoUsuario() {
        usuario = new UserModel();
    }

    public void salvarUsuario() {
        if (usuario.getId() == null) {
            usuarioService.salvarUsuario(usuario);
        } else {
            usuarioService.atualizarUsuario(usuario);
        }
        carregarUsuarios();
        novoUsuario();
        addMessage("Usuário salvo com sucesso!");
    }

    public void editarUsuario(UserModel usuario) {
        this.usuario = usuario;
    }

    public void excluirUsuario(UserModel usuario) {
        usuarioService.excluirUsuario(usuario.getId());
        carregarUsuarios();
        addMessage("Usuário excluído com sucesso!");
    }

    public void cancelarEdicao() {
        novoUsuario();
    }

    private void addMessage(String message) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, null);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public List<UserModel> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UserModel> usuarios) {
        this.usuarios = usuarios;
    }
}
