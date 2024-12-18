import java.lang.reflect.Array;
import java.util.Arrays;

public class TaskQueueTest {

    public static void main(String[] args) {

        TaskQueue taskQueue = new TaskQueue();

        // Add nodes to the system
        taskQueue.addNode("N1");
        taskQueue.addNode("N2");
        taskQueue.addNode("N3");

        //Remove Node
        taskQueue.removeNode("N3");

        // Add tasks
        taskQueue.addTask("A", 3, Arrays.asList());
        taskQueue.addTask("B", 2, Arrays.asList("A"));
        taskQueue.addTask("C", 1, Arrays.asList("A"));
        taskQueue.addTask("D", 2, Arrays.asList("D"));
        taskQueue.addTask("E", 3, Arrays.asList("A"));

        //Remove task
        taskQueue.removeTask("E");

        //Update task
        taskQueue.updateTask("D", 3, Arrays.asList("B", "C"));

        //Get execution order
        System.out.println("Execution Order: " + taskQueue.getExecutionOrder());

        //Assign tasks to nodes
        taskQueue.assignTasksToNodes();
        System.out.println("Task assignments: " + taskQueue.nodeAssignments);

        //Node failure simulation
        taskQueue.handleNodeFailure("N1");
        System.out.println("Task assignments after node failure: " + taskQueue.nodeAssignments);

        //Missing dependency Error test
        taskQueue.updateTask("B", 3, Arrays.asList("G"));
        System.out.println("Execution Order: " + taskQueue.getExecutionOrder());


    }

}
