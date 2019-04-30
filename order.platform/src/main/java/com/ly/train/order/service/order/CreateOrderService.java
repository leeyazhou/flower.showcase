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
package com.ly.train.order.service.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.ly.train.flower.common.annotation.FlowerService;
import com.ly.train.flower.common.service.Service;
import com.ly.train.flower.common.service.container.ServiceContext;
import com.ly.train.order.dao.OrderDao;
import com.ly.train.order.model.Order;

/**
 * @author leeyazhou
 * 
 */
@FlowerService
public class CreateOrderService implements Service<Order, Boolean> {
  private static final Logger logger = LoggerFactory.getLogger(CreateOrderService.class);
  @Autowired
  private OrderDao orderDao;

  @Override
  public Boolean process(Order message, ServiceContext context) throws Throwable {
    try {
      orderDao.insert(message);
      logger.info("创建订单 : {}", message);
    } catch (Exception e) {
      logger.error("", e);
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }

}
