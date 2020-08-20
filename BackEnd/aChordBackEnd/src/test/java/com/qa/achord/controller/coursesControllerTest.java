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
import com.qa.achord.entity.chords;
import com.qa.achord.entity.courses;
import com.qa.achord.entity.users;
import com.qa.achord.repository.chordsRepo;
import com.qa.achord.repository.coursesRepo;
import com.qa.achord.repository.usersRepo;
import com.qa.achord.service.chordsService;
import com.qa.achord.service.coursesService;
//import com.qa.achord.service.usersServiceTest;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class coursesControllerTest {
	
	  @Autowired
	    private MockMvc mock;
	  
	  @MockBean
	    private coursesRepo repo;
	  
	  @MockBean
	    private coursesService chordService;
	  
	  @InjectMocks
	    private ObjectMapper mapper = new ObjectMapper();
	  
	  private courses course;
	
	  private  courses insertedCourse = new courses();
	  
	   @Before
	    public void init() {
	        this.repo.deleteAll();
	        
	        insertedCourse.setCourseId(1);
	        insertedCourse.setCourseImg("asd");
	        insertedCourse.setCourseLevel(2);
	        insertedCourse.setCourseName("asd");
//	        int courseId, String courseName, int courseLevel, String courseImg
	        
	        this.course = new courses(1,"asd", 2,"asd");	        
	    }
	  
	   
	
	   
	   
	   
	   @Test
	    public void testcoruses() throws Exception {
	        
	        Mockito.when(this.repo.save(this.course)).thenReturn(this.course);
	        Assertions.assertThat(this.repo.save(this.course)).isEqualTo(this.course);
	        
	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/aChord/idCourses?");
	        
	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(course))
	        .accept(MediaType.APPLICATION_JSON);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(this.course);
	        
	        this.mock.perform(mockrequest)
	        
	        .andExpect(status().isOk());
	    }
	   
}