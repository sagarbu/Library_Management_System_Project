package library_pejm17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class BookCRUD {
	 
		
		public Connection getConnection()throws Exception
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_pejm17","root","sagar");
			return con;
		}
		
		
		 
		
		public void saveBook(Book book) throws Exception
		{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into book values(?,?,?,?,?)");
			ps.setInt(1, book.getId());
			ps.setString(2, book.getName());
			ps.setString(3,book.getAuthor());
			ps.setDouble(4,book.getPrice());
			ps.setString(5, book.getGenre());
			int count=ps.executeUpdate();
			if(count!=0)
			{
				System.out.println("Book is Saved");
			}
			else
			{
				System.out.println("Not Saved");
			}
			con.close();
					
		}
		public void viewAllBook(Book book )throws Exception
		{
			PreparedStatement ps=getConnection().prepareStatement("select * from book ");
			ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	System.out.println("BOOK ID:-"+rs.getInt(1));
		    	System.out.println("BOOK NAME:-"+rs.getString(2));
		    	System.out.println("AUTHOR NAME:-"+rs.getString(3));
		    	System.out.println("BOOK PRICE:-"+rs.getDouble(4));
		    	System.out.println("GENRE:-"+rs.getString(5));
		    	System.out.println("...........................................................");
		    	
		    }
		     
			
		}
		public void viewBookByID(int id )throws Exception
		{
			PreparedStatement ps=getConnection().prepareStatement("select * from book where id=?");
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
		    if(rs.next())
		    {
		    	System.out.println("BOOK ID:-"+rs.getInt(1));
		    	System.out.println("BOOK NAME:-"+rs.getString(2));
		    	System.out.println("AUTHOR NAME:-"+rs.getString(3));
		    	System.out.println("BOOK PRICE:-"+rs.getDouble(4));
		    	System.out.println("GENRE:-"+rs.getString(5));
		    	System.out.println("...........................................................");
		    	
		    }
		    else
		    {
		    	System.err.println("Book is not Found-Invalid ID");
		    }
			
		}
		public void viewBookByName(String name )throws Exception
		{
			PreparedStatement ps=getConnection().prepareStatement("select * from book where name=?");
			ps.setString(1,name);
			
			ResultSet rs=ps.executeQuery();
		   if(rs.next())
		    {
		    	System.out.println("BOOK ID:-"+rs.getInt(1));
		    	System.out.println("BOOK NAME:-"+rs.getString(2));
		    	System.out.println("AUTHOR NAME:-"+rs.getString(3));
		    	System.out.println("BOOK PRICE:-"+rs.getDouble(4));
		    	System.out.println("GENRE:-"+rs.getString(5));
		    	System.out.println("...........................................................");
		    	
		    }
		   else
		    {
		    	System.err.println("Book is not Found-Invalid Name");
		    }
	    }
		public void viewBookByGenre(String genre )throws Exception
		{
			PreparedStatement ps=getConnection().prepareStatement("select * from book where genre=?");
			ps.setString(1,genre);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				{
				System.out.println("BOOK ID:-"+rs.getInt(1));
		    	System.out.println("BOOK NAME:-"+rs.getString(2));
		    	System.out.println("AUTHOR NAME:-"+rs.getString(3));
		    	System.out.println("BOOK PRICE:-"+rs.getDouble(4));
		    	System.out.println("GENRE:-"+rs.getString(5));
		    	System.out.println("...........................................................");
		  while(rs.next())
		    {
		    	System.out.println("BOOK ID:-"+rs.getInt(1));
		    	System.out.println("BOOK NAME:-"+rs.getString(2));
		    	System.out.println("AUTHOR NAME:-"+rs.getString(3));
		    	System.out.println("BOOK PRICE:-"+rs.getDouble(4));
		    	System.out.println("GENRE:-"+rs.getString(5));
		    	System.out.println("...........................................................");
		    	
		    }
			}
			else
		    {
		    	System.err.println("Book is not Found-Invalid Genre");
		    }
		}
		public void viewBookByAuthor(String author )throws Exception
		{
			PreparedStatement ps=getConnection().prepareStatement("select * from book where author=?");
			ps.setString(1,author);
			
			ResultSet rs=ps.executeQuery();
		   if(rs.next())
		    {
		    	System.out.println("BOOK ID:-"+rs.getInt(1));
		    	System.out.println("BOOK NAME:-"+rs.getString(2));
		    	System.out.println("AUTHOR NAME:-"+rs.getString(3));
		    	System.out.println("BOOK PRICE:-"+rs.getDouble(4));
		    	System.out.println("GENRE:-"+rs.getString(5));
		    	System.out.println("...........................................................");
		    	
		    }
		   else
		    {
		    	System.err.println("Book is not Found-Invalid Author Name");
		    }
	    }
		
		public void viewBookByPrice(double price ,double price2)throws Exception
		{
			PreparedStatement ps=getConnection().prepareStatement("select * from book where price between ? and ?");
			ps.setDouble(1,price);
			ps.setDouble(2,price2);
			
			ResultSet rs=ps.executeQuery();
		   if(rs.next())
		    {
			   System.out.println("BOOK ID:-"+rs.getInt(1));
		    	System.out.println("BOOK NAME:-"+rs.getString(2));
		    	System.out.println("AUTHOR NAME:-"+rs.getString(3));
		    	System.out.println("BOOK PRICE:-"+rs.getDouble(4));
		    	System.out.println("GENRE:-"+rs.getString(5));
		    	System.out.println("...........................................................");
			   while(rs.next())
			   {
		    	System.out.println("BOOK ID:-"+rs.getInt(1));
		    	System.out.println("BOOK NAME:-"+rs.getString(2));
		    	System.out.println("AUTHOR NAME:-"+rs.getString(3));
		    	System.out.println("BOOK PRICE:-"+rs.getDouble(4));
		    	System.out.println("GENRE:-"+rs.getString(5));
		    	System.out.println("...........................................................");
			   }
		    	
		    }
		   else
		    {
		    	System.err.println("Book is not Found-Invalid price");
		    }
	    }
		public void deleteBookByID(int id )throws Exception
		{
			PreparedStatement ps=getConnection().prepareStatement("select * from book where id=?");
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
		    if(rs.next())
		    {
		    	PreparedStatement ps1=getConnection().prepareStatement("delete from book where id=?");
		    	ps1.setInt(1, id);
		    	ps1.execute();
		    	System.out.println("Book is deleted ");
		    	
		    }
		    else
		    {
		    	System.err.println("There is no such ID exist");
		    }
			
		}
		public void deleteBookByName(String name )throws Exception
		{
			PreparedStatement ps=getConnection().prepareStatement("Select * from book where name=?");
			ps.setString(1,name);
			
			ResultSet rs=ps.executeQuery();
			 if(rs.next())
			    {
				    PreparedStatement ps1=getConnection().prepareStatement("delete from book where name=?");
				    ps1.setString(1, name);
			    	ps1.execute();
			    	System.out.println("Book is deleted ");
			    	
			    }
			    else
		   
		    {
		    	System.err.println("There is no book available with such a name");
		    }
	    }
		public void deleteBookByGenre(String genre )throws Exception
		{
			PreparedStatement ps=getConnection().prepareStatement("select * from book where genre=?");
			ps.setString(1,genre);
			
			ResultSet rs=ps.executeQuery();
			 if(rs.next())
			    {   PreparedStatement ps1=getConnection().prepareStatement("delete from book where genre=?");
			        ps1.setString(1, genre);
			    	ps1.execute();
			    	System.out.println("Book is deleted ");
			    	
			    }
			   
			else
		    {
		    	System.err.println("There is Book available with this type of genre");
		    }
		}
		public void deleteBookByAuthor(String author )throws Exception
		{
			PreparedStatement ps=getConnection().prepareStatement("select* from book where author=?");
			ps.setString(1,author);
			
			ResultSet rs=ps.executeQuery();
			 if(rs.next())
			    {   PreparedStatement ps1=getConnection().prepareStatement("delete from book where author=?");
			        ps1.setString(1, author);
			    	ps.execute();
			    	System.out.println("Book is deleted ");
			    	
			    }
			   
		   else
		    {
		    	System.err.println("No book is available with such author name");
		    }
	    }
		public void updateBookID(Book book) throws Exception
		{
			PreparedStatement ps=getConnection().prepareStatement("select id from book where id=?");
			ps.setInt(1, book.getId());
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				PreparedStatement ps1=getConnection().prepareStatement("update book set name=?, author=?, price=?, genre=?  where id =?");
				ps1.setString(1,book.getName());
				ps1.setString(2, book.getAuthor());
				ps1.setDouble(3, book.getPrice());
				ps1.setString(4, book.getGenre());
				ps1.setInt(5, book.getId());
				
				ps1.executeUpdate();
				System.out.println("data is updated  ");
				
			}
			else
			{
				System.err.println("Invalid Id");
					
			}
		}
		public void updateBookByName(Book book) throws Exception
		{
			PreparedStatement ps=getConnection().prepareStatement("select name from book where name=?");
			ps.setInt(1, book.getId());
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				PreparedStatement ps1=getConnection().prepareStatement("update book set id=?, author=?, price=?, genre=?  where name =?");
				ps1.setInt(1, book.getId());
				ps1.setString(2, book.getAuthor());
				ps1.setDouble(3, book.getPrice());
				ps1.setString(4, book.getGenre());
				ps1.setString(5,book.getName());
				 
				ps1.executeUpdate();
				System.out.println("data is updated  ");
				
			}
			else
			{
				System.err.println("Invalid Name");
					
			}
			
		}
		public void updateBookByAuthor(Book book) throws Exception
		{
			PreparedStatement ps=getConnection().prepareStatement("select author from book where author=?");
			ps.setInt(1, book.getId());
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				PreparedStatement ps1=getConnection().prepareStatement("update book set id=?, name=?, price=?, genre=?  where author =?");
				ps1.setInt(1, book.getId());
				ps1.setString(2,book.getName());
				ps1.setDouble(3, book.getPrice());
				ps1.setString(4, book.getGenre());
				ps1.setString(5, book.getAuthor());
				 
				ps1.executeUpdate();
				System.out.println("data is updated  ");
				
			}
			else
			{
				System.err.println("Invalid Author Name");
					
			}
			
		}
		
		
		
		
}
