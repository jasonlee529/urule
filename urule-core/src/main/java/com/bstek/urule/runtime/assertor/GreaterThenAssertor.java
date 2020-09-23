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
package com.bstek.urule.runtime.assertor;

import java.math.BigDecimal;
import java.util.*;

import com.bstek.urule.Utils;
import com.bstek.urule.model.library.Datatype;
import com.bstek.urule.model.rule.Op;

/**
 * @author Jacky.gao
 * @since 2015年1月6日
 */
public class GreaterThenAssertor implements Assertor {

	public boolean eval(Object left, Object right,Datatype datatype) {
		if(left==null || right==null){
			return false;
		}
		if(datatype.equals(Datatype.Date)){
			Date leftDate=(Date)datatype.convert(left);
			Date rightDate=(Date)datatype.convert(right);
			Calendar leftCalendar=Calendar.getInstance();
			leftCalendar.setTime(leftDate);
			Calendar rightCalendar=Calendar.getInstance();
			rightCalendar.setTime(rightDate);
			int result=leftCalendar.compareTo(rightCalendar);
			if(result==1){
				return true;
			}
		} else if (datatype.equals(Datatype.List)) {
			return developEval(left, right, datatype);
		}else{
			BigDecimal leftNumber=Utils.toBigDecimal(left);
			BigDecimal rightNumber=Utils.toBigDecimal(right);
			int result=leftNumber.compareTo(rightNumber);
			if(result==1){
				return true;
			}
		}
		return false;
	}

	public boolean support(Op op) {
		return op.equals(Op.GreaterThen);
	}

	// 扩展类型比较
	private boolean developEval(Object left, Object right, Datatype datatype) {
		if (right instanceof Date) {
			Date rightDate = (Date) Datatype.Date.convert(right);
			for (Object obj : (List) left) {
				Date leftDate = (Date) Datatype.Date.convert(obj);
				Calendar leftCalendar = Calendar.getInstance();
				leftCalendar.setTime(leftDate);
				Calendar rightCalendar = Calendar.getInstance();
				rightCalendar.setTime(rightDate);
				int result = leftCalendar.compareTo(rightCalendar);
				if (result == 1) {
					return true;
				}
			}
		} else {
			BigDecimal rightNumber = Utils.toBigDecimal(right);
			for (Object obj : (List) left) {
				BigDecimal leftNumber = Utils.toBigDecimal(obj);
				int result = leftNumber.compareTo(rightNumber);
				if (result == 1) {
					return true;
				}
			}
		}
		return false;
	}
}
