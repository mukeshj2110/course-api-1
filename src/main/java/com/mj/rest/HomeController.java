package com.mj.rest;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mj.model.Topic;
import com.mj.service.TopicService;



@RestController
public class HomeController {


	@Autowired
	TopicService topicservice;

	@GetMapping("/topics")
	public List<Topic> getTopics() {
		return topicservice.getTopics();
	}
	
	@GetMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable String id) {
		return topicservice.getTopicById(id);
	}
	
	@PostMapping("/topics")
	public String addTopic(@RequestBody Topic topic) {
		return topicservice.addTopic(topic);
	}
	
	@DeleteMapping("/topics/{id}")
	public String deleteTopic(@PathVariable String id) {
		return topicservice.deleteTopic(id);
	}
	
	@PutMapping("/topics/{id}")
	public String updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		return topicservice.updateTopic(topic, id);
	}
	
}
