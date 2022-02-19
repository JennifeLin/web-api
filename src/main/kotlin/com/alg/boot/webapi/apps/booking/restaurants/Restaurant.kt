package com.alg.boot.webapi.apps.booking.restaurants

import com.alg.boot.webapi.apps.booking.boards.Board
import com.alg.boot.webapi.apps.booking.reservations.Reservation
import com.alg.boot.webapi.apps.booking.turns.Turn
import com.alg.boot.webapi.apps.shared.AuditableEntity
import javax.persistence.*

@Entity
@Table(name = "RESTAURANTS")
class Restaurant(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME")
    var name: String? = null,

    @Column(name = "ADDRESS")
    var address: String? = null,

    @Column(name = "DESCRIPTION")
    var description: String? = null,

    @Column(name = "IMAGE")
    var image: String? = null,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "restaurant")
    var reservations: List<Reservation> = emptyList(),

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "restaurant")
    var boards: List<Board> = emptyList(),

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "restaurant")
    var turns: List<Turn> = emptyList(),
): AuditableEntity<String>()
