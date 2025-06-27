package jp.co.internous.ecsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.co.internous.ecsite.dao.OrderHistoryDao;

/**
* 注文履歴機能を制御するコントローラークラス
* 注文履歴の登録、注文完了画面の表示を行う
*/
@Controller
public class OrderHistoryController {

	// 注文履歴テーブルへのデータアクセス
	@Autowired
	private OrderHistoryDao orderHistoryDao;

	// 注文履歴に登録して注文完了画面を表示する
	@GetMapping("/ecsite/order")
	public ModelAndView registerOrder(@RequestParam("productId") int productId,
								 	  @RequestParam("orderCount") int orderCount,
								 	  ModelAndView mav) {
		// 注文履歴テーブルに注文情報を登録する
		orderHistoryDao.insertOrderHistory(productId, orderCount);
		// レスポンスとして表示させるHTMLファイル名を指定する
		mav.setViewName("complate");
		return mav;
	}

}
