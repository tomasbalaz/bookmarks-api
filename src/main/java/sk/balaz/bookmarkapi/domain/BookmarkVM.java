package sk.balaz.bookmarkapi.domain;

import java.time.Instant;

//Bookmark View Model

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#projections
public interface BookmarkVM {

    Long getId();
    String getTitle();
    String getUrl();
    Instant getCreatedAt();
}
