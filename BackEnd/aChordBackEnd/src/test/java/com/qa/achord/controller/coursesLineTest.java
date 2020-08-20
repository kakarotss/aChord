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
import com.qa.achord.entity.courseLine;
import com.qa.achord.entity.users;
import com.qa.achord.repository.chordsRepo;
import com.qa.achord.repository.courseLineRepo;
import com.qa.achord.repository.coursesRepo;
import com.qa.achord.repository.usersRepo;
import com.qa.achord.service.chordsService;
import com.qa.achord.service.courseLineService;
import com.qa.achord.service.coursesService;
//import com.qa.achord.service.usersServiceTest;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class coursesLineTest {
	
	  @Autowired
	    private MockMvc mock;
	  
	  @MockBean
	    private courseLineRepo repo;
	  
	  @MockBean
	    private courseLineService chordService;
	  
	  @InjectMocks
	    private ObjectMapper mapper = new ObjectMapper();
	  
	  private courseLine courseLine;
	
	  private  courseLine insertedCourse = new courseLine();
	  
	   @Before
	    public void init() {
	        this.repo.deleteAll();
	        
	       insertedCourse.setCourseId(1);
	       insertedCourse.setCourseLineId(1);
	       insertedCourse.setCourseStatus("undone");
	       insertedCourse.setUserId(1);
//	       int courseLineId, int courseId, int userId, String courseStatus
	        
	        this.courseLine = new courseLine(1,1,1,"undone");	        
	    }
	  
	   
	 

	   
	   
	   
	   @Test
	    public void myCourseLine() throws Exception {
	        
	        Mockito.when(this.repo.save(this.courseLine)).thenReturn(this.courseLine);
	        Assertions.assertThat(this.repo.save(this.courseLine)).isEqualTo(this.courseLine);
	        
	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/aChord/myCourseLine");
	        
	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(courseLine))
	        .accept(MediaType.APPLICATION_JSON);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(this.courseLine);
	        
	        this.mock.perform(mockrequest)
	        
	        .andExpect(status().isOk());
	    }
	   
	   
	   @Test
	    public void addLine() throws Exception {
	        
	        Mockito.when(this.repo.save(this.courseLine)).thenReturn(this.courseLine);
	        Assertions.assertThat(this.repo.save(this.courseLine)).isEqualTo(this.courseLine);
	        
	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/aChord/addLine");
	        
	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(courseLine))
	        .accept(MediaType.APPLICATION_JSON);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(this.courseLine);
	        
	        this.mock.perform(mockrequest)
	        
	        .andExpect(status().isOk());
	    }
	   
	   @Test
	    public void removeLine() throws Exception {
	        
	        Mockito.when(this.repo.save(this.courseLine)).thenReturn(this.courseLine);
	        Assertions.assertThat(this.repo.save(this.courseLine)).isEqualTo(this.courseLine);
	        
	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.DELETE, "/aChord/removeLine");
	        
	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(courseLine))
	        .accept(MediaType.APPLICATION_JSON);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(this.courseLine);
	        
	        this.mock.perform(mockrequest)
	        
	        .andExpect(status().isOk());
	    }
	   
}