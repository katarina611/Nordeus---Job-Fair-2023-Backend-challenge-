package com.nordeus.jobfair.auctionservice.auctionservice.api.smece.service;


import org.springframework.stereotype.Service;

import com.nordeus.jobfair.auctionservice.auctionservice.api.smece.api.model.RegistrationBody;
import com.nordeus.jobfair.auctionservice.auctionservice.api.smece.exeption.UserAlreadyExistsException;
import com.nordeus.jobfair.auctionservice.auctionservice.api.smece.model.LocalUser;
import com.nordeus.jobfair.auctionservice.auctionservice.api.smece.model.dao.LocalUserDAO;



/**
 * Service for handling user actions.
 */
@Service
public class UserService {

  /** The LocalUserDAO. */
  private LocalUserDAO localUserDAO;

  /**
   * Constructor injected by spring.
   * @param localUserDAO
   */
  public UserService(LocalUserDAO localUserDAO) {
    this.localUserDAO = localUserDAO;
  }

  /**
   * Attempts to register a user given the information provided.
   * @param registrationBody The registration information.
   * @return The local user that has been written to the database.
   * @throws UserAlreadyExistsException Thrown if there is already a user with the given information.
   */
  public LocalUser registerUser(RegistrationBody  registrationBody) throws UserAlreadyExistsException {
    if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
        || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
      throw new UserAlreadyExistsException();
    }
    LocalUser user = new LocalUser();
    user.setEmail(registrationBody.getEmail());
    user.setUsername(registrationBody.getUsername());
    user.setFirstName(registrationBody.getFirstName());
    user.setLastName(registrationBody.getLastName());
    //TODO: Encrypt passwords!!
    user.setPassword(registrationBody.getPassword());
    return localUserDAO.save(user);
  }

}
