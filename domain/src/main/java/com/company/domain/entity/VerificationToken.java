package com.company.domain.entity;

import com.company.domain.entity.user.User;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity(name = "verificationtoken")
public class VerificationToken
        extends AbstractPersistable<Long>{

    private static final long serialVersionUID = -5010077390892174629L;

    private static final int EXPIRATION = 60 * 24; // TODO: move it to entity objects.

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "token")
    private String token;

    @Column(name = "expireDate")
    private Date expireDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User user;

    public VerificationToken(){
        super();
    }

    public VerificationToken(final String token){
        super();

        this.token = token;
        this.expireDate = calculateExpireDate(EXPIRATION);
    }

    public void updateToken(final String newToken){
        this.token = newToken;
        this.expireDate = calculateExpireDate(EXPIRATION);
    }

    private Date calculateExpireDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public VerificationToken(final String token, final User user){
        super();

        this.token = token;
        this.user = user;
        this.expireDate = calculateExpireDate(EXPIRATION);
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}