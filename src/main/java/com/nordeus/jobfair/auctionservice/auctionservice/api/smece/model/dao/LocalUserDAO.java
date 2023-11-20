package com.nordeus.jobfair.auctionservice.auctionservice.api.smece.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.nordeus.jobfair.auctionservice.auctionservice.api.smece.model.LocalUser;

import java.util.Optional;

/**
 * Data Access Object for the LocalUser data.
 */
public interface LocalUserDAO extends CrudRepository<LocalUser, Long> {

  Optional<LocalUser> findByUsernameIgnoreCase(String username);

  Optional<LocalUser> findByEmailIgnoreCase(String email);

}
