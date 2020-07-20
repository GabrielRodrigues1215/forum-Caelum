/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.forum.repository;

import br.com.alura.forum.model.OpenTopicByCategory;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Gabriel
 */
public interface OpenTopicByCategoryRepository extends Repository<OpenTopicByCategory, Long> {

    void saveAll(Iterable<OpenTopicByCategory> topics);

    @Query("select t from OpenTopicByCategory t " +
            "where year(t.date)	= year(current_date)" +
            "and month(t.date) = month(current_date)")
    public List<OpenTopicByCategory> findAllByCurrentMonth();

}
