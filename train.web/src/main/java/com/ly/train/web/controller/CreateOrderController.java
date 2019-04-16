/**
 * Copyright © 2019 同程艺龙 (zhihui.li@ly.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ly.train.web.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ly.train.flower.common.annotation.Flower;
import com.ly.train.flower.web.spring.FlowerController;
import com.ly.train.order.model.ext.OrderExt;
import com.ly.train.web.service.StartService;

/**
 * @author leeyazhou
 *
 */
@RestController
@RequestMapping("/order/")
@Flower(value = "createOrderFlow", flowNumber = 8)
public class CreateOrderController extends FlowerController {

  @RequestMapping(value = "createOrder")
  public void createOrder(OrderExt orderExt, HttpServletRequest req) throws IOException {
    orderExt.setOrderNo(UUID.randomUUID().toString().replace("-", ""));
    orderExt.setCreateTime(new Date());
    logger.info("收到请求:{}", orderExt);
    doProcess(orderExt, req);
  }

  @Override
  public void buildFlower() {
    getServiceFlow().buildFlow(StartService.class.getSimpleName(), Arrays.asList("CreateOrderService", "CreateOrderExtService"));
    getServiceFlow().buildFlow(Arrays.asList("CreateOrderService", "CreateOrderExtService"), "EndService");
    getServiceFlow().build();
  }



}
