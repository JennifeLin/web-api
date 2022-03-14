package com.alg.boot.webapi.apps.booking.hotels

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "ADDRESSES")
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null
    @NotBlank
    var address: String? = null
    var country: String? = null
    var city: String? = null
    var postalCode: String? = null
    @NotBlank
    var latitude: Long? = null
    @NotBlank
    var longitude: Long? = null
    @OneToOne(mappedBy = "ADDRESSES")
    var hotel: Hotel? = null
}
