package com.demo.db.datasource.multdatasource.demo3;
import com.demo.db.datasource.multdatasource.demo1.CustomerContextHolder;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class CustomerRoutingDataSource extends AbstractRoutingDataSource {
 
   @Override
   protected Object determineCurrentLookupKey() {
      return CustomerContextHolder.getCustomerType();
   }

   @Override
   public Logger getParentLogger()   {
      return null;
   }
}
