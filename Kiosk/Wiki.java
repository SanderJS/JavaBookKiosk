import java.util.ArrayList;

/**
 * this is a dummy wiki page for a fake project(s)
 * it contains a list of contributers, a list of 
 * related projects and the name of the main project.
 * 
 * @author Jan Anton and Joachim
 * @version 1.0
 */
public Class Wiki extends Text {
    private ArrayList<String> contributers;
    private ArrayList<String> projects;
    private String project;

    /**
     * constructor for class Wiki
     * 
     * @param the project's name
     */
    public Wiki(String project) {
        this.project = project;
    }

    /**
     * gets the name of the main project
     * 
     * @return the main project's name
     */
    public String getMainProjectName()
    {
        return project;
    }

    /**
     * adds a related project to the main project
     * 
     * @projectName the name of the related project
     */
    public void addPorjects(String projectName)
    {
        projects.add(ProjectName);
    }

    public void getPorject(String name)
}