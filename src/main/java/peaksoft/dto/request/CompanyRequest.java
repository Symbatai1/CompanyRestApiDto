package peaksoft.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CompanyRequest {


    private String name;
    private String country;
    private String address;
    private String phoneNumber;
}
