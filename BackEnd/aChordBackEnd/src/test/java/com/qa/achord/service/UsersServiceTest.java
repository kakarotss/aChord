//package com.qa.achord.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.assertj.core.api.Assertions;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.qa.achord.entity.users;
//import com.qa.achord.repository.usersRepo;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class usersServiceTest {
//	
//	 @Autowired
//	    private MockMvc mock;
//	  
//	  @MockBean
//	    private usersRepo repo;
//	  
//	  @MockBean
//	    private usersServiceTest userService;
//	  
//	  @InjectMocks
//	  private usersService uS;
//	  
//	  
//	  
//	  private List <users> list;
//	  private users user;
//	  
//	  @Before
//	    public void init() {
//	        this.repo.deleteAll();  
//	        uS= new usersService();
//	        
//	        list = new ArrayList<users>();
//	        user = new users();
//	        user.setEmail("asd");
//	        user.setFirstName("asd");
//	        user.setLastName("asd");
//	        user.setUserId(12);
//	        user.setUserLevel(2);
//	        user.setUsername("asd");
//	        user.setUserPassword("asd");
//	        
//	    }
//	  
//	  
//	  @Test
//	    public void testmyProfile() throws Exception {
//	        
//	        Mockito.when(this.repo.userProfile("asd")).thenReturn(list);
//	        assertEquals(list, uS.myProfile(user));
//	        
////	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/aChord/Login");
////	        
////	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(user))
////	        .accept(MediaType.APPLICATION_JSON);
////	        
////	        Mockito.verify(this.repo, Mockito.times(1)).save(this.user);
////	        
////	        this.mock.perform(mockrequest)
////	        
////	        .andExpect(status().isOk());
//	    }
//
//}
