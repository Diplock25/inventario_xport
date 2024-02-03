package com.diplock.inventarioxport.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private Long clientId;

	@Column(name = "first_name", nullable = false, length = 25)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 25)
	private String lastName;

	@Column(name = "address", nullable = false, columnDefinition = "TEXT")
	private String address;

	@ManyToOne
	@JoinColumn(name = "last_purchase_id")
	private PurchaseHistory lastPurchase;

}
