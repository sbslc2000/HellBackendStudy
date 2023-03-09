package org.cau.hellspringboot.study.assignment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LombokTest {


    @ToString
    @Getter
    @AllArgsConstructor
    static class Article {
        Long id;
        String title;
        String content;
        LocalDateTime createdAt;
    }

    static class ArticleRepository {
        private Map<Long, Assignment1.Article> repository;

        public ArticleRepository() {
            repository = new HashMap<>();
            repository.put(1L, new Assignment1.Article(1L,"첫번째 글입니다.","안녕하세요",LocalDateTime.of(2023,3,8,10,0)));
            repository.put(2L, new Assignment1.Article(2L,"리액트 재밌어요","리액트 꼭 배워보세요",LocalDateTime.of(2023,3,8,20,0)));
            repository.put(3L, new Assignment1.Article(3L,"스프링부트 재밌어요","스프링부트 꼭 배워보세요",LocalDateTime.of(2023,3,9,20,0)));
            repository.put(4L, new Assignment1.Article(4L,"Java가 뭔가요","그거 어떻게 하는 건가요",LocalDateTime.of(2023,3,9,10,0)));
            repository.put(5L, new Assignment1.Article(5L,"5번째 글입니다.","떨어진 한 방울 drip",LocalDateTime.of(2023,3,7,10,0)));
            repository.put(6L, new Assignment1.Article(6L,"6번째 글입니다.","투명한 내 안에 섞여 들지",LocalDateTime.of(2023,3,7,10,0)));
            repository.put(7L, new Assignment1.Article(7L,"7번째 글입니다.","아무렇지 않은 듯 keep on moving",LocalDateTime.of(2023,3,7,10,0)));
            repository.put(8L, new Assignment1.Article(8L,"8번째 글입니다.","Impurities show you my impurities",LocalDateTime.of(2023,3,7,10,0)));
            repository.put(9L, new Assignment1.Article(9L,"9번째 글입니다.","F-F-F Fake wings",LocalDateTime.of(2023,3,7,10,0)));
        }

        public Optional<Assignment1.Article> findById(Long id) {
            //implement here
            return null;
        }

        public List<Assignment1.Article> findAll() {
            //implement here
            //DO NOT USE FOR STATEMENT
            return null;
        }

        public List<Assignment1.Article> findWhereTitleEndWithOrderByContentDesc(String suffix) {
            //implement here
            //DO NOT USE FOR STATEMENT
            return null;
        }
    }


    @Test
    void lombokTest() {


    }
}
