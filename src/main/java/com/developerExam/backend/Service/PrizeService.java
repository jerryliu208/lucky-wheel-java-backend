package com.developerExam.backend.Service;

import com.developerExam.backend.Dto.RespDto;
import com.developerExam.backend.Model.Prize;
import com.developerExam.backend.Repository.PrizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PrizeService {
    @Autowired
    PrizeRepository prizeRepository;

    public RespDto getPrizes(){
        List<Prize> prizes = new ArrayList<>();
        try {
            prizes = prizeRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return new RespDto().setOk(0).setCode(400).setMsg("取得所有獎品時錯誤："+e.getMessage());
        }

        return new RespDto().setOk(1).setCode(200).setData(prizes);
    }

    public RespDto drawPrize() {
        List<Prize> prizes = new ArrayList<>();

        try{
            prizes = prizeRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return new RespDto().setOk(0).setCode(400).setMsg("抽獎取得獎品時錯誤："+e.getMessage());
        }

        int min = 0;
        int max = prizes.size();
        Random random = new Random();
        int index = random.nextInt(max+min)+min;

        Prize prize = new Prize();
        try {
            prize = prizeRepository.findOneById(prizes.get(index).getId());
        }catch (Exception e){
            e.printStackTrace();
            return new RespDto().setOk(0).setCode(400).setMsg("抽獎取得id為"+prizes.get(index).getId()+"之獎品時錯誤："+e.getMessage());
        }
        if(prize.getPrizeStock()-1<0){
            return new RespDto().setOk(0).setCode(200).setMsg("獎品"+prize.getPrizeName()+"已無庫存...").setData(prize);
        }
        try {
            prize.setPrizeStock(prize.getPrizeStock()-1);
            prize = prizeRepository.save(prize);
        }catch (Exception e){
            e.printStackTrace();
            return new RespDto().setOk(0).setCode(400).setMsg("抽獎更新"+prizes.get(index).getId()+"之獎品庫存時錯誤："+e.getMessage());
        }

        return new RespDto().setOk(1).setCode(200).setData(prize);
    }

    public RespDto resetAllPrizeStock(){
        List<Prize> prizes = new ArrayList<>();

        try{
            prizes = prizeRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return new RespDto().setOk(0).setCode(400).setMsg("重設所有獎品取得獎品時錯誤："+e.getMessage());
        }

        for(Prize prize:prizes){
            prize.setPrizeStock(prize.getId());
            try {
                prizeRepository.save(prize);
            }catch (Exception e){
                e.printStackTrace();
                return new RespDto().setOk(0).setCode(400).setMsg("重設所有獎品庫存量時錯誤："+e.getMessage());
            }
        }

        return new RespDto().setOk(1).setCode(200).setMsg("重設所有獎品庫存量成功！");
    }
}
