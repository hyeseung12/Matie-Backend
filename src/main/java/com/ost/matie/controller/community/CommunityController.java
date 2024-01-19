package com.ost.matie.controller.community;

import com.ost.matie.domain.community.Community;
import com.ost.matie.dto.community.AddCommunityRequest;
import com.ost.matie.dto.community.CommunityResponse;
import com.ost.matie.dto.community.UpdateCommunityRequest;
import com.ost.matie.service.community.CommunityService;
import com.ost.matie.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommunityController {
    private final CommunityService communityService;
    private final UserService userService;

    @PostMapping("/community")
    public ResponseEntity<CommunityResponse> addCommunity(@Valid @RequestBody AddCommunityRequest request) {
        userService.findById(request.getCreatorUser().getId());
        Community community = communityService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CommunityResponse(community));
    }

    @GetMapping("/community/type/{typeName}")
    public ResponseEntity<List<CommunityResponse>> findByTypeOrderByDateDesc(@PathVariable String typeName) {
        List<CommunityResponse> communityResponses = communityService.findByTypeOrderByCreatedDateDesc(typeName)
                .stream()
                .map(CommunityResponse::new)
                .toList();

        return ResponseEntity.ok().body(communityResponses);
    }

    @GetMapping("/community/{id}")
    public ResponseEntity<CommunityResponse> findCommunity(@PathVariable Long id) {
        Community community = communityService.findById(id);

        return ResponseEntity.ok()
                .body(new CommunityResponse(community));
    }

    @PutMapping("/community/{id}")
    public ResponseEntity<CommunityResponse> updateCommunity(@PathVariable Long id,
                                           @Valid @RequestBody UpdateCommunityRequest request) {
        Community community = communityService.update(id, request);
        return ResponseEntity.ok().body(new CommunityResponse(community));
    }

    @DeleteMapping("/community/{id}")
    public ResponseEntity<Void> deleteCommunity(@PathVariable Long id) {
        communityService.delete(id);
        return ResponseEntity.ok().build();
    }
}
