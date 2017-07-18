package com.shulaibao.smallloan;

/**
 * 描述：业务常量
 * Created by Lee
 * on 2016/9/20.
 */
public class BizsConstant {
    public static final String NEWS_URL = "_news_url";
    public static final String PERSONAL_IDCARDFRONT="_personal_idcardfront";
    public static final String PERSONAL_IDCARDOPPOSITE="_personal_idcardopposite";
    public static final String PERSONAL_BANKONE="_personal_bankone";
    public static final String PERSONAL_RECEIPTONE="_personal_receiptone";
    public static final String PERSONAL_OTHERSONE="_personal_othersone";

    public static final String MECHANISM_BANKPROVE="_mechanism_bankprove";
    public static final String MECHANISM_RECEIPTONE="_mechanism_receiptone";
    public static final String MECHANISM_IDCARDFRONT="_mechanism_idcardfront";
    public static final String MECHANISM_IDCARDOPPOSITE="_mechanism_idcardopposite";
    public static final String MECHANISM_TAX="_mechanism_tax";
    public static final String MECHANISM_ORGCODE="_mechanism_orgcode";
    public static final String MECHANISM_BUSINESSLICENSE="_mechanism_businesslicense";
    public static final String MECHANISM_THREECARD="_mechanism_threecard";
    public static final String MECHANISM_OTHERSTWO="_mechanism_otherstwo";

    public static final String ORDER_ACTIONC_APPOINTMENT_SUCCESS  ="预约成功";
    public static final String ORDER_ACTIONC_PAY_MONEY_DATA_AUDITING ="打款资料审核中";
    public static final String ORDER_ACTIONC_DATA_AUDIT_SUCCESS="打款资料审核通过";
    public static final String ORDER_ACTIONC_CONTRACT_AUDITING ="合同审核中";
    public static final String ORDER_ACTIONC_CONTRACT_AUDIT_SUCCESS ="合同审核通过";

    public static final String PARAM_WEBWIEW_URL = "url";
    public static final String PARAM_WEBVIEW_DATA= "url_data";
    public static final String PARAM_TITLE = "title";
    public static final String PARAM_IS_JUMP = "is_jump";
    public static final String PARAM_TEM_SHOW = "template_show";
    public static final String PARAM_CONTENT = "content";
    public static final String PARAM_CONTENT2 = "content2";
    public static final String PARAM_ORDER = "order";
    public static final String PARAM_ORDER_ID = "order_id";
    public static final String PARAM_BANKCARD = "bank_card";
    public static final String PARAM_AMOUNT = "amount";
    public static final String PARAM_PRODUCT_NAME = "product_name";
    public static final String PARAM_PDF_URL = "pdf_url";
    public static final String PARAM_PRODUCT_INFO_URL = "product_info_url";
    public static final String PARAM_HAS_DATA= "has_data";
    public static final String PARAM_SIG_DATA= "sign_data";
    public static final String PARAM_UPDATA_MONEY_DATE_ENTITY= "UpdataMoneyDateEntity";
    public static final String PARAM_ORDER_LIST_ENTITY= "OrderListEntity";
    public static final String PARAM_RIST_WARM_TXT= "RiskWarnTxt";
    public static final String PARAM_CHECK_PDF_URL= "check_pdf_url";
    public static final String PARAM_CONTRACT_MODULE= "contract_module";
    public static final String PARAM_FROM_CODE_VIDEO_PRE= "from_code";
    public static final String PARAM_IS_FIX_VIDEO= "fix_video";
    public static final String PARAM_FROM_OUT_SIDE= "from_out_side";
    public static final String PARAM_JUST_SEE= "just_see";
    public static final String PARAM_ONLY_SEE_CONTRACT= "only_see_contract";
    public static final String PARAM_MENU_ITME_GONE= "mMenuItemGone";
    public static final String PARAM_TEMPLATE= "template";
    public static final String TEMPLATE= "template";
    public static final String PARAM_FILE_PATH= "file_path";
    public static final String PARAM_AGEMCY_VOUCHER= "AgencyVoucher";
    public static final String PARAM_UPLOAD_DATA= "upload_data";
    public static final String PARAM_LIST_UPLOAD_DATA= "list_upload_data";
    public static final String PARAM_APPLY= "param_apply";
    public static final String PARAM_IS_FROM_TYPE_CHANGGE= "is_from_type_change";
    public static final String PARAM_TXT_DATA = "txt_data";
    public static final String PARAM_TXT_BTN = "txt_btn";
    public static final String PARAM_FROM_CODE = "from_code";
    public static final String PARAM_FROM = "from";
    /**
     * 订单状态
     */
    public static final int ORDER_STATE_BOOK_FAILURE = 0;////预约失败
    public static final int ORDER_STATE_BOOK_SUCEESS = 1;////预约成功
    public static final int ORDER_STATE_BOOK_FORM_AUDITTING = 2;//打款资料审核中
    public static final int ORDER_STATE_FORM_SUCCESS = 3;//打款资料审核通过
    public static final int ORDER_STATE_FORM_FAILURE= 4;//打款审核未通过
    public static final int ORDER_STATE_CONTRACT_AUDITTING= 5;//合同审核中
    public static final int ORDER_STATE_CONTRACT_SUCCESS= 6;//合同审核通过
    public static final int ORDER_STATE_CONTRACT_FAILURE=7;//合同审核未通过


