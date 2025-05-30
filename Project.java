import java.util.Random;

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

    public Project() { Random random2 = new Random();
        int type_number= random2.nextInt(10);
        if (type_number%2==0) this.projectType=ClientType.THEORETICAL;
        else this.projectType=ClientType.PRACTICAL;
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
