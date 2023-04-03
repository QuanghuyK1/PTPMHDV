package com.xemphim.WebXemPhim.entity;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	
	@Id
	@Column(name = "account_name")
	private String accountName;
	
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	private Collection<Comment> comments;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	private Collection<Evaluation> evaluations;
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	public Collection<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Collection<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
}
