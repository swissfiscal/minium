package com.vilt.minium.impl;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.vilt.minium.driver.DefaultWebElementsDriver;
import com.vilt.minium.jquery.DefaultWebElements;
import com.vilt.minium.jquery.JQueryWebElements;

public class WebElementsFactoryTest {

	@Test
	@SuppressWarnings("unchecked")
	public void testInterfaces() {
		WebElementsFactory factory = new WebElementsFactory(DefaultWebElements.class);
		DefaultWebElementsDriver wd = mock(DefaultWebElementsDriver.class);
		DefaultWebElements elem = WebElementsFactoryHelper.createRootWebElements(factory, wd);
		assertTrue(elem instanceof JQueryWebElements<?>);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testResources() {
		WebElementsFactory factory = new WebElementsFactory(DefaultWebElements.class);
		JQueryInvoker invoker = factory.getInvoker();
		assertThat(invoker.getJsResources(), contains("minium/js/jquery.js", "minium/js/position.js"));
	}
}
