public class Project{
    public enum ClientType {
        PRACTICAL,
        THEORETICAL
    }

    public boolean isTaken() {
        return isTaken;
    }

    private boolean isTaken=false; //In order to assign projects we need to know which are taken
    public void selectProject(){ //Student chooses project
        this.isTaken=true;
    }
    public void abandonProject(){ //After Problem use this to reset isTaken
        this.isTaken=false;
    }
    public Project(ClientType projectType) {
        this.projectType = projectType;
    }

    public Project() {
    }

    private ClientType projectType;

    public ClientType getProjectType() {
        return projectType;
    }

    public void setProjectType(ClientType projectType) {
        this.projectType = projectType;
    }
    @Override
    public String toString(){
        if (getProjectType()==ClientType.THEORETICAL)
            return "THEORETICAL";
        else return "PRACTICAL";
    }

}
