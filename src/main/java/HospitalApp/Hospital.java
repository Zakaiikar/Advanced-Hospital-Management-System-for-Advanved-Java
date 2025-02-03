package HospitalApp;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "Hospital")
public class Hospital {
    @Id
    private Long Number;
    @Column(nullable = false,length = 50)
    private String PatientName;
    private  String Location ;
    private String TypeOfPain;
}
