/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

import java.util.HashMap;
import java.util.Map;

import org.apache.tools.ant.Project;

/**
 * @author Michael Hashimoto
 */
public class AppServer {

	public AppServer(Project project) {
		_project = project;
	}

	public String getType() {
		return _project.getProperty("app.server.type");
	}

	public void startService() {
		if (JenkinsResultsParserUtil.isWindows()) {
			JenkinsResultsParserUtil.executeBatchCommandService(
				_getStartCommand(), _getBinDir(), _getEnvironments(),
				_getMaxLogSize());

			return;
		}

		JenkinsResultsParserUtil.executeBashCommandService(
			_getStartCommand(), _getBinDir(), _getEnvironments(),
			_getMaxLogSize());
	}

	public void stopService() {
		if (JenkinsResultsParserUtil.isWindows()) {
			JenkinsResultsParserUtil.executeBatchCommandService(
				_getStopCommand(), _getBinDir(), _getEnvironments(),
				_getMaxLogSize());

			return;
		}

		JenkinsResultsParserUtil.executeBashCommandService(
			_getStopCommand(), _getBinDir(), _getEnvironments(),
			_getMaxLogSize());
	}

	private File _getBinDir() {
		String binDirString = _project.getProperty("test.app.server.bin.dir");

		if (binDirString == null) {
			binDirString = _project.getProperty("app.server.bin.dir");
		}

		if (binDirString == null) {
			binDirString = _project.getProperty(
				JenkinsResultsParserUtil.combine(
					"app.server.", getType(), ".bin.dir"));
		}

		return new File(binDirString);
	}

	private Map<String, String> _getEnvironments() {
		Map<String, String> environments = new HashMap<>();

		environments.put("JAVA_HOME", _getJavaHome());
		environments.put("JAVA_OPTS", _getJavaOpts());
		environments.put("PATH", _getPath());

		return environments;
	}

	private String _getJavaHome() {
		String javaHome = _project.getProperty("java.jdk.home");

		if (javaHome == null) {
			javaHome = _project.getProperty("env.JAVA_HOME");
		}

		if (javaHome == null) {
			javaHome = System.getenv("JAVA_HOME");
		}

		return javaHome;
	}

	private String _getJavaOpts() {
		String javaOpts = _project.getProperty("java.jdk.opts");

		if (javaOpts == null) {
			_project.getProperty("env.JAVA_OPTS");
		}

		if (javaOpts == null) {
			javaOpts = System.getenv("JAVA_OPTS");
		}

		return javaOpts;
	}

	private long _getMaxLogSize() {
		String appServerMaxLogSizeInMB = _project.getProperty(
			"app.server.max.log.size.in.mb");

		if (appServerMaxLogSizeInMB == null) {
			appServerMaxLogSizeInMB = "5";
		}

		return Long.valueOf(appServerMaxLogSizeInMB) * 1024 * 1024;
	}

	private String _getPath() {
		String path = _project.getProperty("env.PATH");

		if (path == null) {
			path = System.getenv("PATH");
		}

		String javaHome = _getJavaHome();

		if ((javaHome == null) || javaHome.isEmpty()) {
			return path;
		}

		if (JenkinsResultsParserUtil.isWindows()) {
			return path.replaceAll(
				"[^;]+\\\\jdk[^\\\\]*\\\\[^;]*bin",
				javaHome.replaceAll("\\\\", "\\\\") + "\\\\bin");
		}

		return path.replaceAll("[^:]+/jdk[^/]*/[^:]*bin", javaHome + "/bin");
	}

	private String _getStartCommand() {
		return JenkinsResultsParserUtil.combine(
			_getStartExecutable(), " ", _getStartExecutableArgLine());
	}

	private String _getStartExecutable() {
		String startExecutable = _project.getProperty(
			"app.server.start.executable");

		if ((startExecutable == null) || startExecutable.isEmpty()) {
			startExecutable = _project.getProperty(
				JenkinsResultsParserUtil.combine(
					"app.server.", getType(), ".start.executable"));
		}

		return startExecutable;
	}

	private String _getStartExecutableArgLine() {
		String startExecutableArgLine = _project.getProperty(
			"app.server.start.executable.arg.line");

		if ((startExecutableArgLine == null) ||
			startExecutableArgLine.isEmpty()) {

			startExecutableArgLine = _project.getProperty(
				JenkinsResultsParserUtil.combine(
					"app.server.", getType(), ".start.executable.arg.line"));
		}

		return startExecutableArgLine;
	}

	private String _getStopCommand() {
		return JenkinsResultsParserUtil.combine(
			_getStopExecutable(), " ", _getStopExecutableArgLine());
	}

	private String _getStopExecutable() {
		String stopExecutable = _project.getProperty(
			"app.server.stop.executable");

		if ((stopExecutable == null) || stopExecutable.isEmpty()) {
			stopExecutable = _project.getProperty(
				JenkinsResultsParserUtil.combine(
					"app.server.", getType(), ".stop.executable"));
		}

		return stopExecutable;
	}

	private String _getStopExecutableArgLine() {
		String stopExecutableArgLine = _project.getProperty(
			"app.server.stop.executable.arg.line");

		if ((stopExecutableArgLine == null) ||
			stopExecutableArgLine.isEmpty()) {

			stopExecutableArgLine = _project.getProperty(
				JenkinsResultsParserUtil.combine(
					"app.server.", getType(), ".stop.executable.arg.line"));
		}

		return stopExecutableArgLine;
	}

	private final Project _project;

}