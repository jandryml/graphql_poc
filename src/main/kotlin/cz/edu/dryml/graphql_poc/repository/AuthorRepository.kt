package cz.edu.dryml.graphql_poc.repository

import cz.edu.dryml.graphql_poc.model.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, Long>
