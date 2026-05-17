package fr.astth.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.astth.ms.domain.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
