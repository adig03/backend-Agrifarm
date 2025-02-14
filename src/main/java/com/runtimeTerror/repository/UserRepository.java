package com.runtimeTerror.repository;

import com.runtimeTerror.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    //Optional<User> findByUserName(String username);
    User findByUsername(String username);

    User findByEmail(String email);
}
