package com.example.backend.business.dao;

import com.example.backend.business.entity.AuthorityEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface AuthorityRepository extends PagingAndSortingRepository<AuthorityEntity, Integer> {
    Set<AuthorityEntity> findAllByIdIn(Collection<Long> ids);
    AuthorityEntity findAllByName(String name);
}
