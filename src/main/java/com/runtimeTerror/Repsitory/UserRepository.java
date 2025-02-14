package com.runtimeTerror.Repsitory;

import com.mongodb.client.MongoDatabase;
import com.runtimeTerror.Models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    //Optional<User> findByUserName(String username);
    User findByUsername(String username);
}
