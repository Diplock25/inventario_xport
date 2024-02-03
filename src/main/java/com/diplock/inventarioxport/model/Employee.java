package com.diplock.inventarioxport.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;

	@Column(name = "first_name", nullable = false, length = 25)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 25)
	private String lastName;

	@Column(name = "role", nullable = false, length = 25)
	private String role;

}
