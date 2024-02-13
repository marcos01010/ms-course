package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Payment;
import com.example.demo.entities.Worker;
import com.example.demo.services.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
				
		return new Payment(worker.getName(), worker.getDailyIncome(),days);
	}
}
