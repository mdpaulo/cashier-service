package portfolio.projects.cashierService.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseErrorTemplate {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timestamp;
    private String message;
    private String path;

    public ResponseErrorTemplate() { }

    public ResponseErrorTemplate(Instant timestamp, String path, String message) {
        this.timestamp = timestamp;
        this.path = path;
        this.message = message;
    }
}
