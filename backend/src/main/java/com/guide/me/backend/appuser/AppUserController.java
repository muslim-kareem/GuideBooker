package com.guide.me.backend.appuser;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService service;

    @PostMapping
    public AppUser register(@RequestBody AppUser user){
        return this.service.register(user);
    }
}
