package ua.com.company.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "director")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Director {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
