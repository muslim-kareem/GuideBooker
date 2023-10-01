package com.guide.me.backend.appuser;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws AppUserNotFountException {
        AppUser appUser = this.appUserRepo.findAppUserByName(userName)
                .orElseThrow(() -> new AppUserNotFountException("User not found"));
        return new User(
                appUser.getName(),
                appUser.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + appUser.getRole()))
        );
    }

    public AppUser register(AppUser newAppUser) {
        Argon2PasswordEncoder passwordEncoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        AppUser appUser;
        if (this.appUserRepo.findAppUserByName(newAppUser.getName()).isEmpty()) {
            appUser = new AppUser(
                    newAppUser.getName(),
                    passwordEncoder.encode(newAppUser.getPassword()),
                    Role.BASIC
            );

        }else {
            throw new RuntimeException("The name is already exist please chose another name. ");
        }
        return this.getAppUserWithoutPassword(this.appUserRepo.save(appUser));
    }

    public AppUser getAppUserWithoutPassword(AppUser appUser) {
        appUser.setPassword(null);
        return appUser;
    }

    public AppUser getAppUserById(String userId){
        return this.appUserRepo.findById(userId)
                .orElseThrow(()-> new AppUserNotFountException("No User found with this id: "+ userId));
    }
}
