package com.example.demo.presenter;

import com.example.demo.application.usecases.OrdersStatistic_UC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders/statistic")
public class OrderStatisticController
{
    @Autowired
    private OrdersStatistic_UC statisticUC;

    @GetMapping
    @CrossOrigin("*")
    public String calculateAverageItemsPerOrder() {
        return statisticUC.run();
    }


}
