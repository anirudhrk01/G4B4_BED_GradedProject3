package com.tickettrack.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tickettrack.entity.TEntity;
import com.tickettrack.repository.TRepository;

@Service
public class TService {

	@Autowired
	private TRepository repo;
	
	public void addTicket(TEntity t)
	{
		repo.save(t);
	}
	public List<TEntity> getAllTicket()
	{
		return repo.findAll();
	}
	public TEntity getTicketById(Long id)
	{
		Optional<TEntity>  t=repo.findById(id);
		if(t.isPresent()) 
		{
			return t.get();
		}
		return null;
	}
	public void deleteTicket(Long id)
	{
		repo.deleteById(id);
		
	}

}