    public static final int FILESTYPE_INCOME=1;//订单收入证明编号
    public static final int FILESTYPE_ASSETS=2;//订单资产证明编号
    public static final int APPLY=-99;//订单资产证明编号

    public static final String INVESTOR_TYPE="investor_type";
    public static final int PERSONAL_INVESTOR=200;//个人投资者
    public static final int PERSONAL_INVESTOR_QUALIFIED=210;//个人-合格投资者
    public static final int PERSONAL_INVESTOR_QUALIFIED_Administrator=220;//个人-投资于所管理私募基金的私募基金管理人的从业人员
    public static final int PERSONAL_INVESTOR_QUALIFIED_ORDINARY=211;//个人-合格投资者-普通投资者
    public static final int PERSONAL_INVESTOR_QUALIFIED_MAJOR=212;//个人-合格投资者-专业投资者

    public static final int mechanism_INVESTOR=300;//机构投资者
    public static final int mechanism_INVESTOR_MAJOR=310;//机构-专业
    public static final int MECHANISM_INVESTOR_LEGAL_PERSON=320;//机构-法人及其他组织
    public static final int MECHANISM_INVESTOR_ADMINISTRATOR=330;//机构-投资于所管理私募基金的私募基金管理人
    public static final int MECHANISM_INVESTOR_LEGAL_PERSON_ORDINARY=321;//机构-法人及其他组织-普通
    public static final int MECHANISM_INVESTOR_LEGAL_PERSON_MAJOR=322;//机构-法人及其他组织-专业

    /**
     * 用户类型
     */
    public static final String USER_TYPE = "user_type";//个人
    public static final int USER_TYPE_PERSONAL = 1;//个人
    public static final int USER_TYPE_ORGANIZATION = 2;//机构
    /**
     * 个人 、三证分离、三证合一
     */
    public static final int UPDATA_STATE_TYPE_PERSONAL = 1;//个人
    public static final int UPDATA_STATE_TYPE_THREE = 1;//三证分离
    public static final int UPDATA_STATE_TYPE_ONE = 2;//三证合一

    /**
     * 上传文件类型id-合同
     */
    public static final int UPLOAD_FILE_TYPE_01 = 1001;
    /**
     * 上传文件类型id-项目文档
     */
    public static final int UPLOAD_FILE_TYPE_02 = 1002;
    /**
     * 上传文件类型id-头像
     */
    public static final int UPLOAD_FILE_TYPE_03 = 1003;
    /**
     * 上传文件类型id-名片
     */
    public static final int UPLOAD_FILE_TYPE_04 = 1004;
    /**
     * 上传文件类型id-身份证
     */
    public static final int UPLOAD_FILE_TYPE_05 = 1005;
    /**
     * 上传文件类型id-银行卡
     */
    public static final int UPLOAD_FILE_TYPE_06 = 1006;
    /**
     * 上传文件类型id-打款凭证
     */
    public static final int UPLOAD_FILE_TYPE_07 = 1007;
    /**
     * 上传文件类型id-视频
     */
    public static final int UPLOAD_FILE_TYPE_08 = 1008;
    /**
     * 上传文件类型id-三件套
     */
    public static final int UPLOAD_FILE_TYPE_09 = 1009;
    /**
     * 上传文件类型id-其他
     */
    public static final int UPLOAD_FILE_TYPE_10 = 1010;

    public static final String SELECT="_select";

    /**自动获取登录手机号*/
    public static final String KEY_PHONE_NUMBERS="key_phone_numbers";

    /**打款资料上传和修改*/
    public static final String JUST_SEE="just_see";
    /**保存用户账号*/
    public static final String KEY_LOGIN_NUMBERS="key_login_numbers";
    /**保存用户密码*/
    public static final String KEY_LOGIN_PASSWORD="key_login_password";
    /**本地缓存shared*/
    public static final String SHARED_UTIL="shared_util";
    /**本地缓存shared*/
    public static final String IS_FIRST="is_first";
    /**类型*/
    public static final String TYPE="type";
}
