package az.ingress.announcementmanagementsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementResponse implements Serializable {
    private String username;

    private Integer viewCount;

    private String title;

    private String description;

    private BigDecimal price;
}
