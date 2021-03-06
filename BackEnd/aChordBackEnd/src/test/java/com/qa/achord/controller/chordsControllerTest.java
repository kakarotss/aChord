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
import com.qa.achord.entity.users;
import com.qa.achord.repository.chordsRepo;
import com.qa.achord.repository.usersRepo;
import com.qa.achord.service.chordsService;
//import com.qa.achord.service.usersServiceTest;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class chordsControllerTest {
	
	  @Autowired
	    private MockMvc mock;
	  
	  @MockBean
	    private chordsRepo repo;
	  
	  @MockBean
	    private chordsService chordService;
	  
	  @InjectMocks
	    private ObjectMapper mapper = new ObjectMapper();
	  
	  private chords chord;
	
	  private  chords insertedChord = new chords();
	  
	   @Before
	    public void init() {
	        this.repo.deleteAll();
	        
	        insertedChord.setChordDescription("d");
	        insertedChord.setChordId(1);
	        insertedChord.setChordImg("a");
	        insertedChord.setChordTitle("s");

	        
	        this.chord = new chords(1,1,"asd","asd","asd");	        
	    }
	  
	   
	   @Test
	    public void testAllUsers() throws Exception {
	        
	        this.mock.perform(get("/aChord/allChords"))
	        .andExpect(status().isOk());
	            
	    }

	   
	   
	   
	   @Test
	    public void testcoruseChord() throws Exception {
	        
	        Mockito.when(this.repo.save(this.chord)).thenReturn(this.chord);
	        Assertions.assertThat(this.repo.save(this.chord)).isEqualTo(this.chord);
	        
	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/aChord/courseChords?Uid=1");
	        
	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(chord))
	        .accept(MediaType.APPLICATION_JSON);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(this.chord);
	        
	        this.mock.perform(mockrequest)
	        
	        .andExpect(status().isOk());
	    }
	   
	   @Test
	    public void testofflineChord() throws Exception {
	        
	        Mockito.when(this.repo.save(this.chord)).thenReturn(this.chord);
	        Assertions.assertThat(this.repo.save(this.chord)).isEqualTo(this.chord);
	        
	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/aChord/courseChordsOffline");
	        
	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(chord))
	        .accept(MediaType.APPLICATION_JSON);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(this.chord);
	        
	        this.mock.perform(mockrequest)
	        
	        .andExpect(status().isOk());
	    }
	   
	   
	   @Test
	    public void testsearch() throws Exception {
	        
	        Mockito.when(this.repo.save(this.chord)).thenReturn(this.chord);
	        Assertions.assertThat(this.repo.save(this.chord)).isEqualTo(this.chord);
	        
	        MockHttpServletRequestBuilder mockrequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/aChord/search?search=asd");
	        
	        mockrequest.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(chord))
	        .accept(MediaType.APPLICATION_JSON);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(this.chord);
	        
	        this.mock.perform(mockrequest)
	        
	        .andExpect(status().isOk());
	    }
	   

	   


}
