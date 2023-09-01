package com.guide.me.backend.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    private String id,name,password,imageId;
    List<String> appointmentsIds = new ArrayList<>();
    private Role role;

    public AppUser(String id, String name, String password, Role role) {
    }
}
