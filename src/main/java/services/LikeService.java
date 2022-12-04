package services;

import java.time.LocalDateTime;

import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import actions.views.LikeConverter;
import actions.views.LikeView;
import actions.views.ReportConverter;
import actions.views.ReportView;
import constants.JpaConst;
import models.Like;

/**
 * likeテーブルの操作に関わる処理を行うクラス
 */

public class LikeService extends ServiceBase {

    public LikeView findOne(int id) {
        return LikeConverter.toView(findOneInternal(id));
    }

    // 指定した従業員が指定したレポートにいいねした件数
    public long getAllMine(EmployeeView employee, ReportView report){
        long like_count = em.createNamedQuery(JpaConst.Q_LIKE_COUNT_ALL_MINE, Long.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
                .setParameter(JpaConst.JPQL_PARM_REPORT, ReportConverter.toModel(report))
                .getSingleResult();

        return like_count;

    }

 // 指定した従業員が指定したレポートにいいねしたデータを取得

    public LikeView findLike(EmployeeView employee, ReportView report) {

        Like lv = em.createNamedQuery(JpaConst.Q_LIKE_GET_ALL_MINE, Like.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
                .setParameter(JpaConst.JPQL_PARM_REPORT, ReportConverter.toModel(report))
                .getSingleResult();

        return LikeConverter.toView(lv);
    }

    // 指定したレポートに集まったいいねの件数を取得し、返却する

    public long countAll(ReportView report) {

        long count = (long) em.createNamedQuery(JpaConst.Q_LIKE_COUNT_LIKE, Long.class)
                .setParameter(JpaConst.JPQL_PARM_REPORT, ReportConverter.toModel(report))
                .getSingleResult();

        return count;
    }

    public Like findLikeInternal(int id) {

        return em.find(Like.class, id);
    }


    public boolean create(LikeView lv){
            LocalDateTime ldt = LocalDateTime.now();
            lv.setCreatedAt(ldt);
            lv.setUpdatedAt(ldt);
            createInternal(lv);

            return true;

    }

    public boolean delete(Like lv){

            deleteInternal(lv);

            return true;

    }

    private Like findOneInternal(int id) {
        return em.find(Like.class, id);
    }

    private void createInternal(LikeView lv) {

        em.getTransaction().begin();
        em.persist(LikeConverter.toModel(lv));
        em.getTransaction().commit();
    }

    private void deleteInternal(Like lv) {

        em.getTransaction().begin();
        Like li = lv;
        em.remove(li);
        em.getTransaction().commit();
    }

}
