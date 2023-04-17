package com.example.SpringBoot.Repository;

import com.example.SpringBoot.Entity.Receipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository  extends CrudRepository<Receipt,Integer> {
}
