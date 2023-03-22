package com.ars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Columns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames={
				"email"})})
public class Passenger extends User {
	@Column(length = 50)
	private String name;
	@Column(length = 10)
	private String phno;
	@Column(length = 100)
	//@Column(unique = true,nullable = false)
	private String email;
}
