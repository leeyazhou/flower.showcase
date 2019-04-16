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
package com.ly.train.order.model;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author leeyazhou
 *
 */
public class OrderExt extends Order implements Serializable {

  private String goods;
  private String to;
  private String from;
  private String remark;



  public String getGoods() {
    return goods;
  }



  public void setGoods(String goods) {
    this.goods = goods;
  }



  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
