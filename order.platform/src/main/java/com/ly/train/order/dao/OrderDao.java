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
package com.ly.train.order.dao;

import org.apache.ibatis.annotations.Insert;
import com.ly.train.order.model.Order;

/**
 * @author leeyazhou
 *
 */
public interface OrderDao {

  @Insert("insert into fl_order(order_no, user_id, price, num, order_status,create_time) values(#{orderNo}, #{userId}, #{price}, #{num}, #{orderStatus}, #{createTime})")
  public void insert(Order order);
}
