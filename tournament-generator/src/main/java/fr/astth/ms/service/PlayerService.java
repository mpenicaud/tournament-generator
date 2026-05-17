package fr.astth.ms.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.astth.ms.domain.Player;
import fr.astth.ms.repository.PlayerRepository;

@Service
public class PlayerService {

	private final PlayerRepository playerRepository;

	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	public Player createPlayer(String lastName, String firstName, String ranking, String club) {
		Player player = new Player();
		player.setLastName(lastName);
		player.setFirstName(firstName);
		player.setRanking(ranking);
		player.setClub(club);
		return player;
	}

	public Optional<Player> getPlayer(String lastName, String firstName) {
		return playerRepository.findByLastNameAndFirstName(lastName, firstName);
	}

}
