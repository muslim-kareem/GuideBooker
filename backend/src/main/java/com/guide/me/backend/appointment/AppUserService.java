package com.guide.me.backend.appointment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AppUserService {
    private AppUserRepo appUserRepo;

    public AppUser getAppUserById(String userId){
        return this.appUserRepo.findById(userId)
                .orElseThrow(()-> new NoSuchElementException("No User found with this id: "+ userId));
    }
}
