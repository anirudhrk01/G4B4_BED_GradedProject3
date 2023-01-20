package com.tickettrack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class TEntity {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ticket_title")
	private String tickettitle;
	
	@Column(name = "ticket_desc")
	private String ticketdesc;
	
	@Column(name="ticket_createdOn")
	private String ticketdate;
	
	public String getTicketdate() {
		return ticketdate;
	}
	public void setTicketdate(String ticketdate) {
		this.ticketdate = ticketdate;
	}
	public TEntity(String ticketdate) {
		super();
		this.ticketdate = ticketdate;
	}
	public TEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TEntity(String tickettitle, String ticketdesc) {
		super();
		this.tickettitle = tickettitle;
		this.ticketdesc = ticketdesc;
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
	public String getTicketdesc() {
		return ticketdesc;
	}
	public void setTicketdesc(String ticketdesc) {
		this.ticketdesc = ticketdesc;
	}
	@Override
	public String toString() {
		return "TEntity [id=" + id + ", tickettitle=" + tickettitle + ", ticketdesc=" + ticketdesc + ", ticketdate="
				+ ticketdate + "]";
	}
	
	

}
