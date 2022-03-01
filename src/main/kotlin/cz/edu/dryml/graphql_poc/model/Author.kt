package cz.edu.dryml.graphql_poc.model

import javax.persistence.*

@Entity
class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @Column(name = "age")
    var age: Int? = null
) {

    constructor() : this(null, null, null)

    constructor(id: Long?) : this(id, null, null)

    constructor(name: String?, age: Int?) : this(null, name, age)

    override fun toString(): String {
        return "User [id=$id, name=$name, age=$age]"
    }
}

