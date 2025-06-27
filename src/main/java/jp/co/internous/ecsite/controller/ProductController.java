package jp.co.internous.ecsite.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.co.internous.ecsite.dao.ProductDao;
import jp.co.internous.ecsite.dto.ProductDto;

/**
* 商品情報を制御するコントローラークラス
* 商品一覧の表示、商品詳細表示を行う
*/
@Controller
public class ProductController {

	// 商品テーブルへのデータアクセス
	@Autowired
	private ProductDao productDao;

	// 全商品情報を取得して商品一覧画面を表示する
    // http://localhost:8080/ecsite/product
	@GetMapping("/ecsite/product")
	public ModelAndView showProductList(ModelAndView mav) {
		// 商品テーブルから全ての商品情報を取得する
		ArrayList<ProductDto> productList = productDao.getAllProducts();
		// レスポンスとして商品検索結果を追加する
		mav.addObject("productList", productList);
		// レスポンスとして表示させるHTMLファイル名を指定する
		mav.setViewName("product_list");
		return mav;
	}

	// 単一商品情報を取得して商品詳細画面を表示する
	@GetMapping("/ecsite/detail")
	public ModelAndView showDetail(@RequestParam("productId") int productId, ModelAndView mav) {
		// 商品テーブルから商品IDを元に単一の商品情報を取得する
		ProductDto product = productDao.getProductByProductId(productId);
		// レスポンスとして商品検索結果を追加する
		mav.addObject("product", product);
		// レスポンスとして表示させるHTMLファイル名を指定する
		mav.setViewName("detail");
		return mav;
	}

}
