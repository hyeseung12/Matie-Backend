package com.ost.matie.controller.clear;

import com.ost.matie.domain.clear.Clear;
import com.ost.matie.domain.comment.Comment;
import com.ost.matie.domain.walk.Walk;
import com.ost.matie.dto.clear.AddClearRequest;
import com.ost.matie.dto.clear.ClearResponse;
import com.ost.matie.dto.clear.UpdateClearRequest;
import com.ost.matie.dto.comment.AddCommentRequest;
import com.ost.matie.dto.comment.CommentResponse;
import com.ost.matie.dto.walk.UpdateWalkRequest;
import com.ost.matie.service.clear.ClearService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ClearController {
    private final ClearService clearService;

    @PostMapping("/clear")
    public ResponseEntity<Clear> addClear(@Valid @RequestBody AddClearRequest request) {
        Clear clear = clearService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clear);
    }

    @GetMapping("/clear/{userId}")
    public ResponseEntity<List<ClearResponse>> findAllByUserId(@PathVariable Long userId) {
        List<ClearResponse> commentResponses = clearService.findAllByUserId(userId)
                .stream()
                .map(ClearResponse::new)
                .toList();

        return ResponseEntity.ok().body(commentResponses);
    }

    @PutMapping("/clear/{userId}/{date}")
    public ResponseEntity<Clear> updateClear(@PathVariable Long userId,
                                           @PathVariable LocalDate date,
                                           @RequestBody UpdateClearRequest request) {
        Clear clear = clearService.update(userId, date, request);
        return ResponseEntity.ok().body(clear);
    }
}