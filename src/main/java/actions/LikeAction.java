package actions;

import java.io.IOException;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import actions.views.LikeView;
import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import models.Like;
import services.LikeService;
import services.ReportService;

public class LikeAction extends ActionBase {


    private ReportService repservice;
    private LikeService likeservice;

    @Override
    public void process() throws ServletException, IOException {

        repservice = new ReportService();
        likeservice = new LikeService();

        invoke();

        likeservice.close();
        repservice.close();
    }

    /**
     * いいね登録を行う
     * @throws ServletException
     * @throws IOException
     */

    public void create() throws ServletException, IOException {

        if (checkToken()) {

            EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);
            ReportView rv = repservice.findOne(toNumber(getRequestParam(AttributeConst.REP_ID)));

            LikeView lv = new LikeView(
                    null,
                    ev,
                    rv,
                    null,
                    null);

            likeservice.create(lv);


            putRequestScope(AttributeConst.TOKEN, getTokenId());
            putRequestScope(AttributeConst.LIKE, lv);

            redirect(ForwardConst.ACT_REP, ForwardConst.CMD_SHOW, rv.getId());

        }

    }

    /**
     * いいね削除を行う
     * @throws ServletException
     * @throws IOException
     */

    public void delete() throws ServletException, IOException{


        if (checkToken()) {


            EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);
            ReportView rv = repservice.findOne(toNumber(getRequestParam(AttributeConst.REP_ID)));

            LikeView lv = likeservice.findLike(ev, rv);

            Like li = likeservice.findLikeInternal(lv.getId());
            likeservice.delete(li);


            redirect(ForwardConst.ACT_REP, ForwardConst.CMD_SHOW, rv.getId());

        }




    }

}
