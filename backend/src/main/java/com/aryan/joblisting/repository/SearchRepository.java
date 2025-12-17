package com.aryan.joblisting.repository;

import java.util.List;

import com.aryan.joblisting.model.Post;

public interface SearchRepository {
	
	List<Post> findByText(String text);
	
}
