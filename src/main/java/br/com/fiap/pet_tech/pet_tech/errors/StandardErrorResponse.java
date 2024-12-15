package br.com.fiap.pet_tech.pet_tech.errors;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardErrorResponse {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
