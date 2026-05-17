package fr.astth.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.astth.ms.domain.TournamentType;

public interface TournamentTypeRepository extends JpaRepository<TournamentType, Long> {

}
