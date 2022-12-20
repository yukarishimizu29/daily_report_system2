package actions.views;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LikeView {

    private Integer id;

    private EmployeeView employee;

    private ReportView report;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
