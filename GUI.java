import porttuningcalculator.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application
{
    /**
     * This method sets up the GUI for the calculator by calling functions needed to setup  the individual rows and
     * buttons. This method also assigns event handlers to their respective buttons.
     *
     * @param primaryStage Stage variable
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Port Tuning Calculator"); //Title of window

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(8); //sets gaps between rows
        grid.setVgap(8); //sets gaps between columns
        grid.setPadding(new Insets(25, 25, 25, 25)); //sets pad layer between grid and window

        Title t1 = new Title();
        t1.titleSetup(grid); //setup the calculator title

        Row1 r1 = new Row1();
        r1.row1Set(grid); //setup the first row

        //create the port area button
        Buttons pABtn = new Buttons();
        Button portAreaBtn = pABtn.portAreaBtnSetup(grid); //setup the port area button using buttons method
        ButtonEvent portAreaBtnEvent = new ButtonEvent();
        portAreaBtnEvent.portAreaEvent(portAreaBtn); //assign corresponding event handler to port area button

        //create the net volume button
        Buttons nVBtn = new Buttons();
        Button netVolumeBtn = nVBtn.netVolumeBtnSetup(grid); //setup the net volume button using buttons method
        ButtonEvent netVolumeBtnEvent = new ButtonEvent();
        netVolumeBtnEvent.netVolumeEvent(netVolumeBtn); //assign corresponding event handler to net volume button

        Row2 r2 = new Row2();
        r2.row2Set(grid); //setup the second row

        //create the port length button
        Buttons pLBtn = new Buttons();
        Button portLengthBtn = pLBtn.portLengthBtnSetup(grid); //setup the port length button using buttons method
        ButtonEvent portLengthBtnEvent = new ButtonEvent();
        portLengthBtnEvent.portLengthEvent(portLengthBtn); //assign corresponding event handler to port length button

        //create the end correction ComboBox
        Buttons eCBox = new Buttons();
        ComboBox endCorrectionBox = eCBox.endCorrectionBoxSetup(grid); //setup the end correction ComboBox using buttons method

        Row3 r3 = new Row3();
        r3.row3Set(grid); //setup the second row

        //create the submit button
        Buttons subBtn = new Buttons();
        Button submitBtn = subBtn.submitBtnSetup(grid); //setup the submit button using buttons method
        ButtonEvent submitBtnEvent = new ButtonEvent();
        submitBtnEvent.submitEvent(submitBtn, portAreaBtn, netVolumeBtn, portLengthBtn, endCorrectionBox,
                                   r1, r2, r3); //assign corresponding event handler to submit button

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
