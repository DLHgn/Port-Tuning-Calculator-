package porttuningcalculator;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Row3
{
    private TextField portTuningTxtFld;
    private TextField numberOfPortsTxtFld;

    /**
     * Sets up TextFields and their respective labels in the third row of the calculator parameters.
     *
     * @param grid
     */
    public void row3Set(GridPane grid)
    {
        //First Entry sets the Port Tuning field
        Label portTuning = new Label("Port Tuning(Hz):");
        portTuning.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD,12));
        grid.add(portTuning, 0, 3);

        portTuningTxtFld = new TextField();
        portTuningTxtFld.setEditable(false);
        grid.add(portTuningTxtFld, 1, 3);

        //This entry sets the number of ports
        Label numberOfPorts = new Label ("Number of Ports:");
        numberOfPorts.setFont(Font.font("Arial",FontWeight.NORMAL,12));
        grid.add(numberOfPorts, 3,3);

        numberOfPortsTxtFld = new TextField("1");
        grid.add(numberOfPortsTxtFld, 4,3);
    }

    /**
     * This method pulls the Port Tuning variable out of it's respective TextField
     *
     * @return Double value of the Port Tuning TextField
     */
    public Double getPortTuning()
    {
        return Double.valueOf(portTuningTxtFld.getText());
    }

    /**
     * Sets the value of the Port Tuning TextField
     *
     * @param portTuning
     */
    public void setPortTuning(Double portTuning)
    {
        portTuningTxtFld.setText(String.valueOf(portTuning));
    }

    /**
     * This method pulls the Number of Ports variable out of it's respective TextField
     *
     * @return Integer value of the Number of Ports TextField
     */
    public Integer getNumberOfPorts()
    {
        return Integer.valueOf(numberOfPortsTxtFld.getText());
    }

}
