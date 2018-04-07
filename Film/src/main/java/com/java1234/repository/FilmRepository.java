package com.java1234.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.java1234.entity.Film;
/**
 * 电影repository接口
 * @author Administrator
 *
 */

public interface FilmRepository extends JpaRepository<Film,Integer>,JpaSpecificationExecutor<Film>{

}
