package com.alg.boot.webapi.apps.booking.reservations

import com.alg.boot.webapi.apps.booking.restaurants.Restaurant
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "RESERVATIONS")
class Reservation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "LOCATOR")
    var locator: String? = null,

    @Column(name = "TURN")
    var turn: String? = null,

    @Column(name = "PERSON")
    var person: Long? = null,

    @Column(name = "DATE")
    var date: Date? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    var restaurant: Restaurant? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
