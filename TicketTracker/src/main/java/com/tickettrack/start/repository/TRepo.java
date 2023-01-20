package com.tickettrack.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tickettrack.start.entity.TEntity;


public interface TRepo extends JpaRepository<TEntity, Long> {

}
