package com.guide.me.backend.appointment;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepo extends MongoRepository<String,AppUser> {
}
