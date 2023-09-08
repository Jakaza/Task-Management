package com.onrender.themba.taskmanagement;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.onrender.themba.taskmanagement.entity.TaskEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskEntityManagementApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldCreateNewTask(){
		TaskEntity taskEntity = new TaskEntity("Test1", "Testing One");
		ResponseEntity<TaskEntity> responseEntity = testRestTemplate.postForEntity("/tasks/new", taskEntity, TaskEntity.class);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		DocumentContext documentContext = JsonPath.parse(responseEntity.getBody());
	}

}
