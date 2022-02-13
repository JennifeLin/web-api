package com.alg.boot.webapi.apps.booking.boards

import com.alg.boot.webapi.apps.booking.restaurants.Restaurant
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*


@Entity
@Table(name = "boards")
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

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null
}
