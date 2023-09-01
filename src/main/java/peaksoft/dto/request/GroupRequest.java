package peaksoft.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public record GroupRequest (
        String groupName,
        String imageLink,
        String description
) {
}
