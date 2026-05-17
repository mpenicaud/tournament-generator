package fr.astth.ms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.astth.ms.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	Optional<Player> findByLastNameAndFirstName(String lastName, String firstName);

}
