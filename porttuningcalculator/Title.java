package porttuningcalculator;


import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Title
{
    /**
     * This method sets up the Title for the calculator. Title reads "Port Tuning" at location Column 0, Row 0
     * Spanning 2 columns and 1 row
     * @param grid
     */
    public void titleSetup(GridPane grid)
    {
        Text firstCalcTitle = new Text("Port Tuning");
        firstCalcTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        grid.add(firstCalcTitle, 0, 0, 2, 1);
    }
}
