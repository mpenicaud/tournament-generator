package fr.astth.ms.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.astth.ms.domain.Group;
import fr.astth.ms.domain.Tournament;
import fr.astth.ms.domain.TournamentType;
import fr.astth.ms.repository.GroupRepository;
import fr.astth.ms.repository.TournamentRepository;

@Service
public class TournamentService {

	private final TournamentRepository tournamentRepository;

	private final GroupRepository groupRepository;

	TournamentService(TournamentRepository tournamentRepository, GroupRepository groupRepository) {
		this.tournamentRepository = tournamentRepository;
		this.groupRepository = groupRepository;
	}

	public Tournament createTournament(Tournament tournament) {
		return tournamentRepository.save(tournament);
	}

	public Tournament getTournamentById(Long id) {
		return tournamentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Tournament not found with id: " + id));
	}

	public void generateGroupsForTournament(Long tournamentId) {
		Tournament tournament = getTournamentById(tournamentId);
		TournamentType type = tournament.getTournamentType();
		// Logic to generate groups based on the tournament's properties (e.g., number
		// of players, group size)

		// Instantiate groups
		int numberOfGroups = (int) Math.ceil((double) type.getNumberOfPlayers() / type.getGroupSize());
		for (int i = 1; i <= numberOfGroups; i++) {
			Group group = new Group();
			group.setName("Poule " + i);
			group.setTournament(tournament);
			group.setParticipants(new ArrayList<>());
			groupRepository.save(group);
		}
	}

	public void assignParticipantsToGroups(Long tournamentId) {
		Tournament tournament = getTournamentById(tournamentId);
		// Logic to assign participants to groups based on the tournament's properties
		// (e.g., number of players, group size)
		// This method would typically involve shuffling the list of participants and
		// distributing them into the groups created in the previous step.
	}

}
