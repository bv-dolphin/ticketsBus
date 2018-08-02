package com.osprey.studio.domain;

import com.osprey.studio.domain.BaseEntity;

public class User extends BaseEntity {

	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private boolean active;
	private int roles;

}