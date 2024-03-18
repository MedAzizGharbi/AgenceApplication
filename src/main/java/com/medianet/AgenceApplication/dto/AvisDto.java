package com.medianet.AgenceApplication.dto;

import com.medianet.AgenceApplication.Entities.Circuit;
import com.medianet.AgenceApplication.Entities.User;
import lombok.Data;

import java.util.Date;

@Data
public class AvisDto {
    private Long id;
    private User user;
    private Circuit circuit;
    private String commentaire;
    private int note;
    private Date date;
}
