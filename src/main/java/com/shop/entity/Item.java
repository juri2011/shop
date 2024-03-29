package com.shop.entity;

//javax와 jakarta의 차이 : 버전 11과 버전 17
//같은 패키지 안에 클래스 2개 이상을 import한다면 *표로 바꿀 수 있다.

import com.shop.constant.ItemSellStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Access(AccessType.FIELD)
//@Table(name="item") 여기서는 쓸 필요 없는데 클래스명과 다른 테이블명을 쓰고 싶을 때는 사용
@Getter
@Setter
@ToString
public class Item {

    @Id //Primary key
    @Column(name="item_id") //필드명과 컬럼명을 다르게 지정할 때 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY)//key값의 생성을 database에게 맡긴다.
    private Long id;            //상품코드

    @Column(nullable = false, length = 50) //Not Null, VARCHAR(50)
    private String itemNm;      //상품명(카멜표기법으로 필드명을 작성하면 SQL에서는 스네이크표기법으로 작성된다.)

    @Column(nullable = false) //Not Null, VARCHAR(50)
    private int price;      //가격

    @Column(nullable = false) //Not Null, VARCHAR(50)
    private int stockNumber;      //재고수량

    @Lob //대량의 데이터를 저장할 때 사용(CLOB: 대량의 텍스트파일, BLOB: 대량의 이진파일)
    @Column(nullable = false) //Not Null, VARCHAR(50)
    private String itemDetail;      //상품 상세 설명

    @Enumerated(EnumType.STRING) //Not Null, VARCHAR(50)
    private ItemSellStatus itemSellStatus;      //상품 판매 상태

    private LocalDateTime regTime; //등록 시간

    private LocalDateTime updateTime; //수정 시간

}
