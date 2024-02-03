package com.diplock.inventarioxport.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "purchase_history")
public class PurchaseHistory {

	@Id
	@Column(name = "history_id")
	private Long historyId;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	@Column(name = "purchase_date", nullable = false)
	private Date purchaseDate;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Column(name = "price_paid", precision = 10, scale = 2, nullable = false)
	private BigDecimal pricePaid;

}
