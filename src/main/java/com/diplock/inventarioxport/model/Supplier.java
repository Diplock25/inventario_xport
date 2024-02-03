package com.diplock.inventarioxport.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id")
	private Long supplierId;

	@Column(name = "company_name", nullable = false, length = 75)
	private String companyName;

	@Column(name = "address", nullable = false, columnDefinition = "TEXT")
	private String address;

	@Column(name = "contact_numbers", nullable = false, length = 255)
	private String contactNumbers;

	@Column(name = "contact_person", nullable = false, length = 255)
	private String contactPerson;

}
