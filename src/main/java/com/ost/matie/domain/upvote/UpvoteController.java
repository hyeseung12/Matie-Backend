package com.ost.matie.domain.upvote;

import com.ost.matie.domain.upvote.dto.AddUpvoteRequest;
import com.ost.matie.domain.upvote.dto.UpvoteResponse;
import com.ost.matie.domain.upvote.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/upvote")
public class UpvoteController {
    private final PostUpvoteService postUpvoteService;
    private final CountAllByCommentIdService countAllByCommentIdService;
    private final FindAllByUserIdService findAllByUserIdService;
    private final FindByUserIdAndCommentIdService findByUserIdAndCommentIdService;
    private final DeleteUpvoteService deleteUpvoteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUpvote(@Valid @RequestBody AddUpvoteRequest request) {
        postUpvoteService.execute(request);
    }

    @GetMapping("/count/{commentId}")
    public Long countAllByCommentId(@PathVariable Long commentId) {
        return countAllByCommentIdService.execute(commentId);
    }

    @GetMapping("/{userId}")
    public List<UpvoteResponse> findAllByUserId(@PathVariable Long userId) {
        return findAllByUserIdService.execute(userId);
    }

    @GetMapping("/{userId}/{commentId}")
    public UpvoteResponse findAllByUserIdAndCommentId(@PathVariable Long userId, @PathVariable Long commentId) {
        return findByUserIdAndCommentIdService.execute(userId, commentId);
    }

    @DeleteMapping("/{userId}/{commentId}")
    public void deleteUpvote(@PathVariable Long userId, @PathVariable Long commentId) {
        deleteUpvoteService.execute(userId, commentId);
    }
}
