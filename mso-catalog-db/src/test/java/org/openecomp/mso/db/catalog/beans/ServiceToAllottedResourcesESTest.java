/*
 * This file was automatically generated by EvoSuite
 * Wed Feb 22 09:33:37 GMT 2017
 */

package org.openecomp.mso.db.catalog.beans;

import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Timestamp;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, useJEE = true)
public class ServiceToAllottedResourcesESTest extends ServiceToAllottedResourcesESTestscaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ServiceToAllottedResources serviceToAllottedResources0 = new ServiceToAllottedResources();
      serviceToAllottedResources0.setServiceModelUuid("serviceModelUuid=nullarModelCustomizationUuid=null");
      String string0 = serviceToAllottedResources0.getServiceModelUuid();
      assertEquals("serviceModelUuid=nullarModelCustomizationUuid=null", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ServiceToAllottedResources serviceToAllottedResources0 = new ServiceToAllottedResources();
      Timestamp timestamp0 = new Timestamp(0L);
      serviceToAllottedResources0.setCreated(timestamp0);
      Timestamp timestamp1 = serviceToAllottedResources0.getCreated();
      assertEquals("1970-01-01 00:00:00.0", timestamp1.toString());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ServiceToAllottedResources serviceToAllottedResources0 = new ServiceToAllottedResources();
      serviceToAllottedResources0.setArModelCustomizationUuid("D7q@");
      String string0 = serviceToAllottedResources0.getArModelCustomizationUuid();
      assertEquals("D7q@", string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ServiceToAllottedResources serviceToAllottedResources0 = new ServiceToAllottedResources();
      serviceToAllottedResources0.setArModelCustomizationUuid("");
      String string0 = serviceToAllottedResources0.getArModelCustomizationUuid();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ServiceToAllottedResources serviceToAllottedResources0 = new ServiceToAllottedResources();
      String string0 = serviceToAllottedResources0.toString();
      assertEquals("serviceModelUuid=nullarModelCustomizationUuid=null", string0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ServiceToAllottedResources serviceToAllottedResources0 = new ServiceToAllottedResources();
      serviceToAllottedResources0.setServiceModelUuid("");
      String string0 = serviceToAllottedResources0.getServiceModelUuid();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ServiceToAllottedResources serviceToAllottedResources0 = new ServiceToAllottedResources();
      Timestamp timestamp0 = new Timestamp((-683L));
      serviceToAllottedResources0.setCreated(timestamp0);
      Timestamp timestamp1 = serviceToAllottedResources0.getCreated();
      assertEquals("1969-12-31 23:59:59.317", timestamp1.toString());
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      ServiceToAllottedResources serviceToAllottedResources0 = new ServiceToAllottedResources();
      String string0 = serviceToAllottedResources0.getServiceModelUuid();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      ServiceToAllottedResources serviceToAllottedResources0 = new ServiceToAllottedResources();
      String string0 = serviceToAllottedResources0.getArModelCustomizationUuid();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test9()  throws Throwable  {
      ServiceToAllottedResources serviceToAllottedResources0 = new ServiceToAllottedResources();
      Timestamp timestamp0 = serviceToAllottedResources0.getCreated();
      assertNull(timestamp0);
  }
}
