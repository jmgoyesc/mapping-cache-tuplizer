# mapping-cache-tuplizer
Hibernate 5.2.7 issue with hbm.xml mapping cache and tuplizer tag order

Using hibernate hbm xml mapping, I got an error.

```java
  org.hibernate.boot.InvalidMappingException: Could not parse mapping document: Event.hbm.xml (RESOURCE)
    at org.hibernate.boot.jaxb.internal.InputStreamXmlSource.doBind(InputStreamXmlSource.java:46)
    at org.hibernate.boot.jaxb.internal.UrlXmlSource.doBind(UrlXmlSource.java:36)
    at org.hibernate.boot.spi.XmlMappingBinderAccess.bind(XmlMappingBinderAccess.java:59)
    at org.hibernate.boot.MetadataSources.addResource(MetadataSources.java:274)
    at org.hibernate.boot.cfgxml.spi.MappingReference.apply(MappingReference.java:70)
    at org.hibernate.boot.internal.MetadataBuilderImpl.build(MetadataBuilderImpl.java:413)
    at org.hibernate.boot.internal.MetadataBuilderImpl.build(MetadataBuilderImpl.java:87)
    at org.hibernate.cfg.Configuration.buildSessionFactory(Configuration.java:691)
    at org.hibernate.cfg.Configuration.buildSessionFactory(Configuration.java:726)
    at MappingTest.setup(MappingTest.java:21)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:47)
    at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
    at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:44)
    at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:24)
    at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:271)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:70)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:50)
    at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)
    at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)
    at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)
    at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)
    at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)
    at org.junit.runners.ParentRunner.run(ParentRunner.java:309)
    at org.junit.runner.JUnitCore.run(JUnitCore.java:160)
    at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
    at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:51)
    at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
    at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
  Caused by: org.hibernate.boot.MappingException: Unable to perform unmarshalling at line number 6 and column 74. Message: cvc-complex-type.2.4.a: Invalid content was found starting with element 'tuplizer'. One of '{"http://www.hibernate.org/xsd/orm/hbm":natural-id-cache, "http://www.hibernate.org/xsd/orm/hbm":synchronize, "http://www.hibernate.org/xsd/orm/hbm":comment, "http://www.hibernate.org/xsd/orm/hbm":id, "http://www.hibernate.org/xsd/orm/hbm":composite-id}' is expected. : origin(Event.hbm.xml)
    at org.hibernate.boot.jaxb.internal.AbstractBinder.jaxb(AbstractBinder.java:177)
    at org.hibernate.boot.jaxb.internal.MappingBinder.doBind(MappingBinder.java:61)
    at org.hibernate.boot.jaxb.internal.AbstractBinder.doBind(AbstractBinder.java:102)
    at org.hibernate.boot.jaxb.internal.AbstractBinder.bind(AbstractBinder.java:57)
    at org.hibernate.boot.jaxb.internal.InputStreamXmlSource.doBind(InputStreamXmlSource.java:43)
    ... 31 more
  Caused by: javax.xml.bind.UnmarshalException
   - with linked exception:
  [org.xml.sax.SAXParseException; lineNumber: 6; columnNumber: 74; cvc-complex-type.2.4.a: Invalid content was found starting with element 'tuplizer'. One of '{"http://www.hibernate.org/xsd/orm/hbm":natural-id-cache, "http://www.hibernate.org/xsd/orm/hbm":synchronize, "http://www.hibernate.org/xsd/orm/hbm":comment, "http://www.hibernate.org/xsd/orm/hbm":id, "http://www.hibernate.org/xsd/orm/hbm":composite-id}' is expected.]
    at com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallerImpl.handleStreamException(UnmarshallerImpl.java:468)
    at com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallerImpl.unmarshal0(UnmarshallerImpl.java:448)
    at com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallerImpl.unmarshal(UnmarshallerImpl.java:420)
    at org.hibernate.boot.jaxb.internal.AbstractBinder.jaxb(AbstractBinder.java:171)
    ... 35 more
  Caused by: org.xml.sax.SAXParseException; lineNumber: 6; columnNumber: 74; cvc-complex-type.2.4.a: Invalid content was found starting with element 'tuplizer'. One of '{"http://www.hibernate.org/xsd/orm/hbm":natural-id-cache, "http://www.hibernate.org/xsd/orm/hbm":synchronize, "http://www.hibernate.org/xsd/orm/hbm":comment, "http://www.hibernate.org/xsd/orm/hbm":id, "http://www.hibernate.org/xsd/orm/hbm":composite-id}' is expected.
    at com.sun.org.apache.xerces.internal.util.ErrorHandlerWrapper.createSAXParseException(ErrorHandlerWrapper.java:203)
    at com.sun.org.apache.xerces.internal.util.ErrorHandlerWrapper.error(ErrorHandlerWrapper.java:134)
    at com.sun.org.apache.xerces.internal.impl.XMLErrorReporter.reportError(XMLErrorReporter.java:396)
    at com.sun.org.apache.xerces.internal.impl.XMLErrorReporter.reportError(XMLErrorReporter.java:327)
    at com.sun.org.apache.xerces.internal.impl.XMLErrorReporter.reportError(XMLErrorReporter.java:284)
    at com.sun.org.apache.xerces.internal.impl.xs.XMLSchemaValidator$XSIErrorReporter.reportError(XMLSchemaValidator.java:452)
    at com.sun.org.apache.xerces.internal.impl.xs.XMLSchemaValidator.reportSchemaError(XMLSchemaValidator.java:3230)
    at com.sun.org.apache.xerces.internal.impl.xs.XMLSchemaValidator.handleStartElement(XMLSchemaValidator.java:1790)
    at com.sun.org.apache.xerces.internal.impl.xs.XMLSchemaValidator.startElement(XMLSchemaValidator.java:740)
    at com.sun.org.apache.xerces.internal.jaxp.validation.ValidatorHandlerImpl.startElement(ValidatorHandlerImpl.java:570)
    at com.sun.xml.internal.bind.v2.runtime.unmarshaller.ValidatingUnmarshaller.startElement(ValidatingUnmarshaller.java:86)
    at com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor.startElement(InterningXmlVisitor.java:60)
    at com.sun.xml.internal.bind.v2.runtime.unmarshaller.StAXEventConnector.handleStartElement(StAXEventConnector.java:246)
    at com.sun.xml.internal.bind.v2.runtime.unmarshaller.StAXEventConnector.bridge(StAXEventConnector.java:115)
    at com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallerImpl.unmarshal0(UnmarshallerImpl.java:445)
    ... 37 more
```
 
 I have created a event.hbm.xml mapping like this:
 ```xml
     <class name="Event" table="Event">
        <cache usage="read-write"/>
        <tuplizer class="org.hibernate.tuple.entity.PojoEntityTuplizer"/>
        <id name="id" type="java.lang.String">
            <column name="ID"/>
            <generator class="identity"/>
        </id>
        <property name="name" type="java.lang.String">
            <column name="name"/>
        </property>
    </class>
```

The error is solved by changing the order of `<tuplizer/>` and `<cache/>` as I show following:

```xml
     <class name="Event" table="Event">
        <tuplizer class="org.hibernate.tuple.entity.PojoEntityTuplizer"/>
        <cache usage="read-write"/>
        <id name="id" type="java.lang.String">
            <column name="ID"/>
            <generator class="identity"/>
        </id>
        <property name="name" type="java.lang.String">
            <column name="name"/>
        </property>
    </class>
```

This project contains a junit test MappingTest.test to run and verify the error. I detected the error in **hibernate-core 5.2.7.Final** but I got the same error in **hibernate-core 5.2.10.Final**

Run in console `mvn clean install` to compile and execute the test. With the current configuration it should fail.

Hibernate issue: https://hibernate.atlassian.net/browse/HHH-11713

