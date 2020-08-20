package com.qa.achord.controller;




import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

 

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

 

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.achord.entity.users;
import com.qa.achord.repository.usersRepo;
import com.qa.achord.service.usersService;
//import com.qa.achord.service.usersServiceTest;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class usersControllerTest {
	
	  @Autowired
	    private MockMvc mock;
	  
	  @MockBean
	    private usersRepo repo;
	  
	  @MockBean
	    private usersService userService;
	  
	  @InjectMocks
	    private ObjectMapper mapper = new ObjectMapper();
	  
	  private users user;
	
	  private  users insertedUser = new users();
	  
	   @Before
	    public void init() {
	        this.repo.deleteAll();
//	        userId, String username, String userPassword, String email, String firstName, String lastName,
//			int userLevel
	        this.user = new users(13, "testt", "t", "t@live.com", "te", "st", 2);
	        this.user = new users();
	        
	       
	         
	        
	    }
	  
	   
	   @Test
	    public void testAllUsers() throws Exception {
	        
	        this.mock.perform(get("/aChord/allUsers"))
	        .andExpect(status().isOk());
	            
	    }
	   
	   
//	   @Test
//	    public void testLogin() throws Exception {
//	        
//	        this.mock.perform(post("/aChord/Login"))
//	        .andExpect(status().isOk());
//	            
//	    }
	   
	   
	   
	   @Test
	    public void testLogin() throws Exception {
	        
	        Mockito.when(this.repo.save(this.user)).thenReturn(user);
	        Assertions.assertThat(this.repo.save(this.user)).isEqualTo(this.user);
	        
	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/aChord/Login");
	        
	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(user))
	        .accept(MediaType.APPLICATION_JSON);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(this.user);
	        
	        this.mock.perform(mockrequest)
	        
	        .andExpect(status().isOk());
	    }
	   
	   @Test
	    public void testmyProfile() throws Exception {
	        
	        Mockito.when(this.repo.save(this.user)).thenReturn(user);
	        Assertions.assertThat(this.repo.save(this.user)).isEqualTo(this.user);
	        
	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/aChord/myProfile");
	        
	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(user))
	        .accept(MediaType.APPLICATION_JSON);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(this.user);
	        
	        this.mock.perform(mockrequest)
	        
	        .andExpect(status().isOk());
	    }
	   
	   
	   @Test
	    public void testregister() throws Exception {
	        
	        Mockito.when(this.repo.save(this.user)).thenReturn(user);
	        Assertions.assertThat(this.repo.save(this.user)).isEqualTo(this.user);
	        
	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/aChord/Register");
	        
	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(user))
	        .accept(MediaType.APPLICATION_JSON);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(this.user);
	        
	        this.mock.perform(mockrequest)
	        
	        .andExpect(status().isOk());
	    }
	   
	   
	   @Test
	    public void testdeletemy() throws Exception {
	        
	        Mockito.when(this.repo.save(this.user)).thenReturn(user);
	        Assertions.assertThat(this.repo.save(this.user)).isEqualTo(this.user);
	        
	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.DELETE, "/aChord/deleteMyAccount");
	        
	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(user))
	        .accept(MediaType.APPLICATION_JSON);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(this.user);
	        
	        this.mock.perform(mockrequest)
	        
	        .andExpect(status().isOk());
	    }
	   
	   @Test
	    public void testaddusers() throws Exception {
	        
	        Mockito.when(this.repo.save(this.user)).thenReturn(user);
	        Assertions.assertThat(this.repo.save(this.user)).isEqualTo(this.user);
	        
	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/aChord/addUsers");
	        
	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(user))
	        .accept(MediaType.APPLICATION_JSON);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(this.user);
	        
	        this.mock.perform(mockrequest)
	        
	        .andExpect(status().isOk());
	    }
	   
	   @Test
	    public void testdelete() throws Exception {
	        
	        Mockito.when(this.repo.save(this.user)).thenReturn(user);
	        Assertions.assertThat(this.repo.save(this.user)).isEqualTo(this.user);
	        
	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.DELETE, "/aChord/deleteAccount");
	        
	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(user))
	        .accept(MediaType.APPLICATION_JSON);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(this.user);
	        
	        this.mock.perform(mockrequest)
	        
	        .andExpect(status().isOk());
	    }
	   
	   
	   
	   
	   

	    


}
