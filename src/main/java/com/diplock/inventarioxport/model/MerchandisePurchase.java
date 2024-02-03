package com.diplock.inventarioxport.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "merchandise_purchases")
public class MerchandisePurchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_id")
	private Long purchaseId;

	@Column(name = "purchase_date", nullable = false)
	private Date purchaseDate;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(name = "price_paid", precision = 10, scale = 2, nullable = false)
	private BigDecimal pricePaid;

}
