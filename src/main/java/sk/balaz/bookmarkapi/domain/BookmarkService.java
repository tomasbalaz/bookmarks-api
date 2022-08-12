package sk.balaz.bookmarkapi.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    public BookmarksDTO getBookmarks(Integer page) {
        int pageNumber = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.Direction.DESC, "createdAt");

        Page<BookmarkDTO> bookmarkPage = bookmarkRepository.findBookmarks(pageable);

        return new BookmarksDTO(bookmarkPage);
    }

    public BookmarksDTO searchBookmarks(Integer page, String query) {
        int pageNumber = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.Direction.DESC, "createdAt");

        Page<BookmarkDTO> bookmarkPage = bookmarkRepository.searchBookmarks(query, pageable);
        Page<BookmarkVM> bookmarkVMPage = bookmarkRepository.findBookmarkByTitleContainingIgnoreCase(query, pageable);

        return new BookmarksDTO(bookmarkPage);
    }
}
