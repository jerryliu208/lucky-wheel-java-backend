package com.developerExam.backend.Controller;

import com.developerExam.backend.Dto.RespDto;
import com.developerExam.backend.Service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lucky")
public class PrizeController {
    @Autowired
    PrizeService prizeService;

    @GetMapping("/get_prizes")
    public RespDto getPrizes(){
        return prizeService.getPrizes();
    }

    @GetMapping("/draw_prize")
    public RespDto drawPrize() {
        return prizeService.drawPrize();
    }

    @GetMapping("/reset_all_prize_stock")
    public RespDto resetAllPrizeStock() {
        return prizeService.resetAllPrizeStock();
    }
}
