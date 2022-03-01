package cz.edu.dryml.graphql_poc.exception

data class EntityNotFoundException(override val message: String?) : Exception()
