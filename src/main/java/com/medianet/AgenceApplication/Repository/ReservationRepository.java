package com.medianet.AgenceApplication.Repository;

import com.medianet.AgenceApplication.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation , Long> {
}
