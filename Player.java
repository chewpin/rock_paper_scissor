package helloworld;

import java.util.Random;
import java.util.Scanner;

public class Player {
	private int hand = 0;
	private int win = 0;
	private int lose = 0;
	private int equal = 0;
	
	Player() {
		hand = win = lose = equal = 0;
	}
	public int get_hand() {
		return hand;
	}
	public int get_win() {
		return win;
	}
	public int get_lose() {
		return lose;
	}
	public int get_equal() {
		return equal;
	}
	public void set_hand (int input) { hand = input; }
	public void set_win_or_lose (int input) {
        if ( input == 0 ) win++;
        else if ( input == 1 ) lose++;
        else if ( input == 2 ) equal++;
        else { System.out.print("set_win_or_lose input exceeds range [0,2]\n"); System.exit(1);}
    }
	public void computer_play (Player user) {
		Random generator = new Random();
        int rand_num = generator.nextInt(10);
        //System.out.print("用户出 " + user.get_hand() + ", 电脑rand出 " + rand_num + "\n");
        if ( rand_num >= 0 && rand_num <= 2 ) hand = (0 + user.get_hand()) % 3; // user loses
        else if ( rand_num >= 3 && rand_num <= 5 ) hand = (1 + user.get_hand()) % 3; // user equals
        else if ( rand_num >= 6 && rand_num <= 9 ) hand = (2 + user.get_hand()) % 3; // user wins
        else { System.out.print("rand_num exceeds range [0,9]\n"); System.exit(1);}
    }
	public void auto_play() { 
		Random generator = new Random();
		hand = generator.nextInt(3); 
	}
	public void user_play () {
		Scanner in = new Scanner(System.in);
        System.out.println("Please enter your next hand: Just enter 'rock', 'paper', 'scissor', or 'r', 'p', 's', or 0 for rock, 1 for paper, 2 for scissor\n");
        String input = in.nextLine();
        if ( input.charAt(0) - 48 == 0 || (input.charAt(0) == 'r'&&input.length()==1) || input.equals("rock") ) { hand = 0; } // rock
        else if ( input.charAt(0) - 48 == 1 || (input.charAt(0) == 'p'&&input.length()==1) || input.equals("paper") ) { hand = 1; } // paper
        else if ( input.charAt(0) - 48 == 2 || (input.charAt(0) == 's'&&input.length()==1) || input.equals("scissor") ) { hand = 2; } // scissor
        else { System.out.print("User input format error\n"); user_play(); } // try again
    }
	public boolean user_progress() {
		Scanner in = new Scanner(System.in);
        System.out.print("Continue? 'y' for yes and 'n' for no\n");
        String input = in.nextLine();
        System.out.println(input);
        if ( input.equals("y") ) return true;
        else if ( input.equals("n") ) return false;
        else { System.out.print("user continue input wrong format\n"); return user_progress(); } // try again
    }
}
