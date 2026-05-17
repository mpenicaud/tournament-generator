package fr.astth.ms.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "players")
@Data
public class Player {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "ranking")
	private String ranking;
	@Column(name = "club")
	private String club;
}
