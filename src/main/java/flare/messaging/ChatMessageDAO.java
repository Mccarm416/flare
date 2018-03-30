package flare.messaging;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import flare.data.FlareDB;
import flare.model.users.Student;


public class ChatMessageDAO {
	
	public static boolean insertMessage(ChatMessage message) {
		boolean check = false;
		//Inserts a ChatMessage to the database
		try{
			//Inserts a single course into the db
			Connection connection = FlareDB.startConnection();
			connection = FlareDB.startConnection();
			//Set the SQL variables
			
			String sql = "INSERT INTO table_messages(chat_id, from_user_id, to_user_id, message, message_time) VALUES " + "(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, message.getChatId());
			preparedStatement.setInt(2, message.getFromUserId());
			preparedStatement.setInt(3, message.getToUserId());
			preparedStatement.setString(4, message.getMessage());
			preparedStatement.setString(5, message.getMessageTime());
			preparedStatement.executeUpdate();
			System.out.println("Message Created");
			check = true;
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}
		
		return check;
	}
	
	public static ArrayList<ChatMessage> getChatMessages(int chatId) {
		ArrayList<ChatMessage> messages = new ArrayList<ChatMessage>();
		
		try {
			ResultSet results;
			Connection connection = FlareDB.startConnection();
			String sql = "SELECT * FROM table_messages WHERE chat_id = " + chatId;
			System.out.println("Running query...");
			Statement statement = connection.createStatement();
			results = statement.executeQuery(sql);
			//Check to see if anything has returned
			if (results != null) {
				//Add to messages while results has data
				while (results.next()) {
					ChatMessage message = new ChatMessage();
					message.setFromUserId(results.getInt("from_user_id"));
					message.setToUserId(results.getInt("to_user_id"));
					message.setMessage(results.getString("message"));
					message.setMessageTime(results.getString("message_time"));
					messages.add(message);
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}
		
		System.out.println("Returning messages with a size of: " + messages.size());
		return messages;
	}
	
	
	
	public static ArrayList<Chat> getActiveChats (int currentUserId) {
		ArrayList<Chat> activeChats = new ArrayList<Chat>();
		try {
			ResultSet results;
			System.out.println("Creating connection...");
			Connection connection = FlareDB.startConnection();
			String sql = "SELECT * FROM table_chat WHERE user_1_id = " + currentUserId;
			System.out.println("Running query...");
			Statement statement = connection.createStatement();
			results = statement.executeQuery(sql);
			//Check to see if anything has returned
			if (results != null) {
				//Add to messages while results has data
				while (results.next()) {
					Chat chat = new Chat();
					chat.setChatId(results.getInt("chat_id"));
					chat.setUser1Id(results.getInt("user_1_id"));
					chat.setUser2Id(results.getInt("user_2_id"));
					chat.setTotalMessages(results.getInt("total_messages"));
					activeChats.add(chat);
				}
			}
			//Check column 2
			sql = "SELECT * FROM table_chat WHERE user_2_id = " + currentUserId;
			System.out.println("Running query...");
			statement = connection.createStatement();
			results = statement.executeQuery(sql);
			//Check to see if anything has returned
			if (results != null) {
				//Add to messages while results has data
				while (results.next()) {
					Chat chat = new Chat();
					chat.setChatId(results.getInt("chat_id"));
					chat.setUser1Id(results.getInt("user_1_id"));
					chat.setUser2Id(results.getInt("user_2_id"));
					chat.setTotalMessages(results.getInt("total_messages"));
					activeChats.add(chat);
				}
			}
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}
		
		System.out.println("Returning activeChats with a size of: " + activeChats.size());
		return activeChats;
	}
	
	public static Chat getChatWithUserIds (int userId1, int userId2) {
		try {
			ResultSet results;
			System.out.println("Creating connection...");
			Connection connection = FlareDB.startConnection();
			String sql = "SELECT * FROM table_chat WHERE user_1_id = " + userId1;
			System.out.println("Running query...");
			Statement statement = connection.createStatement();
			results = statement.executeQuery(sql);
			//Check to see if anything has returned
			if (results != null) {
				//Add to messages while results has data
				while (results.next()) {
					if (results.getInt("user_2_id") == userId2) {
						Chat chat = new Chat();
						chat.setChatId(results.getInt("chat_id"));
						chat.setUser1Id(results.getInt("user_1_id"));
						chat.setUser2Id(results.getInt("user_2_id"));
						chat.setTotalMessages(results.getInt("total_messages"));
						return chat;
					}
				}
			}
			//Check column 2
			sql = "SELECT * FROM table_chat WHERE user_2_id = " + userId1;
			System.out.println("Running query...");
			statement = connection.createStatement();
			results = statement.executeQuery(sql);
			//Check to see if anything has returned
			if (results != null) {
				//Add to messages while results has data
				while (results.next()) {
					if (results.getInt("user_1_id") == userId2) {
						Chat chat = new Chat();
						chat.setChatId(results.getInt("chat_id"));
						chat.setUser1Id(results.getInt("user_1_id"));
						chat.setUser2Id(results.getInt("user_2_id"));
						chat.setTotalMessages(results.getInt("total_messages"));
						return chat;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}
		return null;
	}
	
	public static Student searchUserId(int userId) {
		Student user = null;
		try {
			ResultSet results;
			System.out.println("Creating connection...");
			Connection connection = FlareDB.startConnection();
			String sql = "SELECT * FROM table_user WHERE user_id = " + userId;
			System.out.println("Running query...");
			Statement statement = connection.createStatement();
			results = statement.executeQuery(sql);
			//Check to see if anything has returned
			if (results != null) {
				//Add to messages while results has data
				while (results.next()) {
					user = new Student();
					user.setUserId(results.getInt("user_id"));
					user.setUsername(results.getString("userName"));
				}
			}
			else {
				return user;
			}
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}
		
		System.out.println("Returning user - " + user.getUserId() + ":" + user.getUsername());
		return user;
	}
	
	public static Student searchUsername(String username) {
		Student user = null;
		try {
			ResultSet results;
			System.out.println("Creating connection...");
			Connection connection = FlareDB.startConnection();
			String sql = "SELECT * FROM table_user WHERE userName = '" + username + "'";
			System.out.println("Running query...");
			Statement statement = connection.createStatement();
			results = statement.executeQuery(sql);
			//Check to see if anything has returned
			if (results != null) {
				//Add to messages while results has data
				while (results.next()) {
					user = new Student();
					user.setUserId(results.getInt("user_id"));
					user.setUsername(results.getString("userName"));
				}
			}
			else {
				return user;
			}
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}
		return user;
	}
	
	public static boolean insertChat(Student user1, Student user2) {
		boolean check = false;
		//Inserts a ChatMessage to the database
		try{
			//Inserts a single course into the db
			Connection connection = FlareDB.startConnection();
			System.out.println("Creating connection for ChatMessage insert...");
			connection = FlareDB.startConnection();
			//Set the SQL variables
			String sql = "INSERT INTO table_chat(user_1_id, user_2_id, total_messages) VALUES " + "(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user1.getUserId());
			preparedStatement.setInt(2, user2.getUserId());
			preparedStatement.setInt(3, 0);
			preparedStatement.executeUpdate();
			System.out.println("Chat Created");
			check = true;
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e);
		}
		
		return check;
	}

}
