package peaksoft.service;

public interface StudentService {
    List<StudentResponse> getAllStudents(Long groupId);

    SimpleResponse saveStudent(Long groupId, StudentRequest studentRequest);

    StudentResponse getById(Long id);

    SimpleResponse updateStudent(Long id, StudentRequest studentRequest);

    SimpleResponse deleteById(Long id);

    SimpleResponse createGroups(String groupName, List<Long> courseIds);

    SimpleResponse blockUnblockStudent(Long studentId, Boolean block);

    List<StudentResponse> filter(String studyFormat);
}
