package com.ost.matie.domain.challenge.service.challenge;

import com.ost.matie.domain.challenge.Challenge;
import com.ost.matie.domain.challenge.exception.ChallengeNotFoundException;
import com.ost.matie.domain.challenge.repository.ChallengeRepository;
import com.ost.matie.global.annotation.ReadOnlyService;
import lombok.RequiredArgsConstructor;

@ReadOnlyService
@RequiredArgsConstructor
public class FindChallengeService {
    private final ChallengeRepository challengeRepository;

    public Challenge execute(Long id) {
        return challengeRepository.findById(id).orElseThrow(() -> ChallengeNotFoundException.EXCEPTION);
    }
}
