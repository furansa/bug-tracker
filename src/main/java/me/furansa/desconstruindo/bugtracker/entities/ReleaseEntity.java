package me.furansa.desconstruindo.bugtracker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "releases")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // TODO: Check what's this
public class ReleaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // JPA will use sequence from PgSQL
    private Long id;

    @Column(name = "date", nullable = false, length = 10)
    private String date;

    @Column(nullable = false, length = 2000)
    private String description;

    public ReleaseEntity() {}

    public ReleaseEntity(final String date, final String description) {
        this.date = date;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}