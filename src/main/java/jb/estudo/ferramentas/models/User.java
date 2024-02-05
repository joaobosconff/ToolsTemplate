package jb.estudo.ferramentas.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
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

	@ManyToMany
	private List<Role> roles = new ArrayList<>();
}
