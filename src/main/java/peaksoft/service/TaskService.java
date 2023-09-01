package peaksoft.service;

public interface TaskService {
    List<TaskResponse> getAllTasks(Long lessonId);

    SimpleResponse saveTask(Long lessonId, TaskRequest taskRequest);

    TaskResponse getById(Long id);

    SimpleResponse updateTask(Long id, TaskRequest taskRequest);
    public SimpleResponse deleteById(Long id);
}
