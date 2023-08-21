package com.meuapp.model;

import java.util.List;

public class UserResponse {

	private UserModel model;
	private boolean edit = true;

	public UserModel getModel() {
		return model;
	}

	public void setModel(UserModel model) {
		this.model = model;
	}

	public boolean getEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

}
