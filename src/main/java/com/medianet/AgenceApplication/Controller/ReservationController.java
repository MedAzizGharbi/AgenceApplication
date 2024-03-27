package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Reservation;
import com.medianet.AgenceApplication.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public List<Reservation> getAllReservations(){return reservationRepository.findAll();}
}
