package com.hvdomingues.DinnerApp;

import java.time.Instant;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.BillPayment;
import com.hvdomingues.DinnerApp.entities.Category;
import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.Order;
import com.hvdomingues.DinnerApp.entities.OrderItem;
import com.hvdomingues.DinnerApp.entities.Payment;
import com.hvdomingues.DinnerApp.entities.Product;
import com.hvdomingues.DinnerApp.entities.builder.EntityBuilder;

public class App 
{
    public static void main( String[] args )
    {
        
       EntityBuilder entityBuilder = new EntityBuilder();
       
       Bill bill1 = entityBuilder.createBill(null, 12, 0);
       IndividualBill indBill1 = entityBuilder.createIndividualBill(null, bill1, "Oswaldo", 3);
       Payment pay1 = entityBuilder.createPayment(null, Instant.now(), 60.00);
       BillPayment billPay1 = entityBuilder.createBillPayment(pay1, indBill1);
       Order order1 = entityBuilder.createOrder(null, Instant.now(), indBill1);
       Category cat1 = entityBuilder.createCategory(null, "Saladas");
       Product product1 = entityBuilder.createProduct(null, "Ceasar Salad", 15.00, "Salada com croutons", cat1);
       OrderItem orderItem1 = entityBuilder.createOrderItem(null, 4, order1, product1);
       
       System.out.println(bill1);
       System.out.println(indBill1);
       System.out.println(pay1);
       System.out.println(billPay1);
       System.out.println(order1);
       System.out.println(cat1);
       System.out.println(product1);
       System.out.println(orderItem1);
        
    }
}
