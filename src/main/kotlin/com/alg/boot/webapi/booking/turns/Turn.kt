package com.alg.boot.webapi.booking.turns

import com.alg.boot.webapi.booking.restaurants.Restaurant
import javax.persistence.*

@Entity
@Table(name = "turn")
class Turn(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME")
    var name: String? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    var restaurant: Restaurant? = null
)
