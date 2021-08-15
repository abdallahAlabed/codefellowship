package com.example.codefellowship.model;

import java.util.Date;
import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
public abstract class EntityModel {


    protected Integer id;
    private boolean disabled;
    protected Date createTime;
    protected Date lastModifiedTime;

    @Column(name = "disabled", nullable = false)
    public boolean isDisabled() {
        return disabled;
    }
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", nullable = false)
    @CreatedDate
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_time", nullable = false)
    @LastModifiedDate
    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    @PrePersist
    protected void prePersist() {
        if (this.createTime == null) createTime = new Date();
        if (this.lastModifiedTime == null) lastModifiedTime = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        this.lastModifiedTime = new Date();
    }

    @PreRemove
    protected void preRemove() {
        this.lastModifiedTime = new Date();
    }

}
