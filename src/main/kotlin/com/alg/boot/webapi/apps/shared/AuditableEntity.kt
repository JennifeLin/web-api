package com.alg.boot.webapi.apps.shared

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class AuditableEntity<U> {
    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    @CreatedBy
    var createdBy: U? = null

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @CreatedDate
    var createdAt: LocalDateTime? = null

    @Column(name = "UPDATED_BY", nullable = true)
    @LastModifiedBy
    var updatedBy: U? = null

    @Column(name = "UPDATED_AT", nullable = true)
    @LastModifiedDate
    var updatedAt: LocalDateTime? = null
}
