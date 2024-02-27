package com.medianet.AgenceApplication.dto;

import com.medianet.AgenceApplication.Entities.Circuit;
import com.medianet.AgenceApplication.Entities.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationDto {
    private Long id;
    private User user;
    private Circuit circuit;
    private Date date;
    private boolean statusPaiement;
}
