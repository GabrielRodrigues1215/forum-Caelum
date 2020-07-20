/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.forum.task;

import br.com.alura.forum.model.OpenTopicByCategory;
import br.com.alura.forum.repository.OpenTopicByCategoryRepository;
import br.com.alura.forum.repository.TopicRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gabriel
 */
@Component
public class RegisterUnansweredTopicsTask {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private OpenTopicByCategoryRepository openTopicByCategoryRepository;
    
    //@Scheduled(cron="*/10 * * * * *") PARA FAZER A CRON RODAR A CADA 10 SEG
    
    @Scheduled(cron=" 0 0 20 * * *")
    public void execute() {
        List<OpenTopicByCategory> topics = topicRepository.findOpenTopicsByCategory();
        this.openTopicByCategoryRepository.saveAll(topics);
        System.out.println("TESTE CLASSE REGISTERUNANS");
    }
}
