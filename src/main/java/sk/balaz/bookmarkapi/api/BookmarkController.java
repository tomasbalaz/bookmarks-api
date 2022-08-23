package sk.balaz.bookmarkapi.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.balaz.bookmarkapi.domain.BookmarkDTO;
import sk.balaz.bookmarkapi.domain.BookmarksDTO;
import sk.balaz.bookmarkapi.domain.BookmarkService;
import sk.balaz.bookmarkapi.domain.CreateBookmarkRequest;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/bookmark")
@RequiredArgsConstructor
public class BookmarkController {

    // GET  /api/bookmarks                 <- get all
    // GET  /api/bookmarks/{id}            <- get by id
    // GET  /api/bookmarks?query=k&page=2  <- search
    // POST /api/bookmarks                 <- create
    // PUT /api/bookmarks/{id}             <-  replace by id
    // PATCH /api/bookmarks/{id}           <- partial update by id
    // DELETE /api/bookmarks/{id}          <- delete by id

    private final BookmarkService bookmarkService;

    @GetMapping
    public BookmarksDTO getBookmarks(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "query", required = false, defaultValue = "") String query
            ) {

        if(query == null || query.trim().length() == 0) {
            return bookmarkService.getBookmarks(page);
        }
        return bookmarkService.searchBookmarks(page, query);
    }

    // POST /api/v1/bookmark
    // Request Payload :
    //  {
    //  "title" :  "Sivalabs Blog",
    //  "url" :  "https://sivalabs.in"
    //  }
    // Response status code 201
    // Response payload :
    //  {
    //  "id" : "1",
    //  "title" : "Sivalabs Blog",
    //  "url" : "https://sivalabs.in"
    //  }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDTO createBookmark(@RequestBody @Valid CreateBookmarkRequest request) {
        return bookmarkService.createBookmark(request);
    }
}
