package com.alg.boot.webapi.booking.reservations

import com.alg.boot.webapi.booking.restaurants.Restaurant
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "reservation")
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
    var restaurant: Restaurant? = null
)
