package cz.edu.dryml.graphql_poc.repository

import cz.edu.dryml.graphql_poc.model.Tutorial
import org.springframework.data.jpa.repository.JpaRepository

interface TutorialRepository : JpaRepository<Tutorial, Long>
