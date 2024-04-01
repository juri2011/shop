package com.shop.repository;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
//@TestPropertySource(locations="classpath:application-test.properties")
public class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest(){
        Item item = new Item();
        item.setItemNm("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품 상세 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());

        Item savedItem = itemRepository.save(item);
        System.out.println(savedItem.toString());

    }
    @Test
    @DisplayName("@Query를 이용한 상품 조회 테스트")
    public void findByItemDetailTest(){
        this.createItemTest(); //위의 메소드 실행
        //interface 안에 선언한 @Query 사용 메소드 실행
        List<Item> itemList = itemRepository.findByItemDetail("테스트 상품 상세 설명");

        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }
    @Test
    @DisplayName("nativeQuery 속성을 이용한 상품 조회 테스트")
    public void findByItemDetailByNativeTest(){
        this.createItemTest(); //위의 메소드 실행
        //interface 안에 선언한 @Query 사용 메소드 실행
        List<Item> itemList =
                itemRepository.findByItemDetail("테스트 상품 상세 설명");

        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }
}
