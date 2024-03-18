package com.medianet.AgenceApplication.Repository;

import com.medianet.AgenceApplication.Entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
