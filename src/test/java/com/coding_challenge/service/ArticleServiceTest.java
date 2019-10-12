package com.coding_challenge.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.coding_challenge.model.Article;
import com.coding_challenge.repository.ArticleRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
public class ArticleServiceTest {

	@MockBean
	ArticleRepository mockArticleRepository;

	@InjectMocks
	ArticleService articleService;

	private Article article;

	private static final String mockTitle = "Test Title";

	@BeforeEach
	public void setup() {
		article = new Article();
		article.setId(1);
		article.setTitle(mockTitle);
	}

	@Test
	public void testIfArticleGetsCreated() {

		when(mockArticleRepository.existsById(any())).thenReturn(false);
		when(mockArticleRepository.save(any())).thenReturn(article);

		Article returnedArticle = articleService.createArticle(article);

		assertEquals(1, returnedArticle.getId());
		assertEquals(mockTitle, returnedArticle.getTitle());
	}

	@Test
	public void testIfArticleToBeCreatedAndIdAlreadyExists() {

		when(mockArticleRepository.existsById(any())).thenReturn(true);

		Assertions.assertThrows(IllegalArgumentException.class, () -> articleService.createArticle(article));
	}

	@Test
	public void testIfArticleGetsUpdated() {

		Article inputArticle = new Article();
		inputArticle.setId(1);
		inputArticle.setTitle(mockTitle);

		when(mockArticleRepository.save(any())).thenReturn(article);
		when(articleService.exists(any())).thenReturn(true);
		Article returnedArticle = articleService.updateArticle(inputArticle);

		assertEquals(inputArticle.getId(), returnedArticle.getId());
		assertEquals(inputArticle.getTitle(), returnedArticle.getTitle());
	}
	
	@Test
	public void testThrowsExceptionWhenIdDoesNotExistWhenUpdate() {

		Article inputArticle = new Article();
		inputArticle.setId(1);
		inputArticle.setTitle(mockTitle);

		when(mockArticleRepository.save(any())).thenReturn(article);
		when(articleService.exists(any())).thenReturn(false);
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> articleService.updateArticle(article));
	}
}
