package cz.zcu.kiv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {

    private final FileWriter fileWriter;

    private int lineNumber; // line count
    private final ArrayList<String> rows;

    public Writer(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
        this.rows = new ArrayList<>();
        this.lineNumber = 0;
    }

    /**
     * Saves new row.
     * @param s row
     */
    public void saveRow(String s) {
        rows.add(lineNumber + " " + s + "\n");
        lineNumber++;
    }

    /**
     * Updates row at given index.
     * @param s updated row
     * @param index row index
     */
    public void updateRow(String s, int index) {
        rows.set(index, index + " " + s + "\n");
    }

    /**
     * Writes all lines to the file.
     */
    public void flush() {
        try {
            for (String row : rows) {
                fileWriter.write(row);
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Error while writing code in a file!");
        }
    }

    /**
     * Returns line count.
     */
    public int getLineNumber() {
        return lineNumber;
    }
}
