package peaksoft.service;

import peaksoft.dto.request.InstructorRequest;
import peaksoft.dto.simplerespons.SimpleResponse;

public interface InstructorService {
    List<InstructorResponse> getAllInstructors();

    SimpleResponse saveInstructor(InstructorRequest instructorRequest);

    InstructorResponse getInstructorById(Long id);

    SimpleResponse updateInstructor(Long id, InstructorRequest instructorRequest);

    SimpleResponse deleteInstructorById(Long id);

    SimpleResponse assignInstructor(Long companyId, Long instructorId);


}
