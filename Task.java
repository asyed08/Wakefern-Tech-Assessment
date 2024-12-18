
import java.util.List;

public class Task {

    private String taskId;
    private int priority;
    private List<String> dependencies;

    public Task(String taskId, int priority, List<String> dependencies){
        this.taskId = taskId;
        this.priority = priority;
        this.dependencies = dependencies;
    }

    public String getTaskId() {
        return taskId;
    }

    public int getPriority(){
        return priority;
    }

    public List<String> getDependencies(){
        return dependencies;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }
}
