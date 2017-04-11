/*
 * This file was automatically generated by EvoSuite
 * Fri Feb 17 16:22:30 GMT 2017
 */

package org.openecomp.mso.openstack.beans;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.MockitoExtension.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;
import org.openecomp.mso.entity.MsoRequest;
import org.openecomp.mso.openstack.beans.VnfRollback;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, useJEE = true)
public class VnfRollbackESTest extends VnfRollbackESTestscaffolding {

    @Test(timeout = 4000)
    public void test05()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.setVolumeGroupHeatStackId("");
        vnfRollback0.getVolumeGroupHeatStackId();
        assertFalse(vnfRollback0.getTenantCreated());
        assertFalse(vnfRollback0.getVnfCreated());
    }

    @Test(timeout = 4000)
    public void test06()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.getVnfId();
        assertFalse(vnfRollback0.getTenantCreated());
        assertFalse(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.isBase());
    }

    @Test(timeout = 4000)
    public void test07()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback("M+!!EJC*~uO", "Q,@Ir,{J2Nuu", "M+!!EJC*~uO", true, true, (MsoRequest) null, "M+!!EJC*~uO", "", "Q,@Ir,{J2Nuu", "");
        assertEquals("M+!!EJC*~uO", vnfRollback0.getVnfId());

        vnfRollback0.setVnfId("");
        vnfRollback0.getVnfId();
        assertEquals("Q,@Ir,{J2Nuu", vnfRollback0.getTenantId());
    }

    @Test(timeout = 4000)
    public void test08()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        boolean boolean0 = vnfRollback0.getVnfCreated();
        assertFalse(vnfRollback0.isBase());
        assertFalse(boolean0);
        assertFalse(vnfRollback0.getTenantCreated());
    }

    @Test(timeout = 4000)
    public void test09()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.setVfModuleStackId("VnfRollback: cloud=");
        vnfRollback0.getVfModuleStackId();
        assertFalse(vnfRollback0.getTenantCreated());
        assertFalse(vnfRollback0.isBase());
        assertFalse(vnfRollback0.getVnfCreated());
    }

    @Test(timeout = 4000)
    public void test10()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.setVfModuleStackId("");
        vnfRollback0.getVfModuleStackId();
        assertFalse(vnfRollback0.isBase());
        assertFalse(vnfRollback0.getTenantCreated());
        assertFalse(vnfRollback0.getVnfCreated());
    }

    @Test(timeout = 4000)
    public void test11()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback((String) null, (String) null, ", vnf=", false, true, (MsoRequest) null, "", ", vnf=", "", "");
        String string0 = vnfRollback0.getTenantId();
        assertTrue(vnfRollback0.getVnfCreated());
        assertEquals(", vnf=", vnfRollback0.getVolumeGroupId());
        assertNull(string0);
        assertEquals("", vnfRollback0.getVolumeGroupName());
        assertEquals(", vnf=", vnfRollback0.getCloudSiteId());
        assertEquals("", vnfRollback0.getRequestType());
        assertFalse(vnfRollback0.isBase());
        assertFalse(vnfRollback0.getTenantCreated());
        assertEquals("", vnfRollback0.getModelCustomizationUuid());
    }

    @Test(timeout = 4000)
    public void test12()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        assertFalse(vnfRollback0.getTenantCreated());

        vnfRollback0.setTenantCreated(true);
        boolean boolean0 = vnfRollback0.getTenantCreated();
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test13()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.setRequestType("$W[I&I@KHseI MUVb");
        vnfRollback0.getRequestType();
        assertFalse(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.isBase());
        assertFalse(vnfRollback0.getTenantCreated());
    }

    @Test(timeout = 4000)
    public void test14()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback((String) null, (String) null, ", vnf=", false, true, (MsoRequest) null, "", ", vnf=", "", "");
        String string0 = vnfRollback0.getRequestType();
        assertTrue(vnfRollback0.getVnfCreated());
        assertEquals("", vnfRollback0.getVolumeGroupName());
        assertNotNull(string0);
        assertEquals(", vnf=", vnfRollback0.getCloudSiteId());
        assertFalse(vnfRollback0.getTenantCreated());
        assertEquals("", string0);
        assertEquals(", vnf=", vnfRollback0.getVolumeGroupId());
        assertEquals("", vnfRollback0.getModelCustomizationUuid());
        assertFalse(vnfRollback0.isBase());
    }

    @Test(timeout = 4000)
    public void test15()  throws Throwable  {
        MsoRequest msoRequest0 = mock(MsoRequest.class, new ViolatedAssumptionAnswer());
        doReturn((String) null).when(msoRequest0).toString();
        VnfRollback vnfRollback0 = new VnfRollback("b", "b", "b", true, false, msoRequest0, "b", "b", "*^0M|pdSi&sbx2u>4q#", (String) null);
        vnfRollback0.getMsoRequest();
        assertEquals("b", vnfRollback0.getCloudSiteId());
        assertEquals("b", vnfRollback0.getTenantId());
        assertFalse(vnfRollback0.getVnfCreated());
        assertEquals("b", vnfRollback0.getVnfId());
        assertEquals("b", vnfRollback0.getVolumeGroupName());
        assertEquals("*^0M|pdSi&sbx2u>4q#", vnfRollback0.getRequestType());
        assertEquals("b", vnfRollback0.getVolumeGroupId());
        assertFalse(vnfRollback0.isBase());
        assertTrue(vnfRollback0.getTenantCreated());
    }

    @Test(timeout = 4000)
    public void test16()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.getModelCustomizationUuid();
        assertFalse(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.getTenantCreated());
        assertFalse(vnfRollback0.isBase());
    }

    @Test(timeout = 4000)
    public void test17()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.setModelCustomizationUuid("<W,?yK`bP1Yb75G%66");
        vnfRollback0.getModelCustomizationUuid();
        assertFalse(vnfRollback0.getTenantCreated());
        assertFalse(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.isBase());
    }

    @Test(timeout = 4000)
    public void test18()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.setCloudSiteId("yqA[Rq2FB8g2");
        vnfRollback0.getCloudSiteId();
        assertFalse(vnfRollback0.isBase());
        assertFalse(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.getTenantCreated());
    }

    @Test(timeout = 4000)
    public void test19()  throws Throwable  {
        MsoRequest msoRequest0 = mock(MsoRequest.class, new ViolatedAssumptionAnswer());
        VnfRollback vnfRollback0 = new VnfRollback("", ")\"J", "", true, true, msoRequest0, "%~~n", "%~~n", (String) null, "%~~n");
        String string0 = vnfRollback0.getCloudSiteId();
        assertEquals("", string0);
        assertEquals(")\"J", vnfRollback0.getTenantId());
        assertFalse(vnfRollback0.isBase());
        assertEquals("%~~n", vnfRollback0.getModelCustomizationUuid());
        assertNotNull(string0);
        assertTrue(vnfRollback0.getVnfCreated());
        assertEquals("%~~n", vnfRollback0.getVolumeGroupId());
        assertTrue(vnfRollback0.getTenantCreated());
        assertEquals("", vnfRollback0.getVnfId());
        assertEquals("%~~n", vnfRollback0.getVolumeGroupName());
    }

    @Test(timeout = 4000)
    public void test20()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.setBaseGroupHeatStackId("x|gP");
        vnfRollback0.getBaseGroupHeatStackId();
        assertFalse(vnfRollback0.getTenantCreated());
        assertFalse(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.isBase());
    }

    @Test(timeout = 4000)
    public void test21()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.setBaseGroupHeatStackId("");
        vnfRollback0.getBaseGroupHeatStackId();
        assertFalse(vnfRollback0.isBase());
        assertFalse(vnfRollback0.getTenantCreated());
        assertFalse(vnfRollback0.getVnfCreated());
    }

    @Test(timeout = 4000)
    public void test22()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.getVolumeGroupId();
        assertFalse(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.getTenantCreated());
        assertFalse(vnfRollback0.isBase());
    }

    @Test(timeout = 4000)
    public void test23()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.setTenantId("");
        vnfRollback0.getTenantId();
        assertFalse(vnfRollback0.isBase());
        assertFalse(vnfRollback0.getTenantCreated());
        assertFalse(vnfRollback0.getVnfCreated());
    }

    @Test(timeout = 4000)
    public void test24()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.getRequestType();
        assertFalse(vnfRollback0.isBase());
        assertFalse(vnfRollback0.getTenantCreated());
        assertFalse(vnfRollback0.getVnfCreated());
    }

    @Test(timeout = 4000)
    public void test25()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.getVolumeGroupHeatStackId();
        assertFalse(vnfRollback0.isBase());
        assertFalse(vnfRollback0.getTenantCreated());
        assertFalse(vnfRollback0.getVnfCreated());
    }

    @Test(timeout = 4000)
    public void test26()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback("M+!!EJC*~uO", "Q,@Ir,{J2Nuu", "M+!!EJC*~uO", true, true, (MsoRequest) null, "M+!!EJC*~uO", "", "Q,@Ir,{J2Nuu", "");
        String string0 = vnfRollback0.toString();
        assertEquals("VnfRollback: cloud=M+!!EJC*~uO, tenant=Q,@Ir,{J2Nuu, vnf=M+!!EJC*~uO, tenantCreated=true, vnfCreated=true, requestType = Q,@Ir,{J2Nuu, modelCustomizationUuid=", string0);
        assertEquals("M+!!EJC*~uO", vnfRollback0.getVolumeGroupName());
        assertFalse(vnfRollback0.isBase());
        assertEquals("", vnfRollback0.getVolumeGroupId());
    }

    @Test(timeout = 4000)
    public void test27()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback("M+!!EJC*~uO", "Q,@Ir,{J2Nuu", "M+!!EJC*~uO", true, true, (MsoRequest) null, "M+!!EJC*~uO", "", "Q,@Ir,{J2Nuu", "");
        String string0 = vnfRollback0.getTenantId();
        assertEquals("M+!!EJC*~uO", vnfRollback0.getVolumeGroupName());
        assertEquals("Q,@Ir,{J2Nuu", vnfRollback0.getRequestType());
        assertEquals("Q,@Ir,{J2Nuu", string0);
        assertEquals("", vnfRollback0.getModelCustomizationUuid());
        assertEquals("M+!!EJC*~uO", vnfRollback0.getCloudSiteId());
        assertEquals("", vnfRollback0.getVolumeGroupId());
        assertTrue(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.isBase());
        assertTrue(vnfRollback0.getTenantCreated());
        assertEquals("M+!!EJC*~uO", vnfRollback0.getVnfId());
    }

    @Test(timeout = 4000)
    public void test28()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.setVnfCreated(false);
        assertFalse(vnfRollback0.isBase());
        assertFalse(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.getTenantCreated());
    }

    @Test(timeout = 4000)
    public void test29()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        boolean boolean0 = vnfRollback0.isBase();
        assertFalse(boolean0);
        assertFalse(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.getTenantCreated());
    }

    @Test(timeout = 4000)
    public void test30()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.getVfModuleStackId();
        assertFalse(vnfRollback0.getTenantCreated());
        assertFalse(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.isBase());
    }

    @Test(timeout = 4000)
    public void test31()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        boolean boolean0 = vnfRollback0.getTenantCreated();
        assertFalse(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.isBase());
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test32()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback("M+!!EJC*~uO", "Q,@Ir,{J2Nuu", "M+!!EJC*~uO", true, true, (MsoRequest) null, "M+!!EJC*~uO", "", "Q,@Ir,{J2Nuu", "");
        assertEquals("M+!!EJC*~uO", vnfRollback0.getVolumeGroupName());

        vnfRollback0.setVolumeGroupName("");
        vnfRollback0.getVolumeGroupName();
        assertEquals("", vnfRollback0.getVolumeGroupId());
    }

    @Test(timeout = 4000)
    public void test33()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback("M+!!EJC*~uO", "Q,@Ir,{J2Nuu", "M+!!EJC*~uO", true, true, (MsoRequest) null, "M+!!EJC*~uO", "", "Q,@Ir,{J2Nuu", "");
        String string0 = vnfRollback0.getVnfId();
        assertEquals("", vnfRollback0.getModelCustomizationUuid());
        assertTrue(vnfRollback0.getTenantCreated());
        assertEquals("M+!!EJC*~uO", vnfRollback0.getCloudSiteId());
        assertFalse(vnfRollback0.isBase());
        assertEquals("", vnfRollback0.getVolumeGroupId());
        assertEquals("M+!!EJC*~uO", vnfRollback0.getVolumeGroupName());
        assertTrue(vnfRollback0.getVnfCreated());
        assertEquals("Q,@Ir,{J2Nuu", vnfRollback0.getTenantId());
        assertEquals("M+!!EJC*~uO", string0);
        assertEquals("Q,@Ir,{J2Nuu", vnfRollback0.getRequestType());
    }

    @Test(timeout = 4000)
    public void test34()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.getCloudSiteId();
        assertFalse(vnfRollback0.isBase());
        assertFalse(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.getTenantCreated());
    }

    @Test(timeout = 4000)
    public void test35()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback("M+!!EJC*~uO", "Q,@Ir,{J2Nuu", "M+!!EJC*~uO", true, true, (MsoRequest) null, "M+!!EJC*~uO", "", "Q,@Ir,{J2Nuu", "");
        String string0 = vnfRollback0.getVolumeGroupName();
        assertEquals("Q,@Ir,{J2Nuu", vnfRollback0.getTenantId());
        assertTrue(vnfRollback0.getVnfCreated());
        assertEquals("Q,@Ir,{J2Nuu", vnfRollback0.getRequestType());
        assertEquals("M+!!EJC*~uO", string0);
        assertEquals("", vnfRollback0.getModelCustomizationUuid());
        assertEquals("M+!!EJC*~uO", vnfRollback0.getCloudSiteId());
        assertTrue(vnfRollback0.getTenantCreated());
        assertEquals("", vnfRollback0.getVolumeGroupId());
        assertEquals("M+!!EJC*~uO", vnfRollback0.getVnfId());
        assertFalse(vnfRollback0.isBase());
    }

    @Test(timeout = 4000)
    public void test36()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback("M+!!EJC*~uO", "Q,@Ir,{J2Nuu", "M+!!EJC*~uO", true, true, (MsoRequest) null, "M+!!EJC*~uO", "", "Q,@Ir,{J2Nuu", "");
        vnfRollback0.setMsoRequest((MsoRequest) null);
        assertEquals("M+!!EJC*~uO", vnfRollback0.getVnfId());
        assertEquals("", vnfRollback0.getModelCustomizationUuid());
        assertEquals("Q,@Ir,{J2Nuu", vnfRollback0.getRequestType());
        assertEquals("Q,@Ir,{J2Nuu", vnfRollback0.getTenantId());
        assertEquals("M+!!EJC*~uO", vnfRollback0.getCloudSiteId());
        assertTrue(vnfRollback0.getVnfCreated());
        assertEquals("", vnfRollback0.getVolumeGroupId());
        assertTrue(vnfRollback0.getTenantCreated());
        assertEquals("M+!!EJC*~uO", vnfRollback0.getVolumeGroupName());
        assertFalse(vnfRollback0.isBase());
    }

    @Test(timeout = 4000)
    public void test37()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback((String) null, (String) null, ", vnf=", false, true, (MsoRequest) null, "", ", vnf=", "", "");
        String string0 = vnfRollback0.getModelCustomizationUuid();
        assertEquals("", vnfRollback0.getVolumeGroupName());
        assertEquals("", vnfRollback0.getRequestType());
        assertFalse(vnfRollback0.getTenantCreated());
        assertEquals(", vnf=", vnfRollback0.getCloudSiteId());
        assertNotNull(string0);
        assertEquals(", vnf=", vnfRollback0.getVolumeGroupId());
        assertFalse(vnfRollback0.isBase());
        assertEquals("", string0);
        assertTrue(vnfRollback0.getVnfCreated());
    }

    @Test(timeout = 4000)
    public void test38()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback();
        vnfRollback0.getBaseGroupHeatStackId();
        assertFalse(vnfRollback0.isBase());
        assertFalse(vnfRollback0.getVnfCreated());
        assertFalse(vnfRollback0.getTenantCreated());
    }

    @Test(timeout = 4000)
    public void test39()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback("M+!!EJC*~uO", "Q,@Ir,{J2Nuu", "M+!!EJC*~uO", true, true, (MsoRequest) null, "M+!!EJC*~uO", "", "Q,@Ir,{J2Nuu", "");
        vnfRollback0.getMsoRequest();
        assertEquals("M+!!EJC*~uO", vnfRollback0.getVnfId());
        assertFalse(vnfRollback0.isBase());
        assertEquals("M+!!EJC*~uO", vnfRollback0.getVolumeGroupName());
        assertEquals("", vnfRollback0.getVolumeGroupId());
        assertTrue(vnfRollback0.getTenantCreated());
        assertEquals("M+!!EJC*~uO", vnfRollback0.getCloudSiteId());
        assertEquals("Q,@Ir,{J2Nuu", vnfRollback0.getTenantId());
        assertEquals("", vnfRollback0.getModelCustomizationUuid());
        assertTrue(vnfRollback0.getVnfCreated());
        assertEquals("Q,@Ir,{J2Nuu", vnfRollback0.getRequestType());
    }

    @Test(timeout = 4000)
    public void test40()  throws Throwable  {
        VnfRollback vnfRollback0 = new VnfRollback((String) null, (String) null, ", vnf=", false, true, (MsoRequest) null, "", ", vnf=", "", "");
        boolean boolean0 = vnfRollback0.getVnfCreated();
        assertEquals("", vnfRollback0.getVolumeGroupName());
        assertEquals(", vnf=", vnfRollback0.getCloudSiteId());
        assertEquals(", vnf=", vnfRollback0.getVolumeGroupId());
        assertEquals("", vnfRollback0.getRequestType());
        assertFalse(vnfRollback0.isBase());
        assertFalse(vnfRollback0.getTenantCreated());
        assertEquals("", vnfRollback0.getModelCustomizationUuid());
        assertTrue(boolean0);
    }
}
