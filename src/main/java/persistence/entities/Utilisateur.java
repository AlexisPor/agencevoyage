package persistence.entities;
// Generated 12 avr. 2021 � 11:47:54 by Hibernate Tools 4.0.1.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Utilisateur generated by hbm2java
 */
@Entity
@Table(name = "UTILISATEUR", schema = "AGENCEDB")
public class Utilisateur implements java.io.Serializable {

	private BigDecimal idutilisateur;
	private String username;
	private String password;
	private String role;

	public Utilisateur() {
	}

	public Utilisateur(BigDecimal idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public Utilisateur(BigDecimal idutilisateur, String username, String password, String role) {
		this.idutilisateur = idutilisateur;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	@Id

	@Column(name = "IDUTILISATEUR", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdutilisateur() {
		return this.idutilisateur;
	}

	public void setIdutilisateur(BigDecimal idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	@Column(name = "USERNAME", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "ROLE", length = 20)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}