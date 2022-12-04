package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Like;

public class LikeConverter {

    public static Like toModel(LikeView lv) {
        return new Like(
                lv.getId(),
                EmployeeConverter.toModel(lv.getEmployee()),
                ReportConverter.toModel(lv.getReport()),
                lv.getCreatedAt(),
                lv.getUpdatedAt());
    }

    public static LikeView toView(Like l) {

        if (l == null) {
            return null;
        }

        return new LikeView(
                l.getId(),
                EmployeeConverter.toView(l.getEmployee()),
                ReportConverter.toView(l.getReport()),
                l.getCreatedAt(),
                l.getUpdatedAt());
    }

    public static List<LikeView> toViewList(List<Like> list){
        List<LikeView> evs = new ArrayList<>();

        for (Like l : list) {
            evs.add(toView(l));
        }

        return evs;

    }

    public static void copyViewToModel(Like l, LikeView lv) {
        l.setId(lv.getId());
        l.setEmployee(EmployeeConverter.toModel(lv.getEmployee()));
        l.setReport(ReportConverter.toModel(lv.getReport()));
        l.setCreatedAt(lv.getCreatedAt());
        l.setUpdatedAt(lv.getUpdatedAt());

    }

}
