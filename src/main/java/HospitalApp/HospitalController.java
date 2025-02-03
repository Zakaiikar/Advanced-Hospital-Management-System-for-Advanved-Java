package HospitalApp;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HospitalController {
    private  final  HospitalService service;

    public HospitalController(HospitalService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String getHomePage(){
        return "Home";
    }

@GetMapping("/Register")
public String getRegister(){
    return "Register"; //view name
}

    @PostMapping("/Save")
    public String SaveHospital(@ModelAttribute Hospital hosp){
        service.InsertPatientInfo(hosp);
        return "redirect:/all";
   }
   @GetMapping("/all")
public String getAll(Model model, @Param("keyword") Long keyword){
      List<Hospital> list = service.getAllPatientInfo(keyword);
 model.addAttribute("Hospital" , list);
       model.addAttribute("keyword" , keyword);
      return "PatientInfoList";
    }

    @RequestMapping("/delete/{Number}")
    public String deleteUniversity(@PathVariable Long Number){
        service.DeletePatientInfo(Number);
        return "redirect:/all";
    }
    @RequestMapping("/Edit/{Number}")
    public String UpdatePatient(@PathVariable Long Number, Model model){
        Hospital hospital=service.getPatientInfoById(Number);
        model.addAttribute("Hospital",hospital);
        return "EditPatients";
    }

}

