package com.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveNoteServlet
 */
public class SaveNoteServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
    // TODO Auto-generated method stub
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String content=req.getParameter("content");
			String title=req.getParameter("title");
			Note note=new Note(title, content, new Date());
			System.out.println(note.getId());
			System.out.println(note.getContent());
			//hibernate save
			Session s=FactoryProvider.getFactory().openSession();
Transaction tx=s.beginTransaction();
			s.save(note);
			tx.commit();
			s.close();
			resp.setContentType("text/html");
       PrintWriter out=resp.getWriter();
       out.println("<h1 style='text-align:center;'>Note is added successfully</h1>");
       out.println("<h1 style='text-align:center;'><a href='all_notes.jsp'>View All Notes</a></h1>");
		

	}

	}


