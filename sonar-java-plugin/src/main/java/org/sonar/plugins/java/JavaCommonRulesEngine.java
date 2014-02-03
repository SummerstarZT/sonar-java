
/*
 * SonarQube Java
 * Copyright (C) 2012 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.java;

import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.resources.Java;
import org.sonar.api.resources.ProjectFileSystem;
import org.sonar.commonrules.api.CommonRulesEngine;
import org.sonar.commonrules.api.CommonRulesRepository;

public class JavaCommonRulesEngine extends CommonRulesEngine {

  /**
   * Server side
   */
  public JavaCommonRulesEngine() {
    super(Java.KEY);
  }

  /**
   * Batch side
   */
  public JavaCommonRulesEngine(RulesProfile rulesProfile, ProjectFileSystem fs) {
    super(Java.KEY, rulesProfile, fs);
  }

  @Override
  protected void doEnableRules(CommonRulesRepository repository) {
    repository
      .enableDuplicatedBlocksRule()
      .enableSkippedUnitTestsRule()
      .enableFailedUnitTestsRule()

        // null parameters -> keep default values as hardcoded in sonar-common-rules
      .enableInsufficientBranchCoverageRule(null)
      .enableInsufficientCommentDensityRule(null)
      .enableInsufficientLineCoverageRule(null);
  }
}