package peaksoft.service;

import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.dto.simplerespons.SimpleResponse;

import java.util.List;

public interface CourseService {
    CourseResponse saveCourse(Long instructorId, Long companyId, CourseRequest courseRequest);

    List<CourseResponse> getAllCourse();

    CourseResponse getById(Long id);

    SimpleResponse updateCourse(Long id, CourseRequest courseRequest);

    SimpleResponse deleteById(Long id);

    List<CourseResponse> findAllSorted();

}
