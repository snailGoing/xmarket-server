package me.jcala.xmarket.server.ctrl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.jcala.xmarket.server.conf.ApiConf;
import me.jcala.xmarket.server.entity.dto.Result;
import me.jcala.xmarket.server.service.inter.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api("跟学校有关的api")
@RestController
@Slf4j
public class TradeController {

    private TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }


    @ApiOperation(value = "获取指定分类下的商品",response = Result.class,produces = "application/json;charset=UTF-8")
    @GetMapping(value = ApiConf.get_tag_trades,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> gainTradeListByTag(@PathVariable("tagId") String tagId){
        // TODO: 16-12-10  没有将tagId修正为tagName
        return tradeService.getTradeListBySort(tagId);
    }

    @ApiOperation(value = "获取学校商品列表",response = Result.class,produces = "application/json;charset=UTF-8")
    @GetMapping(value = ApiConf.get_school_trades,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> gainSchoolTradeList(@PathVariable("schoolName") String schoolName,Pageable page){
        return tradeService.getTradeListBySchoolName(schoolName,page);
    }

    @ApiOperation(value = "通过id获取商品的详细信息",response = Result.class,produces = "application/json;charset=UTF-8")
    @GetMapping(value = ApiConf.get_trade,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> gainTradeDetailById(@PathVariable("tradeId") String tradeId){
       // TODO: 16-12-10  没有实现商品详细信息的获取
        return null;
    }


    @ApiOperation(value = "发布商品",response = Result.class,produces = "application/json;charset=UTF-8")
    @PostMapping(value = ApiConf.create_trade,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> create(@PathVariable("userId") String userId,@RequestParam String trade,HttpServletRequest request){
        return tradeService.createTrade(userId,trade,request);
    }


}
