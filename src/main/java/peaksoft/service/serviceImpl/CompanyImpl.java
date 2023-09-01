package peaksoft.service.serviceImpl;

import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.simplerespons.SimpleResponse;
import peaksoft.service.CompanyService;

import java.util.List;

public class CompanyImpl implements CompanyService {
    @Override
    public CompanyResponse saveCompany(CompanyRequest companyRequest) {
        private final CompanyRepository companyRepository;

        @SneakyThrows
        @Override
        public SimpleResponse saveCompany(CompanyRequest companyRequest) {
            try {
                Company company = new Company();
                company.setName(companyRequest.name());
                company.setCountry(companyRequest.country());
                company.setAddress(companyRequest.address());
                company.setPhoneNumber(companyRequest.phoneNumber());

                if (companyRepository.existsByName(company.getName())) {
                    throw new IOException("Company name and phoneNumber must be unique");
                }

                companyRepository.save(company);

                return SimpleResponse.builder()
                        .status("SUCCESSFULLY SAVED")
                        .message("Company with id: " + company.getName() + " is saved!")
                        .build();

            } catch (IOException e) {
                return SimpleResponse.builder()
                        .status("ERROR")
                        .message("Failed to save company: " + e.getMessage())
                        .build();
            }
        }

        @Override
        public List<CompanyResponse> getAllCompanies() {
            return companyRepository.getAllCompanies();
        }

        @Override
        public SimpleResponse updateCompany(Long companyId, CompanyRequest companyRequest) {
            try {
                Company company = companyRepository.findById(companyId).orElseThrow(() ->
                        new NoSuchElementException("Company with id: " + companyId + " does not exist"));

                company.setName(companyRequest.name());
                company.setCountry(companyRequest.country());
                company.setAddress(companyRequest.address());
                company.setPhoneNumber(companyRequest.phoneNumber());
                companyRepository.save(company);

                return SimpleResponse.builder()
                        .status("SUCCESSFULLY UPDATED")
                        .message("Company with id: " + company.getName() + " is updated")
                        .build();

            } catch (Exception e) {
                return SimpleResponse.builder()
                        .status("ERROR")
                        .message("Failed to update company: " + e.getMessage())
                        .build();
            }
        }

        @Override
        public CompanyResponse getCompanyById(Long companyId) {
            try {
                companyRepository.findById(companyId).orElseThrow(() ->
                        new NoSuchElementException("Company with id: " + companyId + " is not found!"));
                return companyRepository.getCompanyById(companyId);

            } catch (Exception e) {
                throw new RuntimeException("Failed to get company: " + e.getMessage());
            }
        }

        @Override
        public SimpleResponse deleteCompanyById(Long companyId) {
            try {
                companyRepository.deleteById(companyId);
                return SimpleResponse.builder().status("SUCCESSFULLY DELETED!")
                        .message("Company with id: " + companyId + " is deleted!").build();

            } catch (Exception e) {
                throw new RuntimeException("Failed to delete company: " + e.getMessage());
            }
        }


    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
        return null;
    }

    @Override
    public SimpleResponse updateCompany(Long companyId, CompanyRequest companyRequest) {
        return null;
    }

    @Override
    public CompanyResponse getCompanyById(Long companyId) {
        return null;
    }

    @Override
    public SimpleResponse deleteCompanyById(Long companyId) {
        return null;
    }
}
