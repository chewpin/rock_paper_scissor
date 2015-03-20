package helloworld;

public class test {
	public static void main(String[] argv){
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
	            game.play_round();
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
