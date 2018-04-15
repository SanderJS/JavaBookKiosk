import java.util.ArrayList;

/**
 * this is a wiki page for a project
 * 
 * @author Jan Anton and Joachim
 * @version 1.0
 */
public Class Wiki extends Text {
    private ArrayList<String> contributers;
    private String project;

    /**
     * constructor for class Wiki
     * 
     * @param the project's name
     */
    public Wiki(String project) {
        this.project = project;
    }

    public String getProjectName()
    {
        return project;
    }
}