
package com.gwnu.smart.domain;

        import lombok.AllArgsConstructor;
        import lombok.Builder;
        import lombok.Getter;
        import lombok.NoArgsConstructor;

        import javax.persistence.*;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Medicine1 {
    @Id
    @GeneratedValue
    private Long id;
    private String itemSeq; //품목 일련번호
    private String itemName; //품목명
    private String entpSeq; //업체 일련번호
    private String entpName; //업체명
    private String chart; //성상
    private String itemImage; //제품이미지
    private String printFront; //표시(앞)
    private String printBack; //표시(뒤)
    private String drugShape; //의약품 모양
    private String colorClass1; //색깔(앞)
    private String colorClass2; //색깔(뒤)
    private String lineFront; //분할선(앞)
    private String lineBack; //분할선(뒤)
    private String lengLong; //크기(장축)
    private String lengShort; //크기(단축)
    private String thick; //크기(두께)
    private String imgRegistRs; //이미지 생성일
    private String classNo; //분류 번호
    private String className; //분류명
    private String etcOtcName; //전문/일반
    private String itemPermitDate;  //품목허가일지
    private String formCodeName; //제형코드이름

    private String markCodeFrontAnal; //마크내용(앞)
    private String markCodeBackAnal; // 마크내용(뒤)
    private String markCodeFrontImg; // 마크이미지(앞)
    private String markCodeBackImg; //마크이미지(뒤)
    private String itemEngName; //제품영문명
    private String changeDate; //변경일자
    private String markCodeFront; //마크코드(앞)
    private String markCodeBack; //마크코드 (뒤)
    private String ediCode; //보험코드
    /*
    private Long id;
    private String ITEM_SEQ; //품목 일련번호
    private String itemName; //품목명
    private String ENTP_SEQ; //업체 일련번호
    private String ENTP_NAME; //업체명
    private String CHART; //성상
    private String ITEM_IMAGE; //제품이미지
    private String PRINT_FRONT; //표시(앞)
    private String PRINT_BACK; //표시(뒤)
    private String DRUG_SHAPE; //의약품 모양
    private String COLOR_CLASS1; //색깔(앞)
    private String COLOR_CLASS2; //색깔(뒤)
    private String LINE_FRONT; //분할선(앞)
    private String LINE_BACK; //분할선(뒤)
    private Double LENG_LONG; //크기(장축)
    private Double LENG_SHORT; //크기(단축)
    private Double THICK; //크기(두께)
    private String IMG_REGIST_TS; //이미지 생성일
    private String CLASS_NO; //분류 번호
    private String CLASS_NAME; //분류명
    private String ETC_OTC_NAME; //전문/일반
    private String ITEM_PERMIT_DATE;  //품목허가일지
    private String FORM_CODE_NAME; //제형코드이름

    private String MARK_CODE_FRONT_ANAL; //마크내용(앞)
    private String MARK_CODE_BACK_ANAL; // 마크내용(뒤)
    private String MARK_CODE_FRONT_IMG; // 마크이미지(앞)
    private String MARK_CODE_BACK_IMG; //마크이미지(뒤)
    private String ITEM_ENG_NAME; //제품영문명
    private String CHANGE_DATE; //변경일자
    private String MARK_CODE_FRONT; //마크코드(앞)
    private String MARK_CODE_BACK; //마크코드 (뒤)
    private String EDI_CODE; //보험코드*/
}

