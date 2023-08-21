package com.meuapp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.meuapp.model.UserModel;
import com.meuapp.model.UserResponse;
import com.meuapp.service.UserService;

@Named
@SessionScoped
public class UserBean {

	private static final String INDEX = "index?faces-redirect=true";

	private UserService usuarioService = new UserService();

	private UserModel usuario = new UserModel();
	private List<UserModel> usuarios;
	private static List<UserResponse> response;

	public UserModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UserModel usuario) {
		this.usuario = usuario;
	}

	public List<UserResponse> carregarUsuarios() {
        if(response != null) {
        	return response;
        }
		usuarios = usuarioService.listarUsuarios();

		this.response = new ArrayList<UserResponse>();

		for (UserModel user : usuarios) {
			UserResponse responses = new UserResponse();
			responses.setModel(user);
			response.add(responses);
		}

		return response;

	}

	public void novoUsuario() {
		usuario = new UserModel();
	}

	public String salvarUsuario() {
		if (usuario.getId() == null) {
			usuarioService.salvarUsuario(usuario);
		} else {
			usuarioService.atualizarUsuario(usuario);
		}
		carregarUsuarios();
		novoUsuario();
		addMessage("Usuário salvo com sucesso!");
		this.response = null;
		return INDEX;
	}

	public String editarUsuario(UserResponse usuario) {
    	usuario.setEdit(false);
    	List<UserResponse> newValue = new ArrayList<UserResponse>();
		for (UserResponse user : response) {
			UserResponse newResponse = new UserResponse();
			if(user.getModel().getId() == usuario.getModel().getId()) {
				newResponse.setEdit(false);
			}
			newResponse.setModel(user.getModel());
		    newValue.add(newResponse);
		}
		
		this.response.clear();
		this.response.addAll(newValue);
    	
    	return INDEX;
		/*usuarioService.atualizarUsuario(usuario); */
    }
	
	public String editar(UserResponse usuario) {
		
	   usuarioService.atualizarUsuario(usuario.getModel()); 
	   
	   this.response = null;
	   
	   return INDEX;
	   
	}

	public String excluirUsuario(UserResponse usuario) {
		usuarioService.excluirUsuario(usuario.getModel().getId());
		addMessage("Usuário excluído com sucesso!");
		this.response = null;
		return INDEX;
	}

	public String cancelarEdicao() {
		return INDEX;
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
