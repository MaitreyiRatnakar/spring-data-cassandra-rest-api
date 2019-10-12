package com.coding_challenge.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding_challenge.model.Article;
import com.coding_challenge.service.ArticleService;

import io.swagger.annotations.Api;

@Api
@RestController
@Validated
public class ArticleController {

	@Autowired
	public ArticleService articleService;

	@GetMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Article>> getArticles(@Positive @RequestParam(required = false) Integer limit) {
		if (limit != null)
			return new ResponseEntity<List<Article>>(articleService.findLimitedArticles(limit), HttpStatus.OK);
		return new ResponseEntity<List<Article>>(articleService.findAllArticles(), HttpStatus.OK);
	}

	@PostMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Article> createArticle(@RequestBody @Valid Article article) {

		return new ResponseEntity<Article>(articleService.createArticle(article), HttpStatus.CREATED);
	}

	@PutMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Article> updateArticle(@RequestBody @Valid Article article) {

		return new ResponseEntity<Article>(articleService.updateArticle(article), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/articles/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> deleteArticle(@PathVariable Integer id) {
		if (articleService.deleteArticleByID(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
}
