package fr.astth.ms.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "participant")
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;

	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;

	@ManyToOne
	@JoinColumn(name = "tournament_id")
	private Tournament tournament;

}
