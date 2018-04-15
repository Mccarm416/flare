package flare.messaging;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import flare.dataaccess.FlareDB;
import flare.model.users.Student;
import flare.model.users.User;

//Manages data access for the chat feature and all of it's classes
public class ChatMessageDAO {
	
	//Inserts a ChatMessage into the database
	public static boolean insertMessage(ChatMessage message) {
		boolean check = false;
		System.out.println("--- ChatMessagesDAO.insertMessage() called ---");
		try{
			JdbcTemplate jdbc = FlareDB.getJdbc();
			
			//Set the SQL variables
			String sql = String.format("INSERT INTO table_messages(chat_id, from_user_id, to_user_id, message, message_time) VALUES " + "(%1$s, %2$s, '%3$s', '%4$s', '%5$s')", 
					message.getChatId(), message.getFromUserId(), message.getToUserId(), message.getMessage(), message.getMessageTime());
			System.out.println("[Executing SQL]:" + sql);
			jdbc.update(sql);
			System.out.println("Message Created!");
			
			check = true;
		} catch (Exception e) {
			System.out.println("*** Error! ***!");
			e.printStackTrace();
		}
		
		return check;
	}
	
	//Inserts a Chat into the database
	public static boolean insertChat(User currentUser, Student user2) {
		System.out.println("--- ChatMessagesDAO.insertChat() called ---");
		boolean check = false;
		try{
			//Inserts a single course into the db
			JdbcTemplate jdbc = FlareDB.getJdbc();
			//Set the SQL variables
			String sql = String.format("INSERT INTO table_chat(user_1_id, user_2_id, total_messages) VALUES " + "(%1$s, %2$s, %3$s)", 
					currentUser.getUserId(), user2.getUserId(), 0);
			System.out.println("[Executing SQL]:" + sql);
			jdbc.update(sql);
			System.out.println("Chat Created! user_1_id =" + currentUser.getUserId() + "/ user_2_id = " + user2.getUserId() );
			check = true;
		} catch (Exception e) {
			System.out.println("*** Error! ***!");
			e.printStackTrace();
		}
		
		return check;
	}
	//Used to provide a list of ChatMessages of a given chatroom
	public static List<ChatMessage> getChatMessages(int chatId) {
		List<ChatMessage> messages = new ArrayList<ChatMessage>();
		System.out.println("--- ChatMessagesDAO.getChatMessages() called ---");
		
		try {
			JdbcTemplate jdbc = FlareDB.getJdbc();
			
			String sql = "SELECT * FROM table_messages WHERE chat_id = " + chatId;
			System.out.println("[Executing SQL]:" + sql);
		    messages = jdbc.query(sql, new ResultSetExtractor<List<ChatMessage>>(){
		        public List<ChatMessage> extractData(ResultSet results) throws SQLException, DataAccessException {
		            List<ChatMessage> dataList = new ArrayList<ChatMessage>();
		            while(results.next()) {
						ChatMessage message = new ChatMessage();
						message.setFromUserId(results.getInt("from_user_id"));
						message.setToUserId(results.getInt("to_user_id"));
						message.setMessage(results.getString("message"));
						message.setMessageTime(results.getString("message_time"));
		                dataList.add(message);
		            }
		            return dataList;
        		}
	        });   
		} catch (Exception e) {
			System.out.println("*** Error! ***!");
			e.printStackTrace();
		}
		
		System.out.println("Returning messages with a size of: " + messages.size());
		return messages;
	}

