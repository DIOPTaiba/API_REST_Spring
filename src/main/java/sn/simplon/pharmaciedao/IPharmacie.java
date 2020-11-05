package sn.simplon.pharmaciedao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.simplon.entities.Pharmacie;

import java.util.List;

@Repository
public interface IPharmacie extends JpaRepository<Pharmacie, Integer> {

    @Query("SELECT p from Pharmacie p where p.ville=:ville")
    public List<Pharmacie> getAllByVille(@Param("ville") String quartier);

    @Query("SELECT p from Pharmacie p where p.quartier=:quartier")
    public List<Pharmacie> getAllByQuartier(@Param("quartier") String ville);

    @Query("SELECT p from Pharmacie p where p.id=:id")
    public Pharmacie getById(@Param("id") int id);

    @Query("SELECT p from Pharmacie p where p.nom=:nom")
    public List<Pharmacie> getAllByNom(@Param("nom") String nom);

    @Query("SELECT p from Pharmacie p where p.etat=:etat")
    List<Pharmacie> getAllByOuverte(@Param("etat") int etat );

}
