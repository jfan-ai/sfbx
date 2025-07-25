/*******************************************************************************
 * Copyright 2017 Bstek
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.itheima.sfbx.framework.rule.builder.resource;

import com.itheima.sfbx.framework.rule.RuleException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Jacky.gao
 * @since 2014年12月22日
 */
public class FileResourceProvider implements ResourceProvider,ApplicationContextAware {
	private ApplicationContext applicationContext;
	
	@Override
	public Resource provide(String path,String version) {
		try {
			InputStream inputStream=applicationContext.getResource(path).getInputStream();
			String content=IOUtils.toString(inputStream,"utf-8");
			IOUtils.closeQuietly(inputStream);
			return new Resource(content,path);
		} catch (IOException e) {
			throw new RuleException(e);
		}
	}

	public boolean support(String path) {
		return path.startsWith("classpath:") || path.startsWith("file:") || path.startsWith("WEB-INF/");
	}
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
}
