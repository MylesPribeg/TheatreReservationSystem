public class Staff{
    private String name;
    private String jobTitle;

    public Staff(String name, String jobTitle){
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public String getName(){
        return name;
    }

    public String getJob(){
        return jobTitle;
    }
}