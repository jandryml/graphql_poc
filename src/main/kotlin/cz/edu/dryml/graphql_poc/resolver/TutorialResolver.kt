package cz.edu.dryml.graphql_poc.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import cz.edu.dryml.graphql_poc.model.Author
import cz.edu.dryml.graphql_poc.model.Tutorial
import cz.edu.dryml.graphql_poc.repository.AuthorRepository
import org.springframework.stereotype.Component

@Component
class TutorialResolver(private val authorRepository: AuthorRepository) : GraphQLResolver<Tutorial> {
    fun getAuthor(tutorial: Tutorial): Author {
        return authorRepository.findById(tutorial.author?.id ?: -1L).orElseThrow<RuntimeException>(null)
    }
}
