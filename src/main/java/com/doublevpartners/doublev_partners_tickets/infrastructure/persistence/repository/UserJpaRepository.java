package com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.repository;

import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByLogin(String login);

}
