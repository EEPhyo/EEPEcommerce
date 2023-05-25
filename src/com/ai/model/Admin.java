package com.ai.model;

import java.io.Serializable;

public class Admin implements Serializable {
			private String email;
			private String password;
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public Admin() {}
}
