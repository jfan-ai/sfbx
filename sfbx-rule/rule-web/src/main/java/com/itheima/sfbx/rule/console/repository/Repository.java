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
package com.itheima.sfbx.rule.console.repository;

import java.util.List;

import com.itheima.sfbx.rule.console.repository.model.RepositoryFile;

public class Repository {
	private RepositoryFile rootFile;
	private List<String> projectNames;
	public RepositoryFile getRootFile() {
		return rootFile;
	}
	public void setRootFile(RepositoryFile rootFile) {
		this.rootFile = rootFile;
	}
	public List<String> getProjectNames() {
		return projectNames;
	}
	public void setProjectNames(List<String> projectNames) {
		this.projectNames = projectNames;
	}
}
