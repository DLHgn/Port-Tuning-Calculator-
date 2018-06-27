package porttuningcalculator;


import javafx.scene.control.Button;
import static java.lang.Math.sqrt;
import static java.lang.Math.PI;

public class Convert
{
    /**
     * This method converts Port Area from cm^2, ft^2, or mm^2 to in^2 for use in the JL port tuning equation
     *
     * @param portArea Double value Port Area given by user
     * @param portAreaBtn Button Object associated with the Port Area variable
     * @return Double value of Port Area in units of in^2
     */
    public Double convertPortArea(Double portArea, Button portAreaBtn)
    {
        String unit = portAreaBtn.getText(); //set the unit variable to the text in the Port Area button

        switch(unit)
        {
            case "cm^2":
                portArea = portArea*.155; //convert cm^2 to in^2
                break;
            case "ft^2":
                portArea = portArea*144; //convert ft^2 to in^2
                break;
            case "mm^2":
                portArea = portArea*.00155; //convert mm^2 to in^2
                break;
            default:
                break;

        }

        return portArea; //return the converted Port Area in units of in^2

    }

    /**
     * This method converts Net Volume from L, cm^3, ft^3, or mm^3 to in^3 for use in the JL port tuning equation
     *
     * @param netVolume Double value Net Volume given by user
     * @param netVolumeBtn Button object associated with Net Volume variable
     * @return Double value of Net Volume in units of in^3
     */
    public Double convertNetVolume(Double netVolume, Button netVolumeBtn)
    {
        String unit = netVolumeBtn.getText(); //set the unit variable to the text in the Net Volume button

        switch(unit)
        {
            case "L":
                netVolume = netVolume*61.0237; //convert L to in^3
                break;
            case "cm^3":
                netVolume = netVolume*.0610237; //convert cm^3 to in^3
                break;
            case "ft^3":
                netVolume = netVolume*1728; //convert ft^3 to in^3
                break;
            case "mm^3":
                netVolume = netVolume*.0000610237; //convert mm^3 to in^3
                break;
            default:
                break;
        }

        return netVolume; //return the converted Net Volume in units of in^3
    }

    /**
     * This method converts Port Length from cm, ft, m or mm to inch for use in the JL port tuning equation
     *
     * @param portLength Double value Port Length given by user
     * @param portLengthBtn Button object associated with Port Length variable
     * @return Double value of Port Length in units of inch
     */
    public Double convertPortLength(Double portLength, Button portLengthBtn)
    {
        String unit = portLengthBtn.getText(); //set the unit variable to the text in the Port Length button

        switch(unit)
        {
            case "cm":
                portLength = portLength*.393701; //convert cm to in
                break;
            case "ft":
                portLength = portLength/12; //convert ft to in
                break;
            case "m":
                portLength = portLength/39.3701; //convert m to in
                break;
            case "mm":
                portLength = portLength*.0393701; //convert mm to in
                break;
            default:
                break;

        }

        return portLength; //return the converted Port Length in units of in
    }

    /**
     * Returns port diameter from given port area
     *
     * This method converts Port Area from in^2, mm^2 or ft^2 to cm^2 for use in the DIYAudio port tuning equation
     * If the port Area is already in cm^2, no conversion is done.
     * Once Port Area is in correct units, it is sent to convertAreaToDiameter.
     *
     * @param portArea Double value Port Area given by user
     * @param portAreaBtn Button object associated with Port Area variable
     * @return Double value of Port Diameter in units of cm
     * @see #convertAreaToDiameter(Double);
     */
    public Double convertPortDiameter(Double portArea, Button portAreaBtn)
    {
        String unit = portAreaBtn.getText(); //set the unit variable to the text in the Port Area button

        switch(unit)
        {
            case "in^2":
                portArea = portArea*6.4516; //convert in^2 to cm^2
                break;
            case "mm^2":
                portArea = portArea*.01; //convert mm^2 to cm^2
                break;
            case "ft^2":
                portArea = portArea*929.03; //convert ft^2 to cm^2
                break;
            default:
                break;

        }

        return convertAreaToDiameter(portArea); //return the value returned by convertAreaToDiameter when given the
                                                //converted Port Area in units of cm^2
    }

    /**
     *  This method converts port area into port diameter in what ever units are given. Units in this case should be
     *  cm for use in DIYAudio port tuning equation
     *
     * @param portArea Double value Port Area given by convertPortDiameter method
     * @return Double value of Port Diameter in units of cm
     * @see #convertPortDiameter(Double, Button)
     */
    private Double convertAreaToDiameter(Double portArea)
    {
        return 2*sqrt((portArea)/(PI)); //This equation takes a given port area and finds the corresponding diameter.
                                        //The result is then returned
    }

    /**
     * This method converts Net Volume from in^3, cm^3, ft^3 or mm^3 to L for use in the DIYAudio port tuning equation
     *
     * @param netVolume Double value Net Volume given by user
     * @param netVolumeBtn Button object associated with Net Volume variable
     * @return Double value of Net Volume in units of L
     */
    public Double convertNetVolume2(Double netVolume, Button netVolumeBtn)
    {
        String unit = netVolumeBtn.getText(); //set the unit variable to the text in the Net Volume button
        Double netVolume2; //second Net Volume variable created to ease confusion. The second volume needs to be in
                           //units of L instead of in^3 like the first volume

        switch(unit)
        {
            case "in^3":
                netVolume2 = netVolume*.0163871; //convert in^3 to L
                break;
            case "cm^3":
                netVolume2 = netVolume*.001; //convert cm^3 to L
                break;
            case "ft^3":
                netVolume2 = netVolume*28.3168; //convert ft^3 to L
                break;
            case "mm^3":
                netVolume2 = netVolume*.000001; //convert mm^3 to L
                break;
            default:
                netVolume2 = netVolume; //if the unit is already L then Volume2 is the same as the given volume
                break;
        }

        return netVolume2; //return Net Volume in unit of L
    }

    /**
     * This method converts Port Length from in, ft, m, or mm to cm for use in the DIYAudio port tuning equation
     *
     * @param portLength Double value Port Length given by user
     * @param portLength2Btn Button object associated with Port Length variable
     * @return Double value of Port Length in units of cm
     */
    public Double convertPortLength2(Double portLength, Button portLength2Btn)
    {
        String unit = portLength2Btn.getText(); //set the unit variable to the text in the Port Length button
        Double portLength2; //second Port Length variable created to ease confusion. The second length needs to be in
                            //units of cm instead of in like the first length

        switch(unit)
        {
            case"in":
                portLength2 = portLength*2.54; //convert in to cm
                break;
            case "ft":
                portLength2 = portLength*91.44; //convert ft to cm
                break;
            case "m":
                portLength2 = portLength*100; //convert m to cm
                break;
            case "mm":
                portLength2 = portLength*.1; //convert mm to cm
                break;
            default:
                portLength2 = portLength; //if the unit is already cm then Length2 is the same as the given length
        }

        return portLength2; //return Port Length in unit of cm
    }

}
