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
package com.ly.train.order.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author leeyazhou
 *
 */
@Configuration
public class DruidDataSourceConfiguration {

  @Bean
  public DataSource dataSourceOne() {
    DruidDataSource dataSource = new DruidDataSource();
    Properties properties = new Properties();
    properties.put("druid.url", "jdbc:mysql://localhost:3306/flower?characterEncoding=UTF-8");
    properties.put("druid.username", "root");
    properties.put("druid.password", "kuche123");
    properties.put("druid.initialSize", "8");
    properties.put("druid.minIdle", "8");
    properties.put("druid.maxActive", "32");
    properties.put("druid.maxWait", "60000");
    properties.put("druid.timeBetweenEvictionRunsMillis", "2000");

    properties.put("druid.validationQuery", "select 1");
    properties.put("druid.testWhileIdle", "true");
    properties.put("druid.testOnBorrow", "false");
    properties.put("druid.testOnReturn", "false");
    
    dataSource.configFromPropety(properties);
    return dataSource;
  }
}
