

package com.nordeus.jobfair.auctionservice.auctionservice.api.smece.api.model;


/**
 * The information required to register a user.
 */
public class RegistrationBody {

  /** The username. */

  private String username;
  /** The email. */

  private String email;
  /** The password. */

  private String password;
  /** The first name. */

  private String firstName;
  /** The last name. */

  private String lastName;

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
