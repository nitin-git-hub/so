/*
 * This file was automatically generated by EvoSuite
 * Mon Feb 20 14:12:21 GMT 2017
 */

package org.openecomp.mso.adapters.catalogrest;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;
import org.openecomp.mso.db.catalog.beans.ServiceMacroHolder;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, useJEE = true)
public class QueryServiceMacroHolderESTest extends QueryServiceMacroHolderESTestscaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ServiceMacroHolder serviceMacroHolder0 = mock(ServiceMacroHolder.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(serviceMacroHolder0).toString();
      QueryServiceMacroHolder queryServiceMacroHolder0 = new QueryServiceMacroHolder(serviceMacroHolder0);
      String string0 = queryServiceMacroHolder0.toString();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ServiceMacroHolder serviceMacroHolder0 = mock(ServiceMacroHolder.class, new ViolatedAssumptionAnswer());
      doReturn("com.att.eelf.policy").when(serviceMacroHolder0).toString();
      QueryServiceMacroHolder queryServiceMacroHolder0 = new QueryServiceMacroHolder(serviceMacroHolder0);
      String string0 = queryServiceMacroHolder0.toString();
      assertEquals("com.att.eelf.policy", string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ServiceMacroHolder serviceMacroHolder0 = mock(ServiceMacroHolder.class, new ViolatedAssumptionAnswer());
      doReturn("com.att.eelf.policy").when(serviceMacroHolder0).toString();
      QueryServiceMacroHolder queryServiceMacroHolder0 = new QueryServiceMacroHolder(serviceMacroHolder0);
      ServiceMacroHolder serviceMacroHolder1 = queryServiceMacroHolder0.getServiceResources();
      assertSame(serviceMacroHolder1, serviceMacroHolder0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      QueryServiceMacroHolder queryServiceMacroHolder0 = new QueryServiceMacroHolder((ServiceMacroHolder) null);
      // Undeclared exception!
      try {
        queryServiceMacroHolder0.toString();
        fail("Expecting exception: NullPointerException");

      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.openecomp.mso.adapters.catalogrest.QueryServiceMacroHolder", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ServiceMacroHolder serviceMacroHolder0 = mock(ServiceMacroHolder.class, new ViolatedAssumptionAnswer());
      doReturn("").when(serviceMacroHolder0).toString();
      QueryServiceMacroHolder queryServiceMacroHolder0 = new QueryServiceMacroHolder(serviceMacroHolder0);
      String string0 = queryServiceMacroHolder0.toString();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      QueryServiceMacroHolder queryServiceMacroHolder0 = new QueryServiceMacroHolder();
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ServiceMacroHolder serviceMacroHolder0 = mock(ServiceMacroHolder.class, new ViolatedAssumptionAnswer());
      QueryServiceMacroHolder queryServiceMacroHolder0 = new QueryServiceMacroHolder(serviceMacroHolder0);
      // Undeclared exception!
      try {
        queryServiceMacroHolder0.toJsonString();
        fail("Expecting exception: VerifyError");

      } catch(VerifyError e) {
         //
         // (class: org/codehaus/jackson/map/MapperConfig, method: <clinit> signature: ()V) Bad type in putfield/putstatic
         //
         verifyException("org.codehaus.jackson.map.ObjectMapper", e);
      }
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      QueryServiceMacroHolder queryServiceMacroHolder0 = new QueryServiceMacroHolder((ServiceMacroHolder) null);
      ServiceMacroHolder serviceMacroHolder0 = queryServiceMacroHolder0.getServiceResources();
      assertNull(serviceMacroHolder0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      ServiceMacroHolder serviceMacroHolder0 = mock(ServiceMacroHolder.class, new ViolatedAssumptionAnswer());
      QueryServiceMacroHolder queryServiceMacroHolder0 = new QueryServiceMacroHolder(serviceMacroHolder0);
      ServiceMacroHolder serviceMacroHolder1 = mock(ServiceMacroHolder.class, new ViolatedAssumptionAnswer());
      queryServiceMacroHolder0.setServiceResources(serviceMacroHolder1);
  }
}
