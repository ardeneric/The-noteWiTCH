/*******************************************************************************
 * CONFIDENTIAL
 *******************************************************************************/
package com.notewitch.witch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
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
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {
	
    @Autowired
    private UserRepository userRepository;
 
    @Test
    public void findByUsernameContaining() {
        List<User> user = userRepository.findByUsernameContaining("gk");
        assertNotNull(user);
        assertThat(user.get(0).getUsername().equals("gknanor"));
    
    }
 

}
