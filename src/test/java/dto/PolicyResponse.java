package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyResponse {
    private String policyNumber;
    private String status;
    private String insuranceType;
    private String premium;
    private String validUntil;
    private String found;
    private String message;
}
