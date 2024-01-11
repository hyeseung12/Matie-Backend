package com.ost.matie.domain.community;

import com.ost.matie.domain.BaseTimeEntity;
import com.ost.matie.domain.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Community extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "agree")
    private Long agree;

    @Column(name = "disagree")
    private Long disagree;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Builder
    public Community(String title, String description, String type, Long agree, Long disagree) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.agree = agree;
        this.disagree = disagree;
    }

    public void update(String title, String description, Long agree, Long disagree) {
        this.title = title;
        this.description = description;
        this.agree = agree;
        this.disagree = disagree;
    }
}
