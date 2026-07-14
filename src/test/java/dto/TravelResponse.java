package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelResponse {
    private double premium;
    private String currency;
    private String insuranceUrl;
    private boolean success;
    private String message;
}
