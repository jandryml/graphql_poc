package cz.edu.dryml.graphql_poc.model

import javax.persistence.*

@Entity
data class Tutorial(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(name = "title", nullable = false)
    var title: String? = null,

    @Column(name = "description")
    var description: String? = null,

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    var author: Author? = null
) {
    constructor() : this(null, null, null, null) {}

    override fun toString(): String {
        return "Tutorial [id=$id, title=$title, description=$description, author=$author]"
    }
}
