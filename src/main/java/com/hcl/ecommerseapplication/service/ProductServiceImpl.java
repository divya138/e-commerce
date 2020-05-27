package com.hcl.ecommerseapplication.service;

import java.util.Optional;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.ecommerseapplication.dao.CategoryRepository;
import com.hcl.ecommerseapplication.dao.ProductRepository;
import com.hcl.ecommerseapplication.dao.UserRepository;
import com.hcl.ecommerseapplication.dto.TransferDto;
import com.hcl.ecommerseapplication.model.Category;
import com.hcl.ecommerseapplication.model.Product;
import com.hcl.ecommerseapplication.model.Transaction;
import com.hcl.ecommerseapplication.model.User;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	RestTemplate restTemplate;
	
	
	@Override
	public ResponseEntity<Product> buyProduct(String username, int productId,int categoryId,TransferDto transferDto) {
		Category category=categoryRepository.getOne(categoryId);
		User user=userRepository.findByEmail(username);
		Optional<Product> optional=productRepository.findById(productId);
		Product product=null;
		if(optional.isPresent()) {
			product=optional.get();
			
		}
		System.out.println(category.getCategoryId());
		if((product!=null)&&(user!=null)&&(category.getProducts().contains(product))) {
			String uri = "http://localhost:9093/transfer";

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			JSONObject request = new JSONObject();
			request.put("savingsAccountNumber",transferDto.getUserAccountNumber());
			request.put("beneficiaryAccountNumber", transferDto.getEcommerceAccountNumber());
			request.put("transferAmmount", product.getPrice());

			HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

			ResponseEntity<Transaction> response = restTemplate.postForEntity(uri, entity, Transaction.class);

			System.out.println(response);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		
		return null;
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