	//Used to provide a list of chats that a single user has open
	public static List<Chat> getActiveChats (int currentUserId) {
		System.out.println("--- ChatMessagesDAO.getActiveChats() called ---");

		List<Chat> activeChats = new ArrayList<Chat>();
		try {
			JdbcTemplate jdbc = FlareDB.getJdbc();
			
			//Check user_1_id for matching id
			String sql = "SELECT * FROM table_chat WHERE user_1_id = " + currentUserId;
			System.out.println("[Executing SQL]:" + sql);
			List<Chat> chatList1 = jdbc.query(sql, new ResultSetExtractor<List<Chat>>(){
		        public List<Chat> extractData(ResultSet results) throws SQLException, DataAccessException {
			            List<Chat> dataList = new ArrayList<Chat>();
			            while(results.next()) {
			            	Chat chat = new Chat();
			            	chat.setChatId(results.getInt("chat_id"));
			            	chat.setUser1Id(results.getInt("user_1_id"));
			            	chat.setUser2Id(results.getInt("user_2_id"));
			            	chat.setTotalMessages(results.getInt("total_messages"));
							System.out.println("Chat found! ID = " + chat.getChatId());
			                dataList.add(chat);
			            }
			            return dataList;
        			}
				});  
			//Check user_2_id for matching id
			sql = "SELECT * FROM table_chat WHERE user_2_id = " + currentUserId;
			System.out.println("[Executing SQL]:" + sql);
		    List<Chat> chatList2 = jdbc.query(sql, new ResultSetExtractor<List<Chat>>(){
		    	public List<Chat> extractData(ResultSet results) throws SQLException, DataAccessException {
		    		List<Chat> dataList = new ArrayList<Chat>();
		            while(results.next()) {
		            	Chat chat = new Chat();
		            	chat.setChatId(results.getInt("chat_id"));
		            	chat.setUser1Id(results.getInt("user_1_id"));
		            	chat.setUser2Id(results.getInt("user_2_id"));
		            	chat.setTotalMessages(results.getInt("total_messages"));
						System.out.println("Chat found! ID = " + chat.getChatId());
		                dataList.add(chat);
		            }
		            return dataList;
        		}
		    });
		    
		    //Merge the lists
		    if(chatList1 != null && chatList2 != null) {
		    	activeChats.addAll(chatList1);
		    	activeChats.addAll(chatList2);
		    }
		    else if (chatList1 != null) {
		    	return chatList1;
		    }
		    else {
		    	return chatList2;
		    }
		    
		} catch (Exception e) {
			System.out.println("*** Error! ***!");
			e.printStackTrace();
		}
		
		System.out.println("Returning activeChats with a size of: " + activeChats.size());
		return activeChats;
	}

	//Used to provide chatroom.jsp with the proper chatroom
	public static Chat getChatWithUserIds (int userId1, int userId2) {
		System.out.println("--- ChatMessagesDAO.getChatWithUserIds() called ---");
		Chat chat = null;
		try {
			//Check the first column of users for a matching userId
			JdbcTemplate jdbc = FlareDB.getJdbc();
			String sql = "SELECT * FROM table_chat WHERE user_1_id = " + userId1;
			System.out.println("[Executing SQL]:" + sql);
			chat = jdbc.query(sql, new ResultSetExtractor<Chat>(){
				public Chat extractData(ResultSet results) throws SQLException, DataAccessException {
	            	Chat chat = null;
		            while(results.next()) {
		            	if (results.getInt("user_2_id") == userId2) {
			            	chat = new Chat();
							chat.setChatId(results.getInt("chat_id"));
							chat.setUser1Id(results.getInt("user_1_id"));
							chat.setUser2Id(results.getInt("user_2_id"));
							chat.setTotalMessages(results.getInt("total_messages"));
							System.out.println("Chat found! ID = " + chat.getChatId());
			            }
		            }
		            return chat;
				}
			});
			
			//Check to see if a chatId was pulled and returns it if it did
			if (chat!= null) {
				 return chat;
			 }
					
			//Check column 2
			sql = "SELECT * FROM table_chat WHERE user_2_id = " + userId1;
			System.out.println("[Executing SQL]:" + sql);
			//Check to see if anything has returned
			chat = jdbc.query(sql, new ResultSetExtractor<Chat>(){
			public Chat extractData(ResultSet results) throws SQLException, DataAccessException {
	            	Chat chat = null;
		            while(results.next()) {
		            	if (results.getInt("user_1_id") == userId2) {
			            	chat = new Chat();
							chat.setChatId(results.getInt("chat_id"));
							chat.setUser1Id(results.getInt("user_1_id"));
							chat.setUser2Id(results.getInt("user_2_id"));
							chat.setTotalMessages(results.getInt("total_messages"));
							System.out.println("Chat found! ID = " + chat.getChatId());
			            }
		            }
		            return chat;
				}
			});
			return chat;
		} catch (Exception e) {
			System.out.println("*** Error! ***!");
			e.printStackTrace();
		}
		return chat;
	}
	

}
