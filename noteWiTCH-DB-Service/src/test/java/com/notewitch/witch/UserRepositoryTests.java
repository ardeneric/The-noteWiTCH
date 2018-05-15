/*******************************************************************************
 * CONFIDENTIAL
 *******************************************************************************/
package com.notewitch.witch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.notewitch.entity.User;
import com.notewitch.repository.UserRepository;

/**
 * @author EricAr
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
	
    @Autowired
    private UserRepository userRepository;
 
    @Test
    public void findByUsernameContaining() {
        Stream<User> user = userRepository.findByUsernameContaining("ard");
        assertNotNull(user);
        System.err.println("this is the user" + user.collect(Collectors.toList()));
        /*assertThat(user.collect(Collectors.toList()).get(0).getUsername().equals("arden"));*/
    
    }
 

}
