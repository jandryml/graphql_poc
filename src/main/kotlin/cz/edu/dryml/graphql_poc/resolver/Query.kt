package cz.edu.dryml.graphql_poc.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import cz.edu.dryml.graphql_poc.model.Author
import cz.edu.dryml.graphql_poc.model.Tutorial
import cz.edu.dryml.graphql_poc.repository.AuthorRepository
import cz.edu.dryml.graphql_poc.repository.TutorialRepository
import org.springframework.stereotype.Component

@Component
class Query(
    private val authorRepository: AuthorRepository,
    private val tutorialRepository: TutorialRepository
) : GraphQLQueryResolver {
    fun findAllAuthors(): Iterable<Author> {
        return authorRepository.findAll()
    }

    fun findAllTutorials(): Iterable<Tutorial> {
        return tutorialRepository.findAll()
    }

    fun countAuthors(): Long {
        return authorRepository.count()
    }

    fun countTutorials(): Long {
        return tutorialRepository.count()
    }
}
