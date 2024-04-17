package az.ingress.announcementmanagementsystem.dto.request;

import lombok.Data;

@Data
public class SearchCriteria {
    private Integer minViewCount;

    private Integer maxViewCount;
}
