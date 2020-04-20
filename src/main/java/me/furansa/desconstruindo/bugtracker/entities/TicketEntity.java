package me.furansa.desconstruindo.bugtracker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "tickets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // TODO: Check what's this
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // JPA will use sequence from PgSQL
    private Long id;
    
    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 2000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "application")
    private ApplicationEntity application;

    @ManyToOne
    @JoinTable(
        name = "tickets_releases",
        joinColumns = @JoinColumn(name = "ticket_id"),
        inverseJoinColumns = @JoinColumn(name = "release_id")
    )
    private ReleaseEntity release;

    @Column(nullable = false, length = 200)
    private String status;

    public TicketEntity() {}

    public TicketEntity(final String title, final String description,
        final ApplicationEntity applicationEntity,
        final ReleaseEntity releaseEntity, final String status) {

        this.title = title;
        this.description = description;
        this.application = applicationEntity;
        this.release = releaseEntity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public ApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(final ApplicationEntity applicationEntity) {
        this.application = applicationEntity;
    }

    public ReleaseEntity getRelease() {
        return release;
    }

    public void setRelease(final ReleaseEntity releaseEntity) {
        this.release = releaseEntity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
}