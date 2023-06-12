package com.mj.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mj.model.Topic;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList <> (Arrays.asList(new Topic("Spring", "SF", "desc of SF"), new Topic("Java", "core", "desc of jave"),
			new Topic("Javascript", "Js", "desc of Js")));
	
	
	public List<Topic> getTopics(){
		return topics;
	}
	
	public Topic getTopicById(String id) {
		
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}
			
	public String addTopic(Topic topic) {
		
		topics.add(topic);
		return "string added";
	}
	
	public String deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
		return "Deleted Entry";
	}
	
	public String updateTopic(Topic topic, String id) {
		
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return "Updated Topic";
			}
		}
		
		return "not Found";
	}
	
	
}
