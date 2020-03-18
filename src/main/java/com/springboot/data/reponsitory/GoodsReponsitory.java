package com.springboot.data.reponsitory;

import com.springboot.data.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface GoodsReponsitory extends JpaRepository<Goods,Long> {
    List<Goods> findAllByUsername(String username);

    List<Goods> findAllByGoodsNameLike(String goodsName);

    /**
     * 获取一个商品信息
     */
    Goods findByGoodsId(long goodsId);

    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM goods WHERE goods_id = ?1",nativeQuery = true)
    int deleteGoods(long id);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE goods SET goods_name=?2,price=?3,quantity=?4 WHERE goods_id = ?1",nativeQuery = true)
    int updateGoodsInfo(long goodsId,String goodsName, String price,String quantity);
}
