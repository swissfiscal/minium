/*
 * Copyright (C) 2013 The Minium Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vilt.minium.jquery;

import static com.vilt.minium.Minium.$;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.Iterables;
import com.vilt.minium.DefaultWebElements;
import com.vilt.minium.MiniumBaseTest;

public class FrameWebElementsTest extends MiniumBaseTest {

	@BeforeTest
	public void openPage() {
		get("minium/tests/iframe-test.html");
	}
	
	@Test
	public void testIframe() {
		DefaultWebElements elems = $(wd).frame("#jquery-frame-1").find("input#name");
		assertThat(elems, hasSize(1));
		Iterables.get(elems, 0).sendKeys("Hello World!");
	}
	
	@Test
	public void testIframes() {
		DefaultWebElements elems = $(wd).frame().find("input#name");
		assertThat(elems, hasSize(2));
		
		for (WebElement elem : elems) {
			elem.sendKeys("Hello World!");
		}
	}
	

	@Test
	public void testIframeRelativeElements() {
		DefaultWebElements frame = $(wd).frame("#jquery-frame-1");
		DefaultWebElements input = frame.find("input#name");
		DefaultWebElements label = frame.find("label").rightOf(input);
		assertThat(label, hasSize(1));
	}
	
	@Test
	public void testIframesRelativeElements() {
		DefaultWebElements frame = $(wd).frame();
		DefaultWebElements input = frame.find("input#name");
		DefaultWebElements label = frame.find("label").rightOf(input);
		assertThat(label, hasSize(2));
	}
	
	@Test
	public void testIframesFalseRelativeElements() {
		try {
			DefaultWebElements input = $(wd, "input#name");

			DefaultWebElements frame = $(wd).frame();
			/* DefaultWebElements label = */ frame.find("label").rightOf(input);

			Assert.fail("An exception was expected");
		} catch (IllegalArgumentException e) {
			// ok
		}
	}
}
