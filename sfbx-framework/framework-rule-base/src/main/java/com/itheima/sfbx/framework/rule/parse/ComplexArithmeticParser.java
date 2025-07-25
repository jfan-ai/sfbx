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
package com.itheima.sfbx.framework.rule.parse;

import com.itheima.sfbx.framework.rule.model.rule.ArithmeticType;
import com.itheima.sfbx.framework.rule.model.rule.ComplexArithmetic;
import org.dom4j.Element;

/**
 * @author Jacky.gao
 * @since 2014年12月23日
 */
public class ComplexArithmeticParser implements Parser<ComplexArithmetic> {
	private ValueParser valueParser;
	private ParenParser parenParser;
	public ComplexArithmetic parse(Element element) {
		ComplexArithmetic arithmetic=new ComplexArithmetic();
		ArithmeticType arithmeticType=ArithmeticType.valueOf(element.attributeValue("type"));
		arithmetic.setType(arithmeticType);
		for(Object obj:element.elements()){
			if(obj==null || !(obj instanceof Element)){
				continue;
			}
			Element ele=(Element)obj;
			if(valueParser.support(ele.getName())){
				arithmetic.setValue(valueParser.parse(ele));
			}else if(parenParser.support(ele.getName())){
				arithmetic.setValue(parenParser.parse(ele));
			}
		}
		return arithmetic;
	}
	public void setValueParser(ValueParser valueParser) {
		this.valueParser = valueParser;
	}
	public void setParenParser(ParenParser parenParser) {
		this.parenParser = parenParser;
	}
	public boolean support(String name) {
		return name.equals("complex-arith");
	}
}
