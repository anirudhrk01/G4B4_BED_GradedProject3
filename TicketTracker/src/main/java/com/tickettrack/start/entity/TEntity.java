package com.tickettrack.start.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_details")

public class TEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ticket_title")

	private String tickettitle;
	private String ticketdisc;

	public TEntity(Long id, String tickettitle, String ticketdisc) {
		super();
		this.id = id;
		this.tickettitle = tickettitle;
		this.ticketdisc = ticketdisc;
	}

	public TEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTickettitle() {
		return tickettitle;
	}

	public void setTickettitle(String tickettitle) {
		this.tickettitle = tickettitle;
	}

	public String getTicketdisc() {
		return ticketdisc;
	}

	public void setTicketdisc(String ticketdisc) {
		this.ticketdisc = ticketdisc;
	}

	@Override
	public String toString() {
		return "TEntity [id=" + id + ", tickettitle=" + tickettitle + ", ticketdisc=" + ticketdisc + "]";
	}

}
