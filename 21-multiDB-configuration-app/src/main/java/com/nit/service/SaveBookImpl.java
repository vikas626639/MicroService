package com.nit.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.book.entity.BookEntity;
import com.nit.book.repo.BookRepo;
@Service
public class SaveBookImpl implements SaveBookObject {
	@Autowired
	private BookRepo repo;

	@Override
	public Serializable saveBookRecord() {
		//create the object of entity class
		List<BookEntity> saveAll=null;
		try {
			saveAll = repo.saveAll(Stream.of(new BookEntity(101, "corejava", "h.k", 400l),new BookEntity(102, "advance java", "n.t", 500l)).collect(Collectors.toList()));
			} catch (Exception e) {
			e.printStackTrace();
		}
		return (Serializable) saveAll;
	}

}
