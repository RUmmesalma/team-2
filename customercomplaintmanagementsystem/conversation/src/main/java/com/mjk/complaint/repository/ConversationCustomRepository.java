package com.mjk.complaint.repository;

import org.springframework.stereotype.Repository;

import com.mjk.complaint.entity.Conversation;
@Repository
public interface ConversationCustomRepository {
	public Conversation getConversationByIssueId(int issueId) throws Exception;
	public Conversation getConversationByTitle(String title) throws Exception ;
	public Conversation getConversationByDescription(String description) throws Exception ;
	public Conversation getConversationByPostingDate(String postingDate) throws Exception;
	public Conversation getConversationByUserName(String userName)throws Exception;
	
}