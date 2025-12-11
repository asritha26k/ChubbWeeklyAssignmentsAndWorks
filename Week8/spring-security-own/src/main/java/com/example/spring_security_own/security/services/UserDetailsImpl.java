package com.example.spring_security_own.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.spring_security_own.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

//we use UserDetailsImpl to build a UserDetails object from our User entity
//UserDetails object is used by Spring Security for authentication and authorization
//UserDetails interface provides core user information
//why only userdetails obj is used and not user entity? because user entity may contain sensitive info or info not relevant to security
//spring recognizes UserDetails interface and uses it internally for security operations

//UserDetailsImpl (your custom UserDetails object) is stored inside the SecurityContext
//after a user successfully authenticates.
public class UserDetailsImpl implements UserDetails {
	// serivalVersionUID is used for version control in a Serializable class.
	// version control is used during deserialization to verify that the sender and
	// receiver of a serialized object maintain serialization compatibility with
	// respect to the class.
	//
	// serialization means converting an object into a byte stream, and
	// deserialization is the reverse process
	//
	// serialization compatability means that the class definition used to serialize
	// an object is compatible with the class definition used to deserialize it
	//
	// if the class definition changes (e.g., new fields are added or removed), then
	// it effects serialization compatibility and we get InvalidClassException.
	// for safety we use serialVersionUID to ensure that a deserialized object
	// matches the version of the class used during serialization
	// suppose class is
//	class Student implements Serializable {
//	    String name;
//	    int age;
//	}If you serialize (save object to file) using today's code:
//
//Student s = new Student("Ram", 20);
//saveToFile(s);  // (serialization)
//
//
//Tomorrow you change the class:
//
//class Student implements Serializable {
//    String name;
//    int age;
//    String college;  // NEW FIELD
//}
//
//
//Now you try to load old object from file:
//
//Student s = loadFromFile();
//
//❌ Without serialVersionUID
//
//Java sees class structure changed → mismatch → throws error:
//
//InvalidClassException:
//local class incompatible:
//stream classdesc serialVersionUID = 123,
//local class serialVersionUID = 456

	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	// granted authority is a permission or right
	// simple granted authority is an implementation of granted authority with a
	// string role
//	At authentication time, Spring Security stores user roles inside the SecurityContext as:
//
//		Collection<? extends GrantedAuthority>
//
//		NOT as:
//
//		List<String>
//
//		So your roles must implement GrantedAuthority.
//	SimpleGrantedAuthority is the built-in implementation of GrantedAuthority.
//
//	It’s just a wrapper over a role string.
//
//	Example:
//
//	new SimpleGrantedAuthority("ROLE_ADMIN")

	public UserDetailsImpl(Long id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				// convert each role to a simple granted authority
				// getName() returns an enum RoleName, so we call name() to get the string value
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

		return new UserDetailsImpl(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
