package sk.balaz.bookmarkapi.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    // Hibernate: select bookmark0_.id as col_0_0_, bookmark0_.title as col_1_0_, bookmark0_.url as col_2_0_,
    // bookmark0_.created_at as col_3_0_ from bookmarks bookmark0_ order by bookmark0_.created_at desc limit
    @Query("select new sk.balaz.bookmarkapi.domain.BookmarkDTO(b.id, b.title, b.url, b.createdAt) from Bookmark b")
    Page<BookmarkDTO> findBookmarks(Pageable pageable);

    // Hibernate: select bookmark0_.id as col_0_0_, bookmark0_.title as col_1_0_, bookmark0_.url as col_2_0_, bookmark0_.created_at as col_3_0_ from
    // bookmarks bookmark0_ where lower(bookmark0_.title) like lower(('%'||?||'%')) order by bookmark0_.created_at desc limit
    @Query("""
    select new sk.balaz.bookmarkapi.domain.BookmarkDTO(b.id, b.title, b.url, b.createdAt) from Bookmark b
    where lower(b.title) like lower(concat('%', :query, '%'))
    """)
    Page<BookmarkDTO> searchBookmarks(String query, Pageable pageable);


    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords

    //Hibernate: select bookmark0_.id as col_0_0_, bookmark0_.title as col_1_0_, bookmark0_.url as col_2_0_, bookmark0_.created_at as col_3_0_
    // from bookmarks bookmark0_ where upper(bookmark0_.title) like upper(?) escape ? order by bookmark0_.created_at desc limit ?
    //Page<BookmarkDTO> findBookmarkByTitleContainingIgnoreCase(String query, Pageable pageable);

    Page<BookmarkVM> findBookmarkByTitleContainingIgnoreCase(String query, Pageable pageable);
}
