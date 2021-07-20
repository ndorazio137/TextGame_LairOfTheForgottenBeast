package LairOfTheForgottenBeast;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The Account information of a specific game user.
 * 
 * @author Nick D'Orazio
 * @since 1.0.0
 */
@Entity
@Table(name="users", schema = "r6fur2nq2l9v04hx")
public class User {
  /**
   * User identification number for database indexing
   */
  @Id
  @Column(unique = true)
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  /**
   * The account username
   */

  @Column(name = "username", unique = true, nullable = false, length = 100, updatable = true, insertable = true)
  @NotNull
  private String username;
  /**
   * The account password
   */
  @Column(name = "password", nullable = false, length = 100, updatable = true, insertable = true)
  @NotNull
  private String password;
  /**
   * The name to display to other users
   */
  @Column(name = "displayName", nullable = false, length = 30, updatable = true, insertable = true)
  @NotNull
  private String displayName;

  /**
   * Constructor to create a new user.
   */
  public User() {}

  /**
   * Constructor to sign in an existing user.
   * 
   * @param username The account username
   * @param password The account password
   */
  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public long getID() {
    return id;
  }

  public boolean setID(long id) {
    if (id == 0)
      return false;
    this.id = id;
    return true;
  }

  /**
   * Retrieves a username for the account
   * 
   * @return the account name
   */
  public String getUsername() {
    return username;
  }

  /**
   * Used to set a new/changed username to an account name
   * 
   * @param username the new account name
   * @return A boolean expression (sanity check) if the new username was set successfully.
   */
  public boolean setUsername(String username) {
    if (username != null) {
      this.username = username;
      return true;
    }

    return false;
  }

  /**
   * Retrieves the password of the account.
   * 
   * @return the account password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Used to set a new/changed password to an account
   * 
   * @param password the new password
   * @return A boolean expression (sanity check) representing if the new password was successfully
   *         set.
   */
  public boolean setPassword(String password) {
    if (password != null) {
      this.password = password;
      return true;
    }

    return false;
  }

  /**
   * Retrieves the current name of the account that is displayed to other users.
   * 
   * @return the name displayed to other users.
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Used to set a new/changed name of the account that is displayed to other users.
   * 
   * @param displayName the new name on the account that will be displayed to other users.
   * @return A boolean expression (sanity check) representing that the display name was successfully
   *         set.
   */
  public boolean setDisplayName(String displayName) {
    if (displayName != null) {
      this.displayName = displayName;
      return true;
    }

    return false;
  }
}
