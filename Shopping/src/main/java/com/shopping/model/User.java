package com.shopping.model;

import javax.management.relation.Role;

import org.hibernate.metamodel.ValueClassification;

import com.shopping.enumpackage.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
	private String name;
	
	private String email;
	
	private long mobile;
	
	private String password;
	
	@Enumerated(value = EnumType.STRING)
	private UserRole role;

	
	
}
