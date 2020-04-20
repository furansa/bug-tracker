package me.furansa.desconstruindo.bugtracker.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import org.springframework.stereotype.Component;

import me.furansa.desconstruindo.bugtracker.entities.ApplicationEntity;
import me.furansa.desconstruindo.bugtracker.repositories.ApplicationRepository;

@Component
public class ApplicationResolver implements GraphQLQueryResolver {
    private ApplicationRepository applicationRepository;

    public ApplicationResolver(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Iterable<ApplicationEntity> getAllApplications() {
        return applicationRepository.findAll();
    }
}