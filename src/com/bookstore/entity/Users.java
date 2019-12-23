
package com.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Vaibhav
 *
 */
@Entity
@NamedQueries({ 
@NamedQuery (name="Users.findAll", query = "SELECT u FROM Users u ORDER BY u.fullName"),
@NamedQuery (name="Users.countAll", query = "SELECT Count(*) FROM Users u"),
@NamedQuery (name="Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
@NamedQuery (name="Users.checkLogin", query = "SELECT u FROM Users u WHERE u.email = :email AND password = :password")
})
@Table(name = "users", catalog = "bookstoredb")
public class Users {
	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	@Column(name="email")
	private String email;
	@Column(name="full_name")
	private String fullName;
	@Column(name="password")
	private String password;
	

	public Users(int userId, String email, String fullName, String password) {
		System.err.println("email=====> " + email + " fullName " + fullName + "password " + password);
		this.userId=userId;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}

	public Users(String email, String fullName, String password) {
		System.err.println("email==> " + email + " fullName " + fullName + "password " + password);
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 * the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 * the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 * the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 * the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
