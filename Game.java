package helloworld;

public class Game {
	private Player user, computer;
	private int round_id = 0;
	
	public void update (Player userr, Player computerr){
        user.set_hand(userr.get_hand());
        computer.set_hand(computerr.get_hand());
    }
	Game(Player userr, Player computerr) {
		user = userr; 
		computer = computerr;
		round_id = 0;
	}
	public void play_round () {
        int win_or_lose_or_equal = -1;
        if ( (user.get_hand() == 0 && computer.get_hand() == 1) || (user.get_hand() == 1 && computer.get_hand() == 2) || (user.get_hand() == 2 && computer.get_hand() == 0) ) { // rock-paper or paper-scissor or scissor-rock: user loses
            user.set_win_or_lose(1);
            computer.set_win_or_lose(0);
            win_or_lose_or_equal = 1;
        }
        else if ( user.get_hand() == computer.get_hand() ) { // equal
            user.set_win_or_lose(2);
            computer.set_win_or_lose(2);
            win_or_lose_or_equal = 2;
        }
        else if ( (user.get_hand() == 1 && computer.get_hand() == 0) || (user.get_hand() == 2 && computer.get_hand() == 1) || (user.get_hand() == 0 && computer.get_hand() == 2) ) { // paper-rock or scissor-paper or rock-scissor: user wins
            user.set_win_or_lose(0);
            computer.set_win_or_lose(1);
            win_or_lose_or_equal = 0;
        }
        //int user_hand = user.get_hand(), computer_hand = computer.get_hand(); // used for sql statement below
        //stmt->execute("INSERT INTO Rounds(table_round_id, table_user_hand, table_computer_hand, table_win_or_lose_or_equal) VALUES (game_round_id, user_hand, computer_hand, win_or_lose_or_equal)");
        round_id++;
    }
	public void print_round () {
        System.out.print("user hand: ");
        if (user.get_hand() == 0) System.out.print("rock");
        else if (user.get_hand() == 1) System.out.print("paper");
        else if (user.get_hand() == 2) System.out.print("scissor");
        else { System.out.print("user hand neither 0 nor 1 nor 2 error\n"); System.exit(1);}
        System.out.print(", computer hand: ");
        if (computer.get_hand() == 0) System.out.print("rock");
        else if (computer.get_hand() == 1) System.out.print("paper");
        else if (computer.get_hand() == 2) System.out.print("scissor");
        else { System.out.print("computer hand neither 0 nor 1 nor 2 error\n"); System.exit(1);}
        System.out.print("\n");
    }
	public void print () {
		System.out.print("user wins " + user.get_win() + " rounds, loses " + user.get_lose() + " rounds, equals " + user.get_equal() + " rounds\n");
        //cout <<  "computer wins " << computer.get_win() << " rounds, loses " << computer.get_lose() << " rounds, equals " << computer.get_equal() << " rounds\n";
		int win_rate = user.get_win() * 100 / (user.get_win() + user.get_lose() + user.get_equal());
		System.out.print("user win rate: " + win_rate + " %\n");
    }
	
}
