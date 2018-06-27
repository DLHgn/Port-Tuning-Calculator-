package porttuningcalculator;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Row1
{
    private TextField portAreaTxtFld;
    private TextField netVolumeTxtFld;

    /**
     * Sets up TextFields and their respective labels in the first row of the calculator parameters.
     *
     * @param grid
     */
    public void row1Set(GridPane grid)
    {
        //Fist entry box sets up the Port Area
        Label portArea = new Label("Port Cross Sectional Area:");
        portArea.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        grid.add(portArea, 0, 1);

        portAreaTxtFld = new TextField();
        grid.add(portAreaTxtFld, 1, 1);

        //Second entry box sets up the Net Box Volume
        Label netVolume = new Label("Net Box Volume:");
        netVolume.setFont(Font.font("Arial",FontWeight.NORMAL,12));
        grid.add(netVolume, 3,1);

        netVolumeTxtFld = new TextField();
        grid.add(netVolumeTxtFld, 4, 1);
    }

    /**
     * This method pulls the Port Area variable out of it's respective TextField
     *
     * @return Double value of the Port Area TextField
     */
    public Double getPortArea()
    {
        return Double.valueOf(portAreaTxtFld.getText());
    }

    /**
     * This method pulls the Net Volume variable out of it's respective TextField
     *
     * @return Double value of the Net Volume TextField
     */
    public Double getNetVolume()
    {
        return Double.valueOf(netVolumeTxtFld.getText());
    }

}
