package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Aeroport;
import model.Ville;

@Repository
public interface AeroportRepository extends JpaRepository<Aeroport, Integer>{

	public List<Aeroport> findAeroportByNomLike(String s);
	
	public Aeroport findAeroportByVilles(Ville v);
}
