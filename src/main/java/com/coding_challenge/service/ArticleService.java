package com.coding_challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding_challenge.model.Article;
import com.coding_challenge.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository repository;

	public Article createArticle(final Article article) {
		if (exists(article.getId())) {
			throw new IllegalArgumentException(String.format("Entered id - %s already exists.", article.getId()));
		}
		return repository.save(article);
	}

	public Article updateArticle(final Article article) {
		return repository.save(article);
	}

	public List<Article> findAllArticles() {
		List<Article> list = new ArrayList<>();
		repository.findAll().forEach(e -> list.add(e));
		return list;
	}

	public boolean exists(final Integer id) {
		return repository.existsById(id);
	}

	public List<Article> findLimitedArticles(int limit) {
		return repository.findLimitedArticles(limit);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public Boolean deleteArticleByID(int id) {
		if (exists(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
