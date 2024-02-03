package com.diplock.inventarioxport.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exchanges")
public class Exchange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "return_id")
	private Long returnId;

	@Column(name = "return_date", nullable = false)
	private Date returnDate;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(name = "reason", nullable = false, columnDefinition = "TEXT")
	private String reason;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

}
