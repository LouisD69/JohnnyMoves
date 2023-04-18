
public class JohnnyMovesDriver {

	public static void main(String[] args) {

		JohnnyMoves jm = new JohnnyMoves();
		JohnnyMovesGUI gui = new JohnnyMovesGUI();
		JohnnyMovesController controller = new JohnnyMovesController(jm, gui);
		
	}

}
