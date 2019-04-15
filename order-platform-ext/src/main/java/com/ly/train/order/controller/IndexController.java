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
package com.ly.train.order.controller;

import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ly.train.order.dao.OrderDao;
import com.ly.train.order.model.OrderExt;
import com.ly.train.order.util.R;
import com.ly.train.order.util.Response;

/**
 * @author leeyazhou
 *
 */
@RestController
public class IndexController {

  @Autowired
  private OrderDao orderDao;

  @RequestMapping(value = {"index", "index.html", "/"})
  public Response<String> index() {
    OrderExt order = new OrderExt();
    order.setCreateTime(new Date());
    order.setOrderNo(UUID.randomUUID().toString().replace("-", ""));
    order.setUserId(1L);

    orderDao.insert(order);
    return R.ok();
  }
}
