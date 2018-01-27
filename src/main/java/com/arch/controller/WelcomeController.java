package com.arch.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.arch.Service.CommentService;
import com.arch.Service.PostService;
import com.arch.Service.RegisterService;
import com.arch.Service.authoritiesService;
import com.arch.Service.usersService;


import com.arch.EncryptPassword;
import com.arch.Entities.*;
import com.arch.RandomV_Code.Random_Vcode;
import com.arch.SendMail.SendMail;

@Controller
public class WelcomeController {

	public static String Current_User;

	@Autowired
	RegisterService registerservice;

	@Autowired
	usersService usersservice;

	@Autowired
	authoritiesService authoritiesservice;

	@Autowired
	PostService postservice;

	@Autowired
	CommentService 	commentservice;
	
	@Autowired
	ServletContext c;
	
	ModelAndView modelAndView ;
	@RequestMapping(value = "/Login")
	public ModelAndView Login(@RequestParam(name = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView("/Login");
		if (error != null) {
			modelAndView.addObject("error", "Please Enter Correct Data :)");
		}
		return modelAndView;
	} 	
	
	@RequestMapping(value = "/")
	public ModelAndView Home(HttpSession session){
	 		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Current_User = authentication.getName();
		authorities au=authoritiesservice.Selectauthorities(Current_User);		
	    String aux=au.getAuthority();
	    System.out.println(aux + "////////////////////");
				    if(aux.equals("ROLE_USER")){
				 	List<Post> c= postservice.All();
							ArrayList<String> Arr=new ArrayList<String>();
							for(int x=0;x<c.size();x++)
							{
								Arr.add(Integer.toString( c.get(x).getId()));
								Arr.add(c.get(x).getPosts());
								Arr.add(c.get(x).getHeader());
								Arr.add(c.get(x).getPicture());
								
							}		
							System.out.println(Arr);
							session.setAttribute("arr",Arr);				
			modelAndView = new ModelAndView ("User");		
		}else{
			 modelAndView = new ModelAndView ("Dashboard");
		}
		
		return modelAndView;
		}
	
	/*
	@RequestMapping(value = "/User")
	public ModelAndView Home(HttpSession s) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Current_User = authentication.getName();
		
	    authorities au=authoritiesservice.Selectauthorities(Current_User);		
	    String aux=au.getAuthority();
	    if(aux.equals("ROLE_USER")){
	    	 modelAndView.addObject("Index");
		//////////////////////////////////////////////////////////////	
		List<Post> c= postservice.All();
				ArrayList<String> Arr=new ArrayList<String>();
				for(int x=0;x<c.size();x++)
				{
					Arr.add(Integer.toString( c.get(x).getId()));
					Arr.add(c.get(x).getPosts());
				}		
				System.out.println(Arr);
				s.setAttribute("arr",Arr);
	    }else{
	    	 modelAndView.addObject("Panel");
	    }
		return modelAndView;
	}
	@RequestMapping(value = "/Admin")
	public ModelAndView Admin() {
		ModelAndView modelAndView = new ModelAndView("Panel");
     	//	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//Current_User = authentication.getName();
		return modelAndView;
	}

	*/
	
	
	

	// User Go To Register Page
	@RequestMapping(value = "/GoRegister", method = RequestMethod.GET)
	public ModelAndView GoRegister() {

		ModelAndView modelAndView = new ModelAndView("Register");
		return modelAndView;
	}

	@RequestMapping(value = "/GoSettings", method = RequestMethod.GET)
	public ModelAndView GoSettings() {

		ModelAndView modelAndView = new ModelAndView("Settings");
		return modelAndView;
	}
	
	@RequestMapping(value = "/GoAddAdmin", method = RequestMethod.GET)
	public ModelAndView GoAddAdmin() {

		ModelAndView modelAndView = new ModelAndView("AddAdmin");
		return modelAndView;
	}
	@RequestMapping(value = "/GoUserSett", method = RequestMethod.GET)
	public ModelAndView GoUSerSett() {

		ModelAndView modelAndView = new ModelAndView("UserSett");
		return modelAndView;
	}

	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public ModelAndView back() {

		ModelAndView modelAndView = new ModelAndView("User");
		return modelAndView;
	}

	
	// User Register & Send Him Mail & Save Reg Data & users and auths DB
	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public ModelAndView Register(@RequestParam("UMail") String UMail, @RequestParam("UName") String UName,
			@RequestParam("UPass") String UPass, @RequestParam("UPhone") String UPhone) {

		ModelAndView modelAndView = new ModelAndView("Login");

		Register register = new Register();
		users users = new users();
		authorities authorities = new authorities();

		SendMail sendmail = new SendMail();
		Random_Vcode Vcode = new Random_Vcode();
		String vcode = Vcode.Genetate();

		String Mail = sendmail.SendMail(UMail, UName, vcode);

		EncryptPassword E = new EncryptPassword();
		String Pss = E.Md5Password(UPass);
		
		if (Mail.equals("Doen")) {

			register.setMail(UMail);
			register.setName(UName);
			register.setPass(Pss);
			register.setPhone(UPhone);
			registerservice.InsertRegister(register);

			users.setEnabled(0);
			users.setV_Code(vcode);
			users.setPassword(Pss);
			users.setUsername(UName);
			usersservice.Insert(users);

			
			authorities.setAuthority("ROLE_USER");
			authorities.setUsername(UName);
			authoritiesservice.Insertauthorities(authorities);


			modelAndView.addObject("Reg", " Your Registration Is Doen Check Your Mail For Verification Your Login :) ");

		} else {
			modelAndView.addObject("Reg", "Some Thing Went Wrong Please Try Later :)");

		}

		
		return modelAndView;
	}

	
	
	
	
	
	

	
	// User Go To Register Page
	@RequestMapping(value = "/PostArticle", method = RequestMethod.POST)
	public ModelAndView PostNews(@RequestParam("Article") String Article,@RequestParam("Head") String Head,@RequestParam("file") MultipartFile file
			 ) {
		ModelAndView modelAndView = new ModelAndView("AddArticle");
		 modelAndView.addObject("addd","Article Is Added Successsfully"); 	 
		 	
		 		
			try {
				// read and write the file to the selected location-
				byte[] bytes = file.getBytes();
				
				//////////////////////////////////////////////////////////////////
				
				 String UPLOAD_FOLDEdR=c.getRealPath("/images");	 
				Path path = Paths.get(UPLOAD_FOLDEdR +"/"+ file.getOriginalFilename());
				Files.write(path, bytes);
System.out.println(path   +"    ***************************************************************");
				String Pic_Name =file.getOriginalFilename() ;
				// insert new offer
				 System.out.println(Head + "  +++++++++++++++++++++++++++++++");
				System.out.println(file.getOriginalFilename() +"------------------------");
				String Pic=file.getOriginalFilename() ;
				
				Post p=new Post();
				p.setPosts(Article);
				p.setHeader(Head);
				p.setPicture(Pic);
				postservice.InsertPost(p);
				
								
			} catch (IOException e) {
				Post p=new Post();
				p.setPosts(Article);
				p.setHeader(Head);
				postservice.InsertPost(p);
			
				e.printStackTrace();
			}
			
		
		return modelAndView;
	}

	@RequestMapping(value = "/UserSett", method = RequestMethod.POST)
	public ModelAndView UserSett(@RequestParam("un") String un,@RequestParam("up") String up) {
		ModelAndView modelAndView = new ModelAndView("User");
		
		 modelAndView.addObject("up","Data Updated Successsfully"); 	
		    EncryptPassword E = new EncryptPassword();
			String Pss = E.Md5Password(up);
			
		 users u=new  users();
		 u.setEnabled(1);
		 u.setUsername(un);
		 u.setV_Code("222");
		 u.setPassword(Pss);
		 
		usersservice.Updatet(u);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/DeleteArticle", method = RequestMethod.POST)
	public ModelAndView DeleteArticle(@RequestParam("ArtId") String ID) {
	
		System.out.println(ID + "000000000000000");
		
		int s =Integer.parseInt(ID);
	//	System.out.println(s +"------------------");
		postservice.DeletePost(s);
		ModelAndView modelAndView = new ModelAndView("AllArticles");
		return modelAndView;
	}
	
	//////////////////////////////////
	@RequestMapping(value = "/UpdateArticle", method = RequestMethod.POST)
	public ModelAndView UpdateArticle(@RequestParam("ArtId") String ID,HttpSession S) {
	
		System.out.println(ID + "///////////////////");	
		S.setAttribute("S",ID);
		ModelAndView modelAndView = new ModelAndView("UpdateArticlee");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView Update(@RequestParam("Ad") String ID,@RequestParam("Update")String Update,@RequestParam("Head")String Head,
			@RequestParam("file") MultipartFile file) {
	
		ModelAndView modelAndView = new ModelAndView("AllArticles");
			 modelAndView.addObject("addd","Article Is Added Successsfully"); 	 
			 	
				 String UPLOAD_FOLDEdR=c.getRealPath("/images");
				try {
					// read and write the file to the selected location-
					byte[] bytes = file.getBytes();
					Path path = Paths.get(UPLOAD_FOLDEdR +"/"+ file.getOriginalFilename());
					
					Files.write(path, bytes);

					String Pic_Name =file.getOriginalFilename() ;
					// insert new offer
					 System.out.println(Head + "  +++++++++++++++++++++++++++++++");
					System.out.println(file.getOriginalFilename() +"------------------------");
					String Pic=file.getOriginalFilename() ;
					
		Post p=new Post();
		p.setId(Integer.parseInt(ID));
		p.setPosts(Update);
		p.setHeader(Head);
		p.setPicture(Pic);
		
		postservice.UpdatetPost(p);
			
				} catch (IOException e) {
					
					Post p=new Post();
					p.setId(Integer.parseInt(ID));
					p.setPosts(Update);
					p.setHeader(Head);
					
					postservice.UpdatetPost(p);
									
					e.printStackTrace();
				}

					
		return modelAndView;
	}

	
	@RequestMapping(value = "/AllArts", method = RequestMethod.GET)
	public ModelAndView AllArts(HttpSession session) {
		
	List<Post> c= postservice.All();
	ArrayList<String> Arr=new ArrayList<String>();
	for(int x=0;x<c.size();x++)
	{
		Arr.add(Integer.toString( c.get(x).getId()));
		Arr.add(c.get(x).getPosts());
		Arr.add(c.get(x).getHeader());
		Arr.add(c.get(x).getPicture());
		
	}
	
	System.out.println(Arr);
	session.setAttribute("arr",Arr);
	ModelAndView modelAndView = new ModelAndView("AllArticles");
		return modelAndView;
	}


	@RequestMapping(value = "/GoPostt", method = RequestMethod.GET)
	public ModelAndView GoPostt() {
		
		ModelAndView modelAndView = new ModelAndView("Admin");
	return modelAndView ;	
	}
	
	@RequestMapping(value = "/er", method = RequestMethod.GET)
	public ModelAndView er() {
		
		ModelAndView modelAndView = new ModelAndView("add");
	return modelAndView ;	
	}
	

	@RequestMapping(value = "/GoAddArt", method = RequestMethod.GET)
	public ModelAndView GoAddArt() {
		
		ModelAndView modelAndView = new ModelAndView("AddArticle");
	return modelAndView ;	
	}
	
	@RequestMapping(value = "/GoAddUser", method = RequestMethod.GET)
	public ModelAndView GoAddUser() {
		
		ModelAndView modelAndView = new ModelAndView("AddUser");
	return modelAndView ;	
	}
	
	@RequestMapping(value = "/GoAllAdmins", method = RequestMethod.GET)
	public ModelAndView GoAllAdmins(HttpSession session) {
		
		ModelAndView modelAndView = new ModelAndView("AllAdmins");		

		System.out.println("0000000000000000000000000000000000000000000000000000000");
	List<users> l =usersservice.Allusers();		
	ArrayList<String>a=new 	ArrayList<String>();
	ArrayList<String>ax=new 	ArrayList<String>();
	for(int f=0;f<l.size();f++)
		{
			a.add(l.get(f).getUsername());
		}
    	for(int ff=0;ff<a.size();ff++)
		{
    		String cv = a.get(ff);
    		authorities au=authoritiesservice.Selectauthorities(cv);		
    String aux=au.getAuthority();
    if(aux.equals("ROLE_ADMIN")){
   // ax.add(aux);
    ax.add(cv);
    }
		}
	System.out.println(ax  +"----------------------------");
    session.setAttribute("AllUsers",ax);	
		
	return modelAndView ;	
	}
	
	@RequestMapping(value = "/AddCommint", method = RequestMethod.POST)
	public ModelAndView AddCommint(@RequestParam("AID") String AID,@RequestParam("Comment") String Comment) {
		
		ModelAndView modelAndView = new ModelAndView("User");
		System.out.println(Comment  +"    "+AID+"    " +Current_User +"-----------------------------------");
		
		//commentservice.SelectComment(Id);
		Comment comment =new Comment();
		comment.setPId(AID);
		comment.setComment(Comment);
		comment.setUser(Current_User);
		
		commentservice.InsertComment(comment);
		return modelAndView;
	}

	

	@RequestMapping(value = "/AllComments", method = RequestMethod.POST)
	public ModelAndView ACommints(@RequestParam("All") String All ,HttpSession d,HttpSession dd) {
		
		ModelAndView modelAndView = new ModelAndView("AllCom");
		System.out.println("  ______________  " +All);
		
		  Post ttt=  postservice.SelectPost(Integer.parseInt(All));
		  
		  ArrayList<String> cv=new ArrayList<String>();
		  
		  cv.add(ttt.getHeader());
		  cv.add(ttt.getPosts());
		  cv.add(ttt.getPicture());
		
		Comment c =new Comment();
	ArrayList<String>g=new ArrayList<String>();
	ArrayList<String>gg=new ArrayList<String>(); 
	gg=	commentservice.SelectCommentBy(All);
	   
		System.out.println(gg);
//		Comment comment =new Comment();
//		comment.setPostId(AID);
//		comment.setComment(Comment);
//		comment.setUser(Current_User);
//		
//		commentservice.InsertComment(comment);
//		
		
		
		d.setAttribute("allcom", gg);
		dd.setAttribute("allart",cv);
		
		return modelAndView;
		
	}


	@RequestMapping(value = "/GoAllUserss", method = RequestMethod.GET)
	public ModelAndView GoAllUserss(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("AllUserss");
	
		System.out.println("0000000000000000000000000000000000000000000000000000000");
	List<users> l =usersservice.Allusers();		
	ArrayList<String>a=new 	ArrayList<String>();
	ArrayList<String>ax=new 	ArrayList<String>();
	for(int f=0;f<l.size();f++)
		{
			a.add(l.get(f).getUsername());
		}
    	for(int ff=0;ff<a.size();ff++)
		{
    		String cv = a.get(ff);
    		authorities au=authoritiesservice.Selectauthorities(cv);		
    String aux=au.getAuthority();
    if(aux.equals("ROLE_USER")){
   // ax.add(aux);
    ax.add(cv);
    }
		}
	System.out.println(ax  +"----------------------------");
    session.setAttribute("AllUsers",ax);	
		return modelAndView ;	
	}

	
	@RequestMapping(value = "/DeleteUser", method = RequestMethod.POST)
	public ModelAndView DeleteUser(@RequestParam("UserName") String UserName) {
		
		ModelAndView modelAndView = new ModelAndView("AllUserss");
		modelAndView.addObject("del","User Deleted Successfully");
		System.out.println(UserName + "------------------");
		usersservice.DeleteUser(UserName);
		authoritiesservice.Deleteauthorities(UserName);
		return modelAndView;
	}

	@RequestMapping(value = "/AddAdmin", method = RequestMethod.POST)
	public ModelAndView AddAdmin(@RequestParam("UN") String UN,@RequestParam("PS") String PS) {
		System.out.println(UN + "     "+PS); 
		ModelAndView modelAndView = new ModelAndView("AddAdmin");
		modelAndView.addObject("Add","New Admin Is Added now");
		EncryptPassword E = new EncryptPassword();
		String Pss = E.Md5Password(PS);
		users s=new users();
		s.setEnabled(1);
		s.setPassword(Pss);
		s.setUsername(UN);
		s.setV_Code("000");
		usersservice.Insert(s);
		
		authorities a=new authorities();
		a.setAuthority("ROLE_ADMIN");
		a.setUsername(UN);
		authoritiesservice.Insertauthorities(a);
		
		return modelAndView;
	}

	@RequestMapping(value = "/IAdmin", method = RequestMethod.POST)
	public ModelAndView IAdmin(@RequestParam("UN") String UN,@RequestParam("PS") String PS) {
		System.out.println(UN + "     "+PS); 
		ModelAndView modelAndView = new ModelAndView("Login");
		EncryptPassword E = new EncryptPassword();
		String Pss = E.Md5Password(PS);
		users s=new users();
		s.setEnabled(1);
		s.setPassword(Pss);
		s.setUsername(UN);
		s.setV_Code("000");
		usersservice.Insert(s);
		
		authorities a=new authorities();
		a.setAuthority("ROLE_ADMIN");
		a.setUsername(UN);
		authoritiesservice.Insertauthorities(a);
		
		return modelAndView;
	}

	@RequestMapping(value = "/IAdminn", method = RequestMethod.POST)
	public ModelAndView IAdminn(@RequestParam("UN") String UN,@RequestParam("PS") String PS) {
		
		System.out.println(UN + "     "+PS); 
		ModelAndView modelAndView = new ModelAndView("Settings");
		modelAndView.addObject("Sett","Data Updated Successfully");
		EncryptPassword E = new EncryptPassword();
		String Pss = E.Md5Password(PS);
		users s=new users();
		s.setEnabled(1);
		s.setPassword(Pss);
		s.setUsername(UN);
		s.setV_Code("000");
		usersservice.Updatet(s);
		
		authorities a=new authorities();
		a.setAuthority("ROLE_ADMIN");
		a.setUsername(UN);
		authoritiesservice.Updatetauthorities(a);
		
		return modelAndView;
	}

	
	@RequestMapping(value = "/IUser", method = RequestMethod.POST)
	public ModelAndView IUser(@RequestParam("UN") String UN,@RequestParam("PS") String PS) {
		
		ModelAndView modelAndView = new ModelAndView("Login");
		
		EncryptPassword E = new EncryptPassword();
		String Pss = E.Md5Password(PS);
		
		users s=new users();
		s.setEnabled(1);
		s.setPassword(Pss);
		s.setUsername(UN);
		s.setV_Code("000");
		usersservice.Insert(s);
		
		authorities a=new authorities();
		a.setAuthority("ROLE_USER");
		a.setUsername(UN);
		authoritiesservice.Insertauthorities(a);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/AddUser", method = RequestMethod.POST)
	public ModelAndView AddUser(@RequestParam("UN") String UN,@RequestParam("PS") String PS) {
		
		ModelAndView modelAndView = new ModelAndView("AddUser");
		 modelAndView.addObject("AUser","New User Is Add Successfully ");
		EncryptPassword E = new EncryptPassword();
		String Pss = E.Md5Password(PS);
		
		users s=new users();
		s.setEnabled(1);
		s.setPassword(Pss);
		s.setUsername(UN);
		s.setV_Code("000");
		usersservice.Insert(s);
		
		authorities a=new authorities();
		a.setAuthority("ROLE_USER");
		a.setUsername(UN);
		authoritiesservice.Insertauthorities(a);
		
		return modelAndView;
	}
		
		// return logout function
	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public ModelAndView Logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("Login");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		modelAndView.addObject("logout", "You Are Succesfully Loged Out :) ");
		System.out.println("-----------------------------");
		return modelAndView;
	}

	
	
	// Check V Code 
	@RequestMapping(value = "/Check")
	public ModelAndView Check(@RequestParam(value = "Vcode", required = false) String vcode) {

		ModelAndView modelAndView = new ModelAndView("Login");
		System.out.println(	vcode + "___________________________ ********************* _____________________________________");
	
		// update user enables status 
        users u =new users();
		u=usersservice.As(vcode);
if(u == null){
modelAndView.addObject("vcod","Mail Verhfication Doen Badlly You Can Not Log In Now Register First ... ");
}else{
	
	users ux =new users();
	ux.setEnabled(  1);
	ux.setPassword(	u.getPassword());
	ux.setUsername( u.getUsername());
	ux.setV_Code(   u.getV_Code());
	usersservice.Updatet(ux);

	modelAndView.addObject("vcod"," Mail Verhfication Doen Well You Can Log In Now ... ");
}
	
		return modelAndView;
	}
	
}