package peaksoft.service;

import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.simplerespons.SimpleResponse;
import peaksoft.entity.Company;

import java.util.List;

public interface CompanyService {

 CompanyResponse saveCompany(CompanyRequest companyRequest);
 List<CompanyResponse> getAllCompanies();

 SimpleResponse updateCompany(Long companyId, CompanyRequest companyRequest);

 CompanyResponse getCompanyById(Long companyId);

 SimpleResponse deleteCompanyById(Long companyId);

}
