package az.unitech.deveopment.auth.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationError {

    private ErrorLevel errorLevel;
    private String path;
    private String message;

}