import java.util.*;

public class TaskQueue {

    private Map<String, Task> taskMap = new HashMap<>();
    private Map<String, Set<String>> taskDependencies = new HashMap<>();
    private Map<String, Integer> taskExecutionOrder = new HashMap<>();
    private List<String> nodes = new ArrayList<>();
    private Map<String, List<String>> nodeAssignments = new HashMap<>();
    private int taskCounter = 0;

    public void addTask(String taskId, int priority, List<String> dependencies){
        if(taskMap.containsKey(taskId)){
            System.out.println("Task with ID " + taskId + " already exists.");
            return;
        }
        Task task = new Task(taskId, priority, dependencies);
        taskMap.put(taskId, task);
        taskDependencies.put(taskId,  new HashSet<>(dependencies));
        taskExecutionOrder.put(taskId, taskCounter++);
    }

    public void removeTask(String taskId){
        if (!taskMap.containsKey(taskId)) {
            System.out.println("Task with ID " + taskId + " does not exist.");
            return;
        }
        taskMap.remove(taskId);
        taskDependencies.remove(taskId);
        taskExecutionOrder.remove(taskId);
    }

    public void updateTask(String taskId, int priority, List<String> dependencies){
        if(!taskMap.containsKey(taskId)){
            System.out.println("Task with ID " + taskId + " does not exist.");
            return;
        }
        Task task = taskMap.get(taskId);
        task.setPriority(priority);
        task.setDependencies(dependencies);
        taskDependencies.put(taskId, new HashSet<>(dependencies));
    }

    public List<String> getExecutionOrder(){

    }

    public void assignTasksToNodes(){

    }

    public void handleNodeFailures(String nodeId){

    }

    public void addNode(String nodeId){

    }

    public void removeNode(String nodeId){

    }

}
