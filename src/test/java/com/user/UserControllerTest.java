package com.user;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  public void getHello() throws Exception {
    User user = User.UserWith()
        .id(Long.valueOf(100))
        .name("Amit")
        .build();

    mvc.perform(MockMvcRequestBuilders.
            post("/user")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)))
        .andExpect(status().isOk());

  }

}
