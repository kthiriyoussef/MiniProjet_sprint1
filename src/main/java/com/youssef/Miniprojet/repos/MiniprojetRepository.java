package com.youssef.Miniprojet.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import com.youssef.Miniprojet.entities.Voiture;

public interface MiniprojetRepository extends JpaRepository<Voiture, Long>  {

}
