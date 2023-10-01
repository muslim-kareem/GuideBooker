package com.guide.me.backend.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@AllArgsConstructor
public class Appointment {
    private String id;
    private String customerId;
    private String guiderId;
    @CreatedDate
    private Date date;
}
