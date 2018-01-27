package com.arch.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arch.Dao.PostDao;
import com.arch.Entities.Comment;
import com.arch.Entities.Post;

@Service
public class CommentService {

	@Autowired
	com.arch.Dao.CommentDao dao;

	public void InsertComment (Comment comment)
	{
		dao.InsertComment(comment);
	}

	public Comment SelectComment (int  Id)
	{
		return dao.SelectComment(Id);
	}
	
	public void DeleteComment (int  Id)
	{
		dao.DeleteComment(Id);
	}

	public void UpdateComment (Comment comment)
	{
		dao.UpdateComment(comment);
	}


	public List<Comment> All ()
	{
			
	return dao.AllComments();
	
	}

	public   ArrayList<String> SelectCommentBy (String PostId)
	{
			
	return dao.SelectCommentBy(PostId);
	
	}

	public ArrayList<String> AllpComment (int id ,String Name)
	{
			
	return dao.AllPComment(id,Name);
	
	}

}
