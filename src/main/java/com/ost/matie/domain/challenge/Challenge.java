package com.ost.matie.domain.challenge;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ost.matie.global.common.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Challenge extends BaseEntity {
    private String title;

    private String description;

    private Long point;

    private Integer type;

    @JsonIgnore
    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChallengeConfirm> challengeConfirmList;
}
