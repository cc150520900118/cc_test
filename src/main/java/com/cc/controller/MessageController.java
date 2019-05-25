package com.cc.controller;

import com.alibaba.fastjson.JSON;
import com.cc.bean.MessagePojo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created by changc on 2019/3/6.
 *
 * <script type="text/javascript">
 *     $(document).ready(function(){
 *     var saveDataAry=[];
 *     var data1={"userName":"test","address":"gz"};
 *     var data2={"userName":"ququ","address":"gr"};
 *     saveDataAry.push(data1);
 *     saveDataAry.push(data2);
 *     $.ajax({
 *     type:"POST",
 *     url:"user/saveUser",
 *     dataType:"json",
 *     contentType:"application/json",        ------注意  @RequestBody   接收的是json字符串
 *     data:JSON.stringify(saveDataAry),         JSON.stringify：将一个JavaScript值(对象或者数组)转换为一个 JSON字符串
 *     success:function(data){
 *
 *      }
 *      });
 *      });
 *      </script>
 *Java代码
         @RequestMapping(value = "saveUser", method = {RequestMethod.POST }})
         @ResponseBody
         public void saveUser(@RequestBody List<User> users) {
         userService.batchSave(users);
         }
 *不使用@RequestBody注解时，* 可以接收Content-Type为application/x-www-form-urlencoded类型的请求所提交的数据，
          * 数据格式：aaa=111&bbb=222  ,form表单提交以及jQuery的.post()方法所发送的请求就是这种类型。
 *
 *如果不使用@RequestBody接受页面参数：
         public Map<String, Object> regProduct(HttpServletRequest request,
 @ApiParam(name = "customerProAuditPO", value = "产品注册实体")CustomerProAuditVO customerProAuditVO
 ) {

 }

 那么前台页面ajax应该这样写：
 var data = {
 customerName:customerName,
 };
 $.ajax({
 url:'',
 type: "POST",
 data: data,
 //async: false,
 dataType:"json",
 success: function(result) {
 var json = result;

 },
 error: function (xhr, ajaxOptions, thrownError) {
 console.log(thrownError);
 return false;
 }
 });
 *
 */
@Api(value = "aop测试接口", description = "提供aop接口")
@RestController
@Slf4j
public class MessageController {
    //方法描述
    @ApiOperation(value = "插入接口-插入map数据", notes = "插入map数据")
    //参数描述
    @ApiImplicitParam(name = "pojo", value = "{\"delay\":\"0\",\"className\":\"150000000000\"}")

    //返回值描述
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 405, message = "测试失败")
    })
    @PostMapping("/send_message")
    public String send_message(@RequestBody MessagePojo pojo) throws Exception {
        log.info("执行了controller.send_message方法");
        return JSON.toJSONString(pojo);
    }

    @ApiOperation(value = "测试接口", notes = "插入map数据")
    @GetMapping("select")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="用户名",dataType="string", paramType = "query",example="xingguo"),
            @ApiImplicitParam(name = "input", value = "接收参数的意义描述", paramType = "body", dataType = "demo«ArrayList«demo1»»", required = true),
            @ApiImplicitParam(name="id",value="用户id",dataType="string", paramType = "query")})
    public void select1(String name,String id){

    }
}