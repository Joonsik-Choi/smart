package com.gwnu.smart.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JoinRepository extends CrudRepository<UserInfo, String> {
    List<UserInfo> findAll();
    Optional<UserInfo> findById(String id);
    UserInfo save(UserInfo userInfo);

    Optional<UserInfo> findByNameAndEmail(String name, String email);

    Optional<UserInfo>  findByNameAndIdAndEmail(String name, String id, String email);
}
