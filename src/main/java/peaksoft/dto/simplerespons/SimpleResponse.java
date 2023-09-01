package peaksoft.dto.simplerespons;

import lombok.Builder;
@Builder
public record SimpleResponse(
        String status,
        String message
){

}