 package Modelo.beans;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable{

	
			//PROPIEDADES
			private static final long serialVersionUID= 1L;
			private String username;
			private String password;
			
			
			
			
			//CONTRUCTORES
			public Cliente(String username, String password) {
				super();
				this.username = username;
				this.password = password;
			}
			public Cliente() {
				super();
			}
			
			
			
			
			//SETTER --> CAMBIA VALORES Y IMPRIME DENTRO
			//GETTER --> RETORNA VALORES Y IMPRIME AFUERA
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			
			
			
			
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			
			
			

			//HASHCODE --> NUMERO
			//EQUAL --> COMPARA
			@Override
			public int hashCode() {
				return Objects.hash(password, username);
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (!(obj instanceof Cliente))
					return false;
				Cliente other = (Cliente) obj;
				return Objects.equals(password, other.password) && Objects.equals(username, other.username);
			}
			
			
			
			
			//TO_STRING --> IMPRIME DATOS
			@Override
			public String toString() {
				return "Cliente [username=" + username + ", password=" + password + "]";
			}
			
			
			
			
			
			
			
			
			
	
}
