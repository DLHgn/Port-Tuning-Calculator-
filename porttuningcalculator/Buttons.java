package porttuningcalculator;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Buttons
{
    /**
     * Returns a Button object that can be assigned to a ButtonEvent method
     *
     * This method creates a new button with the Label "Submit" and located at Column 1, Row 4 (BOTTOM_RIGHT aligned)
     *
     * @param grid
     * @return submitBtn Button Object
     */
    public Button submitBtnSetup(GridPane grid)
    {
        Button submitBtn = new Button("Submit");
        HBox submitHBBtn = new HBox(10);
        submitHBBtn.setAlignment(Pos.BOTTOM_RIGHT);
        submitHBBtn.getChildren().add(submitBtn);
        grid.add(submitHBBtn, 1, 4);

        return submitBtn;
    }

    /**
     * Returns a Button object that can be assigned to a ButtonEvent method
     *
     * This method creates a new button with the Label "in^2" and located at Column 2, Row 1 (CENTER_LEFT aligned)
     *
     * @param grid
     * @return portAreaBtn Button Object
     */
    public Button portAreaBtnSetup(GridPane grid)
    {
        Button portAreaBtn = new Button("in^2");
        HBox portAreaHBBtn = new HBox(10);
        portAreaHBBtn.setAlignment(Pos.CENTER_LEFT);
        portAreaHBBtn.getChildren().add(portAreaBtn);
        grid.add(portAreaHBBtn, 2, 1);

        return portAreaBtn;
    }

    /**
     *  Returns a Button object that can be assigned to a ButtonEvent method
     *
     *  This method creates a new button with the Label "in^3" and located at Column 5, Row 1 (CENTER_LEFT aligned)
     *
     * @param grid
     * @return netVolumeBtn Button Object
     */
    public Button netVolumeBtnSetup(GridPane grid)
    {
        Button netVolumeBtn = new Button("in^3");
        HBox netVolumeHBBtn = new HBox(10);
        netVolumeHBBtn.setAlignment(Pos.CENTER_LEFT);
        netVolumeHBBtn.getChildren().add(netVolumeBtn);
        grid.add(netVolumeHBBtn, 5, 1);

        return netVolumeBtn;
    }

    /**
     * Returns a Button object that can be assigned to a ButtonEvent method
     *
     * This method creates a new button with the Label "in" and located at Column 2, Row 2 (CENTER_LEFT aligned)
     *
     * @param grid
     * @return portLengthBtn Button Object
     */
    public Button portLengthBtnSetup(GridPane grid)
    {
        Button portLengthBtn = new Button("in");
        HBox portLengthHBBtn = new HBox(10);
        portLengthHBBtn.setAlignment(Pos.CENTER_LEFT);
        portLengthHBBtn.getChildren().add(portLengthBtn);
        grid.add(portLengthHBBtn, 2, 2);

        return portLengthBtn;
    }

    /**
     * Returns a ComboBox object that can be assigned to a ComboBox variable
     *
     * This method creates a new button with the default Label "3 Common Walls".
     *
     * Other options include:
     * 1 Common Wall
     * 2 Common Walls
     * One Flanged End
     * Both Flanged Ends
     * Both Free Ends
     *
     * Only 3 options are shown in the box at once.
     *
     * Box is at location Column 4, Row 2
     *
     * @param grid
     * @return endCorrectionBox ComboBox Object
     */
    public ComboBox endCorrectionBoxSetup(GridPane grid)
    {
        ObservableList<String> endCorrections =
                FXCollections.observableArrayList(
                        "1 Common Wall",
                        "2 Common Walls",
                        "3 Common Walls",
                        "One Flanged End",
                        "Both Flanged Ends",
                        "Both Free Ends"
                );
        ComboBox endCorrectionBox = new ComboBox(endCorrections);
        endCorrectionBox.setValue("3 Common Walls"); //set defualt option in CombBox to "3 Common Walls"
        endCorrectionBox.setVisibleRowCount(3); //set the number of visible rows to 3


        grid.add(endCorrectionBox, 4,2);

        return endCorrectionBox;
    }

}

