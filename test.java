package helloworld;

// for SQL
/*import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;
import java.util.Vector;
import java.sql.PreparedStatement;*/


public class test {
	public static void main(String[] argv){
		// for SQL
		/*Connection oracleConnection = null;
		oracleConnection = c; // c is the oracle connection
		ResultSet rst_create = null, rst_insert = null; 
		PreparedStatement insert_round = null, create_table = null;
		String create_table_sql = "CREATE TABLE Rounds(table_round_id NUMBER(11) PRIMARY KEY, "
				+ "table_user_hand VARCHAR2(100) NOT NUll, table_computer_hand VARCHAR2(100) NOT NULL,"
				+ " table_win_or_lose_or_equal NUMBER(11) NOT NULL)";
	    create_table_stmt = oracleConnection.prepareStatement(create_table_sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	    // create_table_stmt is the query that will run
	    rst_create = create_table_stmt.executeQuery();*/
		
		System.out.print("Welcome to rock, paper, and scissors\n");
	    boolean test = false; // set to true to debug and test
	    Player user = new Player(), computer = new Player();
	    Game game = new Game(user, computer);
	    int count = 0;
	    if ( !test ) {
	        while ( true ) {
	            user.user_play();
	            computer.computer_play(user);
	            game.update(user, computer);
	            int win_or_lose_or_equal = game.play_round();
	            
	            // for SQL
	            /*int user_hand = user.get_hand(), computer_hand = computer.get_hand(); // used for sql statement below
	            String insert_round_sql = "INSERT INTO Rounds(table_round_id, table_user_hand, table_computer_hand, table_win_or_lose_or_equal) "
	            		+ "VALUES (" + count + ", " + user_hand + ", " + computer_hand + ", " + win_or_lose_or_equal + ")";
	    		insert_round_stmt = oracleConnection.prepareStatement(insert_round_sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	    		// insert_round_stmt is the query that will run
	    		rst_insert = insert_round_stmt.executeQuery();*/
	    		
	            game.print_round();
	            game.print();
	            if ( !user.user_progress() ) {
	                break;
	            }
	        }
	    }
	    else { // auto test 1000000 rounds to test if success rate is close to 40%
	        while ( true && count < 100000 ) {
	            user.auto_play();
	            computer.computer_play(user);
	            game.update(user, computer);
	            game.play_round();
	            //game.print_round();
	            //game.print();
	            count++;
	        }
	        game.print();
	    }
	    System.out.print("Game over, thank you for playing!\n"); 
	}
}
