package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Vol;

public interface VolRepository extends JpaRepository<Vol, Long> {

}
