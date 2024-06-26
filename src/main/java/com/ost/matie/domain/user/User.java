package com.ost.matie.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ost.matie.domain.challenge.ChallengeConfirm;
import com.ost.matie.global.common.BaseEntity;
import com.ost.matie.domain.cart.Cart;
import com.ost.matie.domain.clear.Clear;
import com.ost.matie.domain.comment.Comment;
import com.ost.matie.domain.upvote.Upvote;
import com.ost.matie.domain.community.Community;
import com.ost.matie.domain.favorite_product.FavoriteProduct;
import com.ost.matie.domain.point.Point;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User extends BaseEntity {
    private String name;

    @Column(name = "user_id", unique = true)
    private String userId;

    @Column(name = "email", unique = true)
    private String email;

    @JsonIgnore
    private String pw;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Point> pointList;

    @JsonIgnore
    @OneToMany(mappedBy = "creatorUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Community> communityList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Upvote> upvoteList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> cartList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FavoriteProduct> favoriteProductList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Clear> clearList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChallengeConfirm> challengeConfirmList;

    @Builder
    public User(String name, String userId, String email, String pw) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.pw = pw;
    }

    public void update(String pw) {
        this.pw = pw;
    }
}
