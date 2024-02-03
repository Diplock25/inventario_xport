package com.diplock.inventarioxport.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sale_id")
	private Long saleId;

	@Column(name = "sale_date", nullable = false)
	private Date saleDate;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(name = "sale_price", precision = 10, scale = 2, nullable = false)
	private BigDecimal salePrice;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

}
