package HospitalApp;

import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class HospitalService {
    private final HospitalRePository repo;

    public HospitalService(HospitalRePository repo) {
        this.repo = repo;
    }
    public void InsertPatientInfo(Hospital hospital){
        repo.save(hospital);
    }
    public void updatePatientInfo(Hospital hospital){
        repo.save(hospital);
    }
    public  void  DeletePatientInfo(Long id){
        repo.deleteById(id);
    }
    public Hospital getPatientInfoById(Long id){
        return repo.findById(id).orElse(null);
    }
    public List<Hospital> getAllPatientInfo(Long keyword){
        if(keyword!=null)
            return repo.search(keyword);
        return  repo.findAll();
    }

}

