package porttuningcalculator;


import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Row2
{
    private TextField portLengthTxtFld;


    /**
     * Sets up TextFields and their respective labels in the second row of the calculator parameters.
     *
     * @param grid
     */
    public void row2Set(GridPane grid)
    {
        //First entry sets up the Port Length
        Label portLength = new Label("Length of Port:");
        portLength.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        grid.add(portLength, 0, 2);

        portLengthTxtFld = new TextField();
        grid.add(portLengthTxtFld, 1, 2);


        //Second entry sets up the End Correction
        Label endCorrection = new Label("End Correction:");
        endCorrection.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        grid.add(endCorrection, 3,2);
    }

    /**
     * This method pulls the Port Length variable out of it's respective TextField
     *
     * @return Double value of the Port Length TextField
     */
    public Double getPortLength()
    {
        return Double.valueOf(portLengthTxtFld.getText());
    }

    /**
     * Returns the corresponding numerical value associated with the text selected
     *
     * This method translates the option selected in the ComboBox into it's corresponding numerical value
     *
     * 1 Common Wall = 1.23
     * 2 Common Walls = 1.728
     * 3 Common Walls = 2.227
     * One Flanged End = .732
     * Both Flanged Ends = .85
     * Both Free Ends = .614
     * Default = .823
     *
     * @param endCorrectionComboBox
     * @return Double value of the translated End Correction
     */
    public Double getEndCorrection(ComboBox endCorrectionComboBox)
    {
        Double endCorrectionDouble;
        String endCorrectionString = endCorrectionComboBox.getValue().toString();

        switch(endCorrectionString)
        {
            case "1 Common Wall":
                endCorrectionDouble = 1.23;
                break;
            case "2 Common Walls":
                endCorrectionDouble = 1.728;
                break;
            case "3 Common Walls":
                endCorrectionDouble = 2.227;
                break;
            case "One Flanged End":
                endCorrectionDouble = .732;
                break;
            case "Both Flanged Ends":
                endCorrectionDouble = .85;
                break;
            case "Both Free Ends":
                endCorrectionDouble = .614;
                break;
            default :
                endCorrectionDouble = .823;
                break;
        }

        return endCorrectionDouble;
    }
}
