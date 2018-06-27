package porttuningcalculator;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ButtonEvent
{
    /**
     * This method handles the bulk of the program mathematical process. On the event that the submit button is pressed,
     * the variables present in the available TextFields and ComboBox are taken in, converted to their necessary units
     * and then loaded into 2 equations used to calculate port tuning. The results of the two equations is then averaged
     * for the closest real world port tuning.
     *
     * @param submitBtn Button object associated with the Submit Button
     * @param portAreaBtn Button object associated with the Port Area variable
     * @param netVolumeBtn Button object associated with the Net Volume variable
     * @param portLengthBtn Button object associated with the Port Length variable
     * @param endCorrectionBox ComboBox object associate with the End Correction Variable
     * @param r1 Row1 object used to setup the first row of the calculator
     * @param r2 Row2 object used to setup the second row of the calculator
     * @param r3 Row3 object used to setup the third row of the calculator
     * @see Buttons
     * @see Row1 #row1Set
     * @see Row2 #row2Set
     * @see Row3 #row3Set
     */
    public void submitEvent(Button submitBtn, Button portAreaBtn, Button netVolumeBtn, Button portLengthBtn,
                            ComboBox endCorrectionBox, Row1 r1, Row2 r2, Row3 r3)
    {
        submitBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                Convert pD = new Convert();
                Convert nV2 = new Convert();
                Convert pL2 = new Convert();

                Double portArea;
                Double netVolume;
                Double portLength;
                //retrieve the numerical value of end correction
                Double endCorrection = r2.getEndCorrection(endCorrectionBox);
                //portDiameter always needs to be called on a given port area.
                Double portDiameter = pD.convertPortDiameter(r1.getPortArea(),portAreaBtn);
                //if Net Volume needs to be converted to L for equation 2, it will be done here
                Double netVolume2 = nV2.convertNetVolume2(r1.getNetVolume(), netVolumeBtn);
                //if Port Length needs to be converted to cm for equation 2, it will be done here
                Double portLength2 = pL2.convertPortLength2(r2.getPortLength(), portLengthBtn);
                //retrieve value of number of ports from TextField
                Integer numberOfPorts = r3.getNumberOfPorts();

                if(!portAreaBtn.getText().equals("in^2")) //if Port Area Button doesn't read in^2
                {
                    Convert pA = new Convert();
                    portArea = pA.convertPortArea(r1.getPortArea(), portAreaBtn); //convert from given unit to in^2
                }
                else
                {
                    portArea = r1.getPortArea(); //otherwise port area equals to what is given
                }

                if(!netVolumeBtn.getText().equals("in^3")) //if net volume button doesn't read in^3
                {
                    Convert nV = new Convert();
                    netVolume = nV.convertNetVolume(r1.getNetVolume(), netVolumeBtn); //convert from given unit to in^3
                }
                else
                {
                    netVolume = r1.getNetVolume(); //otherwise net volume equals to what is given
                }

                if(!portLengthBtn.getText().equals("in")) //if port length button doesn't read in
                {
                    Convert pL = new Convert();
                    portLength = pL.convertPortLength(r2.getPortLength(), portLengthBtn); //convert from given unit to in
                }
                else
                {
                    portLength = r2.getPortLength(); //otherwise port length equals to what is given
                }

                //Equation for JL port tuning is
                // .159*SQRT((portArea*(1.84*10^8))/(netVolume*(portLength+endCorrection*SQRT(portArea))))
                Double portTuning1;
                if(numberOfPorts == 1) //if the number of ports reads 1
                {
                    //normal equation
                    portTuning1 = .159*sqrt((portArea*(1.84*pow(10,8)))/(netVolume*(portLength+endCorrection*sqrt(portArea))));
                }
                else //if the number of ports is more than 1 FIXME: check to make sure numberOfPorts isn't <1
                {
                    //total port area is all of the port areas added together (they should all be equal)
                    Double newPortArea = numberOfPorts*portArea;
                    portTuning1 = .159*sqrt((newPortArea*(1.84*pow(10,8)))/(netVolume*(portLength+endCorrection*sqrt(newPortArea))));
                }


                //Equation for DIYAudio port tuning is
                //(153.501*portDiameter*SQRT(numberOfPorts))/(SQRT(netVolume2)*SQRT(portLength2+endCorrection2*portDiameter))
                Double portTuning2;
                //if statement from above equation doesn't need to be used because the equation already takes into account
                //number of ports
                portTuning2 = (153.501*portDiameter*sqrt(numberOfPorts))/(sqrt(netVolume2)*sqrt(portLength2+endCorrection*portDiameter));


                //This section gets the average of the two tunings. Real world tuning is generally somewhere in between
                //the two calculated tuning's.
                Double avgPortTuning = (portTuning1 + portTuning2)/2;

                r3.setPortTuning(avgPortTuning); //set the Port Tuning TextField to the average result of the two equations


            }
        });
    }

    /**
     * This method changes the text associated with the Port Area Button in the following order
     * in^2 (default)
     * cm^2
     * ft^2
     * mm^2 (back to in^2)
     *
     * @param portAreaBtn Button object associated with the Port Area variable
     */
    public void portAreaEvent(Button portAreaBtn)
    {
        portAreaBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                switch(portAreaBtn.getText())
                {
                    case "in^2":
                        portAreaBtn.setText("cm^2"); //if entry is in^2, next will be cm^2
                        break;
                    case "cm^2":
                        portAreaBtn.setText("ft^2"); //if entry is cm^2, next will be ft^2
                        break;
                    case "ft^2":
                        portAreaBtn.setText("mm^2"); //if entry is ft^2, next will be mm^2
                        break;
                    case "mm^2":
                        portAreaBtn.setText("in^2"); //if entry is mm^2, next will be in^2
                        break;

                }
            }
        });
    }

    /**
     * This method changes the text associated with the Net Volume Button in the following order
     * in^3 (default)
     * L
     * cm^3
     * ft^3
     * mm^3 (back to in^3)
     *
     * @param netVolumeBtn Button object associated with the Net Volume variable
     */
    public void netVolumeEvent(Button netVolumeBtn)
    {
        netVolumeBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                switch(netVolumeBtn.getText())
                {
                    case "in^3":
                        netVolumeBtn.setText("L"); //if entry is in^3, next will be L
                        break;
                    case "L":
                        netVolumeBtn.setText("cm^3"); //if entry is L, next will be cm^3
                        break;
                    case "cm^3":
                        netVolumeBtn.setText("ft^3"); //if entry is cm^3, next will be ft^3
                        break;
                    case "ft^3":
                        netVolumeBtn.setText("mm^3"); //if entry is ft^3, next will be mm^3
                        break;
                    case "mm^3":
                        netVolumeBtn.setText("in^3"); //if entry is mm^3, next will be in^3
                        break;

                }
            }
        });
    }


    /**
     * This method changes the text associated with the Port Length Button in the following order
     * in (default)
     * cm
     * ft
     * m
     * mm (back to in)
     *
     * @param portLengthBtn Button object associated with the Port Length variable
     */
    public void portLengthEvent(Button portLengthBtn)
    {
        portLengthBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                switch(portLengthBtn.getText())
                {
                    case "in":
                        portLengthBtn.setText("cm"); //if entry is in, next will be cm
                        break;
                    case "cm":
                        portLengthBtn.setText("ft"); //if entry is cm, next will be ft
                        break;
                    case "ft":
                        portLengthBtn.setText("m"); //if entry is ft, next will be m
                        break;
                    case "m":
                        portLengthBtn.setText("mm"); //if entry is m, next will be mm
                        break;
                    case "mm":
                        portLengthBtn.setText("in"); //if entry is mm, next will be in
                        break;

                }
            }
        });
    }
}
