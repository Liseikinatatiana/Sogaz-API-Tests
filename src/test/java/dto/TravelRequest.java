package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelRequest {
    private String country;
    private int age;
    private String startDate;
    private String endDate;
    private String insuranceType;
}
