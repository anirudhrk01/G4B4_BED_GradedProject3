package com.tickettrack.start.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickettrack.start.entity.TEntity;
import com.tickettrack.start.repository.TRepo;

@Service
public class TService{

@Autowired
private TRepo repo;

public void addTicket(TEntity t)
{
repo.save(t);

}

public List<TEntity> getAllTicket()
{
return repo.findAll();
}

public TEntity getTEntityById(long id)
{
	Optional <TEntity> t=repo.findById(id);
	if(t.isPresent())
	{
		return t.get();
	}return null;
}
	public void deleteTEntity (long id)  
	{
		repo.deleteById(id);
	}
	
}

