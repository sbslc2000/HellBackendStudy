package org.cau.hellspringboot.study.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class Assignment1 {

    static class Article {
        Long id;
        String title;
        String content;
        LocalDateTime createdAt;

        @Override
        public String toString() {
            return "Article{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", createdAt=" + createdAt +
                    '}';
        }

        public Long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }



        public Article(Long id, String title, String content, LocalDateTime createdAt) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.createdAt = createdAt;
        }
    }

    static class ArticleRepository {
        private Map<Long, Article> repository;

        public ArticleRepository() {
            repository = new HashMap<>();
            repository.put(1L, new Article(1L,"첫번째 글입니다.","안녕하세요",LocalDateTime.of(2023,3,8,10,0)));
            repository.put(2L, new Article(2L,"리액트 재밌어요","리액트 꼭 배워보세요",LocalDateTime.of(2023,3,8,20,0)));
            repository.put(3L, new Article(3L,"스프링부트 재밌어요","스프링부트 꼭 배워보세요",LocalDateTime.of(2023,3,9,20,0)));
            repository.put(4L, new Article(4L,"Java가 뭔가요","그거 어떻게 하는 건가요",LocalDateTime.of(2023,3,9,10,0)));
            repository.put(5L, new Article(5L,"5번째 글입니다.","떨어진 한 방울 drip",LocalDateTime.of(2023,3,7,10,0)));
            repository.put(6L, new Article(6L,"6번째 글입니다.","투명한 내 안에 섞여 들지",LocalDateTime.of(2023,3,7,10,0)));
            repository.put(7L, new Article(7L,"7번째 글입니다.","아무렇지 않은 듯 keep on moving",LocalDateTime.of(2023,3,7,10,0)));
            repository.put(8L, new Article(8L,"8번째 글입니다.","Impurities show you my impurities",LocalDateTime.of(2023,3,7,10,0)));
            repository.put(9L, new Article(9L,"9번째 글입니다.","F-F-F Fake wings",LocalDateTime.of(2023,3,7,10,0)));
        }

        public Optional<Article> findById(Long id) {
            //implement here
            return null;
        }

        public List<Article> findAll() {
            //implement here
            //DO NOT USE FOR STATEMENT
            return null;
        }

        public List<Article> findWhereTitleEndWithOrderByContentDesc(String suffix) {
            //implement here
            //DO NOT USE FOR STATEMENT
            return null;
        }
    }

    @Test
    void assignment1() {
        ArticleRepository articleRepository = new ArticleRepository();


        /*
            findById Test
         */
        Optional<Article> test1 = articleRepository.findById(5L);
        Optional<Article> test2 = articleRepository.findById(10L);

        assertThat(test1.get().id).isEqualTo(5L);
        assertThatThrownBy(() -> {test2.get();}).isInstanceOf(NoSuchElementException.class);

        /*
            findAll Test
         */
        List<Article> test3 = articleRepository.findAll();

        assertThat(test3.size()).isEqualTo(9);
        articleRepository.repository.values().stream().forEach(assertThat(test3)::contains);

        /*
            findWhereTitleEndWithOrderByContentDesc test
         */
        List<Article> test4 = articleRepository.findWhereTitleEndWithOrderByContentDesc("글입니다.");

        assertThat(test4.size()).isEqualTo(6);
        assertThat(test4.get(0).id).isEqualTo(6);
        assertThat(test4.get(5).id).isEqualTo(9);
    }
}
