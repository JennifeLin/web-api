package com.alg.boot.webapi.booking.reservations

import com.alg.boot.webapi.booking.restaurants.Restaurant
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "reservation")
class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null

    @Column(name = "LOCATOR")
    var locator: String? = null

    @Column(name = "TURN")
    var turn: String? = null

    @Column(name = "PERSON")
    var person: Long? = null

    @Column(name = "DATE")
    var date: Date? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    var restaurant: Restaurant? = null

    constructor() {}
    constructor(
        id: Long?,
        locator: String?,
        turn: String?,
        person: Long?,
        date: Date?,
        restaurant: Restaurant?
    ) : super() {
        this.id = id
        this.locator = locator
        this.turn = turn
        this.person = person
        this.date = date
        this.restaurant = restaurant
    }
}