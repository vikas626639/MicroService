package com.nit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StockRepository extends JpaRepository<Stock_Details, Serializable> {
	public Stock_Details findByCompanyname(String name);
}
