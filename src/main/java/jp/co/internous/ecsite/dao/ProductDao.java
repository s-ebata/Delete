package jp.co.internous.ecsite.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.ecsite.dto.ProductDto;

/**
 * 商品情報にアクセスするためのDAO
 */
@Mapper
public interface ProductDao {

	// 商品情報の全件検索
    @Select("""
        SELECT
          p.product_id,
          p.product_name,
          p.product_price,
          p.product_image_path,
          c.category_name
        FROM
          product AS p
        INNER JOIN
          category AS c
        ON
          p.category_id = c.category_id
        ORDER BY
          p.product_id;
            """)
	ArrayList<ProductDto> getAllProducts();

	 //商品IDによる単一の商品検索
    @Select("""
        SELECT
          p.product_id,
          p.product_name,
          p.product_description,
          p.product_price,
          p.product_image_path,
          c.category_name
        FROM
          product AS p
        INNER JOIN
          category AS c
        ON
          p.category_id = c.category_id
         WHERE
            p.product_id = #{productId};
    	    """)
	ProductDto getProductByProductId(int productId);

}
