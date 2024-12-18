import java.util.*;

public class TaskQueue {

    private Map<String, Task> taskMap = new HashMap<>();
    private Map<String, Set<String>> taskDependencies = new HashMap<>();
    private Map<String, Integer> taskExecutionOrder = new HashMap<>();
    private List<String> nodes = new ArrayList<>();
    private Map<String, List<String>> nodeAssignments = new HashMap<>();
    private int taskCounter = 0;

    //Add task to queue
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

    //Remove task from queue
    public void removeTask(String taskId){
        if (!taskMap.containsKey(taskId)) {
            System.out.println("Task with ID " + taskId + " does not exist.");
            return;
        }
        taskMap.remove(taskId);
        taskDependencies.remove(taskId);
        taskExecutionOrder.remove(taskId);
    }

    //Update tasks priorities or dependencies
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

    //This will give the execution order in tasks based on priority and throwing an error if there are any cycles in depndency graph.
    public List<String> getExecutionOrder(){
        List<String> orderedTasks = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Set<String> stack = new HashSet<>();

        for(String taskId: taskMap.keySet()){
            if(!visited.contains(taskId)){
                if(hasCycle(taskId, visited, stack, orderedTasks)){
                    System.out.println("Error. There is a cycle in Task Dependencies.");
                    return Collections.emptyList();
                }
            }
        }

        orderedTasks.sort((task1, task2)-> taskMap.get(task2).getPriority()-taskMap.get(task1).getPriority());
        return orderedTasks;
    }

    //This method will tell us if there is a cycle in dependencies graph. Cycles are bad because they will mess up execution order and throw ane error in getExecutionOrder() method.
    private boolean hasCycle(String taskId, Set<String> visited, Set<String> stack, List<String> orderedTasks){
        if(stack.contains(taskId)){
            return true;
        }
        if(visited.contains(taskId)){
            return false;
        }
        visited.add(taskId);
        stack.add(taskId);
        for(String dep: taskDependencies.get(taskId)){
            if(hasCycle(dep,visited,stack,orderedTasks)){
                return true;
            }
        }
        stack.remove(taskId);
        orderedTasks.add(taskId);
        return false;
    }

    //Assign tasks to nodes based on execution order.
    public void assignTasksToNodes(){
        int nodeIndex = 0;
        for(String taskId: getExecutionOrder()){
            String node = nodes.get(nodeIndex);
            nodeAssignments.putIfAbsent(node, new ArrayList<>());
            nodeAssignments.get(node).add(taskId);
            nodeIndex = (nodeIndex + 1) % nodes.size();
        }
    }

    //Handle node failure and reassign tasks.
    public void handleNodeFailures(String nodeId){
        if(!nodeAssignments.containsKey(nodeId)){
            System.out.println("Node " + nodeId + " doesn't exist or has no assigned tasks.");
            return;
        }
        List<String> failedNodeTasks = nodeAssignments.get(nodeId);
        nodeAssignments.remove(nodeId);

        // Reassign failed tasks to other nodes
        int nodeIndex = 0;
        for(String taskId: failedNodeTasks){
            String newNode = nodes.get(nodeIndex);
            nodeAssignments.putIfAbsent(newNode, new ArrayList<>());
            nodeAssignments.get(newNode).add(taskId);
            nodeIndex = (nodeIndex + 1) % nodes.size();
        }

    }

    //Add node to system
    public void addNode(String nodeId){
        if(!nodes.contains(nodeId)){
            nodes.add(nodeId);
        }
    }

    //Remove node to system
    public void removeNode(String nodeId){
        nodes.remove(nodeId);
        nodeAssignments.remove(nodeId);
    }

}
