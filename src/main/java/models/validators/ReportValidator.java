package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.ReportView;
import constants.MessageConst;

/**
 * 日報インスタンスに設定されている値のバリデーションを行うクラス
 */

public class ReportValidator {

    /**
     * 日報インスタンスの各項目についてバリデーションを行う
     * @param rv 日報インスタンス
     * @return エラーのリスト
     */
    public static List<String> validate(ReportView rv){
        List<String> errors = new ArrayList<String>();

        // タイトルのチェック
        String titleError = validateTitle(rv.getTitle());
        if (!titleError.equals("")) {
            errors.add(titleError);
        }

        // 内容のチェック
        String contentError = validateContent(rv.getContent());
        if (!contentError.equals("")) {
            errors.add(contentError);
        }

        // 出勤時間のチェック
        String beginAtError = validateBeginAt(rv.getBeginAt());
        if (!beginAtError.equals("")) {
            errors.add(beginAtError);
        }

        // 退勤時間のチェック
        String finishAtError = validateFinishAt(rv.getFinishAt());
        if (!finishAtError.equals("")) {
            errors.add(finishAtError);
        }



        return errors;
    }

    /**
     * タイトルに入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param title タイトル
     * @return エラーメッセージ
     */
    private static String validateTitle(String title) {
        if (title == null || title.equals("")) {
            return MessageConst.E_NOTITLE.getMessage();
        }

        // 入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 内容に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param content 内容
     * @return エラーメッセージ
     */
    private static String validateContent(String content) {
        if (content == null || content.equals("")) {
            return MessageConst.E_NOCONTENT.getMessage();
        }

        // 入力値がある場合は空文字を返却
        return "";

    }

    /**
     * 出勤時間に入力値があるかチェックし、入力値がなければエラーメッセージを返却
     * @param beginAt 出勤時間
     * @return エラーメッセージ
     */
    private static String validateBeginAt(String beginAt) {
        if (beginAt == null || beginAt.equals("")) {
            return MessageConst.E_NOBEGIN.getMessage();
        }

        // 入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 退勤時間に入力値があるかチェックし、入力値がなければエラーメッセージを返却
     * @param finishAt 退勤時間
     * @return エラーメッセージ
     */
    private static String validateFinishAt(String finishAt) {
        if (finishAt == null || finishAt.equals("")) {
            return MessageConst.E_NOFINISH.getMessage();
        }

        // 入力値がある場合は空文字を返却
        return "";
    }


}
