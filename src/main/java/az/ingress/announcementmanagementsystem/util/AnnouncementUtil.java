package az.ingress.announcementmanagementsystem.util;

import az.ingress.announcementmanagementsystem.dto.request.PageCriteria;
import az.ingress.announcementmanagementsystem.entity.User;
import az.ingress.announcementmanagementsystem.exception.NotLoggedInException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static az.ingress.announcementmanagementsystem.enums.ExceptionMessage.USER_NOT_LOGGED_IN_EXCEPTION;
import static az.ingress.announcementmanagementsystem.enums.LoginStatus.LOGGED_OUT;

public class AnnouncementUtil {

    public static void checkUserLogin(User user) {
        if (user.getStatus().equals(LOGGED_OUT))
            throw new NotLoggedInException(USER_NOT_LOGGED_IN_EXCEPTION.getMessage());
    }

    public static Pageable getDefaultPageable(PageCriteria pageCriteria) {
        var pageNumber = pageCriteria.getPageNumber() == null ? 0 : pageCriteria.getPageNumber();
        var pageSize = pageCriteria.getPageSize() == null ? 10 : pageCriteria.getPageSize();
        var sort = pageCriteria.getSort() == null ? new String[]{"id", "asc"} : pageCriteria.getSort();

        Pageable pageable;
        switch (sort[1]) {
            case "asc" -> pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sort[0]));
            case "desc" -> pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sort[0]).descending());
            default -> throw new RuntimeException("Please enter the valid sort direction like {asc,desc}");
        }
        return pageable;
    }
}
