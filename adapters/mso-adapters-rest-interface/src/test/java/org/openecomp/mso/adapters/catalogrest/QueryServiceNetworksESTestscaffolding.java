/**
 * Scaffolding file used to store all the setups needed to run
 * tests automatically generated by EvoSuite
 * Mon Feb 20 14:04:40 GMT 2017
 */

package org.openecomp.mso.adapters.catalogrest;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;

@EvoSuiteClassExclude
public class QueryServiceNetworksESTestscaffolding {

  @org.junit.Rule
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone();

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);

  @BeforeClass
  public static void initEvoSuiteFramework() {
    org.evosuite.runtime.RuntimeSettings.className = "org.openecomp.mso.adapters.catalogrest.QueryServiceNetworks";
    org.evosuite.runtime.GuiSupport.initialize();
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100;
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000;
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true;
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED;
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT();
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime();
  }

  @AfterClass
  public static void clearEvoSuiteFramework(){
    Sandbox.resetDefaultSecurityManager();
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone());
  }

  @Before
  public void initTestCase(){
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler();
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode();
    org.evosuite.runtime.GuiSupport.setHeadless();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime();
    org.evosuite.runtime.agent.InstrumentingAgent.activate();
  }

  @After
  public void doneWithTestCase(){
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks();
    org.evosuite.runtime.classhandling.JDKClassResetter.reset();
    resetClasses();
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode();
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate();
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode();
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(QueryServiceNetworksESTestscaffolding.class.getClassLoader() ,
      "org.codehaus.jackson.map.JsonSerializableWithType",
      "org.codehaus.jackson.map.HandlerInstantiator",
      "org.codehaus.jackson.map.deser.StdDeserializerProvider",
      "org.codehaus.jackson.map.SerializerFactory",
      "org.codehaus.jackson.map.SerializerProvider",
      "org.codehaus.jackson.map.type.TypeBindings",
      "org.codehaus.jackson.map.SerializationConfig",
      "org.codehaus.jackson.JsonProcessingException",
      "org.codehaus.jackson.map.introspect.AnnotationMap",
      "org.codehaus.jackson.map.introspect.Annotated",
      "org.codehaus.jackson.io.InputDecorator",
      "org.codehaus.jackson.map.Module",
      "org.codehaus.jackson.map.util.Annotations",
      "org.codehaus.jackson.map.type.TypeModifier",
      "org.codehaus.jackson.sym.NameN",
      "org.codehaus.jackson.JsonGenerator",
      "org.codehaus.jackson.map.introspect.AnnotatedClass",
      "org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector",
      "org.codehaus.jackson.annotate.JsonAutoDetect$1",
      "org.codehaus.jackson.map.JsonSerializable",
      "org.codehaus.jackson.annotate.JsonMethod",
      "com.att.eelf.i18n.EELFResolvableErrorEnum",
      "org.codehaus.jackson.node.BaseJsonNode",
      "org.openecomp.mso.logger.MsoLogger$StatusCode",
      "org.codehaus.jackson.map.ObjectReader",
      "org.codehaus.jackson.map.DeserializerProvider",
      "org.codehaus.jackson.annotate.JsonAutoDetect$Visibility",
      "org.codehaus.jackson.node.ValueNode",
      "org.codehaus.jackson.map.ser.BeanSerializerFactory",
      "org.codehaus.jackson.map.JsonSerializer",
      "org.codehaus.jackson.map.introspect.AnnotatedWithParams",
      "com.att.eelf.i18n.EELFMsgs",
      "org.codehaus.jackson.map.AnnotationIntrospector",
      "org.codehaus.jackson.map.MappingJsonFactory",
      "com.att.eelf.configuration.EELFLogger$Level",
      "org.codehaus.jackson.map.MapperConfig$Impl",
      "org.codehaus.jackson.sym.Name1",
      "org.codehaus.jackson.sym.Name2",
      "org.codehaus.jackson.sym.Name3",
      "org.codehaus.jackson.map.introspect.MethodFilter",
      "org.codehaus.jackson.map.ser.StdSerializerProvider",
      "org.codehaus.jackson.map.deser.StdDeserializationContext",
      "org.codehaus.jackson.type.TypeReference",
      "org.codehaus.jackson.map.ClassIntrospector",
      "org.codehaus.jackson.map.AnnotationIntrospector$Pair",
      "org.codehaus.jackson.map.PropertyNamingStrategy$LowerCaseWithUnderscoresStrategy",
      "org.codehaus.jackson.map.MapperConfig$ConfigFeature",
      "org.codehaus.jackson.map.SerializationConfig$Feature",
      "org.codehaus.jackson.Versioned",
      "org.codehaus.jackson.io.IOContext",
      "org.openecomp.mso.db.catalog.beans.NetworkResourceCustomization",
      "org.codehaus.jackson.map.type.TypeBase",
      "org.codehaus.jackson.map.ser.BasicSerializerFactory",
      "com.att.eelf.i18n.EELFResourceManager$RESOURCE_TYPES",
      "org.codehaus.jackson.map.PropertyNamingStrategy",
      "org.codehaus.jackson.node.ContainerNode",
      "org.codehaus.jackson.map.jsontype.NamedType",
      "org.codehaus.jackson.map.ser.FilterProvider",
      "org.codehaus.jackson.map.introspect.NopAnnotationIntrospector",
      "com.att.eelf.configuration.EELFLogger",
      "org.codehaus.jackson.map.DeserializationConfig",
      "org.codehaus.jackson.map.introspect.AnnotatedConstructor",
      "org.codehaus.jackson.sym.BytesToNameCanonicalizer",
      "org.codehaus.jackson.map.type.TypeFactory",
      "org.codehaus.jackson.impl.ReaderBasedParser",
      "org.codehaus.jackson.sym.BytesToNameCanonicalizer$TableInfo",
      "org.codehaus.jackson.JsonEncoding",
      "org.codehaus.jackson.map.type.MapLikeType",
      "org.codehaus.jackson.map.JsonDeserializer",
      "org.codehaus.jackson.map.PropertyNamingStrategy$PropertyNamingStrategyBase",
      "org.codehaus.jackson.node.ObjectNode",
      "org.openecomp.mso.logger.MsoLogger$ErrorCode",
      "org.codehaus.jackson.map.ser.std.SerializerBase",
      "org.codehaus.jackson.map.introspect.BasicClassIntrospector$MinimalMethodFilter",
      "org.codehaus.jackson.map.type.CollectionLikeType",
      "org.openecomp.mso.logger.MessageEnum",
      "org.codehaus.jackson.map.DeserializationConfig$Feature",
      "org.codehaus.jackson.sym.CharsToNameCanonicalizer$Bucket",
      "org.codehaus.jackson.map.introspect.AnnotatedMethodMap",
      "org.codehaus.jackson.impl.JsonParserMinimalBase",
      "org.codehaus.jackson.map.type.TypeParser",
      "org.codehaus.jackson.map.introspect.POJOPropertiesCollector",
      "org.codehaus.jackson.JsonParseException",
      "org.codehaus.jackson.map.introspect.BasicClassIntrospector$SetterMethodFilter",
      "org.codehaus.jackson.map.introspect.VisibilityChecker",
      "org.codehaus.jackson.map.introspect.AnnotatedField",
      "org.codehaus.jackson.impl.JsonGeneratorBase",
      "org.codehaus.jackson.map.ObjectMapper",
      "org.codehaus.jackson.util.ByteArrayBuilder",
      "org.codehaus.jackson.map.ser.impl.FailingSerializer",
      "org.codehaus.jackson.PrettyPrinter",
      "org.codehaus.jackson.JsonToken",
      "org.codehaus.jackson.map.jsontype.SubtypeResolver",
      "org.codehaus.jackson.map.type.SimpleType",
      "org.codehaus.jackson.map.util.StdDateFormat",
      "org.codehaus.jackson.impl.Utf8Generator",
      "org.codehaus.jackson.node.NumericNode",
      "org.jboss.resteasy.annotations.providers.NoJackson",
      "org.codehaus.jackson.map.introspect.BasicClassIntrospector",
      "org.codehaus.jackson.map.introspect.BasicClassIntrospector$SetterAndGetterMethodFilter",
      "org.codehaus.jackson.JsonNode",
      "org.codehaus.jackson.sym.CharsToNameCanonicalizer",
      "org.codehaus.jackson.annotate.JacksonAnnotation",
      "org.codehaus.jackson.map.ObjectWriter",
      "org.codehaus.jackson.schema.SchemaAware",
      "org.codehaus.jackson.io.OutputDecorator",
      "com.att.eelf.configuration.SLF4jWrapper",
      "org.codehaus.jackson.FormatSchema",
      "org.codehaus.jackson.format.MatchStrength",
      "org.openecomp.mso.logger.MsoLogger$Catalog",
      "org.codehaus.jackson.ObjectCodec",
      "org.codehaus.jackson.map.introspect.AnnotatedMethod",
      "org.openecomp.mso.db.catalog.utils.MavenLikeVersioning",
      "org.codehaus.jackson.JsonGenerationException",
      "org.openecomp.mso.entity.MsoRequest",
      "org.codehaus.jackson.format.InputAccessor",
      "org.codehaus.jackson.JsonFactory",
      "org.codehaus.jackson.node.ArrayNode",
      "org.codehaus.jackson.util.BufferRecycler",
      "org.codehaus.jackson.io.SegmentedStringWriter",
      "org.openecomp.mso.logger.MsoLogger$ResponseCode",
      "org.codehaus.jackson.map.jsontype.TypeResolverBuilder",
      "org.codehaus.jackson.map.type.HierarchicType",
      "org.codehaus.jackson.map.introspect.BasicClassIntrospector$GetterMethodFilter",
      "org.codehaus.jackson.JsonParser$Feature",
      "org.codehaus.jackson.map.BeanDescription",
      "org.codehaus.jackson.JsonParser$1",
      "org.codehaus.jackson.impl.WriterBasedGenerator",
      "org.codehaus.jackson.JsonGenerator$Feature",
      "org.codehaus.jackson.sym.Name",
      "org.codehaus.jackson.Version",
      "org.codehaus.jackson.io.CharacterEscapes",
      "org.codehaus.jackson.map.introspect.BasicBeanDescription",
      "org.codehaus.jackson.schema.JsonSchema",
      "org.codehaus.jackson.util.TokenBuffer",
      "org.codehaus.jackson.map.MappingIterator",
      "org.codehaus.jackson.map.annotate.JsonSerialize$Inclusion",
      "org.codehaus.jackson.map.DeserializationContext",
      "org.codehaus.jackson.impl.JsonParserBase",
      "org.codehaus.jackson.map.ObjectMapper$DefaultTyping",
      "org.codehaus.jackson.map.JsonMappingException",
      "org.codehaus.jackson.map.introspect.AnnotatedMember",
      "org.codehaus.jackson.node.JsonNodeFactory",
      "org.codehaus.jackson.type.JavaType",
      "com.att.eelf.i18n.EELFResourceManager",
      "org.codehaus.jackson.map.introspect.VisibilityChecker$Std",
      "org.codehaus.jackson.annotate.JsonTypeInfo$As",
      "org.codehaus.jackson.JsonParser",
      "org.codehaus.jackson.node.NullNode",
      "org.codehaus.jackson.map.InjectableValues",
      "org.codehaus.jackson.map.jsontype.impl.StdSubtypeResolver",
      "org.codehaus.jackson.node.TreeTraversingParser",
      "org.codehaus.jackson.map.type.CollectionType",
      "com.att.eelf.configuration.EELFManager",
      "org.codehaus.jackson.map.MapperConfig",
      "org.codehaus.jackson.map.Module$SetupContext",
      "org.openecomp.mso.adapters.catalogrest.QueryServiceNetworks",
      "org.codehaus.jackson.io.UTF8Writer",
      "org.openecomp.mso.db.catalog.beans.NetworkResource",
      "org.codehaus.jackson.map.introspect.VisibilityChecker$1",
      "org.codehaus.jackson.map.type.MapType",
      "org.codehaus.jackson.annotate.JsonAutoDetect",
      "org.codehaus.jackson.map.type.ArrayType",
      "org.openecomp.mso.logger.MsoLogger",
      "org.codehaus.jackson.map.ClassIntrospector$MixInResolver"
    );
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(QueryServiceNetworksESTestscaffolding.class.getClassLoader());

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "org.openecomp.mso.logger.MsoLogger$Catalog",
      "org.openecomp.mso.logger.MsoLogger",
      "com.att.eelf.i18n.EELFResourceManager",
      "com.att.eelf.i18n.EELFMsgs",
      "com.att.eelf.i18n.EELFResourceManager$RESOURCE_TYPES",
      "com.att.eelf.configuration.EELFLogger$Level",
      "com.att.eelf.configuration.EELFManager",
      "org.openecomp.mso.logger.MessageEnum",
      "org.openecomp.mso.adapters.catalogrest.QueryServiceNetworks",
      "org.codehaus.jackson.map.introspect.AnnotatedClass",
      "org.codehaus.jackson.map.introspect.BasicClassIntrospector",
      "org.codehaus.jackson.annotate.JsonAutoDetect$Visibility",
      "org.codehaus.jackson.annotate.JsonMethod",
      "org.codehaus.jackson.map.introspect.VisibilityChecker$Std",
      "org.codehaus.jackson.map.ObjectMapper",
      "org.codehaus.jackson.JsonParser$Feature",
      "org.codehaus.jackson.JsonGenerator$Feature",
      "org.codehaus.jackson.JsonFactory",
      "org.codehaus.jackson.sym.CharsToNameCanonicalizer",
      "org.codehaus.jackson.sym.BytesToNameCanonicalizer",
      "org.codehaus.jackson.map.type.TypeFactory"
    );
  }
}
