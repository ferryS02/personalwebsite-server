package com.ucong.audit;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {
    @CreatedBy
    protected U created_by;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date created_at;

    @LastModifiedBy
    protected U updated_by;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updated_at;

    public U getCreated_by() {
        return created_by;
    }

    public void setCreated_by(U created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public U getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(U updated_by) {
        this.updated_by = updated_by;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
