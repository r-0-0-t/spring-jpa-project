package com.ishan.springjpaproject;

import com.ishan.springjpaproject.entity.VoterId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ishan.springjpaproject.entity.User;
import com.ishan.springjpaproject.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@SpringBootApplication
public class SpringJpaProjectApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

    @Autowired
    private EntityManager em;

    Logger logger = LoggerFactory.getLogger(SpringJpaProjectApplication.class);

	public static void main(String[] args) {
        SpringApplication.run(SpringJpaProjectApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        VoterId voterId = new VoterId();
        em.persist(voterId);
        User user1 = new User("bdafahim", "Badrudduza", "Ahmed");
        user1.setVoterId(voterId);
        userRepository.insert(user1);
        User user = userRepository.findById(1);
        if(user != null) {
            logger.info("Find By Id -> {}", user);
        }
    }
}
