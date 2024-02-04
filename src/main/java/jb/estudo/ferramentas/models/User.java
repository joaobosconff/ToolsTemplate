package jb.estudo.ferramentas.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Nonnull
	@Column(nullable = false, unique = true)
	private String login;
	
	@Nonnull
	@Column(nullable = false, unique = false)
	private String password;
	
	private String name;
}
