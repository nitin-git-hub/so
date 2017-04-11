/*
 * This file was automatically generated by EvoSuite
 * Mon Feb 20 14:10:17 GMT 2017
 */

package org.openecomp.mso.adapters.vnfrest;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import org.openecomp.mso.adapters.vnfrest.CreateVfModuleResponse;
import org.openecomp.mso.adapters.vnfrest.VfModuleRollback;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, useJEE = true)
public class CreateVfModuleResponseESTest extends CreateVfModuleResponseESTestscaffolding {

    @Test(timeout = 4000)
    public void test00()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        createVfModuleResponse0.setVnfId("");
        String string0 = createVfModuleResponse0.getVnfId();
        assertEquals("", string0);
    }

    @Test(timeout = 4000)
    public void test01()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        createVfModuleResponse0.setVfModuleStackId("}V=E6z^$czD");
        String string0 = createVfModuleResponse0.getVfModuleStackId();
        assertEquals("}V=E6z^$czD", string0);
    }

    @Test(timeout = 4000)
    public void test02()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        createVfModuleResponse0.setVfModuleOutputs((Map<String, String>) null);
        Map<String, String> map0 = createVfModuleResponse0.getVfModuleOutputs();
        assertNull(map0);
    }

    @Test(timeout = 4000)
    public void test03()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        createVfModuleResponse0.setVfModuleId("Zc%GM]/E*oKC:3T=N_");
        String string0 = createVfModuleResponse0.getVfModuleId();
        assertEquals("Zc%GM]/E*oKC:3T=N_", string0);
    }

    @Test(timeout = 4000)
    public void test04()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        Boolean boolean0 = createVfModuleResponse0.getVfModuleCreated();
        assertNull(boolean0);
    }

    @Test(timeout = 4000)
    public void test05()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        String string0 = createVfModuleResponse0.getVnfId();
        assertNull(string0);
    }

    @Test(timeout = 4000)
    public void test06()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        Map<String, String> map0 = createVfModuleResponse0.getVfModuleOutputs();
        CreateVfModuleResponse createVfModuleResponse1 = new CreateVfModuleResponse((String) null, (String) null, (String) null, (Boolean) null, map0, (VfModuleRollback) null, "g[03BX;$B");
        VfModuleRollback vfModuleRollback0 = createVfModuleResponse1.getRollback();
        assertNull(vfModuleRollback0);
    }

    @Test(timeout = 4000)
    public void test07()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        String string0 = createVfModuleResponse0.getVfModuleStackId();
        assertNull(string0);
    }

    @Test(timeout = 4000)
    public void test08()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        VfModuleRollback vfModuleRollback0 = createVfModuleResponse0.getRollback();
        createVfModuleResponse0.setRollback(vfModuleRollback0);
        assertNull(vfModuleRollback0.getVnfId());
    }

    @Test(timeout = 4000)
    public void test09()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        createVfModuleResponse0.setVnfId("z");
        String string0 = createVfModuleResponse0.getVnfId();
        assertEquals("z", string0);
    }

    @Test(timeout = 4000)
    public void test10()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        createVfModuleResponse0.setVfModuleStackId("");
        String string0 = createVfModuleResponse0.getVfModuleStackId();
        assertEquals("", string0);
    }

    @Test(timeout = 4000)
    public void test11()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        createVfModuleResponse0.setVfModuleId("");
        String string0 = createVfModuleResponse0.getVfModuleId();
        assertEquals("", string0);
    }

    @Test(timeout = 4000)
    public void test12()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        String string0 = createVfModuleResponse0.getVfModuleId();
        assertNull(string0);
    }

    @Test(timeout = 4000)
    public void test13()  throws Throwable  {
        CreateVfModuleResponse createVfModuleResponse0 = new CreateVfModuleResponse();
        createVfModuleResponse0.setVfModuleCreated((Boolean) null);
        assertNull(createVfModuleResponse0.getVnfId());
    }
}
