package com.hcl.ecommerseapplication.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@Temporal(TemporalType.DATE)
	private Date orderingDate;
@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> products;
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public Date getOrderingdate() {
	return orderingDate;
}
public void setOrderingdate(Date orderingdate) {
	this.orderingDate = orderingdate;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public List<Product> getProducts() {
	return products;
}
public void setProducts(List<Product> products) {
	this.products = products;
}
public Orders(Date orderingdate, User user, List<Product> products) {
	super();
	this.orderingDate = orderingdate;
	this.user = user;
	this.products = products;
}
public Orders() {
	super();
}



}
