package com.gx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gx.entites.Image;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {

}
