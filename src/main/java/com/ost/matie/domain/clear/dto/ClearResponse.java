package com.ost.matie.domain.clear.dto;

import com.ost.matie.domain.challenge.Challenge;
import com.ost.matie.domain.clear.Clear;
import com.ost.matie.domain.user.User;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ClearResponse {
    private final Long id;
    private final LocalDate date;
    private final Challenge challenge;
    private final User user;

    public ClearResponse(Clear clear) {
        this.id = clear.getId();
        this.date = clear.getDate();
        this.challenge = clear.getChallenge();
        this.user = clear.getUser();
    }
}
