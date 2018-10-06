package br.edu.iftm.extensaoSTS.resources;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtividadeResourceTest {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	private String url = "/atividade/1";

	@Before
	private void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	/*@Test
	public void testaId() {
		this.mvc.perform(MockMvcRequestBuilders.get(url))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("nome", MockMvcResultMatchers.status().equals("Visita Técnica GDG 2018")));
	}*/
}
