package com.alg.boot.webapi.apps.booking.boards

import com.alg.boot.webapi.apps.booking.restaurants.Restaurant
import com.alg.boot.webapi.apps.shared.AuditableEntity
import javax.persistence.*


@Entity
@Table(name = "BOARDS")
class Board: AuditableEntity<String>() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null

    @Column(name = "CAPACITY")
    var capacity: Long? = null

    @Column(name = "NUMBER")
    var number: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    var restaurant: Restaurant? = null
}
