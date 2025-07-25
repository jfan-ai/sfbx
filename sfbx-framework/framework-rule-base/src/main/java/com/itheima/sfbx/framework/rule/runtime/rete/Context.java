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
package com.itheima.sfbx.framework.rule.runtime.rete;

import com.itheima.sfbx.framework.rule.debug.MessageItem;
import com.itheima.sfbx.framework.rule.debug.MsgType;
import com.itheima.sfbx.framework.rule.runtime.WorkingMemory;
import com.itheima.sfbx.framework.rule.runtime.assertor.AssertorEvaluator;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @author Jacky.gao
 * @since 2015年1月8日
 */
public interface Context {
	AssertorEvaluator getAssertorEvaluator();
	ValueCompute getValueCompute();
	ApplicationContext getApplicationContext();
	String getVariableCategoryClass(String variableCategory);
	WorkingMemory getWorkingMemory();
	Object parseExpression(String expression);
	List<MessageItem> getDebugMessageItems();
	void debugMsg(String msg,MsgType type,boolean debug);
}
