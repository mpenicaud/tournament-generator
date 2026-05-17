package fr.astth.ms.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.astth.ms.domain.Group;
import fr.astth.ms.domain.Player;
import fr.astth.ms.domain.Tournament;
import fr.astth.ms.domain.TournamentType;
import fr.astth.ms.repository.GroupRepository;
import fr.astth.ms.repository.PlayerRepository;
import fr.astth.ms.repository.TournamentRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TournamentServiceClass {

	@Mock
	private TournamentRepository tournamentRepository;

	@Mock
	private PlayerRepository playerRepository;

	@Mock
	private GroupRepository groupRepository;

	@InjectMocks
	private TournamentService tournamentService;

	private final AtomicLong ids = new AtomicLong(1);

	@BeforeEach
	void setup() {

		mockSave(tournamentRepository, Tournament::setId);
		mockSave(playerRepository, Player::setId);
		mockSave(groupRepository, Group::setId);
	}

	private <T> void mockSave(JpaRepository<T, Long> repository, BiConsumer<T, Long> idSetter) {

		when(repository.save(any())).thenAnswer(invocation -> {

			T entity = invocation.getArgument(0);

			if (entity == null) {
				return null;
			}
			idSetter.accept(entity, ids.getAndIncrement());

			return entity;
		});
	}

	@Test
	public void testCreateTournament() {

		when(tournamentRepository.save(any(Tournament.class))).thenAnswer(invocation -> {

			Tournament t = invocation.getArgument(0);

			t.setId(1L);

			return t;
		});
		TournamentType tournamentType = new TournamentType();
		tournamentType.setName("Test Type");
		tournamentType.setNumberOfPlayers(16);
		tournamentType.setGroupSize(4);

		Tournament tournament = new Tournament();
		tournament.setName("Test Tournament");
		tournament.setTournamentType(tournamentType);
		tournament.setDate(LocalDate.of(2026, 06, 10));
		tournament.setLocation("Herserange");

		// Mock the repository save method
		tournament = tournamentService.createTournament(tournament);

		assert tournament.getName().equals("Test Tournament");
		assert tournament.getTournamentType().getName().equals("Test Type");
		assert tournament.getId() != null; // Assuming the ID is generated upon saving

	}

}
