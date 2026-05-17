package fr.astth.ms.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tournament_type")
public class TournamentType {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "number_of_players")
	private int numberOfPlayers;
	@Column(name = "barrage")
	private boolean barrage;
	@Column(name = "groups")
	private boolean groups;
	@Column(name = "group_size")
	private int groupSize;
}
