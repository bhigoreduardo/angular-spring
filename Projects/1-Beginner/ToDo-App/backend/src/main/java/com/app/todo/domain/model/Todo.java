package com.app.todo.domain.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private Boolean status;

	@CreationTimestamp
	private LocalDateTime dataCadastro;

	private LocalDateTime dataFinalizacao;

	@PrePersist
	public void beforeSave() {
		setStatus(Boolean.FALSE);
	}

}
