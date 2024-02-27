package com.medianet.AgenceApplication.Repository;

import com.medianet.AgenceApplication.Entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceRepository extends JpaRepository<Agence , Long> {
}
