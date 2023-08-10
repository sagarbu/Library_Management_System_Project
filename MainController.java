package library_pejm17;

import java.util.Scanner;

public class MainController {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		
		Book book=new Book();
		BookCRUD crud=new BookCRUD();
		
		 
		System.out.println(".....WELCOME ADMIN.....");
		while(true)
		{
		System.out.println("Enter the choice\n1.Add Book\n2.View Book\n3.View All Book \n4.Delete Book \n5.Update the Book ");
	 
 
		int choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:{
			System.out.println("Enter the id");
			int id=sc.nextInt();
			System.out.println("Enter the name");
			String name=sc.next();
			System.out.println("Enter author name");
			String author=sc.next();
			System.out.println("Enter the price");
			double price=sc.nextDouble();
			System.out.println("Enter the Genre");
			String genre=sc.next();
			
			book.setId(id);
			book.setName(name);
			book.setAuthor(author);
			book.setPrice(price);
			book.setGenre(genre);
			
			crud.saveBook(book);
			break;
			
			
		}
		case 2:
		{
			
			System.out.println("1.View Book By ID\n2.View Book By Name\n3.View Book By Genre\n4.View Book By Author Name\n5.View  Book By Price Range\n6.Back To Main Options");
			int choice1=sc.nextInt();
			switch(choice1)
			{
		case 1: 
			{
				System.out.println("Enter Id");
			    int id=sc.nextInt();
		        book.setId(id);
	      	    crud.viewBookByID(id);
		        break;
			}
		case 2:
		   {

			 System.out.println("Enter Book Name");
			String name=sc.next();
			book.setName(name);
			crud.viewBookByName(name);
			break;
		    }
		case 3:
		{
			System.out.println("Enter Genre");
			String genre=sc.next();
			book.setGenre(genre);
			crud.viewBookByGenre(genre);
			break;
		}
		case 4:
		{
			System.out.println("Enter Author Name");
			String author=sc.next();
			book.setAuthor(author);
			crud.viewBookByAuthor(author);
			break;
					
		}
		case 5:
		{
			System.out.println("Enter the Price Range ");
			int price1=sc.nextInt();
			System.out.println("To");
			int price2=sc.nextInt();
			book.setPrice(price1);
			crud.viewBookByPrice(price1,price2);
			break;
			
		}
		case 6:{break;}
	 
		}
			break;
		}
		case 3:
		{
			crud.viewAllBook(book);
		}
		case 4:
		{
			System.out.println("1.Delete Book By ID\n2.Delete Book By Name\n3.Delete Book By Author Name\n4.Delete Book By Genre\n5.Back To Main Options");
			int choice2=sc.nextInt();
			switch(choice2)
			{

		
		    case 1:
		   {
			    System.out.println("Enter Id");
			    int id=sc.nextInt();
			    book.setId(id);
			    crud.deleteBookByID(id);
			    break;
		   }
		   case 2:
		   {
			    System.out.println("Enter Book Name");
			    String name=sc.next();
			    book.setName(name);
			    crud.deleteBookByName(name);
			    break;
		   }
		  case 3:
		   {
			   System.out.println("Enter Author Name");
			   String author=sc.next();
		       book.setAuthor(author);
			   crud.deleteBookByAuthor(author);
			   break;
		   }
		 case 4:
		   {
			  System.out.println("Enter Genre");
			  String genre=sc.next();
			  book.setGenre(genre);
			  crud.deleteBookByGenre(genre);
			  break;
		   }
		 case 5:{break;}
			}
		break;
		}
		case 5:
		{
			System.out.println("1.Update Book By ID \n2.Update Book By Name \n3.Update Book by Author Name\n4.Update Only Selected Column");
			int choice3=sc.nextInt();
			switch(choice3)
			{
			case 1:
			{
			    System.out.println("Enter  ID   ");
			    int id=sc.nextInt();
			    System.out.println("....Enter data to update....");
			    System.out.println("Enter Book name");
			 	String name=sc.next();
			 	System.out.println("Enter Author name");
			 	String author=sc.next();
			 	System.out.println("Enter genre");
			 	String genre=sc.next();
			 	System.out.println("Enter Book price");
			 	double price=sc.nextDouble();
			    book.setId(id);
		     	book.setName(name);
		    	book.setGenre(genre);
			    book.setAuthor(author);
			    book.setPrice(price);
			 
			   crud.updateBookID( book);
			   break;
			}
			case 2:
			{
		        System.out.println("Enter Book name");
			 	String name=sc.next();
			 	System.out.println("....Enter data to update....");
			 	System.out.println("Enter  ID ");
			    int id=sc.nextInt();
			 	System.out.println("Enter Author name");
			 	String author=sc.next();
			 	System.out.println("Enter genre");
			 	String genre=sc.next();
			 	System.out.println("Enter Book price");
			 	double price=sc.nextDouble();
			    book.setId(id);
		     	book.setName(name);
		    	book.setGenre(genre);
			    book.setAuthor(author);
			    book.setPrice(price);
			 
			   crud.updateBookByName( book);
			   break;	
			}
			case 3:
			{
				System.out.println("Enter Author name");
			 	String author=sc.next();
			 	System.out.println("....Enter data to update....");
			 	System.out.println("Enter  ID ");
			    int id=sc.nextInt();
			    System.out.println("Enter Book name");
			 	String name=sc.next();	 
			 	System.out.println("Enter genre");
			 	String genre=sc.next();
			 	System.out.println("Enter Book price");
			 	double price=sc.nextDouble();
			    book.setId(id);
		     	book.setName(name);
		    	book.setGenre(genre);
			    book.setAuthor(author);
			    book.setPrice(price);
			 
			   crud.updateBookByAuthor( book);
			   break;	
			}
			case 4:
			{
				System.out.println("1.Update Book Name By Id\n2.Update Author Name By ID\n3.Update Genre By ID\n4.Update Price By ID");
				int ip=sc.nextInt();
				break;
			}
			}
		 break;
		}
	
		
		
	}

		}
	}
}

