package com.coding_challenge.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.coding_challenge.model.Article;

@Repository
public interface ArticleRepository extends CassandraRepository<Article, Integer> {
	@Query("SELECT * FROM Article LIMIT ?0")
	public List<Article> findLimitedArticles(int limit);

}
