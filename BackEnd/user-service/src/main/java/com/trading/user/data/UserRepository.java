package com.trading.user.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import static jakarta.persistence.criteria.Predicate.BooleanOperator.AND;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {


    @Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
    Optional<User> getUserByEmailPassword(@Param("email") String email, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> getUserIdByEmail(@Param("email") String email);

}
