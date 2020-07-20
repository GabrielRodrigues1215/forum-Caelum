/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.forum.service;

import br.com.alura.forum.model.Answer;
import br.com.alura.forum.repository.AnswerRepository;
import br.com.alura.forum.service.infra.ForumMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gabriel
 */
@Service
public class NewReplyProcessorService {

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private ForumMailService forumMailService;

    public void execute(Answer answer) {
        this.answerRepository.save(answer);
        this.forumMailService.sendNewReplyMail(answer);
    }

}
