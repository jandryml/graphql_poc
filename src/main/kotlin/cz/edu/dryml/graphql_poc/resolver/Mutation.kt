package cz.edu.dryml.graphql_poc.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import cz.edu.dryml.graphql_poc.exception.EntityNotFoundException
import cz.edu.dryml.graphql_poc.model.Author
import cz.edu.dryml.graphql_poc.model.Tutorial
import cz.edu.dryml.graphql_poc.repository.AuthorRepository
import cz.edu.dryml.graphql_poc.repository.TutorialRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class Mutation @Autowired constructor(
    private val authorRepository: AuthorRepository,
    private val tutorialRepository: TutorialRepository
) :
    GraphQLMutationResolver {
    fun createAuthor(name: String, age: Int): Author {
        val author = Author().apply {
            this.name = name
            this.age = age
        }

        authorRepository.save(author)
        return author
    }

    fun createTutorial(title: String, description: String?, authorId: Long?): Tutorial {
        val tutorial = Tutorial().apply {
            this.author = Author(authorId)
            this.title = title
            this.description = description
        }

        tutorialRepository.save(tutorial)
        return tutorial
    }

    fun deleteTutorial(id: Long): Boolean {
        tutorialRepository.deleteById(id)
        return true
    }

    fun updateTutorial(id: Long, title: String?, description: String?): Tutorial {
        val optTutorial: Optional<Tutorial> = tutorialRepository.findById(id)
        if (optTutorial.isPresent) {
            val tutorial: Tutorial = optTutorial.get()
            title?.let { tutorial.title = it }
            description?.let { tutorial.description = it }

            tutorialRepository.save(tutorial)
            return tutorial
        }
        throw EntityNotFoundException("Not found Tutorial to update!")
    }
}
