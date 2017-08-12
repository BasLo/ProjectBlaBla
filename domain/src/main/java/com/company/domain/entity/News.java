package com.company.domain.entity;

import com.company.domain.entity.parent.AbstractVersionPersistable;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name = "news")
public class News
        extends AbstractVersionPersistable<Long> {

    private static final long serialVersionUID = -7397483409793611918L;

    @Column(name = "date")
    private Date date;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    public News() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = stringToGoodDateView(date);
    }

    private Date stringToGoodDateView(String s) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
        try {
            d = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    public void setDateTime(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}