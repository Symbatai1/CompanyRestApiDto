package peaksoft.service;

public interface LessonService {
    List<LessonResponse> getAllLessons(Long courseId);

    SimpleResponse saveLesson(Long courseId, LessonRequest lessonRequest);

    LessonResponse getById(Long id);

    SimpleResponse updateLesson(Long id, LessonRequest lessonRequest);

    SimpleResponse deleteById(Long id);


    SimpleResponse uploadLessonToCourse(String lessonName, Long courseId);
}
