package com.desarrolloWeb.springboot.app.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desarrolloWeb.springboot.app.entity.User;


@Repository
public interface IUserRepository extends CrudRepository<User, Long>  {
    public Optional<com.desarrolloWeb.springboot.app.entity.User> findByUsername(String username);
}