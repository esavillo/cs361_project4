/*
File: ErrorType.java
CS361 Project 4
Names: Yi Feng, Iris Lian, Christopher Marcello, and Evan Savillo
Date: 10/02/18
*/

package proj4FengLianMarcelloSavillo;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Specialization of the Alert class for making customizable user error notifications,
 * cleanly.
 *
 * @author Evan Savillo
 * @see javafx.scene.control.Alert
 */
class MyErrorDialog extends Alert
{
    /**
     * enumeration which defines the contents of error alerts of certain types
     */
    enum ErrorType
    {
        SAVING_ERROR("Error",
                "Saving Error",
                "File %s could not be saved!"),
        READING_ERROR("Error",
                "Reading Error",
                "File %s could not be read!"),
        FNF_ERROR("Error",
                "File Not Found Error",
                "File %s could not be found!");

        final String TITLE;
        final String HEADER;
        final String CONTENT;
        ErrorType(final String title, final String header, final String content)
        {
            TITLE = title;
            HEADER = header;
            CONTENT = content;
        }
    }

    /**
     * Constructor which requires a predefined ErrorType in order to
     * construct itself with predefined contents.
     *
     * @param type enum of variety ErrorType
     * @param filename optionally pass the name of the file with which the error
     *                 occurred.
     */
    MyErrorDialog(ErrorType type, String filename)
    {
        super(AlertType.NONE);

        this.getButtonTypes().add(ButtonType.OK);

        this.setTitle(type.TITLE);
        this.setHeaderText(type.HEADER);
        this.setContentText(String.format(type.CONTENT, filename));
    }

    /**
     * Fallback constructor
     */
    MyErrorDialog(ErrorType type)
    {
        this(type, "in question");
    }
}
