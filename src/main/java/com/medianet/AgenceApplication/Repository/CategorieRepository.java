package com.medianet.AgenceApplication.Repository;

import com.medianet.AgenceApplication.Entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
