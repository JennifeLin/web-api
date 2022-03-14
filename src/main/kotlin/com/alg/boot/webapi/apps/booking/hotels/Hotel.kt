package com.alg.boot.webapi.apps.booking.hotels

import com.alg.boot.webapi.apps.shared.AuditableEntity
import net.minidev.json.annotate.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "HOTELS")
class Hotel: AuditableEntity<String>() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null
    @Column(name = "HOTEL_BOOKING_URL")
    var bookingUrl: String? = null
    @Column(name = "HOTEL_WEBSITE_URL")
    var hotelUrl: String? = null
    @Column(name = "HOTEL_NAME")
    var hotelName: String? = null
    @Column(columnDefinition = "TEXT")
    var description: String? = null
    @Column(name = "ADDRESS_ID")
    var addressId: Long? = null
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "ADDRESS_ID", insertable = false, updatable = false)
    var address: Address? = null
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH])
    @JoinColumn(name = "DESTINATION_ID")
    var destination: Destination? = null
    var photoUrl: String? = null
    var brand: String? = null
    var experience: String? = null
    var minimalRate: Int? = null
    var maximalRate: Int? = null
    @ElementCollection
    @CollectionTable(name = "HOTELS_RATE_PLANS", joinColumns = [JoinColumn(name = "HOTEL_ID")])
    var ratePlans: MutableSet<String>? = mutableSetOf()
    @ElementCollection
    @CollectionTable(name = "HOTELS_PACKAGE_PLANS", joinColumns = [JoinColumn(name = "HOTEL_ID")])
    var packagePlans: MutableSet<String>? = mutableSetOf()
    @ElementCollection
    @CollectionTable(name = "HOTELS_AMENITIES", joinColumns = [JoinColumn(name = "HOTEL_ID")])
    var amenities: MutableSet<String>? = mutableSetOf()
    @ElementCollection
    var photos: Map<String, String> = HashMap()
}
