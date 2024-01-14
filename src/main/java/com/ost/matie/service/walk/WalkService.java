package com.ost.matie.service.walk;

import com.ost.matie.domain.walk.Walk;
import com.ost.matie.dto.walk.AddWalkRequest;
import com.ost.matie.repository.WalkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WalkService {
    private final WalkRepository walkRepository;

    public Walk save(AddWalkRequest request) {
        return walkRepository.save(request.toEntity());
    }

}
