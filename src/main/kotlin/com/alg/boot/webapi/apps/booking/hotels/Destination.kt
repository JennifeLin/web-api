package com.alg.boot.webapi.apps.booking.hotels

import javax.persistence.*

@Entity
@Table(name = "DESTINATIONS")
class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null
    var name: String? = null
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "DESTINATIONS")
    var hotels: MutableSet<Hotel> = mutableSetOf()
}
