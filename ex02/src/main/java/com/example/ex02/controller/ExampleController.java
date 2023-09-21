package com.example.ex02.controller;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ex02.domain.vo.Product;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ExampleController {
//	�̸��� �Է��ϰ� ��� �Ǵ� ��� ��ư Ŭ���Ѵ�.
//	��� �ð��� 09:00�̸�, ��� �ð� 18:00�̴�.
//	��� ��ư Ŭ�� �� 9�ð� ������ �������� ó���ϰ�,
//	��� ��ư Ŭ�� �� 18�� ���̶�� ����� �ƴ� �����ð����� ó���Ѵ�.

//	��� jsp�� work ��� �ȿ� �����ϸ� �ֶ�� ���� �б⺰�� jsp���� �� ���� �ۼ��Ѵ�.
	
//	- getToWork.jsp
//	- leaveWork.jsp
//	- late.jsp
//	- work.jsp
	
	@GetMapping("/checkIn")
	public String checkIn() {
		return "work/checkIn";
	}
	
	@GetMapping("/getToWork")
	public String getToWork(@ModelAttribute("name") String name) {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		
		boolean lateCondition = hour >= 9 && minute > 0;
		
		if(lateCondition) {
			return "work/late";
		}
		return "work/getToWork";
		
	}
	
	@GetMapping("/leaveWork")
	public String leaveWork(@ModelAttribute("name") String name) {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		
		boolean leaveWorkCondition = hour >= 18 && minute >= 0;
		
		if(leaveWorkCondition) {
			return "work/leaveWork";
		}
		return "work/work";
		
	}
	
//	��ǰ�� ���ڵ带 �Է¹ް� �ش� ��ǰ���� ����Ѵ�.
//	��¡�� ���� - 4383927
//	���� ���� - 0832147
//	���� ���� - 9841631
//	������ġ - 5587578
	
	@GetMapping("/market")
	public String goMarket() {
		return "market/market";
	}
	
	@PostMapping("/cashier")
	public String getProduct(String barcode, Model model) {
		String productName = null;
		
		switch(barcode) {
		case "4383927":
			productName = "��¡�� ����";
			break;
		case "0832147":
			productName = "���� ����";
			break;
		case "9841631":
			productName = "���� ����";
			break;
		case "5587578":
			productName = "������ġ";
			break;
		default:
			productName = "���� ��ǰ";
			break;
		}
		
		model.addAttribute("productName", productName);
		return "/market/cashier";
	}
	
//	������ ���η��� �ش� ��ǰ�� ����
//	��ư�� ���� �� ���� Ŭ���� ���η���ŭ ��ǰ�� ���� ����
	
//	@GetMapping("/sale")
//	�޼ҵ�� : goChangeSale
//	saleChange.jsp
//	- ����, ��ǰ��, ����,  �� 3���� �׸����� �����Ѵ�.
//	- �� ��ǰ�� ���� �κ��� raido��ư���� �����Ѵ�.
//	- ���η� ��ư�� �� 4���� ��ư���� �����ϰ�,
//	  ���� 10%, 30%, 60%, 90%
//	- �������� ���� ��ư�� �����Ͽ� form�±׸� �����Ѵ�.
	@GetMapping("/sale")
	public String goChangeSale() {
		return "product/saleChange";
	}
	
	
//	@PostMapping("/change")
// �޼ҵ�� : change
//	��ǰ �� ��ü(Product)�� ��ü ������ ���޹޴´�.
//	���޹��� ��ǰ ���ݿ� ���η��� ������ ������
//	showChange.jsp�� �����Ѵ�.
	@PostMapping("/change")
	public String change(Product product, Model model) throws UnsupportedEncodingException{
		log.info(product);
		double rating = (100 - product.getDiscountRate()) * 0.01;
		model.addAttribute("originPrice", product.getProductPrice());
		product.setProductPrice((int)(product.getProductPrice() * rating)); 
		return "product/showChange";
	}
	
	@PostMapping("/usePoint")
	public String usePoint(@ModelAttribute("product") Product product) {
		return "product/usePoint";
	}
	
	@PostMapping("/use")
	public String use(Product product, Integer point, Model model) {
		int cash = product.getProductPrice() - point;
//		if(cash < 1) {
		if(point >= product.getProductPrice()) {
			point = product.getProductPrice();
			cash = 0;
		}
		
		model.addAttribute("product", product);
		model.addAttribute("point", point);
		model.addAttribute("cash", cash);
		
		return "product/payment";
	}
}
















