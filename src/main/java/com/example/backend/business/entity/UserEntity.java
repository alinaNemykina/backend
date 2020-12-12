package com.example.backend.business.entity;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    private Long id;
    private String username;
    private Integer balanceOfCookies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBalanceOfCookies() {
        return balanceOfCookies;
    }

    public void setBalanceOfCookies(Integer balanceOfCookies) {
        this.balanceOfCookies = balanceOfCookies;
    }

    public UserEntity(Long id, String username, Integer balanceOfCookies) {
        this.id = id;
        this.username = username;
        this.balanceOfCookies = balanceOfCookies;
    }
}
