package com.nit.book.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.book.entity.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity, Serializable>{

}
