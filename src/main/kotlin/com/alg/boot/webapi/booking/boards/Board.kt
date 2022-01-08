package com.alg.boot.webapi.booking.boards

import com.alg.boot.webapi.booking.restaurants.Restaurant
import javax.persistence.*


@Entity
@Table(name = "board")
class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null

    @Column(name = "CAPACITY")
    var capacity: Long? = null

    @Column(name = "NUMBER")
    var number: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    var restaurant: Restaurant? = null

    protected constructor() : super() {}
    constructor(id: Long?, capacity: Long?, number: Long?, restaurant: Restaurant?) : super() {
        this.id = id
        this.capacity = capacity
        this.number = number
        this.restaurant = restaurant
    }
}