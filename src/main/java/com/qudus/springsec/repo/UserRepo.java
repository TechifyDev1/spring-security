package com.qudus.springsec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qudus.springsec.model.Users;


// This interface is a Spring Data JPA repository for the Users entity.
// It extends JpaRepository, which provides methods for CRUD operations and pagination.
@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    // This interface is used to define methods for user-related operations.
    // It can be implemented by a class that interacts with a database or other data source.
    // For example, it can be used to retrieve user details, save user information, etc.
    // The actual implementation of this interface will depend on the specific requirements of the application.
    // This method retrieves a user by their username.
    Users findByUsername(String username);
}

// This interface extends JpaRepository, which provides methods for CRUD operations on the Users entity.
// The first parameter is the entity type (Users), and the second parameter is the type of the entity's ID (Integer).

// 3306