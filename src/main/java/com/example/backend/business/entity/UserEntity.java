package com.example.backend.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

import static javax.persistence.CascadeType.ALL;

@NoArgsConstructor
@Entity
@Table(name = "user")
@EqualsAndHashCode()
public class UserEntity implements UserDetails {

    public UserEntity(UUID id, @NotBlank String username, @Email @NotBlank String email, @NotNull Integer balanceOfCookies, @Size(min = 6) @NotEmpty String password, boolean accountConfirmed, boolean accountExpired, boolean accountLocked, boolean credentialsExpired, boolean enabled, Set<AuthorityEntity> userAuthorities, List<WordSetEntity> wordSets, List<WordEntity> words, List<CourseEntity> courses) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.balanceOfCookies = balanceOfCookies;
        this.password = password;
        this.accountConfirmed = accountConfirmed;
        this.accountExpired = accountExpired;
        this.accountLocked = accountLocked;
        this.credentialsExpired = credentialsExpired;
        this.enabled = enabled;
        this.userAuthorities = userAuthorities;
        this.wordSets = wordSets;
    }

    @Id
    @GeneratedValue(generator = "UserUUIDGenerator")
    @GenericGenerator(name = "UserUUIDGenerator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotBlank
    @Column(name = "username")
    private String username;

    @Email
    @NotBlank
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "balance_of_cookies")
    private Integer balanceOfCookies;

    @Size(min = 6)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty
    @Column(name = "password")
    private String password;

    @Column(name = "account_confirmed")
    private boolean accountConfirmed;

    @Column(name = "account_expired")
    private boolean accountExpired;

    @Column(name = "account_locked")
    private boolean accountLocked;

    @Column(name = "credentials_expired")
    private boolean credentialsExpired;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user2authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id",
                    referencedColumnName = "id"))
    @OrderBy
    private Set<AuthorityEntity> userAuthorities;

    @ManyToMany
    @JoinTable(name = "user2word_set",
            joinColumns = @JoinColumn(name = "word_set_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<WordSetEntity> wordSets;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userAuthorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return !isAccountExpired();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return !isCredentialsExpired();
    }

    public void addAuthority(AuthorityEntity authority) {
        if (userAuthorities == null) {
            userAuthorities = new HashSet<>();
        }
        userAuthorities.add(authority);
    }

    public void deleteAuthority(AuthorityEntity authority) {
        userAuthorities.remove(authority);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public List<WordSetEntity> getWordSets() {
        return wordSets;
    }

    public void setWordSets(List<WordSetEntity> wordSets) {
        this.wordSets = wordSets;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccountConfirmed() {
        return accountConfirmed;
    }

    public void setAccountConfirmed(boolean accountConfirmed) {
        this.accountConfirmed = accountConfirmed;
    }

    public boolean isAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<AuthorityEntity> getUserAuthorities() {
        return userAuthorities;
    }

    public void setUserAuthorities(Set<AuthorityEntity> userAuthorities) {
        this.userAuthorities = userAuthorities;
    }
}
